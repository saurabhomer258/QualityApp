package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.BaseActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class CartoonAudit extends BaseActivity implements View.OnClickListener
{

    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker;
    EditText txtDate;
    Button info_btn;
    static CartoonAuditModel cartoonAuditModel = new CartoonAuditModel();
    static ArrayList<AreaofOutsideCartoonModel> areaofOutsideCartoonModelArrayList = new ArrayList<>();
    static ArrayList<AreaofInsideCartoonModel> areaofInsideCartoonModelArrayList = new ArrayList<>();
    static ArrayList<AreaOfPackingMaterialModel> areaOfPackingMaterialArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_audit);

        info_btn = (Button)findViewById(R.id.info_daily);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);


        final Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {


                  cartoonAuditModel.setDate(txtDate.getText().toString());
//                cartoonAuditModel.setCartoonlotquantity(editText_edt_cartoon.getText().toString());
//                cartoonAuditModel.setHour1(editText_edt_hour1.getText().toString());
//                cartoonAuditModel.setHour2(editText_edt_hour2.getText().toString());
//                cartoonAuditModel.setHour3(editText_edt_hour3.getText().toString());
//                cartoonAuditModel.setHour4(editText_edt_hour4.getText().toString());
//                cartoonAuditModel.setHour5(editText_edt_hour5.getText().toString());
//                cartoonAuditModel.setHour6(editText_edt_hour6.getText().toString());
//                cartoonAuditModel.setHour7(editText_edt_hour7.getText().toString());
//                cartoonAuditModel.setHour8(editText_edt_hour8.getText().toString());

                Intent i =new Intent(CartoonAudit.this, AreaofOutsideCartoon.class);
                startActivity(i);
                finish();
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
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}
