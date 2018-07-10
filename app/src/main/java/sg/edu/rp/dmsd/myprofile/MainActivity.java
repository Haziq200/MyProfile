package sg.edu.rp.dmsd.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("Name","");
        etName.setText(name);

        float gpa = prefs.getFloat("GPA",0);
        etGPA.setText(String.valueOf(gpa));

        int radio = prefs.getInt("Radio",0);
        rgGender.check(radio);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get the user input from the EditText abd store it in a varuable
        String strName = etName.getText().toString();
        float floatGPA = Float.parseFloat(etGPA.getText().toString());
        int intRadio = rgGender.getCheckedRadioButtonId();


        //Step 1b: Obtain an instance of the SharedPreferences

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1c: Obtain an instance of the SharedPreferences Editor for update later

        SharedPreferences.Editor prefsEdit = prefs.edit();

        // Step 1d: Add the key-value pair
        //           The value should be from the variable defined in Step 1a
        prefsEdit.putString("Name",strName);
        prefsEdit.putFloat("GPA",floatGPA);
        prefsEdit.putInt("Radio",intRadio);


        // Step 1e: Call commit() method to save the changes into SharedPreferences
        prefsEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

        // This is a new line

    }
}
