package com.example.saurabhomer.qualityapp.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;


public class DailyfinishingAdmin extends AppCompatActivity
{
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyfinishing_admin);
        layout = findViewById(R.id.dailyLayout);
        FirebaseDatabase.getInstance().getReference("dailyFinishing")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                DailyFinishinfModels dailyFinishinfModels =   dataSnapshot.getValue(DailyFinishinfModels.class);
                setLayout("Total Defect",dailyFinishinfModels.getTotalDefect());
                setLayout("Defect%",dailyFinishinfModels.getDefectInPercent());
                setLayout("Total Check",dailyFinishinfModels.getTotalCheck());
                setLayout("Hours",dailyFinishinfModels.getHours());
                setLayout("Finishing Line",dailyFinishinfModels.getFinishingLine());
                TextView textView= new TextView(DailyfinishingAdmin.this);
                textView.setText("_________________________________________________");
                layout.addView(textView);
                ArrayList<DialyFinishingAnalysisModel> list = dailyFinishinfModels.getDialyFinishingAnalysisModels();
                for(DialyFinishingAnalysisModel items: list)
                {

                    setLayout("Printing MRBO",items.getPrintingMRBO());
                    setLayout("Slubs Holes NAR",items.getSlubs_Holes_NAR());
                    setLayout("Color Shading",items.getColorShading());
                    setLayout("Broken Stitches",items.getBrokenStitches());

                    setLayout("Slip Stitches",items.getSlipStitches());
                    setLayout("SPI",items.getSPI());
                    setLayout("Pukering",items.getPukering());
                    setLayout("LooseTensions",items.getLooseTensions());
                    setLayout("SnapDefects",items.getSnapDefects());
                    setLayout("NeedleMark",items.getNeedleMark());
                    setLayout("OpenSeam",items.getOpenSeam());
                    setLayout("Pleats",items.getPleats());
                    setLayout("MissingStitches",items.getMissingStitches());
                    setLayout("SkipRunOff",items.getSkipRunOff());
                    setLayout("IncorrectLabel",items.getIncorrectLabel());
                    setLayout("WrongPlacement",items.getWrongPlacement());
                    setLayout("LooseNess",items.getLooseNess());
                    setLayout("CutDamage",items.getCutDamage());
                    setLayout("Others",items.getOthers());
                    setLayout("Stain",items.getStain());
                    setLayout("OilMark",items.getOilMark());
                    setLayout("Stickers",items.getStickers());
                    setLayout("UncutThread",items.getUncutThread());
                    setLayout("OutOfSpec",items.getOutOfSpec());
                    setLayout("TotalDefect",items.getTotalDefect());
                    setLayout("QualityOut",items.getQualityOut());
                    setLayout("ProductionOut",items.getProductionOut());
                    setLayout("Damage",items.getDamage());
                    setLayout("Dirty",items.getDirty());
                    setLayout("Iron",items.getIron());
                    setLayout("hours",items.getHours());
                    TextView textView1= new TextView(DailyfinishingAdmin.this);
                    textView1.setText("_________________________________________________");
                    layout.addView(textView1);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }
    private void setLayout(String object ,String result){
        if(result!=null) {
            TextView textView = new TextView(DailyfinishingAdmin.this);
            textView.setText(object + " : " + result);
            layout.addView(textView);
        }
    }
}
