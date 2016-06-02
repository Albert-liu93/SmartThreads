package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class LogoActivity extends Activity {

    public static EditText uID;
    public static EditText password;
    private Button bLogin;
    private Button bReg;

    Firebase myFirebaseRef = new Firebase("https://userauthdemo.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
        registerButton();
    }
    public void loginButton() {
        uID = (EditText) findViewById(R.id.userID);
        password = (EditText) findViewById(R.id.passwordText);
        bLogin = (Button) findViewById(R.id.btnLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                if(uID.getText().toString().equals("") || password.getText().toString().equals("")) {
                    uID.setError("Invalid Username/Password!");
                }
                if(uID.getText().toString().equals("cmpe137") && password.getText().toString().equals("cmpe137"))
                {
                    startActivity(new Intent(LogoActivity.this , aboutUS.class));
                }
                else
                {
                    myFirebaseRef.authWithPassword(uID.getText().toString(),password.getText().toString(), new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {
                            System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                            Toast toast = Toast.makeText(LogoActivity.this , "Successful Login!", Toast.LENGTH_LONG);
                            toast.show();
                            startActivity(new Intent(LogoActivity.this, companyList.class));
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {

                        }
                    });




                    //BackgroundTask backgroundTask = new BackgroundTask(LogoActivity.this);
                    //backgroundTask.execute("login", uID.getText().toString(), password.getText().toString());
                }

            }
        });
    }
    public void registerButton() {
        bReg = (Button) findViewById(R.id.regButton);
        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoActivity.this, SignUpActivity.class); //signUP activity
                startActivity(intent);
            }

        });

        }

}
