package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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
        Intent i = getIntent();
        if(i!=null){
             String hours= i.getStringExtra("hours");
        }
        setContentView(R.layout.activity_measurment_description);

        View  view_measurment= findViewById(R.id.edt_measurment);
        edt_measurement = view_measurment.findViewById(R.id.atvCommon);

        View  view_tolerance_plus= findViewById(R.id.edt_tolerance_plus);
        edt_tolerance_plus = view_tolerance_plus.findViewById(R.id.atvCommon);

        View  view_tolerance_minus= findViewById(R.id.edt_tolerance_minus);
        edt_tolerance_minus = view_tolerance_minus.findViewById(R.id.atvCommon);

//        final CheckBox  check40= findViewById(R.id.checkbox_40);
//
//        final CheckBox  check42= findViewById(R.id.checkbox_42);
//
//        final CheckBox  check44= findViewById(R.id.checkbox_44);
//
//        final CheckBox  check46= findViewById(R.id.checkbox_46);
//
//        final CheckBox  check48= findViewById(R.id.checkbox_48);



        View view_done = findViewById(R.id.btn_done_measurement);
        done = view_done.findViewById(R.id.btnNext);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeasurementModel measurementModel = new MeasurementModel();
                measurementModel.setEdt_measur(edt_measurement.getText().toString());
                measurementModel.setEdt_tolerance_plus(edt_tolerance_plus.getText().toString());
                measurementModel.setEdt_tolerance_minus(edt_tolerance_minus.getText().toString());
//                if(check40.isChecked())
//                {
//                    measurementModel.setCheck_40("1");
//                }
//                else {
//                    measurementModel.setCheck_40("0");
//                }
//
//                if(check42.isChecked())
//                {
//                    measurementModel.setCheck_42("1");
//                }
//                else {
//                    measurementModel.setCheck_42("0");
//                }
//
//                if(check44.isChecked())
//                {
//                    measurementModel.setCheck_44("1");
//                }
//                else {
//                    measurementModel.setCheck_44("0");
//                }
//                if(check46.isChecked())
//                {
//                    measurementModel.setCheck_46("1");
//                }
//                else {
//                    measurementModel.setCheck_46("0");
//                }
//                if(check48.isChecked())
//                {
//                    measurementModel.setCheck_48("1");
//                }
//                else {
//                    measurementModel.setCheck_48("0");
//                }

            }
        });
    }
    private void senddonedata(MeasurementModel measurementModel)
    {

    }
}
