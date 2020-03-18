package com.example.saurabhomer.qualityapp.SkuCheckReport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;

import java.lang.reflect.Array;
import java.util.ArrayList;

import customView.NextButton;

public class SkuCheckReport100Page1 extends AppCompatActivity {
    static SkuCheckReport100Model skuCheckReport100Model = new SkuCheckReport100Model();
    static ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList1 = new ArrayList<>();
    Button submitButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sku_check_report100_page2);
        View view_readyquantity = findViewById(R.id.edt_readyquantity);
        final EditText editText_readyquantity = view_readyquantity.findViewById(R.id.atvCommon);

        View view_checkquantity = findViewById(R.id.edt_checkquantity);
        final EditText editText_checkquantity = view_checkquantity.findViewById(R.id.atvCommon);

        View view_size = findViewById(R.id.edt_size);
        final EditText editText_size = view_size.findViewById(R.id.atvCommon);
        NextButton nextButton = findViewById(R.id.btn_next1);
        if(nextButton!=null)
        {
            submitButton  = nextButton.findViewById(R.id.btnNext);
            if(submitButton!=null) {
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        skuCheckReport100Model.setEdt_checkquantity(editText_checkquantity.getText().toString());
                        skuCheckReport100Model.setEdt_readyquantity(editText_readyquantity.getText().toString());
                        skuCheckReport100Model.setEdt_size(editText_size.getText().toString());
                        Intent i = new Intent(SkuCheckReport100Page1.this, SkuCheckReport100Page2.class);
                        startActivity(i);
                        finish();
                    }

                });
            }

        }
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                skuCheckReport100Model.setEdt_checkquantity(editText_checkquantity.getText().toString());
//                skuCheckReport100Model.setEdt_readyquantity(editText_readyquantity.getText().toString());
//                skuCheckReport100Model.setEdt_size(editText_size.getText().toString());
//                Intent i = new Intent(SkuCheckReport100Page1.this,SkuCheckReport100Page2.class);
//                startActivity(i);
//            }
//        });

    }
}
