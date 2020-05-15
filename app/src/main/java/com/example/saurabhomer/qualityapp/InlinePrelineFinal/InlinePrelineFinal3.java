package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.AreaOfPackingMaterial;
import com.example.saurabhomer.qualityapp.CartoonAudit.model.AreaOfPackingMaterialModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;
import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class InlinePrelineFinal3 extends AppCompatActivity {

    static ArrayList<InlinePrelineFinalModel1> inlinePrelineFinalModel1List = new ArrayList<>();
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_preline_final3);
        progressDialog = new ProgressDialog(this);

        final EditText edt_defectname = findViewById(R.id.edt_defectname).findViewById(R.id.atvCommon);
        final EditText edt_critical = findViewById(R.id.edt_critical).findViewById(R.id.atvCommon);
        final EditText edt_minor = findViewById(R.id.edt_minor).findViewById(R.id.atvCommon);
        final EditText edt_major = findViewById(R.id.edt_major).findViewById(R.id.atvCommon);
        final EditText edt_total = findViewById(R.id.edt_total).findViewById(R.id.atvCommon);
        final TextView txt_result = findViewById(R.id.txt_result);
        final TextView txt_remark = findViewById(R.id.txt_remark);
        final TextView txt_aql = findViewById(R.id.txt_aql);
        final TextView txt_inspection = findViewById(R.id.txt_inspection);
        final TextView txt_samplesize = findViewById(R.id.txt_samplesize);
        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);
        Intent intent = new Intent();
        String select_1 = intent.getStringExtra("Select_Level");
        String inspection_1 = intent.getStringExtra("Inspection");
        txt_aql.setText(select_1);
        txt_inspection.setText(inspection_1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InlinePrelineFinalModel1 inlinePrelineFinalModel1 = new InlinePrelineFinalModel1();
                inlinePrelineFinalModel1.setAql(txt_aql.getText().toString());
                inlinePrelineFinalModel1.setInspection(txt_inspection.getText().toString());
                inlinePrelineFinalModel1.setSamplesize(txt_samplesize.getText().toString());
                inlinePrelineFinalModel1.setDefectname(edt_defectname.getText().toString());
                inlinePrelineFinalModel1.setMajor(edt_major.getText().toString());
                inlinePrelineFinalModel1.setMinor(edt_minor.getText().toString());
                inlinePrelineFinalModel1.setCritical(edt_critical.getText().toString());
                inlinePrelineFinalModel1.setRemark(txt_remark.getText().toString());
                inlinePrelineFinalModel1.setResult(txt_result.getText().toString());
                inlinePrelineFinalModel1.setTotal(edt_total.getText().toString());
                inlinePrelineFinalModel1List.add(inlinePrelineFinalModel1);
                Intent i = new Intent(InlinePrelineFinal3.this, InlinePrelineFinal3.class);
                startActivity(i);
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InlinePrelineFinalModel1 inlinePrelineFinalModel1 = new InlinePrelineFinalModel1();
                inlinePrelineFinalModel1.setAql(txt_aql.getText().toString());
                inlinePrelineFinalModel1.setInspection(txt_inspection.getText().toString());
                inlinePrelineFinalModel1.setSamplesize(txt_samplesize.getText().toString());
                inlinePrelineFinalModel1.setDefectname(edt_defectname.getText().toString());
                inlinePrelineFinalModel1.setMajor(edt_major.getText().toString());
                inlinePrelineFinalModel1.setMinor(edt_minor.getText().toString());
                inlinePrelineFinalModel1.setCritical(edt_critical.getText().toString());
                inlinePrelineFinalModel1.setRemark(txt_remark.getText().toString());
                inlinePrelineFinalModel1.setResult(txt_result.getText().toString());
                inlinePrelineFinalModel1List.add(inlinePrelineFinalModel1);
                inlinePrelineFinalModel.setInlinePrelineFinalModel1(inlinePrelineFinalModel1List);
                FirebaseDatabase.getInstance().getReference("inlinepreline").child(STYLE_NUMBER).setValue(inlinePrelineFinalModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isComplete()) {
                            Toast.makeText(InlinePrelineFinal3.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                        finish();
                    }
                });
                inlinePrelineFinalModel1List.clear();
                Intent i = new Intent(InlinePrelineFinal3.this, CardMenuP.class);
                startActivity(i);
                finish();

            }
        });

    }
}
