package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingAnalysis2;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page2;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.example.saurabhomer.qualityapp.dialog.DailyFInishingResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.areaOfPackingMaterialArrayList;
import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.cartoonAuditModel;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class AreaOfPackingMaterial extends AppCompatActivity {


    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_of_packing_material);

        progressDialog = new ProgressDialog(this);

        View view_edt_hour = findViewById(R.id.edt_hour);
        final EditText editText_edt_hour = view_edt_hour.findViewById(R.id.atvCommon);

        View view_edt_cartoon = findViewById(R.id.edt_cartoon);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);


        View view_edt_check_cartoon = findViewById(R.id.edt_check_cartoon);
        final EditText editText_edt_check_cartoon = view_edt_check_cartoon.findViewById(R.id.atvCommon);


        View view_edt_packinglabel = findViewById(R.id.edt_packinglabel);
        final RadioButton radioButton_view_edt_packinglabel = view_edt_packinglabel.findViewById(R.id.ok);


        View view_edt_additionallabel = findViewById(R.id.edt_additionallabel);
        final RadioButton radioButton_edt_additionallabel = view_edt_additionallabel.findViewById(R.id.ok);

        View view_edt_misplace = findViewById(R.id.edt_misplace);
        final RadioButton radioButton_edt_misplace = view_edt_misplace.findViewById(R.id.ok);

        View view_edt_incorrectlabel = findViewById(R.id.edt_incorrectlabel);
        final RadioButton radioButton_edt_incorrectlabel= view_edt_incorrectlabel.findViewById(R.id.ok);

        View view_edt_damagelabel = findViewById(R.id.edt_damagelabel);
        final RadioButton radioButton_edt_damagelabel= view_edt_damagelabel.findViewById(R.id.ok);


        View view_edt_incorrectUPC = findViewById(R.id.edt_incorrectUPC);
        final RadioButton radioButton_edt_incorrectUPC= view_edt_incorrectUPC.findViewById(R.id.ok);

        View view_edt_incorrectSize = findViewById(R.id.edt_incorrectSize);
        final RadioButton radioButton_edt_incorrectSize= view_edt_incorrectSize.findViewById(R.id.ok);

        View view_edt_incorrectHanger = findViewById(R.id.edt_incorrectHanger);
        final RadioButton radioButton_edt_incorrectHanger= view_edt_incorrectHanger.findViewById(R.id.ok);

        View view_edt_polywarning = findViewById(R.id.edt_polywarning);
        final RadioButton radioButton_edt_polywarning= view_edt_polywarning.findViewById(R.id.ok);


        View view_edt_total_defect_count = findViewById(R.id.edt_total_defect_count);
        final EditText editText_edt_total_defect_count = view_edt_total_defect_count.findViewById(R.id.atvCommon);


        View btn_next = findViewById(R.id.btn_next);
        Button bt_next = btn_next.findViewById(R.id.btnNext);

        View btn_done = findViewById(R.id.btn_done_measurement);
        Button bt_done = btn_done.findViewById(R.id.btnNext);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AreaOfPackingMaterial.this, AreaOfPackingMaterial.class);
                AreaOfPackingMaterialModel areaOfPackingMaterialModel = new AreaOfPackingMaterialModel();
                areaOfPackingMaterialModel.setHour_inside1(editText_edt_hour.getText().toString());
                areaOfPackingMaterialModel.setCartoon_lot(editText_edt_cartoon.getText().toString());
                areaOfPackingMaterialModel.setCheckcartoon(editText_edt_check_cartoon.getText().toString());
                areaOfPackingMaterialModel.setPackinglabel(getStringOfRedio(radioButton_view_edt_packinglabel.isChecked()));
                areaOfPackingMaterialModel.setAdditionlabel(getStringOfRedio(radioButton_edt_additionallabel.isChecked()));
                areaOfPackingMaterialModel.setMisplacelabel(getStringOfRedio(radioButton_edt_misplace.isChecked()));
                areaOfPackingMaterialModel.setIncorrectlabel(getStringOfRedio(radioButton_edt_incorrectlabel.isChecked()));
                areaOfPackingMaterialModel.setDamagelabel(getStringOfRedio(radioButton_edt_damagelabel.isChecked()));
                areaOfPackingMaterialModel.setIncorrectupc(getStringOfRedio(radioButton_edt_incorrectUPC.isChecked()));
                areaOfPackingMaterialModel.setIncorrectsize(getStringOfRedio(radioButton_edt_incorrectSize.isChecked()));
                areaOfPackingMaterialModel.setIncorrecthanger(getStringOfRedio(radioButton_edt_incorrectHanger.isChecked()));
                areaOfPackingMaterialModel.setPolywarning(getStringOfRedio(radioButton_edt_polywarning.isChecked()));
                areaOfPackingMaterialModel.setTotaldefectcount(editText_edt_total_defect_count.getText().toString());
                areaOfPackingMaterialArrayList.add(areaOfPackingMaterialModel);
                startActivity(i);
            }
        });

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AreaOfPackingMaterialModel areaOfPackingMaterialModel = new AreaOfPackingMaterialModel();
                areaOfPackingMaterialModel.setHour_inside1(editText_edt_hour.getText().toString());
                areaOfPackingMaterialModel.setCartoon_lot(editText_edt_cartoon.getText().toString());
                areaOfPackingMaterialModel.setCheckcartoon(editText_edt_check_cartoon.getText().toString());
                areaOfPackingMaterialModel.setPackinglabel(getStringOfRedio(radioButton_view_edt_packinglabel.isChecked()));
                areaOfPackingMaterialModel.setAdditionlabel(getStringOfRedio(radioButton_edt_additionallabel.isChecked()));
                areaOfPackingMaterialModel.setMisplacelabel(getStringOfRedio(radioButton_edt_misplace.isChecked()));
                areaOfPackingMaterialModel.setIncorrectlabel(getStringOfRedio(radioButton_edt_incorrectlabel.isChecked()));
                areaOfPackingMaterialModel.setDamagelabel(getStringOfRedio(radioButton_edt_damagelabel.isChecked()));
                areaOfPackingMaterialModel.setIncorrectupc(getStringOfRedio(radioButton_edt_incorrectUPC.isChecked()));
                areaOfPackingMaterialModel.setIncorrectsize(getStringOfRedio(radioButton_edt_incorrectSize.isChecked()));
                areaOfPackingMaterialModel.setIncorrecthanger(getStringOfRedio(radioButton_edt_incorrectHanger.isChecked()));
                areaOfPackingMaterialModel.setPolywarning(getStringOfRedio(radioButton_edt_polywarning.isChecked()));
                areaOfPackingMaterialModel.setTotaldefectcount(editText_edt_total_defect_count.getText().toString());
                areaOfPackingMaterialArrayList.add(areaOfPackingMaterialModel);
                cartoonAuditModel.setAreaOfPackingMaterialArrayList(areaOfPackingMaterialArrayList);

                FirebaseDatabase.getInstance().getReference("cartoonaudit").child(STYLE_NUMBER).setValue(cartoonAuditModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(!task.isComplete())
                        {
                            Toast.makeText(AreaOfPackingMaterial.this,"opps ! some thing went wrong, please try again",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                        finish();
                    }
                });
                areaOfPackingMaterialArrayList.clear();
                Intent i =new Intent(AreaOfPackingMaterial.this, CardMenuP.class);
                startActivity(i);
                finish();
            }
        });
    }

    private String getStringOfRedio(boolean okButton)
    {
        if(okButton) return "ok";
        else return "notOk";
    }
}
