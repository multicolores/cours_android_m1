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
    private static final int REQUEST_CODE_OPTION_ACTIVITY3 = 1;


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
        myBundle.putInt("key2", 1234);
        intentUActivity2.putExtras(myBundle);

        startActivity(intentUActivity2);
    }


    public void onClickGoActivity3(View view) {
        final Intent intentUActivity3 = new Intent(this, ThirdActivity.class);

        startActivityForResult(intentUActivity3, REQUEST_CODE_OPTION_ACTIVITY3);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_OPTION_ACTIVITY3) {
                String result = data.getStringExtra("clef_from_act3");
                customShowToast(result);
            }
        }
    }

    public void showToaster(){
        Toast.makeText(this,myEditText.getText().toString(), Toast.LENGTH_LONG).show();

    }

    private void customShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
