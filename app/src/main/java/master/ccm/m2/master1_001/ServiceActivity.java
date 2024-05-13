package master.ccm.m2.master1_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }


    public void onClickLancerServiceSimple(View view) {
    Intent myIntent = new Intent(this, MonService.class);
    startService(myIntent);
    }


}
