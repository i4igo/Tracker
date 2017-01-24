package ua.i4igo.tracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar tbAccept;

    private EditText etRPhone;
    private EditText etRPassword;
    private EditText etRConfirmPass;
    private EditText etRName;
    private EditText etRLName;
    private EditText etREMail;
    private EditText etRCity;

    private String sPhone;
    private String sPassword;
    private String sConfirmPass;
    private String sName;
    private String sLName;
    private String sEMail;
    private String sCity;

    private AccountUser user;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_registration, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tbAccept = (Toolbar) findViewById(R.id.tbAccept);
        setSupportActionBar(tbAccept);

        etRPhone = (EditText) findViewById(R.id.etRPhone);
        etRPassword = (EditText) findViewById(R.id.etRPassword);
        etRConfirmPass = (EditText) findViewById(R.id.etRConfirmPass);
        etRName = (EditText) findViewById(R.id.etRName);
        etRLName = (EditText) findViewById(R.id.etRLName);
        etREMail = (EditText) findViewById(R.id.etREMail);
        etRCity = (EditText) findViewById(R.id.etRCity);
    }
    
    // при нажатии на кнопку "сохранить" создается объект AccountUser
    // в него передаются данные
    @Override
    public void onClick(View v) {

        sPhone = etRPhone.getText().toString();
        sPassword = etRPassword.getText().toString();
        sConfirmPass = etRConfirmPass.getText().toString();
        sName = etRName.getText().toString();
        sLName = etRLName.getText().toString();
        sEMail = etREMail.getText().toString();
        sCity = etRCity.getText().toString();

        user = new AccountUser(getApplicationContext());
        user.savePhone(sPhone);
        user.savePassword(sPassword);
        user.saveConfirmPassword(sConfirmPass);
        user.saveName(sName);
        user.saveLName(sLName);
        user.saveEMail(sEMail);
        user.saveCity(sCity);

        SharedPreferences preferences = getSharedPreferences(Constants.FILE_SAVE, MODE_PRIVATE);
        String answer = preferences.getString(Constants.KEY_USER_PHONE, "");
        Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
    }
}
