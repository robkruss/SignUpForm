package com.bearcreekapps.signupform;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    public static final String TAG = "LoginActivity";

    EditText mUsernameInput;
    EditText mPasswordInput;
    EditText mConfirmInput;
    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameInput = (EditText) findViewById(R.id.editText_username);
        mPasswordInput = (EditText) findViewById(R.id.editText_password);
        mConfirmInput = (EditText) findViewById(R.id.editText_confirm);
        mSubmitButton = (Button) findViewById(R.id.button_submit);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsernameInput.getText().toString();
                String password = mPasswordInput.getText().toString();
                String confirm = mConfirmInput.getText().toString();

                if (password.equals(confirm)){
                    Log.d(TAG,"Password Success");
                    User newUser = new User(username,password);

                    Intent loginActivityIntent = new Intent(LoginActivity.this, HomeActivity.class);
                    loginActivityIntent.putExtra(HomeActivity.EXTRA_USER,newUser);
                    startActivity(loginActivityIntent);

                } else {
                    Log.d(TAG,"Password Failure");
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
