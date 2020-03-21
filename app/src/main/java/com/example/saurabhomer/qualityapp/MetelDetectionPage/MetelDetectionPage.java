package com.example.saurabhomer.qualityapp.MetelDetectionPage;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;


import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class MetelDetectionPage extends AppCompatActivity implements
        View.OnClickListener {
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button btnDatePicker;
    EditText txtDate;
    Button next;
    Button done;
    EditText edt_date;
    EditText edt_time;
    RadioButton r_calibrated;
    EditText edt_garment_pass;
    EditText edt_garment_reject;
    EditText edt_garment;
    private ProgressDialog progressDialog;
    static MetelDetectionPageModel metelDetectionPageModel = new MetelDetectionPageModel();
    static ArrayList<MetelDetectionPageModel> METELDETECTIONMODELLIST = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metel_detection_page);

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

        View view_time = findViewById(R.id.edt_time);
        edt_time = view_time.findViewById(R.id.atvCommon);

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

        done.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!NetworkUtils.isNetworkConnected(MetelDetectionPage.this))
                {
                    return;
                }
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                metelDetectionPageModel.setEdt_date(txtDate.getText().toString());
                metelDetectionPageModel.setEdt_time(edt_time.getText().toString());
                metelDetectionPageModel.setEdt_garment_pass(edt_garment_pass.getText().toString());
                metelDetectionPageModel.setEdt_no_of_garment_check(edt_garment.getText().toString());
                metelDetectionPageModel.setEdt_garment_fail(edt_garment_reject.getText().toString());
                metelDetectionPageModel.setEdt_calibrated(getStringOfRedio(r_calibrated.isChecked()));
                FirebaseDatabase.getInstance().getReference("matelDetectionPage")
                        .child(STYLE_NUMBER).setValue(metelDetectionPageModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.hide();
                        finish();
                    }
                });


            }
        });


    }
    private String getStringOfRedio(boolean okButton){
        if(okButton) return "ok";
        else return "notOk";
    }

    private void senddonedata(MetelDetectionPageModel metelDetectionPageModel)
    {

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
}
