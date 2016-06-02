package com.albertliu.cmpe137finalbuild;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Size extends Activity {


    Spinner shirtSpinner,sockSpinner;
    EditText etWaist, etLength;
    Button submitButton,shirtSizeButton;
    ArrayAdapter<CharSequence> adapter;
    AlertDialog.Builder fieldError;
    private final String Waist = "Waist";
    private final String Length = "Length";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);


        shirtSpinner = (Spinner)findViewById(R.id.shirtSpinner);
        sockSpinner = (Spinner)findViewById(R.id.sockSpinner);
        submitButton = (Button)findViewById(R.id.submitButton);
        shirtSizeButton = (Button)findViewById(R.id.shirtSizeButton);
        etWaist = (EditText)findViewById(R.id.etWaist);
        etLength = (EditText)findViewById(R.id.etLength);
        adapter = ArrayAdapter.createFromResource(this,R.array.sizes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shirtSpinner.setAdapter(adapter);
        sockSpinner.setAdapter(adapter);




        shirtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Waist = etWaist.getText().toString();
                String Length = etLength.getText().toString();
                String shirtsize = shirtSpinner.getSelectedItem().toString();
                String socksize = sockSpinner.getSelectedItem().toString();
                if(Waist.matches("") || (Length.matches(""))){
                    fieldError = new AlertDialog.Builder(Size.this);
                    fieldError.setTitle("Error!");
                    fieldError.setMessage("Some Fields Aren't Complete!");
                    fieldError.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    AlertDialog alertDialog = fieldError.create();
                    alertDialog.show();
                    return;
                } else {
                    startActivity(new Intent(Size.this, shipping.class));
                    //BackgroundTask backgroundTask = new BackgroundTask(Size.this);
                    //backgroundTask.execute("sizeinput", shirtSpinner.getSelectedItem().toString(), etWaist.getText().toString(), etLength.getText().toString(), sockSpinner.getSelectedItem().toString());
                }
            }
        });

        shirtSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Size.this, sizeChart.class));
            }
        });


    }



}
