package com.example.saurabhomer.qualityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MeasurementDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_description);

        View view_finishingworking = findViewById(R.id.edt_finishing_working_hour);
        final EditText editText_tolerance_plus = view_finishingworking.findViewById(R.id.atvCommon);

        View view_measurementreport = findViewById(R.id.edt_measurement_report);
        final EditText editText_measurementreport = view_measurementreport.findViewById(R.id.atvCommon);

        View view_measurementdescription = findViewById(R.id.edt_measurement_description);
        final EditText editText_measurementdescription = view_measurementdescription.findViewById(R.id.atvCommon);

        View view_tolerance = findViewById(R.id.edt_tolerance);
        final EditText editText_tolerance = view_tolerance.findViewById(R.id.atvCommon);

        View view_next= findViewById(R.id.btn_next_m);
        final Button btn_next = view_next.findViewById(R.id.btnNext);

        View view_done = findViewById(R.id.btn_done_m);
        final Button btn_done = view_done.findViewById(R.id.btnNext);
    }
}
