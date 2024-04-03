package master.ccm.m2.master1_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private EditText saisieEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        saisieEditText = findViewById(R.id.id_saisie_act3);
    }


    public void onClick_quitter(View view) {
        String maChaine = saisieEditText.getText().toString();
        Intent unIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("clef_from_act3", maChaine);
        unIntent.putExtras(bundle);
        setResult(RESULT_OK, unIntent);
        finish();
    }
}
