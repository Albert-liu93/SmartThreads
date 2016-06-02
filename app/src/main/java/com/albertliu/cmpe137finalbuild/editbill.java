package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class editbill extends Activity {

    Button billingnextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editbill);

        billingnextBtn = (Button)findViewById(R.id.button);

        billingnextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(editbill.this, confirmation.class));
            }
        });
    }
}
