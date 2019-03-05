package edevelopmentandroidcompanydomain.num4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ParkStatusActivity extends AppCompatActivity {

    private TextView tvCurrentNum,tvTotalNum;
    private SeekBar seekBarPark;
    private Button btnGo;
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
        btnGo=findViewById(R.id.btnGo);
    }
}
