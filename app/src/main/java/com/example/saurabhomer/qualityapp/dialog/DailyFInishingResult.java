package com.example.saurabhomer.qualityapp.dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFInishingResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_result);
        Button btn_ok =  findViewById(R.id.btn_ok);
        FirebaseDatabase.getInstance().getReference("dailyFinishing")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DailyFinishinfModels dailyFinishinfModels =   dataSnapshot.getValue(DailyFinishinfModels.class);

            }
            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DailyFInishingResult.this, CardMenu.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void getMaxThree(DailyFinishinfModels dailyFinishinfModels) {
        ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels = dailyFinishinfModels.getDialyFinishingAnalysisModels();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<dialyFinishingAnalysisModels.size();i++){
            if(map.containsKey(""))
            {

            }
            else {

            }
        }
    }
}
