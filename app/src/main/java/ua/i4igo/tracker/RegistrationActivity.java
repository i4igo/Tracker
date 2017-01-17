package ua.i4igo.tracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etRPhone;
    private EditText etRPassword;
    private EditText etRConfirmPass;
    private EditText etRName;
    private EditText etRLName;
    private EditText etREMail;
    private EditText etRCity;
    private Toolbar tbAccept;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_registration, menu);
        return true;
    }

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

        tbAccept = (Toolbar) findViewById(R.id.tbAccept);
        setSupportActionBar(tbAccept);

        String sPhone = etRPhone.getText().toString();
        String sPassword = etRPassword.getText().toString();
        String sConfirmPass = etRConfirmPass.getText().toString();
        String sName = etRName.getText().toString();
        String sLName = etRLName.getText().toString();
        String sEMail = etREMail.getText().toString();
        String sCity = etRCity.getText().toString();

        // при нажатии на кнопку "сохранить" создается объект AccountUser
        // в него передаются данные

        AccountUser user = new AccountUser(sPhone, sPassword, sConfirmPass, sName, sLName, sEMail, sCity);
        user.savePhone(user.getPhone());
        user.savePassword(user.getPassword());
        user.saveConfirmPassword(user.getConfirmPassword());
        user.saveName(user.getName());
        user.saveLName(user.getLName());
        user.saveEMail(user.getEMail());
        user.saveCity(user.getCity());
    }
}
