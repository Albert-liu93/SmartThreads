package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class editInfo extends Activity {

    private Button tobillingedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        EditBilling();
    }

    public void EditBilling() {
        tobillingedit = (Button) findViewById(R.id.tobillingedit);

        tobillingedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(editInfo.this, editbill.class); //to confirmation page
                startActivity(intent);
            }
        });
    }


}
