package com.example.saurabhomer.qualityapp.Measurement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.MeasurementDescription;
import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPageModel;
import com.example.saurabhomer.qualityapp.R;

public class Measurment extends AppCompatActivity
{
    EditText edt_measurement;
    EditText edt_tolerance_plus;
    EditText edt_tolerance_minus;
    CheckBox check_40;
    CheckBox check_42;
    CheckBox check_44;
    CheckBox check_46;
    CheckBox check_48;
    Button next;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurment_description);

        View  view_measurment= findViewById(R.id.edt_measurment);
        edt_measurement = view_measurment.findViewById(R.id.atvCommon);

        View  view_tolerance_plus= findViewById(R.id.edt_tolerance_plus);
        edt_tolerance_plus = view_tolerance_plus.findViewById(R.id.atvCommon);

        View  view_tolerance_minus= findViewById(R.id.edt_tolerance_minus);
        edt_tolerance_minus = view_tolerance_minus.findViewById(R.id.atvCommon);

        View view_done = findViewById(R.id.btn_done_measurement);
        done = view_done.findViewById(R.id.btnNext);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeasurementModel measurementModel = new MeasurementModel();
                measurementModel.setEdt_measur(edt_measurement.getText().toString());
                measurementModel.setEdt_tolerance_plus(edt_tolerance_plus.getText().toString());
                measurementModel.setEdt_tolerance_minus(edt_tolerance_minus.getText().toString());
            }
        });
    }
}
