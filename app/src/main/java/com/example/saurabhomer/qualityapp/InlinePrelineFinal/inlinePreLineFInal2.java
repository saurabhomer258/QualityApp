package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.R;

import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;

public class inlinePreLineFInal2 extends AppCompatActivity {

    Spinner select_level,inspection_level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_pre_line_final2);

        final EditText edt_quantity = findViewById(R.id.edt_quantity).findViewById(R.id.atvCommon);
        edt_quantity.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);
        select_level= findViewById(R.id.sel_aql).findViewById(R.id.spinner);
        inspection_level= findViewById(R.id.inspection_level).findViewById(R.id.spinner);
        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);

        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inlinePrelineFinalModel.setQuantity(edt_quantity.getText().toString());
                inlinePrelineFinalModel.setSelect_level(select_level.getSelectedItem().toString());
                inlinePrelineFinalModel.setInspection_level(inspection_level.getSelectedItem().toString());

                Intent intent = new Intent(inlinePreLineFInal2.this,InlinePrelineFinal3.class);
                startActivity(intent);

            }
        });

    }
}
