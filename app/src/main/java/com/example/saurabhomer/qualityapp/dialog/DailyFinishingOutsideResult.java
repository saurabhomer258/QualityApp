package com.example.saurabhomer.qualityapp.dialog;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFinishingOutsideResult extends AppCompatActivity {
    TextView data1,data2,data3;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_outside_result);

        Button btn_ok =  findViewById(R.id.btn_ok);
        data1 = findViewById(R.id.data1);
        data2 = findViewById(R.id.data2);
        data3 = findViewById(R.id.data3);
        pieChart = findViewById(R.id.piechart_1);
        FirebaseDatabase.getInstance().getReference("dailyFinishingoutside")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DailyFinishinfModels dailyFinishinfModels =   dataSnapshot.getValue(DailyFinishinfModels.class);
              //  getMaxThree(dailyFinishinfModels);
            }
            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DailyFinishingOutsideResult.this, CardMenuP.class);
                startActivity(i);
                finish();
            }
        });


    }

    private void setPieChart(){
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(value.get(0),strings.get(0)));
        yValues.add(new PieEntry(value.get(1),strings.get(1)));
        yValues.add(new PieEntry(value.get(2),strings.get(2)));


        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);
    }
    private void getMaxThree(DailyFinishinfModels dailyFinishinfModels) {
        ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels = dailyFinishinfModels.getDialyFinishingAnalysisModels();
        List<Integer> val = new ArrayList<>();
        int PrintingMRBO = 0,Slubs_Holes_NAR =0,colorShading = 0,BrokenStitches=0,SlipStitches =0,SPI =0 ,Pukering =0 ,LooseTensions = 0,SnapDefects = 0,NeedleMark = 0,OpenSeam = 0,Pleats = 0;
        int MissingStitches= 0 ,SkipRunOff=0,IncorrectLabel=0,WrongPlacement=0,LooseNess=0,CutDamage=0,Others=0,Stain=0,OilMark=0,Stickers=0,UncutThread=0,OutOfSpec=0;
        int TotalDefect=0,QualityOut=0,ProductionOut=0,Damage=0,Dirty=0,Iron=0;
        int unEvent = 0;

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
            MissingStitches= MissingStitches + d.getMissingStitches();
            SkipRunOff=SkipRunOff + d.getSkipRunOff();
            IncorrectLabel=IncorrectLabel + d.getIncorrectLabel();
            WrongPlacement=WrongPlacement + d.getWrongPlacement();
            unEvent = unEvent+d.getUneven();
            LooseNess=LooseNess + d.getLooseNess();
            CutDamage=CutDamage + d.getCutDamage();
            Others=Others + d.getOthers();
            Stain=Stain +d.getStain();
            OilMark=OilMark + d.getOilMark();
            Stickers=Stickers + d.getStickers();
            UncutThread=UncutThread + d.getUncutThread();
            OutOfSpec=OutOfSpec +d.getOutOfSpec();
            TotalDefect=TotalDefect +d.getTotalDefect();
            QualityOut=QualityOut + d.getQualityOut();
            ProductionOut=ProductionOut +d.getProductionOut();
            Damage=Damage +d.getDamage();
            Dirty=Dirty +d.getDirty();
            Iron=Iron +d.getIron();

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
        val.add(MissingStitches);
        val.add(SkipRunOff);
        val.add(IncorrectLabel);
        val.add(WrongPlacement);
        val.add(unEvent);

        val.add(LooseNess);
        val.add(CutDamage);
        val.add(Others);
        val.add(Stain);
        val.add(OilMark);
        val.add(Stickers);
        val.add(UncutThread);
        val.add(OutOfSpec);
        val.add(TotalDefect);
        val.add(QualityOut);
        val.add(ProductionOut);
        val.add(Damage);
        val.add(Dirty);
        val.add(Iron);




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
            else if(val.get(i)==MissingStitches)
            {
                setString("Missing Stitches",val.get(i));
            }
            else if(val.get(i)==SkipRunOff)
            {
                setString("Skip RunOff",val.get(i));
            }
            else if(val.get(i)==IncorrectLabel)
            {
                setString("Incorrect Label",val.get(i));
            }else if(val.get(i)==CutDamage)
            {
                setString("Cut Damage",val.get(i));
            }
            else if(val.get(i)==WrongPlacement){
                setString("Wrong Placement",val.get(i));
            }
            else if(val.get(i)==unEvent){
                setString("un Event",val.get(i));
            }

            else if(val.get(i)==LooseNess){
                setString("Loose Ness",val.get(i));
            }


            else if(val.get(i)==Others)
            {
                setString("Others",val.get(i));
            }
            else if(val.get(i)==Stain)
            {
                setString("Stain",val.get(i));
            }
            else if(val.get(i)==OilMark)
            {
                setString("OilMark",val.get(i));
            }
            else if(val.get(i)==Stickers)
            {
                setString("Stickers",val.get(i));
            }
            else if(val.get(i)==UncutThread)
            {
                setString("UncutThread",val.get(i));
            }
            else if(val.get(i)==OutOfSpec)
            {
                setString("OutOfSpec",val.get(i));
            }
            else if(val.get(i)==TotalDefect)
            {
                setString("TotalDefect",val.get(i));
            }else if(val.get(i)==QualityOut)
            {
                setString("QualityOut",val.get(i));
            }else if(val.get(i)==ProductionOut)
            {
                setString("ProductionOut",val.get(i));
            }else if(val.get(i)==Damage)
            {
                setString("Damage",val.get(i));
            }

            else if(val.get(i)==Dirty)
            {
                setString("Dirty",val.get(i));
            }
            else if(val.get(i)==Iron)
            {
                setString("Iron",val.get(i));
            }

        }
        setPieChart();


    }
    int count =0 ;
    List<String> strings = new ArrayList();
    List<Integer> value = new ArrayList<>();
    void setString(String string,int val){
        if(count==0)
        {
            data1.setText(string +" "+val);
            strings.add(string);
            value.add(val);
            count++;
        }
        else if(count==1)
        {
            data2.setText(string +"  "+val);
            strings.add(string);
            value.add(val);
            count++;
        }
        else if(count==2)
        {
            data3.setText(string +"  "+val);
            strings.add(string);
            value.add(val);
            count++;
        }
    }
}
