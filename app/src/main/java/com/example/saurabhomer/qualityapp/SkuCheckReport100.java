package com.example.saurabhomer.qualityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SkuCheckReport100 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_check_report100);
        View rd_ok = findViewById(R.id.countryhasbeencheck);
        RadioButton rd_btn_ok = rd_ok.findViewById(R.id.ok);

        View rd_notok = findViewById(R.id.countryhasbeencheck);
        RadioButton rd_btn_notok = rd_ok.findViewById(R.id.notok);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ok:
                if (checked)
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.notok:
                if (checked)
                    Toast.makeText(this, "NOT Ok", Toast.LENGTH_SHORT).show();
                    break;
        }
    }
}
