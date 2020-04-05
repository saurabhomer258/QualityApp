package com.example.saurabhomer.qualityapp.utils;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;

import java.util.Calendar;

public class CommonDateFilter extends AppCompatActivity implements
        View.OnClickListener {
    Button btnDatePicker, btnTimePicker;
    static EditText commontxtDate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String str;
    String test1 = "Skutest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_date_filter);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        commontxtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        final String strDate = commontxtDate.getText().toString();

        View btn_done = findViewById(R.id.btn_donedate);
        Button bt_done = btn_done.findViewById(R.id.btnNext);
        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=getIntent();
                str = intent.getStringExtra("Name");

                if(test1.equals(str))
                {
                    Intent i = new Intent(CommonDateFilter.this, SkuAdmin.class);
                    i.putExtra("SkuDate",strDate);
                    startActivity(i);
                }


            }
        });
    }
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            commontxtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}
