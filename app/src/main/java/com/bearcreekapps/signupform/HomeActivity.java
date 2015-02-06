package com.bearcreekapps.signupform;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HomeActivity extends ActionBarActivity {

    public static final String TAG = "HomeActivity";
    public static final String EXTRA_USER = "User";
    public TextView mWelcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User user = (User) getIntent().getSerializableExtra(EXTRA_USER);
        Log.d(TAG, "Username "+ user.getUsername() + " was found.");

        mWelcomeText = (TextView)findViewById(R.id.welcome_string);
        String welcomeMessage = String.format(getResources().getString(R.string.welcome_format),user.getUsername());
        mWelcomeText.setText(welcomeMessage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
