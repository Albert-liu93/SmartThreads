package com.albertliu.cmpe137finalbuild;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class companyList extends ListActivity{
    private Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companylist);

        String[] companies = {"1. Nike", "2. Adidas", "3. Puma", "4. UnderArmour","5. Old Navy", "6. American Rag", "7. U.S Polo"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, companies);
        getListView().setAdapter(adapter);
        continueButton();
    }
    public void continueButton() {
        cont = (Button)findViewById(R.id.companylistcontinueBtn);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(companyList.this, companyItems.class);
                startActivity(intent1);
            }
        });
    }
}
