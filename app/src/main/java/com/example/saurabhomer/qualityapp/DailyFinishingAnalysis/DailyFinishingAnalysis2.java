package com.example.saurabhomer.qualityapp.DailyFinishingAnalysis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenu;
import com.example.saurabhomer.qualityapp.dialog.DailyFInishingResult;
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
        final EditText total_check = findViewById(R.id.edt_total_check).findViewById(R.id.atvCommon);
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
       Button btn_res =findViewById(R.id.btn_result).findViewById(R.id.btnNext);
       Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);
       btn_res.setText("Get Result");
       btn_res.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
           TextView total =  findViewById(R.id.tv_total);
           TextView totalPer =  findViewById(R.id.tv_Defect_per);
             String a = total_check.getText().toString().trim().equals("") ? 0 +"": total_check.getText().toString().trim();


             DialyFinishingAnalysisModel dialyFinishingAnalysisModel = new DialyFinishingAnalysisModel(
                     Integer.parseInt(a),
                     printing.getSelectedItemPosition(),
                     slube_hole.getSelectedItemPosition()
                     ,edt_color_shading.getSelectedItemPosition()
                     ,edt_broken_stitches.getSelectedItemPosition()
                     ,edt_slip_stitches.getSelectedItemPosition()
                     ,edt_spi.getSelectedItemPosition()
                     ,edt_pukering.getSelectedItemPosition()
                     ,edt_snap_defects.getSelectedItemPosition()
                     ,edt_loose_tensions.getSelectedItemPosition()

                     ,edt_needle_mark.getSelectedItemPosition()
                     ,edt_open_seam.getSelectedItemPosition()
                     ,edt_pleats.getSelectedItemPosition()
                     ,edt_missing_stitches.getSelectedItemPosition()
                     ,edt_skip_run_off.getSelectedItemPosition()
                     ,edt_incorrect_label.getSelectedItemPosition()
                     ,edt_wrong_placement.getSelectedItemPosition()
                     ,edt_looseness.getSelectedItemPosition()
                     ,edt_cut_damage.getSelectedItemPosition()
                     ,edt_others.getSelectedItemPosition()
                     ,edt_stain.getSelectedItemPosition()
                     ,edt_oil_marks.getSelectedItemPosition()
                     ,edt_stickers.getSelectedItemPosition()
                     ,edt_uncut_thread.getSelectedItemPosition()
                     ,edt_out_of_spec.getSelectedItemPosition()
                     ,edt_total_defects_1111.getSelectedItemPosition()
                     ,edt_quality_out.getSelectedItemPosition()
                     ,edt_production_out.getSelectedItemPosition()
                     ,edt_damage.getSelectedItemPosition()
                     ,edt_dirty.getSelectedItemPosition()
                     ,edt_iron.getSelectedItemPosition()
                     , hour.getText().toString()+""
                     ,edt_uneven.getSelectedItemPosition()
             );
             String s = dialyFinishingAnalysisModel.getTotal()+"";
           total.setText(s);
           if(dialyFinishingAnalysisModel.getTotalCheck()==0)
           {
              totalPer.setText(0);
           }
           else {
         float f    =  (float) dialyFinishingAnalysisModel.getTotal() / dialyFinishingAnalysisModel.getTotalCheck();
         f = f*100;
              totalPer.setText(f+"");
           }
          }
       });
       done.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              String a = total_check.getText().toString().trim().equals("") ? 0 +"": total_check.getText().toString().trim();
             DialyFinishingAnalysisModel dialyFinishingAnalysisModel = new DialyFinishingAnalysisModel(
                     Integer.parseInt(a),
                     printing.getSelectedItemPosition(),
                     slube_hole.getSelectedItemPosition()
                     ,edt_color_shading.getSelectedItemPosition()
                     ,edt_broken_stitches.getSelectedItemPosition()
                     ,edt_slip_stitches.getSelectedItemPosition()
                     ,edt_spi.getSelectedItemPosition()
                     ,edt_pukering.getSelectedItemPosition()
                     ,edt_snap_defects.getSelectedItemPosition()
                     ,edt_loose_tensions.getSelectedItemPosition()

                     ,edt_needle_mark.getSelectedItemPosition()
                     ,edt_open_seam.getSelectedItemPosition()
                     ,edt_pleats.getSelectedItemPosition()
                     ,edt_missing_stitches.getSelectedItemPosition()
                     ,edt_skip_run_off.getSelectedItemPosition()
                     ,edt_incorrect_label.getSelectedItemPosition()
                     ,edt_wrong_placement.getSelectedItemPosition()
                     ,edt_looseness.getSelectedItemPosition()
                     ,edt_cut_damage.getSelectedItemPosition()
                     ,edt_others.getSelectedItemPosition()
                     ,edt_stain.getSelectedItemPosition()
                     ,edt_oil_marks.getSelectedItemPosition()
                     ,edt_stickers.getSelectedItemPosition()
                     ,edt_uncut_thread.getSelectedItemPosition()
                     ,edt_out_of_spec.getSelectedItemPosition()
                     ,edt_total_defects_1111.getSelectedItemPosition()
                     ,edt_quality_out.getSelectedItemPosition()
                     ,edt_production_out.getSelectedItemPosition()
                     ,edt_damage.getSelectedItemPosition()
                     ,edt_dirty.getSelectedItemPosition()
                     ,edt_iron.getSelectedItemPosition()
                     , hour.getText().toString()+""
                     ,edt_uneven.getSelectedItemPosition()
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
             Intent i =new Intent(DailyFinishingAnalysis2.this,DailyFInishingResult.class);
             startActivity(i);
             finish();
          }
       });
       next.setOnClickListener(new View.OnClickListener()
       {
          @Override
          public void onClick(View v) {
              String a = total_check.getText().toString().trim().equals("") ? 0 +"": total_check.getText().toString().trim();
             DialyFinishingAnalysisModel dialyFinishingAnalysisModel = new DialyFinishingAnalysisModel(
                     Integer.parseInt(a),
                     printing.getSelectedItemPosition(),
                     slube_hole.getSelectedItemPosition()
                     ,edt_color_shading.getSelectedItemPosition()
                     ,edt_broken_stitches.getSelectedItemPosition()
                     ,edt_slip_stitches.getSelectedItemPosition()
                     ,edt_spi.getSelectedItemPosition()
                     ,edt_pukering.getSelectedItemPosition()
                     ,edt_snap_defects.getSelectedItemPosition()
                     ,edt_loose_tensions.getSelectedItemPosition()

                     ,edt_needle_mark.getSelectedItemPosition()
                     ,edt_open_seam.getSelectedItemPosition()
                     ,edt_pleats.getSelectedItemPosition()
                     ,edt_missing_stitches.getSelectedItemPosition()
                     ,edt_skip_run_off.getSelectedItemPosition()
                     ,edt_incorrect_label.getSelectedItemPosition()
                     ,edt_wrong_placement.getSelectedItemPosition()
                     ,edt_looseness.getSelectedItemPosition()
                     ,edt_cut_damage.getSelectedItemPosition()
                     ,edt_others.getSelectedItemPosition()
                     ,edt_stain.getSelectedItemPosition()
                     ,edt_oil_marks.getSelectedItemPosition()
                     ,edt_stickers.getSelectedItemPosition()
                     ,edt_uncut_thread.getSelectedItemPosition()
                     ,edt_out_of_spec.getSelectedItemPosition()
                     ,edt_total_defects_1111.getSelectedItemPosition()
                     ,edt_quality_out.getSelectedItemPosition()
                     ,edt_production_out.getSelectedItemPosition()
                     ,edt_damage.getSelectedItemPosition()
                     ,edt_dirty.getSelectedItemPosition()
                     ,edt_iron.getSelectedItemPosition()
                     , hour.getText().toString()+""
                     ,edt_uneven.getSelectedItemPosition()
             );
             DAILYFINIFSHINGMODELLIST.add(dialyFinishingAnalysisModel);
             Intent i =new Intent(DailyFinishingAnalysis2.this,DailyFinishingAnalysis2.class);
             startActivity(i);
             finish();
          }
       });

    }
}
