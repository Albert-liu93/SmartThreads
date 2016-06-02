package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class SignUpActivity extends Activity {

    private EditText entryName;
    private EditText uName;
    private EditText pWord;
    private EditText cPass;
    private Button sub;

    Firebase myFirebaseRef = new Firebase("https://userauthdemo.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        entryName = (EditText) findViewById(R.id.fullName);
        uName = (EditText) findViewById(R.id.userName);
        pWord = (EditText) findViewById(R.id.pass);
        cPass = (EditText) findViewById(R.id.conPass);
        sub = (Button) findViewById(R.id.subBtn);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean check = false;
                if (entryName.getText().toString().equals("")) {              //any of the entry are not filled, display a toast saying to fill in the missing fields
                    entryName.setError(" Please input your name");
                }
                if (uName.getText().toString().equals("")) {              //if name is the same as the user, display a toast saying to change either the user or the full Name
                    uName.setError("Please input a username");
                }
                if (pWord.getText().toString().equals("")) {              //if user and full are not the same && password and confirm password are the same, proceed to the next activity
                    pWord.setError("Please input a password");
                }
                if (cPass.getText().toString().equals("")) {              //if user and full name are not the same && the password and confirm password are not the same, display
                    cPass.setError("Please confirm your password");
                    //message that password and the confirm password field are not the same.
                }
                if (!cPass.getText().toString().equals(pWord.getText().toString())) {
                    cPass.setError("Please make sure the two password fields are the same");
                }
                if (cPass.getText().toString().length() > 0 && pWord.getText().toString().length() > 0) {
                    check = true;
                }
                if (!entryName.getText().toString().equals("") && !uName.getText().toString().equals("") && (check) &&
                        (pWord.getText().toString().equals(cPass.getText().toString()))) {

//                    myFirebaseRef.createUser(uName.getText().toString(), pWord.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
//                        @Override
//                        public void onSuccess(Map<String, Object> result) {
//                            System.out.println("Successfully created user account with uid: " + result.get("uid"));
//                            startActivity(new Intent(SignUpActivity.this, aboutUS.class));
//                        }
//                        @Override
//                        public void onError(FirebaseError firebaseError) {
//                            System.out.println("Error");
//                        }
//                    });



                    BackgroundTask backgroundTask = new BackgroundTask(SignUpActivity.this);
                    backgroundTask.execute("register", entryName.getText().toString(), uName.getText().toString(), pWord.getText().toString());
                }
            }
        });
    }

}
