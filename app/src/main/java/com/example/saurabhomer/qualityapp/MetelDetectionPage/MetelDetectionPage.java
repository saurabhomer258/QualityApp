package com.example.saurabhomer.qualityapp.MetelDetectionPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;

import java.util.ArrayList;

public class MetelDetectionPage extends AppCompatActivity {

    Button next;
    Button done;
    EditText edt_date;
    EditText edt_time;
    RadioButton r_calibrated;
    EditText edt_garment_pass;
    EditText edt_garment_reject;
    EditText edt_garment;
    static MetelDetectionPageModel metelDetectionPageModel = new MetelDetectionPageModel();
    static ArrayList<MetelDetectionPageModel> METELDETECTIONMODELLIST = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metel_detection_page);

        View view_date = findViewById(R.id.edt_date);
        edt_date = view_date.findViewById(R.id.atvCommon);

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

                metelDetectionPageModel.setEdt_date(edt_date.getText().toString());
                metelDetectionPageModel.setEdt_time(edt_time.getText().toString());
                metelDetectionPageModel.setEdt_garment_pass(edt_garment_pass.getText().toString());
                metelDetectionPageModel.setEdt_no_of_garment_check(edt_garment.getText().toString());
                metelDetectionPageModel.setEdt_garment_fail(edt_garment_reject.getText().toString());
                metelDetectionPageModel.setEdt_calibrated(getStringOfRedio(r_calibrated.isChecked()));
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
}
