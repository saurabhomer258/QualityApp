package com.example.saurabhomer.qualityapp.DailyFinishingAnalysis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishingModel1;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.pref.LoginPref;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.saurabhomer.qualityapp.cardviewmenu.CardMenu.STYLE_NUMBER;

public class DailyFinishingDefectAnalysis extends AppCompatActivity
{
    static int DAILYFINISHINGPAGE =0;
    static String total_defect="";
    static String total_Check="";
    static String total_defect_per="";
    static DailyFinishingModel1 model;
    static DailyFinishinfModels dailyFinishinfModels = new DailyFinishinfModels();

    static ArrayList<DialyFinishingAnalysisModel> DAILYFINIFSHINGMODELLIST = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        DAILYFINISHINGPAGE =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_defect_analysis1);
        View view_edt_hour = findViewById(R.id.edt_hours);
        final EditText editText_hour = view_edt_hour.findViewById(R.id.atvCommon);


        final Spinner spinner =(Spinner)view_edt_hour.findViewById(R.id.edt_finishing).findViewById(R.id.spinner);
        View view_edt_total_defect = findViewById(R.id.edt_total_defects);
        final EditText editText_total_defects = view_edt_total_defect.findViewById(R.id.atvCommon);

        View view_edt_defects = findViewById(R.id.edt_defect_s);
        final EditText editText_edt_defects = view_edt_defects.findViewById(R.id.atvCommon);

        View view_edt_total_check = findViewById(R.id.edt_total_check);
        final EditText editText_edt_total_check = view_edt_total_check.findViewById(R.id.atvUsernameReg);

        View signin_button = findViewById(R.id.bt_next);
        Button bt_signin_button= signin_button.findViewById(R.id.btnNext);
        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase.getInstance().getReference("dailyFinishing")
                        .child(STYLE_NUMBER).child(0+"").
                        addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.getValue()==null)
                                {
                                    DailyFinishingModel1 model = new DailyFinishingModel1(editText_hour.getText().toString(),
                                            editText_total_defects.getText().toString(),
                                            editText_edt_defects.getText().toString(),
                                            editText_edt_total_check.getText().toString()
                                    );
                                    dailyFinishinfModels.setHours(editText_hour.getText().toString());
                                    dailyFinishinfModels.setTotalDefect(editText_total_defects.getText().toString());
                                    dailyFinishinfModels.setDefectInPercent(editText_edt_defects.getText().toString());
                                    dailyFinishinfModels.setTotalDefect(editText_edt_total_check.getText().toString());
                                    int val = spinner.getSelectedItemPosition();
                                    dailyFinishinfModels.setFinishingLine(val+1+"");
                                    Intent intent = new Intent(DailyFinishingDefectAnalysis.this,DailyFinishingAnalysis2.class);
                                    startActivity(intent);
                                    finish();
                                }


                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
            }
        });
    }
}
