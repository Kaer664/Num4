package edevelopmentandroidcompanydomain.num4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edevelopmentandroidcompanydomain.num4.adapter.DashBoardAdapter;
import edevelopmentandroidcompanydomain.num4.bean.DashBoardBean;

public class DashBoardActivity extends AppCompatActivity {

    private ListView mLvDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init() {
        List<DashBoardBean> list = new ArrayList<>();
        list.add(new DashBoardBean(1,100,2.5,5));
        list.add(new DashBoardBean(2,52,4.7,8));
        list.add(new DashBoardBean(3,23,7.2,10));
        list.add(new DashBoardBean(4,77,0.5,8));
        mLvDashboard = (ListView) findViewById(R.id.lv_Dashboard);
        mLvDashboard.setAdapter(new DashBoardAdapter(list, this));
    }
}
