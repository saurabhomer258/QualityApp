package com.example.saurabhomer.qualityapp.dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFInishingResult extends AppCompatActivity {
    TextView data1,data2,data3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_result);
        Button btn_ok =  findViewById(R.id.btn_ok);
        data1 = findViewById(R.id.data1);
        data2 = findViewById(R.id.data2);
        data3 = findViewById(R.id.data3);
        FirebaseDatabase.getInstance().getReference("dailyFinishing")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DailyFinishinfModels dailyFinishinfModels =   dataSnapshot.getValue(DailyFinishinfModels.class);
                getMaxThree(dailyFinishinfModels);
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
        List<Integer> val = new ArrayList<>();
         int PrintingMRBO = 0,Slubs_Holes_NAR =0,colorShading = 0,BrokenStitches=0,SlipStitches =0,SPI =0 ,Pukering =0 ,LooseTensions = 0,SnapDefects = 0,NeedleMark = 0,OpenSeam = 0,Pleats = 0;
         int MissingStitches= 0 ,SkipRunOff,IncorrectLabel,WrongPlacement,LooseNess,CutDamage,Others,Stain,OilMark,Stickers,UncutThread,OutOfSpec;
         int TotalDefect,QualityOut,ProductionOut,Damage,Dirty,Iron;

        for(int i=0;i<dialyFinishingAnalysisModels.size();i++)
        {
            DialyFinishingAnalysisModel d = dialyFinishingAnalysisModels.get(i);
            PrintingMRBO =PrintingMRBO+ d.getPrintingMRBO();
            Slubs_Holes_NAR  = Slubs_Holes_NAR + d.getSlubs_Holes_NAR();
            colorShading = colorShading+ d.getColorShading();
            BrokenStitches  =BrokenStitches + d.getBrokenStitches();
            SlipStitches= SlipStitches+ d.getSlipStitches();
            SPI =SPI + d.getSPI();
            Pukering = Pukering + d.getPukering();
            LooseTensions =LooseTensions + d.getLooseTensions();
            SnapDefects = SnapDefects+ d.getSnapDefects();
            NeedleMark = NeedleMark + d.getNeedleMark();
            OpenSeam = OpenSeam + d.getOpenSeam();
            Pleats = Pleats + d.getPleats();

        }
        val.add(PrintingMRBO);
        val.add(Slubs_Holes_NAR);
        val.add(colorShading);
        val.add(BrokenStitches);
        val.add(SlipStitches);
        val.add(SPI);
        val.add(Pukering);
        val.add(LooseTensions);
        val.add(SnapDefects);
        val.add(NeedleMark);
        val.add(OpenSeam);
        val.add(Pleats);





        // sort list
        Collections.sort(val, Collections.reverseOrder());
        for(int i=0;i<val.size();i++){
            if(val.get(i)==PrintingMRBO)
            {
                setString("Printing MRBO",val.get(i));
            }
           else if(val.get(i)==Slubs_Holes_NAR)
            {
                setString("Slubs Holes NAR ",val.get(i));
            }

            else if(val.get(i)==BrokenStitches)
            {
                setString("Broken Stitches",val.get(i));
            }
            else if(val.get(i)==SlipStitches)
            {
                setString("Slip Stitches",val.get(i));
            }
            else if(val.get(i)==SPI)
            {
                setString("SPI",val.get(i));
            }
            else if(val.get(i)==Pukering)
            {
                setString("Pukering",val.get(i));
            }
            else if(val.get(i)==LooseTensions)
            {
                setString("Loose Tensions",val.get(i));
            }
            else if(val.get(i)==SnapDefects)
            {
                setString("Snap Defects",val.get(i));
            }
            else if(val.get(i)==NeedleMark)
            {
                setString("Needle Mark",val.get(i));
            }
            else if(val.get(i)==OpenSeam)
            {
                setString("Open Seam",val.get(i));
            }
            else if(val.get(i)==Pleats)
            {
                setString("Pleats",val.get(i));
            }

        }


    }
    int count =0 ;
    void setString(String string,int val){
        if(count==0)
        {
            data1.setText(string +"  "+val);
            count++;
        }
        else if(count==1)
        {
            data2.setText(string +"  "+val);
            count++;
        }
        else if(count==2)
        {
            data3.setText(string +"  "+val);
            count++;
        }
    }
}
