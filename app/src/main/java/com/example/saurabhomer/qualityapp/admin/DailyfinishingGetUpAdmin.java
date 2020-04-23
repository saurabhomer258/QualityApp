package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.GetUp.DailyFinishingAnalysisGetup;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.dialog.DailyFInishingResult;
import com.example.saurabhomer.qualityapp.dialog.DailyFinishingGetupResult;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyfinishingGetUpAdmin extends AppCompatActivity {
    LinearLayout layout;
    TextView data41, data42, data43;
    String strdate,strfinish;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyfinishing_get_up_admin);

        layout = findViewById(R.id.dailyLayout);

        data41 = findViewById(R.id.data41);
        data42 = findViewById(R.id.data42);
        data43 = findViewById(R.id.data43);
        Button btn = findViewById(R.id.btn_ok);
        if (!NetworkUtils.isNetworkConnected(DailyfinishingGetUpAdmin.this))
        {
            return;
        }
        progressDialog = new ProgressDialog(DailyfinishingGetUpAdmin.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        FirebaseDatabase.getInstance().getReference("dailyFinishinggetup")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MainDailyFinishingModel mainDailyFinishingModel = dataSnapshot.getValue(MainDailyFinishingModel.class);
                ArrayList<DailyFinishinfModels> dailyFinishinfModels =   mainDailyFinishingModel.getDailyFinishingModels();
                Intent intent = getIntent();
                strdate=intent.getStringExtra("getupdate");
                strfinish = intent.getStringExtra("getupfinishing");

                for (int i =0 ;i< dailyFinishinfModels.size() ; i++) {
                    DailyFinishinfModels finishinfModels = dailyFinishinfModels.get(i);
                    String insidedate1 = finishinfModels.getDate();
                    String finishingline = finishinfModels.getFinishingLine();
                    Log.d(insidedate1,"check");
                    Log.d(strdate,"check sys");
                    if(insidedate1.equals(strdate) && finishingline.equals(strfinish))
                    {
                        setLayout("Date",finishinfModels.getDate());
                        setLayout("Finishing Line",finishinfModels.getFinishingLine());
                        TextView textView= new TextView(DailyfinishingGetUpAdmin.this);
                        textView.setText("_________________________________________________");
                        layout.addView(textView);

                        ArrayList<DialyFinishingAnalysisModel> list = finishinfModels.getDialyFinishingAnalysisModels();
                        if(list!=null)
                        {
                            for(DialyFinishingAnalysisModel items: list)
                            {
                                setLayout("Printing/MRBO            ",items.getPrintingMRBO()+"");
                                setLayout("Slubs/Holes/NAR        ",items.getSlubs_Holes_NAR()+"");
                                setLayout("Color Shading             ",items.getColorShading()+"");
                                setLayout("Broken Stitches          ",items.getBrokenStitches()+"");

                                setLayout("Slip Stitches                ",items.getSlipStitches()+"");
                                setLayout("SPI                                 ",items.getSPI()+"");
                                setLayout("Puckering                       ",items.getPukering()+"");
                                setLayout("Loose Tensions           ",items.getLooseTensions()+"");
                                setLayout("Snap Defects               ",items.getSnapDefects()+"");
                                setLayout("Needle Mark                 ",items.getNeedleMark()+"");
                                setLayout("Open Seam                   ",items.getOpenSeam()+"");
                                setLayout("Pleats                            ",items.getPleats()+"");
                                setLayout("Missing Stitches          ",items.getMissingStitches()+"");
                                setLayout("Skip/RunOff                   ",items.getSkipRunOff()+"");
                                setLayout("Incorrect Label             ",items.getIncorrectLabel()+"");
                                setLayout("Wrong Placement        ",items.getWrongPlacement()+"");
                                setLayout("Looseness                   ",items.getLooseNess()+"");
                                setLayout("Cut Damage                  ",items.getCutDamage()+"");
                                setLayout("Others                           ",items.getOthers()+"");
                                setLayout("Stain                              ",items.getStain()+"");
                                setLayout("OilMark                         ",items.getOilMark()+"");
                                setLayout("Stickers                         ",items.getStickers()+"");
                                setLayout("Uncut Thread                ",items.getUncutThread()+"");
                                setLayout("OutOfSpec                    ",items.getOutOfSpec()+"");
                                setLayout("Total Defect                   ",items.getTotalDefect()+"");
                                setLayout("Quality Out                     ",items.getQualityOut()+"");
                                setLayout("Production Out             ",items.getProductionOut()+"");
                                setLayout("Damage                         ",items.getDamage()+"");
                                setLayout("Dirty                                ",items.getDirty()+"");
                                setLayout("Iron                                  ",items.getIron()+"");
                                setLayout("hours                              ",items.getHours());
                                setLayout("Uneven                           ",items.getUneven()+"");
                                setLayout("Total Check                   ",items.getTotalCheck()+"");


                                TextView textView1= new TextView(DailyfinishingGetUpAdmin.this);
                                textView1.setText("_________________________________________________");
                                layout.addView(textView1);
                            }
                        }
                            TextView textView1 = new TextView(DailyfinishingGetUpAdmin.this);
                            if(list!=null && list.size()>0 ) {
                                textView1.setText("            Total check:         ");
                                textView1.setTextSize(18);
                                layout.addView(textView1);
                                setToal(list);
                            }
                        getMaxThree(dailyFinishinfModels.get(i).getDialyFinishingAnalysisModels());
                        break;
                    } if(i==dailyFinishinfModels.size()-1) {

                        Toast.makeText(DailyfinishingGetUpAdmin.this, "Opps! No data found", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }

                progressDialog.hide();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                progressDialog.hide();
            }
        });
    }
    private void setLayout(String object ,String result){
        if(result!=null) {
            TextView textView = new TextView(DailyfinishingGetUpAdmin.this);
            textView.setText(object + " : " + result);
            layout.addView(textView);
        }
    }

    private void setToal(ArrayList<DialyFinishingAnalysisModel> DAILYFINIFSHINGMODELLIST) {
        DialyFinishingAnalysisModel items =DAILYFINIFSHINGMODELLIST.get(0);
        for(int i=1;i<DAILYFINIFSHINGMODELLIST.size();i++){

            DialyFinishingAnalysisModel dialyFinishingAnalysisModel1 = DAILYFINIFSHINGMODELLIST.get(i);
            items.setPrintingMRBO(items.getPrintingMRBO()+dialyFinishingAnalysisModel1.getPrintingMRBO());
            items.setSlubs_Holes_NAR(items.getSlubs_Holes_NAR()+dialyFinishingAnalysisModel1.getSlubs_Holes_NAR());
            items.setColorShading(items.getColorShading()+dialyFinishingAnalysisModel1.getColorShading());
            items.setBrokenStitches(items.getBrokenStitches()+dialyFinishingAnalysisModel1.getBrokenStitches());


            items.setSlipStitches(items.getSlipStitches()+dialyFinishingAnalysisModel1.getSlipStitches());
            items.setSPI(items.getSPI()+dialyFinishingAnalysisModel1.getSPI());
            items.setPukering(items.getPukering()+dialyFinishingAnalysisModel1.getPukering());
            items.setLooseTensions(items.getLooseTensions()+dialyFinishingAnalysisModel1.getLooseTensions());
            items.setSnapDefects(items.getSnapDefects()+dialyFinishingAnalysisModel1.getSnapDefects());

            items.setNeedleMark(items.getNeedleMark()+dialyFinishingAnalysisModel1.getNeedleMark());
            items.setOpenSeam(items.getOpenSeam()+dialyFinishingAnalysisModel1.getOpenSeam());
            items.setPleats(items.getPleats()+dialyFinishingAnalysisModel1.getPleats());
            items.setMissingStitches(items.getMissingStitches()+dialyFinishingAnalysisModel1.getMissingStitches());
            items.setSkipRunOff(items.getSkipRunOff()+dialyFinishingAnalysisModel1.getSkipRunOff());
            items.setIncorrectLabel(items.getIncorrectLabel()+dialyFinishingAnalysisModel1.getIncorrectLabel());
            items.setWrongPlacement(items.getWrongPlacement()+dialyFinishingAnalysisModel1.getWrongPlacement());
            items.setLooseNess(items.getLooseNess()+dialyFinishingAnalysisModel1.getLooseNess());
            items.setCutDamage(items.getCutDamage()+dialyFinishingAnalysisModel1.getCutDamage());
            items.setOthers(items.getOthers()+dialyFinishingAnalysisModel1.getOthers());
            items.setStain(items.getStain()+dialyFinishingAnalysisModel1.getStain());
            items.setOilMark(items.getOilMark()+dialyFinishingAnalysisModel1.getOilMark());
            items.setStickers(items.getStickers()+dialyFinishingAnalysisModel1.getStickers());
            items.setUncutThread(items.getUncutThread()+dialyFinishingAnalysisModel1.getUncutThread());
            items.setOutOfSpec(items.getOutOfSpec()+dialyFinishingAnalysisModel1.getOutOfSpec());
            items.setTotalDefect(items.getTotalDefect()+dialyFinishingAnalysisModel1.getTotalDefect());
            items.setQualityOut(items.getQualityOut()+dialyFinishingAnalysisModel1.getQualityOut());
            items.setProductionOut(items.getProductionOut()+dialyFinishingAnalysisModel1.getProductionOut());
            items.setDamage(items.getDamage()+dialyFinishingAnalysisModel1.getDamage());
            items.setDirty(items.getDirty()+dialyFinishingAnalysisModel1.getDirty());
            items.setIron(items.getIron()+dialyFinishingAnalysisModel1.getIron());


        }

        setLayout("Printing/MRBO            ",items.getPrintingMRBO()+"");
        setLayout("Slubs/Holes/NAR        ",items.getSlubs_Holes_NAR()+"");
        setLayout("Color Shading             ",items.getColorShading()+"");
        setLayout("Broken Stitches          ",items.getBrokenStitches()+"");

        setLayout("Slip Stitches                ",items.getSlipStitches()+"");
        setLayout("SPI                                 ",items.getSPI()+"");
        setLayout("Puckering                       ",items.getPukering()+"");
        setLayout("Loose Tensions           ",items.getLooseTensions()+"");
        setLayout("Snap Defects               ",items.getSnapDefects()+"");
        setLayout("Needle Mark                 ",items.getNeedleMark()+"");
        setLayout("Open Seam                   ",items.getOpenSeam()+"");
        setLayout("Pleats                            ",items.getPleats()+"");
        setLayout("Missing Stitches          ",items.getMissingStitches()+"");
        setLayout("Skip/RunOff                   ",items.getSkipRunOff()+"");
        setLayout("Incorrect Label             ",items.getIncorrectLabel()+"");
        setLayout("Wrong Placement        ",items.getWrongPlacement()+"");
        setLayout("Loose Ness                   ",items.getLooseNess()+"");
        setLayout("Cut Damage                  ",items.getCutDamage()+"");
        setLayout("Stain                              ",items.getStain()+"");
        setLayout("OilMark                         ",items.getOilMark()+"");
        setLayout("Stickers                         ",items.getStickers()+"");
        setLayout("Uncut Thread                ",items.getUncutThread()+"");
        setLayout("OutOfSpec                    ",items.getOutOfSpec()+"");
        setLayout("Total Defect                   ",items.getTotalDefect()+"");
        setLayout("Quality Out                     ",items.getQualityOut()+"");
        setLayout("Production Out             ",items.getProductionOut()+"");
        setLayout("Damage                         ",items.getDamage()+"");
        setLayout("Dirty                                ",items.getDirty()+"");
        setLayout("Iron                                  ",items.getIron()+"");
        setLayout("Uneven                           ",items.getUneven()+"");
        setLayout("Others                           ",items.getOthers()+"");
        setLayout("Total Check                   ",items.getTotalCheck()+"");
        if (items.getTotalCheck() == 0) {
            setLayout("Total percentage         ",  0 + "");
        } else {
            float f = (float) items.getTotal() / items.getTotalCheck();
            f = f * 100;
            setLayout( "Total percentage           :" , f + "");
        }
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

    List<String> strings = new ArrayList();
    List<Integer> value = new ArrayList<>();
    HashMap<String,Integer> checkmap = new HashMap<>();
    HashMap<Integer,String> sortedValue = new HashMap<>();
    int count = 0;


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
            data41.setTextSize(18);
            strings.add(string);
            value.add(val);
            count++;
        } else if (count == 1) {
            data42.setText(string + "  " + val);
            data42.setTextSize(18);
            strings.add(string);
            value.add(val);
            count++;
        } else if (count == 2) {
            data43.setText(string + "  " + val);
            data43.setTextSize(18);
            strings.add(string);
            value.add(val);
            count++;
        }
    }

}
