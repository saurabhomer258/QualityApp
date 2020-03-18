package com.example.saurabhomer.qualityapp.DailyFinishingAnalysis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis.DAILYFINIFSHINGMODELLIST;
import static com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis.dailyFinishinfModels;
import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DailyFinishingAnalysis2 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_finishing_analysis2);
        final EditText hour = findViewById(R.id.edt_hours).findViewById(R.id.atvCommon);
       final Spinner printing = findViewById(R.id.edt_printing_mrbo).findViewById(R.id.spinner);
       final Spinner slube_hole = findViewById(R.id.edt_slubes_holes).findViewById(R.id.spinner);
       final Spinner edt_color_shading = findViewById(R.id.edt_color_shading).findViewById(R.id.spinner);
       final Spinner edt_broken_stitches = findViewById(R.id.edt_broken_stitches).findViewById(R.id.spinner);
       final Spinner edt_slip_stitches = findViewById(R.id.edt_slip_stitches).findViewById(R.id.spinner);
       final Spinner edt_spi = findViewById(R.id.edt_spi).findViewById(R.id.spinner);
       final Spinner edt_pukering = findViewById(R.id.edt_pukering).findViewById(R.id.spinner);
       final Spinner edt_snap_defects = findViewById(R.id.edt_snap_defects).findViewById(R.id.spinner);
       final Spinner edt_loose_tensions = findViewById(R.id.edt_loose_tensions).findViewById(R.id.spinner);
       final Spinner edt_uneven = findViewById(R.id.edt_uneven).findViewById(R.id.spinner);



       final Spinner edt_needle_mark = findViewById(R.id.edt_needle_mark).findViewById(R.id.spinner);
       final Spinner edt_open_seam = findViewById(R.id.edt_open_seam).findViewById(R.id.spinner);
       final Spinner edt_pleats = findViewById(R.id.edt_pleats).findViewById(R.id.spinner);
       final Spinner edt_missing_stitches = findViewById(R.id.edt_missing_stitches).findViewById(R.id.spinner);
       final Spinner edt_skip_run_off = findViewById(R.id.edt_skip_run_off).findViewById(R.id.spinner);
       final Spinner edt_incorrect_label = findViewById(R.id.edt_incorrect_label).findViewById(R.id.spinner);
       final Spinner edt_wrong_placement = findViewById(R.id.edt_wrong_placement).findViewById(R.id.spinner);
       final Spinner edt_looseness = findViewById(R.id.edt_looseness).findViewById(R.id.spinner);
       final Spinner edt_cut_damage = findViewById(R.id.edt_cut_damage).findViewById(R.id.spinner);
       final Spinner edt_others = findViewById(R.id.edt_others).findViewById(R.id.spinner);

       final Spinner edt_stain = findViewById(R.id.edt_stain).findViewById(R.id.spinner);
       final Spinner edt_oil_marks = findViewById(R.id.edt_oil_marks).findViewById(R.id.spinner);
       final Spinner edt_stickers = findViewById(R.id.edt_stickers).findViewById(R.id.spinner);
       final Spinner edt_uncut_thread = findViewById(R.id.edt_uncut_thread).findViewById(R.id.spinner);
       final Spinner edt_out_of_spec = findViewById(R.id.edt_out_of_spec).findViewById(R.id.spinner);
       final Spinner edt_total_defects_1111 = findViewById(R.id.edt_total_defects_1111).findViewById(R.id.spinner);
       final Spinner edt_quality_out = findViewById(R.id.edt_quality_out).findViewById(R.id.spinner);
       final Spinner edt_production_out = findViewById(R.id.edt_production_out).findViewById(R.id.spinner);
       final Spinner edt_damage = findViewById(R.id.edt_damage).findViewById(R.id.spinner);
       final Spinner edt_dirty = findViewById(R.id.edt_dirty).findViewById(R.id.spinner);
       final Spinner edt_iron = findViewById(R.id.edt_iron).findViewById(R.id.spinner);
       Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
       Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);
       done.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
             DialyFinishingAnalysisModel dialyFinishingAnalysisModel = new DialyFinishingAnalysisModel(
                     hour.getText().toString(),
                     slube_hole.getSelectedItemPosition()+1+""
                     ,edt_color_shading.getSelectedItemPosition()+1+""
                     ,edt_broken_stitches.getSelectedItemPosition()+1+""
                     ,edt_slip_stitches.getSelectedItemPosition()+1+""
                     ,edt_spi.getSelectedItemPosition()+1+""
                     ,edt_pukering.getSelectedItemPosition()+1+""
                     ,edt_snap_defects.getSelectedItemPosition()+1+""
                     ,edt_loose_tensions.getSelectedItemPosition()+1+""
                     ,edt_uneven.getSelectedItemPosition()+1+""
                     ,edt_needle_mark.getSelectedItemPosition()+1+""
                     ,edt_open_seam.getSelectedItemPosition()+1+""
                     ,edt_pleats.getSelectedItemPosition()+1+""
                     ,edt_missing_stitches.getSelectedItemPosition()+1+""
                     ,edt_skip_run_off.getSelectedItemPosition()+1+""
                     ,edt_incorrect_label.getSelectedItemPosition()+1+""
                     ,edt_wrong_placement.getSelectedItemPosition()+1+""
                     ,edt_looseness.getSelectedItemPosition()+1+""
                     ,edt_cut_damage.getSelectedItemPosition()+1+""
                     ,edt_others.getSelectedItemPosition()+1+""
                     ,edt_stain.getSelectedItemPosition()+1+""
                     ,edt_oil_marks.getSelectedItemPosition()+1+""
                     ,edt_stickers.getSelectedItemPosition()+1+""
                     ,edt_uncut_thread.getSelectedItemPosition()+1+""
                     ,edt_out_of_spec.getSelectedItemPosition()+1+""
                     ,edt_total_defects_1111.getSelectedItemPosition()+1+""
                     ,edt_quality_out.getSelectedItemPosition()+1+""
                     ,edt_production_out.getSelectedItemPosition()+1+""
                     ,edt_damage.getSelectedItemPosition()+1+""
                     ,edt_dirty.getSelectedItemPosition()+1+""
                     ,edt_iron.getSelectedItemPosition()+1+""
             );
             DAILYFINIFSHINGMODELLIST.add(dialyFinishingAnalysisModel);
             dailyFinishinfModels.setDialyFinishingAnalysisModels(DAILYFINIFSHINGMODELLIST);
             FirebaseDatabase.getInstance().getReference("dailyFinishing")
                     .child(STYLE_NUMBER).setValue(dailyFinishinfModels).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                }
             });

             DAILYFINIFSHINGMODELLIST.clear();
             Intent i =new Intent(DailyFinishingAnalysis2.this,CardMenu.class);
             startActivity(i);
             finish();
          }
       });
       next.setOnClickListener(new View.OnClickListener()
       {
          @Override
          public void onClick(View v) {

             DialyFinishingAnalysisModel dialyFinishingAnalysisModel = new DialyFinishingAnalysisModel(
                     hour.getText().toString(),
                     slube_hole.getSelectedItemPosition()+1+""
                     ,edt_color_shading.getSelectedItemPosition()+1+""
                     ,edt_broken_stitches.getSelectedItemPosition()+1+""
                     ,edt_slip_stitches.getSelectedItemPosition()+1+""
                     ,edt_spi.getSelectedItemPosition()+1+""
                     ,edt_pukering.getSelectedItemPosition()+1+""
                     ,edt_snap_defects.getSelectedItemPosition()+1+""
                     ,edt_loose_tensions.getSelectedItemPosition()+1+""
                     ,edt_uneven.getSelectedItemPosition()+1+""
                     ,edt_needle_mark.getSelectedItemPosition()+1+""
                     ,edt_open_seam.getSelectedItemPosition()+1+""
                     ,edt_pleats.getSelectedItemPosition()+1+""
                     ,edt_missing_stitches.getSelectedItemPosition()+1+""
                     ,edt_skip_run_off.getSelectedItemPosition()+1+""
                     ,edt_incorrect_label.getSelectedItemPosition()+1+""
                     ,edt_wrong_placement.getSelectedItemPosition()+1+""
                     ,edt_looseness.getSelectedItemPosition()+1+""
                     ,edt_cut_damage.getSelectedItemPosition()+1+""
                     ,edt_others.getSelectedItemPosition()+1+""
                     ,edt_stain.getSelectedItemPosition()+1+""
                     ,edt_oil_marks.getSelectedItemPosition()+1+""
                     ,edt_stickers.getSelectedItemPosition()+1+""
                     ,edt_uncut_thread.getSelectedItemPosition()+1+""
                     ,edt_out_of_spec.getSelectedItemPosition()+1+""
                     ,edt_total_defects_1111.getSelectedItemPosition()+1+""
                     ,edt_quality_out.getSelectedItemPosition()+1+""
                     ,edt_production_out.getSelectedItemPosition()+1+""
                     ,edt_damage.getSelectedItemPosition()+1+""
                     ,edt_dirty.getSelectedItemPosition()+1+""
                     ,edt_iron.getSelectedItemPosition()+1+""
             );
             DAILYFINIFSHINGMODELLIST.add(dialyFinishingAnalysisModel);
             Intent i =new Intent(DailyFinishingAnalysis2.this,DailyFinishingAnalysis2.class);
             startActivity(i);
             finish();
          }
       });

    }
}
