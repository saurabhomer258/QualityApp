package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;

public class AreaofOutsideCartoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areaof_outside_audit);

        View view_edt_hour = findViewById(R.id.edt_hour);
        final EditText editText_edt_hour = view_edt_hour.findViewById(R.id.atvCommon);

        View view_edt_cartoon = findViewById(R.id.edt_cartoon);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);

        View view_edt_cartoon_shiping = findViewById(R.id.edt_cartoon_shiping);
        final RadioButton radioButton_edt_cartoon_shiping = view_edt_cartoon_shiping.findViewById(R.id.ok);

        View view_edt_printing= findViewById(R.id.edt_printing);
        final RadioButton radioButton_edt_printing = view_edt_printing.findViewById(R.id.ok);

        View view_edt_car_size = findViewById(R.id.edt_car_size);
        final RadioButton radioButton_edt_car_size = view_edt_car_size.findViewById(R.id.ok);

        View view_edt_cartoon_no = findViewById(R.id.edt_cartoon_no);
        final RadioButton radioButton_edt_cartoon_no = view_edt_cartoon_no.findViewById(R.id.ok);

        View view_edt_barcode = findViewById(R.id.edt_barcode);
        final RadioButton radioButton_edt_barcode = view_edt_barcode.findViewById(R.id.ok);

        View view_edt_car_fly = findViewById(R.id.edt_car_fly);
        final RadioButton radioButton_edt_car_fly= view_edt_car_fly.findViewById(R.id.ok);


        final TextView textView_edt_hour8 = (TextView) findViewById(R.id.remarks);

        View btn_next = findViewById(R.id.btn_next);
        Button bt_next = btn_next.findViewById(R.id.btnNext);

        View btn_done = findViewById(R.id.btn_done_measurement);
        Button bt_done = btn_done.findViewById(R.id.btnNext);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AreaofOutsideCartoon.this, AreaofOutsideCartoon.class);
                startActivity(i);
            }
        });

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AreaofOutsideCartoon.this, AreaOfInsideCartoon.class);
                startActivity(i);
            }
        });
    }
}
