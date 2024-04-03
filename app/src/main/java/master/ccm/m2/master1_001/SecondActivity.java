package master.ccm.m2.master1_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    private TextView premierTextView;
    private TextView secondTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        premierTextView=findViewById(R.id.id_premier_param);
        secondTextView=findViewById(R.id.id_second_param);


        Intent monIntent = getIntent();
        Bundle bundleRecup = monIntent.getExtras();
        if(Objects.nonNull(bundleRecup)) {
            String chaineRecu=bundleRecup.getString("key1", "default value if the key doens't exist");
            Integer chaineRecu2=bundleRecup.getInt("key2", 98);
            premierTextView.setText(chaineRecu);
            secondTextView.setText(chaineRecu2.toString());
        }
    }

    public void onClick_quitter(View view) {
        finish();
    }
}
