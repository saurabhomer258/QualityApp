package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.saurabhomer.qualityapp.R;

public class AreaOfPackingMaterial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_of_packing_material);

        View view_edt_hour = findViewById(R.id.edt_hour);
        final EditText editText_edt_hour = view_edt_hour.findViewById(R.id.atvCommon);

        View view_edt_cartoon = findViewById(R.id.edt_cartoon);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);


        View view_edt_check_cartoon = findViewById(R.id.edt_check_cartoon);
        final EditText editText_edt_check_cartoon = view_edt_check_cartoon.findViewById(R.id.atvCommon);


        View view_edt_packinglabel = findViewById(R.id.edt_packinglabel);
        final RadioButton radioButton_view_edt_packinglabel = view_edt_packinglabel.findViewById(R.id.ok);


        View view_edt_additionallabel = findViewById(R.id.edt_additionallabel);
        final RadioButton radioButton_edt_additionallabel = view_edt_additionallabel.findViewById(R.id.ok);

        View view_edt_misplace = findViewById(R.id.edt_misplace);
        final RadioButton radioButton_edt_misplace = view_edt_misplace.findViewById(R.id.ok);

        View view_edt_incorrectlabel = findViewById(R.id.edt_incorrectlabel);
        final RadioButton radioButton_edt_incorrectlabel= view_edt_incorrectlabel.findViewById(R.id.ok);

        View view_edt_damagelabel = findViewById(R.id.edt_damagelabel);
        final RadioButton radioButton_edt_damagelabel= view_edt_damagelabel.findViewById(R.id.ok);


        View view_edt_incorrectUPC = findViewById(R.id.edt_incorrectUPC);
        final RadioButton radioButton_edt_incorrectUPC= view_edt_incorrectUPC.findViewById(R.id.ok);

        View view_edt_incorrectSize = findViewById(R.id.edt_incorrectSize);
        final RadioButton radioButton_edt_incorrectSize= view_edt_incorrectSize.findViewById(R.id.ok);

        View view_edt_incorrectHanger = findViewById(R.id.edt_incorrectHanger);
        final RadioButton radioButton_edt_incorrectHanger= view_edt_incorrectHanger.findViewById(R.id.ok);

        View view_edt_polywarning = findViewById(R.id.edt_polywarning);
        final RadioButton radioButton_edt_polywarning= view_edt_polywarning.findViewById(R.id.ok);


        View view_edt_total_defect_count = findViewById(R.id.edt_total_defect_count);
        final EditText editText_edt_total_defect_count = view_edt_total_defect_count.findViewById(R.id.atvCommon);


        View btn_next = findViewById(R.id.btn_next);
        Button bt_next = btn_next.findViewById(R.id.btnNext);

        View btn_done = findViewById(R.id.btn_done_measurement);
        Button bt_done = btn_done.findViewById(R.id.btnNext);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AreaOfPackingMaterial.this, AreaOfPackingMaterial.class);
                startActivity(i);
            }
        });

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
