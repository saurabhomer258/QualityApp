package com.example.saurabhomer.qualityapp.MainSeet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;

import com.example.saurabhomer.qualityapp.R;

public class MainSheet extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sheet);
        AutoCompleteTextView styleNu = findViewById(R.id.edt_style_no).findViewById(R.id.atvCommon);
//        AutoCompleteTextView styleNu = findViewById(R.id.edt_buyer_name).findViewById(R.id.atvCommon);
//        AutoCompleteTextView styleNu = findViewById(R.id.edt_product_name).findViewById(R.id.atvCommon);
//        AutoCompleteTextView styleNu = findViewById(R.id.edt_order_quality).findViewById(R.id.atvCommon);
//        AutoCompleteTextView styleNu = findViewById(R.id.edt_style_no).findViewById(R.id.atvCommon);
//        AutoCompleteTextView styleNu = findViewById(R.id.edt_style_no).findViewById(R.id.atvCommon);
//        styleNu.getText();
    }
}
