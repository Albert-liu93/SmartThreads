package com.albertliu.cmpe137finalbuild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;


public class howitWorks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howitworks);
    }
}