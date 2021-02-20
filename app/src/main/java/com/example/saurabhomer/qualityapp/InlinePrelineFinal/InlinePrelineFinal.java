package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingAnalysis2;
import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.InsideResultView;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;

import java.util.ArrayList;
import java.util.Calendar;

public class InlinePrelineFinal extends AppCompatActivity  implements View.OnClickListener {

    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker;
    EditText txtDate;
    Spinner finishing_line;
    Button info_btn;
    static InlinePrelineFinalModel inlinePrelineFinalModel;
    static ArrayList<InlinePrelineFinalModel1> inlinePrelineFinalModel1ArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_preline_final);

        btnDatePicker=(ImageButton) findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);

        info_btn = (Button)findViewById(R.id.info_daily);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);

        finishing_line= findViewById(R.id.edt_finishing).findViewById(R.id.spinner);


        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inlinePrelineFinalModel = new InlinePrelineFinalModel();
                inlinePrelineFinalModel.setDate(txtDate.getText().toString());
                inlinePrelineFinalModel.setFinishing_line(finishing_line.getSelectedItem().toString());
                Intent intent = new Intent(InlinePrelineFinal.this,InlinePreLineFinal1.class);
                startActivity(intent);
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InlinePrelineFinal.this, CommonStyleData.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth)
                        {
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}


