package ua.i4igo.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar tbToolBar;
    private EditText etLogin;
    private EditText etPassword;
    private Button bRegistration;
    private Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*tbToolBar = (Toolbar) findViewById(R.id.tbToolbar);
        setSupportActionBar(tbToolBar);*/

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegistration = (Button) findViewById(R.id.bRegistration);
        bLogin = (Button) findViewById(R.id.bLogin);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bLogin:
                Intent intentLogin = new Intent(MainActivity.this, TrackerActivity.class);
                /*Bundle bundle = new Bundle();
                bundle.putString(Constants.KEY_LOGIN, etLogin.getText().toString());
                bundle.putString(Constants.KEY_PASSWORD, etPassword.getText().toString());*/
                intentLogin.putExtra(Constants.KEY_LOGIN, etLogin.getText().toString());
                startActivity(intentLogin);
                finish();
                break;

            case R.id.bRegistration:
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }

    }
}

//Toast.makeText(this, "r", Toast.LENGTH_SHORT).show();