package ua.i4igo.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TrackerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        String s = getIntent().getExtras().get(Constants.KEY_LOGIN).toString();
    }
}
