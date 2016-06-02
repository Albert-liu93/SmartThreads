package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class confirmation extends Activity {

    String ORDER_NUMBER;
    Button Tracking, mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView orderNumber;

        Tracking = (Button)findViewById(R.id.trackingBtn);
        mainMenu = (Button)findViewById(R.id.mainMenubtn);
        orderNumber = (TextView)findViewById(R.id.ordernumber);
        ORDER_NUMBER = getSaltString();
        orderNumber.setText(ORDER_NUMBER);

        Tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(confirmation.this,Tracking.class);
                i.putExtra("orderNumber",ORDER_NUMBER);
                startActivity(i);
            }
        });
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(confirmation.this, companyList.class));
            }
        });

    }
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


}
