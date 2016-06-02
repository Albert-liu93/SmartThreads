package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class billing extends Activity {

    private Button NextAct;
    private EditText CardNumber;
    private EditText CardName;
    private EditText Expiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        NextAct();
    }

    public void NextAct() {
        CardNumber = (EditText) findViewById(R.id.cardnum);
        CardName = (EditText) findViewById(R.id.cardname);
        Expiration = (EditText) findViewById(R.id.expiration);
        NextAct = (Button) findViewById(R.id.nextact);

        NextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((CardNumber.getText().toString().length() < 16)) {
                    CardNumber.setError("Too Few Numbers");
                }
                if((CardName.getText().toString().isEmpty())) {
                    CardName.setError("Please Enter Name");
                }
                if((Expiration.getText().toString().isEmpty())) {
                    Expiration.setError("Please Enter Expiration Date");
                }
                else if(CardNumber.getText().toString().length() == 16 &&
                        !CardName.getText().toString().isEmpty() &&
                        !Expiration.getText().toString().isEmpty()) {
                    Intent intent = new Intent(billing.this, editInfo.class);
                    startActivity(intent);
                }
            }
        });

    }

}
