package com.example.saurabhomer.qualityapp.OutSide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.GetUp.GetupResultView;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class ResultViewForActivity extends AppCompatActivity {
    TextView data41, data42, data43;
    LinearLayout layout;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.common_total);
        layout = findViewById(R.id.dailyLayout);
        TextView total = findViewById(R.id.tv_total);
        TextView totalPer = findViewById(R.id.tv_Defect_per);
        data41 = findViewById(R.id.data41);
        data42 = findViewById(R.id.data42);
        data43 = findViewById(R.id.data43);

        DialyFinishingAnalysisModel dialyFinishingAnalysisModel = DailyFinishingAnalysisOutside.DAILYFINIFSHINGMODELLISTForFinalResut1.get(0);
        ArrayList<DialyFinishingAnalysisModel> DAILYFINIFSHINGMODELLIST = new ArrayList<>();
        DAILYFINIFSHINGMODELLIST = DailyFinishingAnalysisOutside.DAILYFINIFSHINGMODELLISTForFinalResut1;
        ArrayList<DialyFinishingAnalysisModel> Dummy = new ArrayList<>();

        Dummy.add(dialyFinishingAnalysisModel);

        for (int i = 1; i < DAILYFINIFSHINGMODELLIST.size(); i++) {

            DialyFinishingAnalysisModel dialyFinishingAnalysisModel1 = DAILYFINIFSHINGMODELLIST.get(i);
            dialyFinishingAnalysisModel.setPrintingMRBO(dialyFinishingAnalysisModel.getPrintingMRBO() + dialyFinishingAnalysisModel1.getPrintingMRBO());
            dialyFinishingAnalysisModel.setSlubs_Holes_NAR(dialyFinishingAnalysisModel.getSlubs_Holes_NAR() + dialyFinishingAnalysisModel1.getSlubs_Holes_NAR());
            dialyFinishingAnalysisModel.setColorShading(dialyFinishingAnalysisModel.getColorShading() + dialyFinishingAnalysisModel1.getColorShading());
            dialyFinishingAnalysisModel.setBrokenStitches(dialyFinishingAnalysisModel.getBrokenStitches() + dialyFinishingAnalysisModel1.getBrokenStitches());


            dialyFinishingAnalysisModel.setSlipStitches(dialyFinishingAnalysisModel.getSlipStitches() + dialyFinishingAnalysisModel1.getSlipStitches());
            dialyFinishingAnalysisModel.setSPI(dialyFinishingAnalysisModel.getSPI() + dialyFinishingAnalysisModel1.getSPI());
            dialyFinishingAnalysisModel.setPukering(dialyFinishingAnalysisModel.getPukering() + dialyFinishingAnalysisModel1.getPukering());
            dialyFinishingAnalysisModel.setLooseTensions(dialyFinishingAnalysisModel.getLooseTensions() + dialyFinishingAnalysisModel1.getLooseTensions());
            dialyFinishingAnalysisModel.setSnapDefects(dialyFinishingAnalysisModel.getSnapDefects() + dialyFinishingAnalysisModel1.getSnapDefects());

            dialyFinishingAnalysisModel.setNeedleMark(dialyFinishingAnalysisModel.getNeedleMark() + dialyFinishingAnalysisModel1.getNeedleMark());
            dialyFinishingAnalysisModel.setOpenSeam(dialyFinishingAnalysisModel.getOpenSeam() + dialyFinishingAnalysisModel1.getOpenSeam());
            dialyFinishingAnalysisModel.setPleats(dialyFinishingAnalysisModel.getPleats() + dialyFinishingAnalysisModel1.getPleats());
            dialyFinishingAnalysisModel.setMissingStitches(dialyFinishingAnalysisModel.getMissingStitches() + dialyFinishingAnalysisModel1.getMissingStitches());
            dialyFinishingAnalysisModel.setSkipRunOff(dialyFinishingAnalysisModel.getSkipRunOff() + dialyFinishingAnalysisModel1.getSkipRunOff());
            dialyFinishingAnalysisModel.setIncorrectLabel(dialyFinishingAnalysisModel.getIncorrectLabel() + dialyFinishingAnalysisModel1.getIncorrectLabel());
            dialyFinishingAnalysisModel.setWrongPlacement(dialyFinishingAnalysisModel.getWrongPlacement() + dialyFinishingAnalysisModel1.getWrongPlacement());
            dialyFinishingAnalysisModel.setLooseNess(dialyFinishingAnalysisModel.getLooseNess() + dialyFinishingAnalysisModel1.getLooseNess());
            dialyFinishingAnalysisModel.setCutDamage(dialyFinishingAnalysisModel.getCutDamage() + dialyFinishingAnalysisModel1.getCutDamage());
            dialyFinishingAnalysisModel.setOthers(dialyFinishingAnalysisModel.getOthers() + dialyFinishingAnalysisModel1.getOthers());
            dialyFinishingAnalysisModel.setStain(dialyFinishingAnalysisModel.getStain() + dialyFinishingAnalysisModel1.getStain());
            dialyFinishingAnalysisModel.setOilMark(dialyFinishingAnalysisModel.getOilMark() + dialyFinishingAnalysisModel1.getOilMark());
            dialyFinishingAnalysisModel.setStickers(dialyFinishingAnalysisModel.getStickers() + dialyFinishingAnalysisModel1.getStickers());
            dialyFinishingAnalysisModel.setUncutThread(dialyFinishingAnalysisModel.getUncutThread() + dialyFinishingAnalysisModel1.getUncutThread());
            dialyFinishingAnalysisModel.setOutOfSpec(dialyFinishingAnalysisModel.getOutOfSpec() + dialyFinishingAnalysisModel1.getOutOfSpec());
            dialyFinishingAnalysisModel.setTotalDefect(dialyFinishingAnalysisModel.getTotalDefect() + dialyFinishingAnalysisModel1.getTotalDefect());
            dialyFinishingAnalysisModel.setQualityOut(dialyFinishingAnalysisModel.getQualityOut() + dialyFinishingAnalysisModel1.getQualityOut());
            dialyFinishingAnalysisModel.setProductionOut(dialyFinishingAnalysisModel.getProductionOut() + dialyFinishingAnalysisModel1.getProductionOut());
            dialyFinishingAnalysisModel.setDamage(dialyFinishingAnalysisModel.getDamage() + dialyFinishingAnalysisModel1.getDamage());
            dialyFinishingAnalysisModel.setDirty(dialyFinishingAnalysisModel.getDirty() + dialyFinishingAnalysisModel1.getDirty());
            dialyFinishingAnalysisModel.setIron(dialyFinishingAnalysisModel.getIron() + dialyFinishingAnalysisModel1.getIron());
            dialyFinishingAnalysisModel.setUneven(dialyFinishingAnalysisModel.getUneven() + dialyFinishingAnalysisModel1.getUneven());
        }
        TextView textView1 = findViewById(R.id.data1);
        textView1.setText("Printing/MRBO            :" + dialyFinishingAnalysisModel.getPrintingMRBO());

        TextView textView2 = findViewById(R.id.data2);
        textView2.setText("Slubs/Holes/NAR     :" + dialyFinishingAnalysisModel.getSlubs_Holes_NAR());


        TextView textView3 = findViewById(R.id.data3);
        textView3.setText("Color Shading              :" + dialyFinishingAnalysisModel.getColorShading());


        TextView textView4 = findViewById(R.id.data4);
        textView4.setText("Broken Stitches          :" + dialyFinishingAnalysisModel.getBrokenStitches());


        TextView textView5 = findViewById(R.id.data5);
        textView5.setText("Slip Stitches                :" + dialyFinishingAnalysisModel.getSlipStitches());


        TextView textView6 = findViewById(R.id.data6);
        textView6.setText("SPI                                :" + dialyFinishingAnalysisModel.getSPI());


        TextView textView7 = findViewById(R.id.data7);
        textView7.setText("Puckering                      :" + dialyFinishingAnalysisModel.getPukering());


        TextView textView8 = findViewById(R.id.data8);
        textView8.setText("Loose Tensions          :" + dialyFinishingAnalysisModel.getLooseTensions());


        TextView textView9 = findViewById(R.id.data9);
        textView9.setText("Snap Defects              :" + dialyFinishingAnalysisModel.getSnapDefects());

        TextView textView10 = findViewById(R.id.data10);
        textView10.setText("Needle Mark                :" + dialyFinishingAnalysisModel.getNeedleMark());


        TextView textView11 = findViewById(R.id.data11);
        textView11.setText("OpenSeam                  :" + dialyFinishingAnalysisModel.getOpenSeam());

        TextView textView12 = findViewById(R.id.data12);
        textView12.setText("Pleats                           :" + dialyFinishingAnalysisModel.getPleats());


//   private int MissingStitches,SkipRunOff,IncorrectLabel,WrongPlacement,LooseNess,CutDamage,Others,Stain,OilMark,Stickers,UncutThread,OutOfSpec;
        //    private int TotalDefect,QualityOut,ProductionOut,Damage,Dirty,Iron;
        //    private String hours;
        //    private int totalCheck;
        //    private int uneven;

        TextView textView13 = findViewById(R.id.data13);
        textView13.setText("Missing Stitches         :" + dialyFinishingAnalysisModel.getMissingStitches());


        TextView textView14 = findViewById(R.id.data14);
        textView14.setText("Skip/RunOff                  :" + dialyFinishingAnalysisModel.getSkipRunOff());


        TextView textView15 = findViewById(R.id.data15);
        textView15.setText("Incorrect Label            :" + dialyFinishingAnalysisModel.getIncorrectLabel());


        TextView textView16 = findViewById(R.id.data16);
        textView16.setText("Wrong Placement       :" + dialyFinishingAnalysisModel.getWrongPlacement());


        TextView textView17 = findViewById(R.id.data17);
        textView17.setText("Looseness                  :" + dialyFinishingAnalysisModel.getLooseNess());

        TextView textView171 =  findViewById(R.id.data171);
        textView171.setText("Unevent/Rewedge     :"+ dialyFinishingAnalysisModel.getUneven());

        TextView textView18 = findViewById(R.id.data18);
        textView18.setText("Cut Damage                 :" + dialyFinishingAnalysisModel.getCutDamage());


        //   private int MissingStitches,SkipRunOff,IncorrectLabel,WrongPlacement,LooseNess,CutDamage,Others,Stain,OilMark,Stickers,UncutThread,;


        TextView textView19 = findViewById(R.id.data19);
        textView19.setText("Others                           :" + dialyFinishingAnalysisModel.getOthers());

        TextView textView20 = findViewById(R.id.data20);
        textView20.setText("Stain                              :" + dialyFinishingAnalysisModel.getStain());

        TextView textView21 = findViewById(R.id.data21);
        textView21.setText("Oil Mark                         :" + dialyFinishingAnalysisModel.getOilMark());


        TextView textView22 = findViewById(R.id.data22);
        textView22.setText("Stickers                        :" + dialyFinishingAnalysisModel.getStickers());

        TextView textView23 = findViewById(R.id.data23);
        textView23.setText("Uncut Thread               :" + dialyFinishingAnalysisModel.getUncutThread());


        TextView textView24 = findViewById(R.id.data24);
        textView24.setText("OutOfSpec                   :" + dialyFinishingAnalysisModel.getOutOfSpec());

        // private int TotalDefect,QualityOut,ProductionOut,Damage,Dirty,Iron;


        TextView textView25 = findViewById(R.id.data25);
        textView25.setText("Total Defect                  :" + dialyFinishingAnalysisModel.getTotalDefect());


        TextView textView26 = findViewById(R.id.data26);
        textView26.setText("Quality Out                    :" + dialyFinishingAnalysisModel.getQualityOut());


        TextView textView27 = findViewById(R.id.data27);
        textView27.setText("Production Out            :" + dialyFinishingAnalysisModel.getProductionOut());


        TextView textView28 = findViewById(R.id.data28);
        textView28.setText("Damage                       :" + dialyFinishingAnalysisModel.getDamage());


        TextView textView29 = findViewById(R.id.data29);
        textView29.setText("Dirty                              :" + dialyFinishingAnalysisModel.getDirty());

        TextView textView30 = findViewById(R.id.data30);
        textView30.setText("Iron                                :" + dialyFinishingAnalysisModel.getIron());


        String s = dialyFinishingAnalysisModel.getTotal() + "";
        total.setText("Total                             :" + s);

        if (dialyFinishingAnalysisModel.getTotalCheck() == 0) {
            totalPer.setText("Total percentage         :" + 0 + "");
            totalPer.setTextSize(18);
        } else {
            float f = (float) dialyFinishingAnalysisModel.getTotal() / dialyFinishingAnalysisModel.getTotalCheck();
            f = f * 100;
            totalPer.setText("Total percentage          :" + f + "");
            totalPer.setTextSize(18);
        }
        Button b = findViewById(R.id.btn_ok);
        getMaxThree(Dummy);
        for (int i=0 ; i <DAILYFINIFSHINGMODELLIST.size();i++){
            setLayout(DAILYFINIFSHINGMODELLIST.get(i).getHours()+"" ,DAILYFINIFSHINGMODELLIST.get(i).getTotal()+"" );
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                Intent i = new Intent(ResultViewForActivity.this, CardMenuP.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }

    private void clear() {
        DailyFinishingAnalysisOutside.DAILYFINIFSHINGMODELLIST.clear();
        DailyFinishingAnalysisOutside.DAILYFINIFSHINGMODELLISTForFinalResut1.clear();
    }


    private void getMaxThree(ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels) {

        List<Integer> val = new ArrayList<>();
        int PrintingMRBO = 0, Slubs_Holes_NAR = 0, colorShading = 0, BrokenStitches = 0, SlipStitches = 0, SPI = 0, Pukering = 0, LooseTensions = 0, SnapDefects = 0, NeedleMark = 0, OpenSeam = 0, Pleats = 0;
        int MissingStitches = 0, SkipRunOff = 0, IncorrectLabel = 0, WrongPlacement = 0, LooseNess = 0, CutDamage = 0, Others = 0, Stain = 0, OilMark = 0, Stickers = 0, UncutThread = 0, OutOfSpec = 0;
        int TotalDefect = 0, QualityOut = 0, ProductionOut = 0, Damage = 0, Dirty = 0, Iron = 0;
        int unEvent = 0;

        for (int i = 0; i < dialyFinishingAnalysisModels.size(); i++) {
            DialyFinishingAnalysisModel d = dialyFinishingAnalysisModels.get(i);
            PrintingMRBO = PrintingMRBO + d.getPrintingMRBO();
            Slubs_Holes_NAR = Slubs_Holes_NAR + d.getSlubs_Holes_NAR();
            colorShading = colorShading + d.getColorShading();
            BrokenStitches = BrokenStitches + d.getBrokenStitches();
            SlipStitches = SlipStitches + d.getSlipStitches();
            SPI = SPI + d.getSPI();
            Pukering = Pukering + d.getPukering();
            LooseTensions = LooseTensions + d.getLooseTensions();
            SnapDefects = SnapDefects + d.getSnapDefects();
            NeedleMark = NeedleMark + d.getNeedleMark();
            OpenSeam = OpenSeam + d.getOpenSeam();
            Pleats = Pleats + d.getPleats();
            MissingStitches = MissingStitches + d.getMissingStitches();
            SkipRunOff = SkipRunOff + d.getSkipRunOff();
            IncorrectLabel = IncorrectLabel + d.getIncorrectLabel();
            WrongPlacement = WrongPlacement + d.getWrongPlacement();
            unEvent = unEvent + d.getUneven();
            LooseNess = LooseNess + d.getLooseNess();
            CutDamage = CutDamage + d.getCutDamage();
            Others = Others + d.getOthers();
            Stain = Stain + d.getStain();
            OilMark = OilMark + d.getOilMark();
            Stickers = Stickers + d.getStickers();
            UncutThread = UncutThread + d.getUncutThread();
            OutOfSpec = OutOfSpec + d.getOutOfSpec();
            TotalDefect = TotalDefect + d.getTotalDefect();
            QualityOut = QualityOut + d.getQualityOut();
            ProductionOut = ProductionOut + d.getProductionOut();
            Damage = Damage + d.getDamage();
            Dirty = Dirty + d.getDirty();
            Iron = Iron + d.getIron();

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
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i) == PrintingMRBO) {
                setString("Printing MRBO", val.get(i));
            }  if (val.get(i) == Slubs_Holes_NAR) {
                setString("Slubs Holes NAR ", val.get(i));
            } if(val.get(i)==colorShading)
            {
                setString("Color Shading ", val.get(i));
            }
            if (val.get(i) == BrokenStitches) {
                setString("Broken Stitches", val.get(i));
            }  if (val.get(i) == SlipStitches) {
                setString("Slip Stitches", val.get(i));
            }  if (val.get(i) == SPI) {
                setString("SPI", val.get(i));
            }  if (val.get(i) == Pukering) {
                setString("Pukering", val.get(i));
            }  if (val.get(i) == LooseTensions) {
                setString("Loose Tensions", val.get(i));
            }  if (val.get(i) == SnapDefects) {
                setString("Snap Defects", val.get(i));
            }  if (val.get(i) == NeedleMark) {
                setString("Needle Mark", val.get(i));
            }  if (val.get(i) == OpenSeam) {
                setString("Open Seam", val.get(i));
            }  if (val.get(i) == Pleats) {
                setString("Pleats", val.get(i));
            }  if (val.get(i) == MissingStitches) {
                setString("Missing Stitches", val.get(i));
            }  if (val.get(i) == SkipRunOff) {
                setString("Skip RunOff", val.get(i));
            }  if (val.get(i) == IncorrectLabel) {
                setString("Incorrect Label", val.get(i));
            }  if (val.get(i) == CutDamage) {
                setString("Cut Damage", val.get(i));
            }  if (val.get(i) == WrongPlacement) {
                setString("Wrong Placement", val.get(i));
            }  if (val.get(i) == unEvent) {
                setString("un Event", val.get(i));
            }  if (val.get(i) == LooseNess) {
                setString("Loose Ness", val.get(i));
            }  if (val.get(i) == Others) {
                setString("Others", val.get(i));
            }  if (val.get(i) == Stain) {
                setString("Stain", val.get(i));
            }  if (val.get(i) == OilMark) {
                setString("OilMark", val.get(i));
            }  if (val.get(i) == Stickers) {
                setString("Stickers", val.get(i));
            }  if (val.get(i) == UncutThread) {
                setString("UncutThread", val.get(i));
            }  if (val.get(i) == OutOfSpec) {
                setString("OutOfSpec", val.get(i));
            }  if (val.get(i) == TotalDefect) {
                setString("TotalDefect", val.get(i));
            } else if (val.get(i) == QualityOut) {
                setString("QualityOut", val.get(i));
            }  if (val.get(i) == ProductionOut) {
                setString("ProductionOut", val.get(i));
            }  if (val.get(i) == Damage) {
                setString("Damage", val.get(i));
            }  if (val.get(i) == Dirty) {
                setString("Dirty", val.get(i));
            }  if (val.get(i) == Iron) {
                setString("Iron", val.get(i));
            }

        }


    }

    int count = 0;
    List<String> strings = new ArrayList();
    HashMap<String,Integer> checkmap = new HashMap<>();
    List<Integer> value = new ArrayList<>();

    void setString(String string, int val) {
        if(checkmap.containsKey(string))
        {
            return;
        }
        else {
            checkmap.put(string,val);
        }
        if (count == 0) {
            data41.setText(string + " " + val);
            strings.add(string);
            value.add(val);
            count++;
        } else if (count == 1) {
            data42.setText(string + "  " + val);
            strings.add(string);
            value.add(val);
            count++;
        } else if (count == 2) {
            data43.setText(string + "  " + val);
            strings.add(string);
            value.add(val);
            count++;
        }
    }
    private void setLayout(String object ,String result){
        if(result!=null) {
            TextView textView = new TextView(ResultViewForActivity.this);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(18);
            textView.setText("Hour "+object + "    : " + result);
            layout.addView(textView);
        }
    }
}
