package com.example.saurabhomer.qualityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Measurment extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurment_description);

        View  measurment= findViewById(R.id.edt_measurment);
        final EditText editText_measurement = measurment.findViewById(R.id.atvCommon);

        View  tolerance_plus= findViewById(R.id.edt_tolerance_plus);
        final EditText editText_tolerance_plus = tolerance_plus.findViewById(R.id.atvCommon);

        View  tolerance_minus= findViewById(R.id.edt_tolerance_minus);
        final EditText editText_tolerance_minus = tolerance_minus.findViewById(R.id.atvCommon);

    }
}
