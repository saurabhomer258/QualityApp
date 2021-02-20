package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import com.example.saurabhomer.qualityapp.R;

import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;

public class InlinePreLineFinal1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_pre_line_final1);

        View view_radio_washlabel = findViewById(R.id.rad_washlabel);
        final RadioButton rad_washlabel = view_radio_washlabel.findViewById(R.id.ok);

        View view_radio_mainlabel = findViewById(R.id.rad_mainlabel);
        final RadioButton rad_mainlabel = view_radio_mainlabel.findViewById(R.id.ok);

        View view_radio_sizelabel = findViewById(R.id.rad_sizelabel);
        final RadioButton rad_sizelabel = view_radio_sizelabel.findViewById(R.id.ok);

        View view_radio_hanglabel = findViewById(R.id.rad_hangtag);
        final RadioButton rad_hanglabel = view_radio_hanglabel.findViewById(R.id.ok);

        View view_radio_carelabel = findViewById(R.id.rad_carelabel);
        final RadioButton rad_carelabel = view_radio_carelabel.findViewById(R.id.ok);

        View view_radio_pricelabel = findViewById(R.id.rad_pricetag);
        final RadioButton rad_pricelabel = view_radio_pricelabel.findViewById(R.id.ok);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);



        final EditText edt_cartonmarking = findViewById(R.id.edt_cartonmarking).findViewById(R.id.atvCommon);
        final EditText edt_cartonmearsurement = findViewById(R.id.edt_cartonmearsurement).findViewById(R.id.atvCommon);
        final EditText edt_grossweight = findViewById(R.id.edt_grossweight).findViewById(R.id.atvCommon);
        final EditText edt_cartonquality = findViewById(R.id.edt_cartonquality).findViewById(R.id.atvCommon);
        final EditText edt_netweight = findViewById(R.id.edt_netweight).findViewById(R.id.atvCommon);
        final EditText edt_colour = findViewById(R.id.edt_colour).findViewById(R.id.atvCommon);
        final EditText edt_burstweight = findViewById(R.id.edt_burstweight).findViewById(R.id.atvCommon);
        final EditText edt_cutquantity = findViewById(R.id.edt_cutquantity).findViewById(R.id.atvCommon);
        final EditText edt_buttoncolour = findViewById(R.id.edt_buttoncolour).findViewById(R.id.atvCommon);
        final EditText edt_threadcolour = findViewById(R.id.edt_threadcolor).findViewById(R.id.atvCommon);

        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inlinePrelineFinalModel.setCartoonmarking(edt_cartonmarking.getText().toString());
                inlinePrelineFinalModel.setCartonmeasurement(edt_cartonmearsurement.getText().toString());
                inlinePrelineFinalModel.setGrossweight(edt_grossweight.getText().toString());
                inlinePrelineFinalModel.setCartonquality(edt_cartonquality.getText().toString());
                inlinePrelineFinalModel.setNetweight(edt_netweight.getText().toString());
                inlinePrelineFinalModel.setColour(edt_colour.getText().toString());
                inlinePrelineFinalModel.setBurstweight(edt_burstweight.getText().toString());
                inlinePrelineFinalModel.setCutquantity(edt_cutquantity.getText().toString());
                inlinePrelineFinalModel.setButtoncolour(edt_buttoncolour.getText().toString());
                inlinePrelineFinalModel.setThreadcolour(edt_threadcolour.getText().toString());
                inlinePrelineFinalModel.setWashlabel(getStringOfRedio(rad_washlabel.isChecked()));
                inlinePrelineFinalModel.setMainlabel(getStringOfRedio(rad_mainlabel.isChecked()));
                inlinePrelineFinalModel.setSizelabel(getStringOfRedio(rad_sizelabel.isChecked()));
                inlinePrelineFinalModel.setHangtag(getStringOfRedio(rad_hanglabel.isChecked()));
                inlinePrelineFinalModel.setCarelabel(getStringOfRedio(rad_carelabel.isChecked()));
                inlinePrelineFinalModel.setPricetag(getStringOfRedio(rad_pricelabel.isChecked()));


                Intent intent = new Intent(InlinePreLineFinal1.this,inlinePreLineFInal2.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private String getStringOfRedio(boolean okButton) {
        if (okButton) return "ok";
        else return "notOk";
    }

}
