package com.albertliu.cmpe137finalbuild;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tracking extends AppCompatActivity {

    TextView orderstatus;
    EditText ordernumber;
    Button submit, mainmenu;
    String orderNumber, ORDER_NUMBER;
    AlertDialog.Builder fieldError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        Intent intent = getIntent();
        ORDER_NUMBER = intent.getExtras().getString("orderNumber");

        orderstatus = (TextView)findViewById(R.id.tvorderStatus);
        ordernumber = (EditText)findViewById(R.id.etorderNumber);
        submit = (Button)findViewById(R.id.chkorderbtn);
        mainmenu = (Button)findViewById(R.id.trackingMainMenubtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderNumber = ordernumber.getText().toString();

                if (ORDER_NUMBER.equals(orderNumber)) {
                    orderstatus.setText("Your order is:     Processing");
                } else {
                    fieldError = new AlertDialog.Builder(Tracking.this);
                    fieldError.setTitle("Error!");
                    fieldError.setMessage("Invalid Order Number!");
                    fieldError.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = fieldError.create();
                    alertDialog.show();
                }
            }
        });

        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // goes to main menu
                Intent intent1 = new Intent(Tracking.this, companyList.class);
                startActivity(intent1);
            }
        });


    }
}
