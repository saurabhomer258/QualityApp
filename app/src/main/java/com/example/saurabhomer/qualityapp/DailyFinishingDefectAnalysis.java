package com.example.saurabhomer.qualityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DailyFinishingDefectAnalysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_defect_analysis1);
        View view_edt_hour = findViewById(R.id.edt_hours);
        final EditText editText_hour = view_edt_hour.findViewById(R.id.atvCommon);

        View view_edt_total_defect = findViewById(R.id.edt_total_defects);
        final EditText editText_total_defects = view_edt_total_defect.findViewById(R.id.atvCommon);

        View view_edt_defects = findViewById(R.id.edt_defect_s);
        final EditText editText_edt_defects = view_edt_defects.findViewById(R.id.atvCommon);

        View view_edt_total_check = findViewById(R.id.edt_total_check);
        final EditText editText_edt_total_check = view_edt_total_check.findViewById(R.id.atvCommon);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);
        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(DailyFinishingDefectAnalysis.this,DailyFinishingAnalysis2.class);
               startActivity(intent);
            }
        });



    }
}
