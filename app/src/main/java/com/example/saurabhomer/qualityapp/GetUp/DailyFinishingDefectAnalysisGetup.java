package com.example.saurabhomer.qualityapp.GetUp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingAnalysis2;
import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishingModel1;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.OutSide.DailyFinishingAnalysisOutside;
import com.example.saurabhomer.qualityapp.OutSide.DailyFinishingDefectAnalysisOutside;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.admin.DailyfinishingGetUpAdmin;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFinishingDefectAnalysisGetup extends AppCompatActivity implements
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
    private ProgressDialog progressDialog;

    static ArrayList<DialyFinishingAnalysisModel> DAILYFINIFSHINGMODELLIST = new ArrayList<>();
    static MainDailyFinishingModel mainDailyFinishingModel = new MainDailyFinishingModel();
    static DailyFinishinfModels sDailyFinishinfModels = new DailyFinishinfModels();

    static Spinner finishing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DAILYFINISHINGPAGE =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_defect_analysis_getup);
        info_btn = (Button)findViewById(R.id.info_daily);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        progressDialog = new ProgressDialog(DailyFinishingDefectAnalysisGetup.this);
        progressDialog.setMessage("Verificating...");

        finishing =(Spinner)    findViewById(R.id.edt_finishing).findViewById(R.id.spinner);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);
        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                checkAuth();
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyFinishingDefectAnalysisGetup.this, CommonStyleData.class);
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
    private void checkAuth(){
        final String strdate = txtDate.getText().toString();
        final String text = finishing.getSelectedItem().toString();
        FirebaseDatabase.getInstance().getReference("dailyFinishinggetup")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MainDailyFinishingModel mainDailyFinishingModel = dataSnapshot.getValue(MainDailyFinishingModel.class);
                if(mainDailyFinishingModel!=null){
                    ArrayList<DailyFinishinfModels> list =    mainDailyFinishingModel.getDailyFinishingModels();
                    for(int i=0;i< list.size() ;i++ ){
                        if(list.get(i).getDate().equals(strdate) && list.get(i).getFinishingLine().equals(text))
                        {
                            progressDialog.hide();
                          Toast.makeText(DailyFinishingDefectAnalysisGetup.this,"Date and finishing line is filled.",Toast.LENGTH_SHORT).show();
                            break;
                        }
                        if(i==list.size()-1){
                            sDailyFinishinfModels.setDate(strdate);
                            sDailyFinishinfModels.setFinishingLine(text);
                            Intent intent = new Intent(DailyFinishingDefectAnalysisGetup.this, DailyFinishingAnalysisGetup.class);
                            startActivity(intent);
                            progressDialog.hide();
                        }
                    }
                }
                else {
                    sDailyFinishinfModels.setDate(strdate);
                    sDailyFinishinfModels.setFinishingLine(text);
                    Intent intent = new Intent(DailyFinishingDefectAnalysisGetup.this,DailyFinishingAnalysisGetup.class);
                    startActivity(intent);
                    progressDialog.hide();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
