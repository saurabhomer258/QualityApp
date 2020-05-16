package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.AreaOfPackingMaterial;
import com.example.saurabhomer.qualityapp.CartoonAudit.model.AreaOfPackingMaterialModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.handles.InlinePreLineHandler;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.handles.ResultModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;
import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinePreLineFInal2.inlinePrelineFinalModel1List;
import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class InlinePrelineFinal3 extends AppCompatActivity {


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_preline_final3);
        progressDialog = new ProgressDialog(this);

        final EditText edt_defectname = findViewById(R.id.edt_defectname).findViewById(R.id.atvCommon);
        final EditText edt_critical = findViewById(R.id.edt_critical).findViewById(R.id.atvCommon);
        edt_critical.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);
        final EditText edt_minor = findViewById(R.id.edt_minor).findViewById(R.id.atvCommon);
        edt_minor .setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);
        final EditText edt_major = findViewById(R.id.edt_major).findViewById(R.id.atvCommon);

        edt_major.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);
       // final TextView txt_result = findViewById(R.id.txt_result);

        final TextView txt_total = findViewById(R.id.txt_total);
        final TextView txt_aql = findViewById(R.id.txt_aql);
        final TextView txt_inspection = findViewById(R.id.txt_inspection);
        final TextView txt_samplesize = findViewById(R.id.txt_samplesize);

        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);

        Button result_btn = findViewById(R.id.btn_getResult).findViewById(R.id.btnNext);
        result_btn.setText("Get result");
        TextView text_critical_acc = findViewById(R.id.txt_critical_Accept);
        TextView text_critical_rej = findViewById(R.id.txt_critical_reject);
        TextView text_major_acc = findViewById(R.id.txt_major_Accept);
        TextView text_major_rej = findViewById(R.id.txt_major_reject);
        TextView text_minor_acc = findViewById(R.id.txt_minor_Accept);
        TextView text_minor_rej = findViewById(R.id.txt_minor_reject);

        InlinePreLineHandler inlinePreLineHandler = new InlinePreLineHandler(inlinePrelineFinalModel.getSelect_level(), inlinePrelineFinalModel.getInspection_level(), Integer.parseInt(inlinePrelineFinalModel.getQuantity()));
        final ResultModel resultModel = inlinePreLineHandler.getResult();


        String select_1 = inlinePrelineFinalModel.getSelect_level();
        String inspection_1 = inlinePrelineFinalModel.getInspection_level();
        txt_aql.setText(select_1);
        txt_inspection.setText(inspection_1);
        txt_samplesize.setText(resultModel.getSAMPLESIZE());

        text_critical_acc.setText(resultModel.getCRITICAL_ACE() + "");
        text_major_acc.setText(resultModel.getCRITICAL_ACE() + "");
        text_minor_acc.setText(resultModel.getCRITICAL_ACE() + "");
        text_critical_rej.setText(resultModel.getCRITICAL_REJ() + "");
        text_major_rej.setText(resultModel.getCRITICAL_REJ() + "");
        text_minor_rej.setText(resultModel.getCRITICAL_REJ() + "");

//        String minor = edt_minor.getText().toString();
//        String major = edt_major.getText().toString();
//        int total = Integer.parseInt(minor)+Integer.parseInt(major);
//        txt_total.setText(total);
        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt_major.getText().toString().isEmpty() || edt_critical.getText().toString() .isEmpty()|| edt_minor.getText().toString().isEmpty() )
                {
                    Toast.makeText(InlinePrelineFinal3.this,"All fields must not be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    int a = Integer.parseInt(edt_major.getText().toString());
                    int b = Integer.parseInt(edt_critical.getText().toString());
                    int c = Integer.parseInt(edt_minor.getText().toString());
                    int sum = (a + b + c);

                    txt_total.setText("TOTAL    " + sum);
                }
//                if (sum <= resultModel.getCRITICAL_ACE()) {
//                    txt_remark.setText("REMARK   PASS");
//                } else {
//                    txt_remark.setText("REMARK    FAIL");
//                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(edt_major.getText().toString().isEmpty() || edt_critical.getText().toString() .isEmpty()|| edt_minor.getText().toString().isEmpty() )
                {
                    Toast.makeText(InlinePrelineFinal3.this,"All fields must not be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                InlinePrelineFinalModel1 inlinePrelineFinalModel1 = new InlinePrelineFinalModel1();
                inlinePrelineFinalModel1.setAql(txt_aql.getText().toString());
                inlinePrelineFinalModel1.setInspection(txt_inspection.getText().toString());
                inlinePrelineFinalModel1.setSamplesize(txt_samplesize.getText().toString());
                inlinePrelineFinalModel1.setDefectname(edt_defectname.getText().toString());
                inlinePrelineFinalModel1.setMajor(edt_major.getText().toString());
                inlinePrelineFinalModel1.setMinor(edt_minor.getText().toString());
                inlinePrelineFinalModel1.setCritical(edt_critical.getText().toString());

//                inlinePrelineFinalModel1.setResult(txt_result.getText().toString());
                int a = Integer.parseInt(edt_major.getText().toString());
                int b = Integer.parseInt(edt_critical.getText().toString());
                int c = Integer.parseInt(edt_minor.getText().toString());
                int sum = (a + b + c);
                inlinePrelineFinalModel1.setTotal(sum + "");
//                if (sum <= resultModel.getCRITICAL_ACE()) {
//                    inlinePrelineFinalModel1.setRemark("PASS");
//
//                } else {
//                    inlinePrelineFinalModel1.setRemark("FAIL");
//                }
                inlinePrelineFinalModel1List.add(inlinePrelineFinalModel1);
                Intent i = new Intent(InlinePrelineFinal3.this, InlinePrelineFinal3.class);
                startActivity(i);
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_major.getText().toString().isEmpty() || edt_critical.getText().toString() .isEmpty()|| edt_minor.getText().toString().isEmpty() )
                {
                    Toast.makeText(InlinePrelineFinal3.this,"All fields must not be empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                InlinePrelineFinalModel1 inlinePrelineFinalModel1 = new InlinePrelineFinalModel1();
                inlinePrelineFinalModel1.setAql(txt_aql.getText().toString());
                inlinePrelineFinalModel1.setInspection(txt_inspection.getText().toString());
                inlinePrelineFinalModel1.setSamplesize(txt_samplesize.getText().toString());
                inlinePrelineFinalModel1.setDefectname(edt_defectname.getText().toString());
                inlinePrelineFinalModel1.setMajor(edt_major.getText().toString());
                inlinePrelineFinalModel1.setMinor(edt_minor.getText().toString());
                inlinePrelineFinalModel1.setCritical(edt_critical.getText().toString());
                // inlinePrelineFinalModel1.setResult(txt_result.getText().toString());
                int a = Integer.parseInt(edt_major.getText().toString());
                int b = Integer.parseInt(edt_critical.getText().toString());
                int c = Integer.parseInt(edt_minor.getText().toString());
                int sum = (a + b + c);

                inlinePrelineFinalModel1.setTotal(sum + "");
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

                Intent i = new Intent(InlinePrelineFinal3.this, ResultViewForActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}
