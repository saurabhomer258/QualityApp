package com.example.saurabhomer.qualityapp.SkuCheckReport;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.MainSkuModel;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuDateModel;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

import customView.NextButton;

public class SkuCheckReport100Page1 extends AppCompatActivity implements View.OnClickListener
{
    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker;
    static EditText txtDate;

    static SkuCheckReport100Model skuCheckReport100Model = new SkuCheckReport100Model();
    static ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList1 = new ArrayList<>();
    Button submitButton ,info_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sku_check_report100_page2);


        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        info_btn = findViewById(R.id.info_sku);

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkuCheckReport100Page1.this, CommonStyleData.class);
                startActivity(intent);
            }
        });

        View view_readyquantity = findViewById(R.id.edt_readyquantity);
        final EditText editText_readyquantity = view_readyquantity.findViewById(R.id.atvCommon);

        View view_checkquantity = findViewById(R.id.edt_checkquantity);
        final EditText editText_checkquantity = view_checkquantity.findViewById(R.id.atvCommon);

        View view_size = findViewById(R.id.edt_size);
        final EditText editText_size = view_size.findViewById(R.id.atvCommon);
        NextButton nextButton = findViewById(R.id.btn_next1);
        submitButton  = nextButton.findViewById(R.id.btnNext);


          submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String readq = editText_readyquantity.getText().toString();
                            String checkq = editText_checkquantity.getText().toString();
                            String size = editText_size.getText().toString();
                            String date = txtDate.getText().toString();

                            if (isNullOrEmpty(readq) || isNullOrEmpty(checkq) || isNullOrEmpty(size) || isNullOrEmpty(date)) {
                                Toast.makeText(SkuCheckReport100Page1.this, "Field's should not be Empty", Toast.LENGTH_SHORT).show();
                            } else {

                                skuCheckReport100Model.setEdt_checkquantity(editText_checkquantity.getText().toString());
                                skuCheckReport100Model.setEdt_readyquantity(editText_readyquantity.getText().toString());
                                skuCheckReport100Model.setEdt_size(editText_size.getText().toString());
                                Intent i = new Intent(SkuCheckReport100Page1.this, SkuCheckReport100Page2.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    });





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
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth)
                        {
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }

}
