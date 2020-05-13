package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.R;

public class inlinePreLineFInal2 extends AppCompatActivity {

    Spinner select_level,inspection_level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_pre_line_final2);

        final EditText edt_quantity = findViewById(R.id.edt_quantity).findViewById(R.id.atvCommon);
        select_level= findViewById(R.id.sel_aql).findViewById(R.id.spinner);
        inspection_level= findViewById(R.id.inspection_level).findViewById(R.id.spinner);
        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);

        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
