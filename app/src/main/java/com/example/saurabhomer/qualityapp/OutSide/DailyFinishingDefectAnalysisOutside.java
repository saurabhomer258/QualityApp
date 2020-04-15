package com.example.saurabhomer.qualityapp.OutSide;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.GetUp.DailyFinishingAnalysisGetup;
import com.example.saurabhomer.qualityapp.GetUp.DailyFinishingDefectAnalysisGetup;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishingModel1;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFinishingDefectAnalysisOutside extends AppCompatActivity implements
        View.OnClickListener {
    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker;
    EditText txtDate;
    Button info_btn;
    static int DAILYFINISHINGPAGE =0;
    static String total_defect="";
    static String total_Check="";
    static String total_defect_per="";
    static DailyFinishingModel1 model;
    static public DailyFinishinfModels dailyFinishinfModels1 = new DailyFinishinfModels();

    static public ArrayList<DialyFinishingAnalysisModel> DAILYFINIFSHINGMODELLIST = new ArrayList<>();
    static MainDailyFinishingModel mainDailyFinishingModel = new MainDailyFinishingModel();
    static DailyFinishinfModels sDailyFinishinfModels = new DailyFinishinfModels();
    static Spinner finishing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DAILYFINISHINGPAGE =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_defect_analysis_outside);
        info_btn = (Button)findViewById(R.id.info_daily);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);

        final Spinner finishing =(Spinner)    findViewById(R.id.edt_finishing).findViewById(R.id.spinner);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);
        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strdate = txtDate.getText().toString();
                String text = finishing.getSelectedItem().toString();
                sDailyFinishinfModels.setDate(strdate);
                sDailyFinishinfModels.setFinishingLine(text);
                Intent intent = new Intent(DailyFinishingDefectAnalysisOutside.this, DailyFinishingAnalysisOutside.class);
                startActivity(intent);
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyFinishingDefectAnalysisOutside.this, CommonStyleData.class);
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
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}
