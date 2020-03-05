package com.example.saurabhomer.qualityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import customView.DailyFinishingEditText;

public class SkuCheckReport extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_check_report100);
        DailyFinishingEditText edt_readyQuantity = findViewById(R.id.edt_readyquantity);
        DailyFinishingEditText edt_checkquantity = findViewById(R.id.edt_checkquantity);
        Spinner mdropdown = (Spinner) edt_readyQuantity.findViewById(R.id.spinner);
        Spinner checkquantity = (Spinner) edt_readyQuantity.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Data,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
