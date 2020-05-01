package com.example.saurabhomer.qualityapp.MetelDetectionPage;

import android.app.DatePickerDialog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.app.TimePickerDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class MetelDetectionPage extends AppCompatActivity implements
        View.OnClickListener {
    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker,btnTimePicker;
    EditText txtDate,txtTime;
    Button next;
    Button done;
    EditText edt_date;
    EditText edt_time;
    RadioButton r_calibrated;
    EditText edt_garment_pass;
    EditText edt_garment_reject;
    EditText edt_garment;
    String remark1;
    private ProgressDialog progressDialog;
    static MetelDetectionPageModel metelDetectionPageModel = new MetelDetectionPageModel();
    static ArrayList<MetelDetectionPageModel> METELDETECTIONMODELLIST = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metel_detection_page);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        btnTimePicker=(ImageButton)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);
        btnDatePicker.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        btnTimePicker.setOnClickListener(this);

        View view_calibrate = findViewById(R.id.edt_calibrated);
        r_calibrated = view_calibrate.findViewById(R.id.ok);

        View view_garmentpass = findViewById(R.id.edt_garmentpass);
        edt_garment_pass = view_garmentpass.findViewById(R.id.atvCommon);

        View view_garmentreject = findViewById(R.id.edt_garment_reject);
        edt_garment_reject = view_garmentreject.findViewById(R.id.atvCommon);

        View view_garment = findViewById(R.id.edt_garment);
        edt_garment = view_garment.findViewById(R.id.atvCommon);

        View view_done = findViewById(R.id.btn_done_metel);
        done = view_done.findViewById(R.id.btnNext);

//        View view_next = findViewById(R.id.btn_next);
//        next = view_next.findViewById(R.id.btnNext);

        View view_res = findViewById(R.id.result);
        Button remark_btn = view_res.findViewById(R.id.btnNext);

        View view_remark = findViewById(R.id.remarks);
        final EditText remark = view_remark.findViewById(R.id.atvCommon);


        remark_btn.setText("Show Remark");

        remark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();
                String calibrated = r_calibrated.getText().toString();
                String garment_pass = edt_garment_pass.getText().toString();
                String garment_reject = edt_garment_reject.getText().toString();
                String garment = edt_garment.getText().toString();
                if(isNullOrEmpty(date)||isNullOrEmpty(time)||isNullOrEmpty(calibrated)||isNullOrEmpty(garment)||isNullOrEmpty(garment_pass)||isNullOrEmpty(garment_reject))
                {
                    Toast.makeText(MetelDetectionPage.this, "All fields should be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(edt_garment_reject.getText().toString().trim().equals("0"))
                    {
                        remark.setText("PASS");
                    }
                    else {
                        remark.setText("RECHECK OR REJECT THAT PIECE");
                    }
                }

            }
        });

//        next.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                    String remarks1 = remark.getText().toString();
//
//                    if(isNullOrEmpty(remarks1))
//                    {
//                        Toast.makeText(MetelDetectionPage.this, "Click on the Show remark", Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        MetelDetectionPageModel metelDetectionPageModel = new MetelDetectionPageModel();
//                        metelDetectionPageModel.setEdt_date(txtDate.getText().toString());
//                        metelDetectionPageModel.setEdt_time(txtTime.getText().toString());
//                        metelDetectionPageModel.setEdt_garment_pass(edt_garment_pass.getText().toString());
//                        metelDetectionPageModel.setEdt_no_of_garment_check(edt_garment.getText().toString());
//                        metelDetectionPageModel.setEdt_garment_fail(edt_garment_reject.getText().toString());
//                        metelDetectionPageModel.setEdt_calibrated(getStringOfRedio(r_calibrated.isChecked()));
//                        metelDetectionPageModel.setRemark(remark.getText().toString());
//                        METELDETECTIONMODELLIST.add(metelDetectionPageModel);
//                        Intent i = new Intent(MetelDetectionPage.this,MetelDetectionPage.class);
//                        startActivity(i);
//                        finish();
//                    }
//                }
//
//        });

        done.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String remarks1 = remark.getText().toString();

                if(isNullOrEmpty(remarks1))
                {
                    Toast.makeText(MetelDetectionPage.this, "Click on the Show remark", Toast.LENGTH_SHORT).show();
                }
                else {
                    FirebaseDatabase.getInstance().getReference("matelDetectionPage").child(STYLE_NUMBER)
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot)
                                {
                                    MetelDetectionPageListModel metelDetectionPageListModel = dataSnapshot.getValue(MetelDetectionPageListModel.class);
                                    if(metelDetectionPageListModel!=null)
                                    {
                                        ArrayList<MetelDetectionPageModel> metelDetectionPageModels;
                                        if(metelDetectionPageListModel.getmMetelDetectionPageModel()!=null)
                                        {
                                           metelDetectionPageModels = metelDetectionPageListModel.getmMetelDetectionPageModel();
                                        }
                                        else
                                        {
                                            metelDetectionPageModels = new ArrayList<>();
                                        }
                                       // MetelDetectionPageModel metelDetectionPageModel1 = new MetelDetectionPageModel();
                                        metelDetectionPageModel.setEdt_date(txtDate.getText().toString());
                                        metelDetectionPageModel.setEdt_time(txtTime.getText().toString());
                                        metelDetectionPageModel.setEdt_garment_pass(edt_garment_pass.getText().toString());
                                        metelDetectionPageModel.setEdt_no_of_garment_check(edt_garment.getText().toString());
                                        metelDetectionPageModel.setEdt_garment_fail(edt_garment_reject.getText().toString());
                                        metelDetectionPageModel.setEdt_calibrated(getStringOfRedio(r_calibrated.isChecked()));
                                        metelDetectionPageModel.setRemark(remark.getText().toString());
                                        METELDETECTIONMODELLIST.add(metelDetectionPageModel);
                                        MetelDetectionPageListModel metelDetectionPageListModel1 = new MetelDetectionPageListModel();
                                        metelDetectionPageListModel1.setmMetelDetectionPageModel(metelDetectionPageModels);
                                        FirebaseDatabase.getInstance().getReference("matelDetectionPage")
                                                .child(STYLE_NUMBER).setValue(metelDetectionPageListModel1).addOnCompleteListener(new OnCompleteListener<Void>()
                                        {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task)
                                            {
                                                progressDialog.hide();
                                                finish();
                                            }
                                        });
                                    }
                                    else
                                    {
                                        if (!NetworkUtils.isNetworkConnected(MetelDetectionPage.this))
                                        {
                                            return;
                                        }
                                            progressDialog.setMessage("Verificating...");
                                            progressDialog.show();
                                            metelDetectionPageModel.setEdt_date(txtDate.getText().toString());
                                            metelDetectionPageModel.setEdt_time(txtTime.getText().toString());
                                            metelDetectionPageModel.setEdt_garment_pass(edt_garment_pass.getText().toString());
                                            metelDetectionPageModel.setEdt_no_of_garment_check(edt_garment.getText().toString());
                                            metelDetectionPageModel.setEdt_garment_fail(edt_garment_reject.getText().toString());
                                            metelDetectionPageModel.setEdt_calibrated(getStringOfRedio(r_calibrated.isChecked()));
                                            metelDetectionPageModel.setRemark(remark.getText().toString());
                                            METELDETECTIONMODELLIST.add(metelDetectionPageModel);
                                            MetelDetectionPageListModel metelDetectionPageListModel1 = new MetelDetectionPageListModel();
                                            metelDetectionPageListModel1.setmMetelDetectionPageModel(METELDETECTIONMODELLIST);
                                            FirebaseDatabase.getInstance().getReference("matelDetectionPage")
                                            .child(STYLE_NUMBER).setValue(metelDetectionPageListModel1).addOnCompleteListener(new OnCompleteListener<Void>()
                                            {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task)
                                                {
                                                    progressDialog.hide();
                                                    finish();
                                                }
                                            });
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }

                        });

                    }
                }

        });


    }
    private String getStringOfRedio(boolean okButton){
        if(okButton) return "ok";
        else return "notOk";
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
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener()
                    {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                        {
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

    public static boolean isNullOrEmpty(String str)
    {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}
