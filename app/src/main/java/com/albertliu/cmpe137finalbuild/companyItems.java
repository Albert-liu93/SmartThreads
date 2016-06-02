package com.albertliu.cmpe137finalbuild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class companyItems extends AppCompatActivity {
    Button companyitemcontinueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyitems);
        companyitemcontinueBtn = (Button)findViewById(R.id.companyitemcontinueBtn);

        companyitemcontinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(companyItems.this, Size.class));
            }
        });
    }
}
