package ua.i4igo.tracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etRPhone;
    private EditText etRPassword;
    private EditText etRConfirmPass;
    private EditText etRName;
    private EditText etRLName;
    private EditText etREMail;
    private EditText etRCity;
    private Toolbar tbAccept;

    String sPhone;
    String sPassword;
    String sConfirmPass;
    String sName;
    String sLName;
    String sEMail;
    String sCity;

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

        etRPhone = (EditText) findViewById(R.id.etRPhone);
        etRPassword = (EditText) findViewById(R.id.etRPassword);
        etRConfirmPass = (EditText) findViewById(R.id.etRConfirmPass);
        etRName = (EditText) findViewById(R.id.etRName);
        etRLName = (EditText) findViewById(R.id.etRLName);
        etREMail = (EditText) findViewById(R.id.etREMail);
        etRCity = (EditText) findViewById(R.id.etRCity);

        tbAccept = (Toolbar) findViewById(R.id.tbAccept);
        setSupportActionBar(tbAccept);

        sPhone = etRPhone.getText().toString();
        sPassword = etRPassword.getText().toString();
        sConfirmPass = etRConfirmPass.getText().toString();
        sName = etRName.getText().toString();
        sLName = etRLName.getText().toString();
        sEMail = etREMail.getText().toString();
        sCity = etRCity.getText().toString();

        // при нажатии на кнопку "сохранить" создается объект AccountUser
        // в него передаются данные
        AccountUser user = new AccountUser(this);

        user.savePhone(sPhone);
        user.savePassword(sPassword);
        user.saveConfirmPassword(sConfirmPass);
        user.saveName(sName);
        user.saveLName(sLName);
        user.saveEMail(sEMail);
        user.saveCity(sCity);
    }

    @Override
    public void onClick(View v) {
        user = new AccountUser(this);
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        user.savePhone(sPhone);
        user.savePassword(sPassword);
        user.saveConfirmPassword(sConfirmPass);
        user.saveName(sName);
        user.saveLName(sLName);
        user.saveEMail(sEMail);
        user.saveCity(sCity);
    }
}
