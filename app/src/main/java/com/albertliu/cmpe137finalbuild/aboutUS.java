package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class aboutUS extends Activity {
    private static Button button_howitworks;
    private static Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        setContentView(R.layout.activity_aboutus);
        onClickButtonListener();
        onClickButtonListenerTwo();
    }
    public void onClickButtonListener(){

        button_howitworks = (Button)findViewById(R.id.howitworksBtn);
        button_howitworks.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(aboutUS.this, howitWorks.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void onClickButtonListenerTwo(){

        button_next = (Button)findViewById(R.id.aboutusnextBtn);
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(aboutUS.this, companyList.class);
                        startActivity(intent1);
                    }
                }
        );
    }
}
