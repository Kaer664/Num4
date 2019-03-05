package edevelopmentandroidcompanydomain.num4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeft();
    }

    List<Map<String,String>> globalData=new ArrayList<>();
    private void initLeft() {
        listViewLeft=findViewById(R.id.listViewLeft);
        initGlobalData();
        SimpleAdapter adapter=new SimpleAdapter(this,globalData,R.layout.main_left_item
                ,new String[]{"text"},new int[]{R.id.text1});
        listViewLeft.setAdapter(adapter);
        listViewLeft.setOnItemClickListener(this);
    }

    private void initGlobalData() {
        //停车场动态   选择一个停车场  搜索停车场   Dashboard  登陆界面  创意设计
        Map<String,String> map1=new HashMap<>();
        map1.put("text","停车场动态");

        Map<String,String> map2=new HashMap<>();
        map2.put("text","选择一个停车场");

        Map<String,String> map3=new HashMap<>();
        map3.put("text","搜索停车场");

        Map<String,String> map4=new HashMap<>();
        map4.put("text","Dashboard");

        Map<String,String> map5=new HashMap<>();
        map5.put("text","登陆界面");

        Map<String,String> map6=new HashMap<>();
        map6.put("text","创意设计");
        globalData.add(map1);
        globalData.add(map2);
        globalData.add(map3);
        globalData.add(map4);
        globalData.add(map5);
        globalData.add(map6);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 1:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 2:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 3:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 4:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 5:
                Log.i("TestNum",String.valueOf(i));
                break;
        }
    }
}
