package com.codepath.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.lang.annotation.AnnotationTypeMismatchException;
public class LoginActivity extends AppCompatActivity {
   //constants
    public static final String TAG = "LoginActivity";



// layouts
    private LinearLayout loginLayout;
    private AnimationDrawable animationDrawable;

   //fields
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        gradientBackground();
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(userName , password);
            }
        });
    }
    private void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Log.e(TAG , "Issue with Login");
                    e.printStackTrace();
                }
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    private void gradientBackground(){
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        loginLayout = (LinearLayout) findViewById(R.id.login_layout);
        animationDrawable = (AnimationDrawable) loginLayout.getBackground();
        animationDrawable.setExitFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }
}
