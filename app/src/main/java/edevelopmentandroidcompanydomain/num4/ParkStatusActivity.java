package edevelopmentandroidcompanydomain.num4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class ParkStatusActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvCurrentNum,tvTotalNum;
    private SeekBar seekBarPark;
    private Button btnGo;
    private CheckBox checkbox1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_status);
        init();
    }

    private void init() {
        tvCurrentNum=findViewById(R.id.tvCurrentNum);
        tvTotalNum=findViewById(R.id.tvTotalNum);
        seekBarPark=findViewById(R.id.seekBarPark);
        checkbox1=findViewById(R.id.checkbox1);
        btnGo=findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGo:

                break;
        }
    }
}
