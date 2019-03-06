package edevelopmentandroidcompanydomain.num4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChoiceParkActivity extends AppCompatActivity {

    private ListView listViewChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_park);
        init();
    }

    private List<Map<String,Object>> globalData=new ArrayList<>();
    private void init() {
        listViewChoice=findViewById(R.id.listViewChoice);
        initGlobalData();
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return globalData.size();
            }

            @Override
            public Object getItem(int i) {
                return globalData.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View itemView=LayoutInflater.from(ChoiceParkActivity.this).inflate(R.layout.park_view_item,viewGroup,false);
                TextView tvParkName=itemView.findViewById(R.id.tvParkName);
                TextView tvWhether=itemView.findViewById(R.id.tvWhether);
                String parkName= (String) globalData.get(i).get("tvParkName");
                String whether= (String) globalData.get(i).get("whether");
                if(whether.equals("打开")){
                    tvWhether.setVisibility(View.INVISIBLE);
                }
                tvWhether.setText(whether);
                tvParkName.setText(parkName);
                return itemView;
            }
        };
        listViewChoice.setAdapter(adapter);
    }

    private void initGlobalData() {
        //tvParkName,   tvWhether
        Map<String,Object> map1=new HashMap<>();
        map1.put("tvParkName","城市广场停车场");
        map1.put("whether","打开");
        map1.put("what","1");

        Map<String,Object> map2=new HashMap<>();
        map2.put("tvParkName","百货大厦停车场");
        map2.put("whether","打开");
        map2.put("what","1");

        Map<String,Object> map3=new HashMap<>();
        map3.put("tvParkName","百城柯德基停车场");
        map3.put("whether","关闭");
        map3.put("what","0");

        Map<String,Object> map4=new HashMap<>();
        map4.put("tvParkName","新余大厦停车场");
        map4.put("whether","关闭");
        map4.put("what","0");
        globalData.add(map4);
        globalData.add(map2);
        globalData.add(map3);
        globalData.add(map1);
        //默认排序
        Collections.sort(globalData, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> m1, Map<String, Object> m2) {
                Integer num1=Integer.parseInt((String) m1.get("what"));
                Integer num2=Integer.parseInt((String) m2.get("what"));
                return -num1.compareTo(num2);
            }
        });
}
}
