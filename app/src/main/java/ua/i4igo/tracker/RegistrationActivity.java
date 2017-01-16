package ua.i4igo.tracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etRPhone;
    private EditText etRPassword;
    private EditText etRConfirmPass;
    private EditText etRName;
    private EditText etRLName;
    private EditText etREMail;
    private EditText etRCity;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etRPhone = (EditText) findViewById(R.id.etRPhone);
        etRPassword = (EditText) findViewById(R.id.etRPassword);
        etRConfirmPass = (EditText) findViewById(R.id.etRConfirmPass);
        etRName = (EditText) findViewById(R.id.etRName);
        etRLName = (EditText) findViewById(R.id.etRLName);
        etREMail = (EditText) findViewById(R.id.etREMail);
        etRCity = (EditText) findViewById(R.id.etRCity);

        // при нажатии на кнопку "сохранить" создается объект AccountUser
        // в него передаются данные

        AccountUser user = new AccountUser();


    }
}
