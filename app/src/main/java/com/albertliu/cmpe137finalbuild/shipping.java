package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class shipping extends Activity {

    private Button nextbutton;
    private EditText address;
    private EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);

        NextButton();

    }

    public void NextButton() {
        address = (EditText) findViewById(R.id.etadd);
        city = (EditText) findViewById(R.id.etcity);
        nextbutton = (Button) findViewById(R.id.nextbutton);


        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(address.getText().toString().trim().equals("")) {
                    address.setError("Please Enter Address");
                }
                if(city.getText().toString().trim().equals("")) {
                    city.setError("Please Enter City");
                }
                else if(!address.getText().toString().trim().equals("") &&
                        !city.getText().toString().trim().equals("") ) {
                    Intent intent = new Intent(shipping.this, billing.class);
                    startActivity(intent);
                }
            }
        });

    }
}
