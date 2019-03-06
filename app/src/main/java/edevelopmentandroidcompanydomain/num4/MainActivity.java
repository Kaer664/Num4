package edevelopmentandroidcompanydomain.num4;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,SensorEventListener {

    private ListView listViewLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
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
        Intent intent=null;
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
                intent=new Intent(this,DashBoardActivity.class);

                Log.i("TestNum",String.valueOf(i));
                break;
            case 4:
                Log.i("TestNum",String.valueOf(i));
                break;
            case 5:
                intent=new Intent(this,CreativeActivity.class);
                Log.i("TestNum",String.valueOf(i));
                break;
        }
        startActivity(intent);
    }

    SensorManager sensorManager;//全局变量，方便取消操作
    Sensor accelerometerSensor;
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);//获得系统服务
        if (sensorManager!=null){
            accelerometerSensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//获取加速度传感器
            if (accelerometerSensor!=null){
                sensorManager.registerListener(this,//listener对象，this表示此类已实现listener接口
                        accelerometerSensor,        //监听的传感器
                        SensorManager.SENSOR_DELAY_NORMAL);//传感器监听的频率
            }
        }
    }


    //传感器监听
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //判断调用此方法的是什么传感器
        int type=sensorEvent.sensor.getType();
        if (type==Sensor.TYPE_ACCELEROMETER){
            //获取三个方向的值
            float[] values = sensorEvent.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            //一般在这三个方向上速度达到40就达到晃动手机的状态，如果手机敏感度低，适当调低就行了
            //速度不能低于10，因为z轴速度本身就是10
            if (Math.abs(x)>19||Math.abs(y)>19||Math.abs(z)>19){
                Toast.makeText(this,"摇一摇功能实现", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,CreativeActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //在onPause方法内取消注册
    @Override
    protected void onPause() {
        sensorManager.unregisterListener(this);
        super.onPause();
    }

}
