package master.ccm.m2.master1_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getName();
    private Button secondsBouton;
    private EditText myEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.id_saisie_editText);

        secondsBouton=findViewById(R.id.button2);
        secondsBouton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "The message");
                showToaster();
            }
        });
    }

    public void onClickTestFunction(View view) {
        finish();
    }

    public void onClickGoActivity2(View view) {
        final Intent intentUActivity2 = new Intent(this, SecondActivity.class);
        //intentUActivity2.putExtra("key1", "value1");
        Bundle myBundle = new Bundle();
        myBundle.putString("key1", myEditText.getText().toString());

        startActivity(intentUActivity2);
    }

    public void showToaster(){
        Toast.makeText(this,myEditText.getText().toString(), Toast.LENGTH_LONG).show();

    }
}
