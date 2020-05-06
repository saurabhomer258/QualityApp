package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.R;

import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.areaOfPackingMaterialArrayList;
import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.areaofInsideCartoonModelArrayList;
import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.cartoonAuditModel;
import static java.lang.Integer.*;

public class AreaOfInsideCartoon extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_of_inside_carton);

        View view_edt_hour = findViewById(R.id.edt_hour);
        final EditText editText_edt_hour = view_edt_hour.findViewById(R.id.atvCommon);

        View view_edt_cartoon = findViewById(R.id.edt_cartoon);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);


//        View view_edt_check_cartoon = findViewById(R.id.edt_check_cartoon);
//        final EditText editText_edt_check_cartoon = view_edt_check_cartoon.findViewById(R.id.atvCommon);

        View view_edt_blister = findViewById(R.id.edt_blister);
        final RadioButton radioButton_edt_blister = view_edt_blister.findViewById(R.id.ok);


        View view_edt_damage_blister = findViewById(R.id.edt_damage_blister);
        final RadioButton radioButton_edt_damage_blister = view_edt_damage_blister.findViewById(R.id.ok);

        View view_edt_assorment = findViewById(R.id.edt_assorment);
        final RadioButton radioButton_edt_assorment = view_edt_assorment.findViewById(R.id.ok);

        View view_edt_quantity = findViewById(R.id.edt_quantity);
        final RadioButton radioButton_edt_quantity= view_edt_quantity.findViewById(R.id.ok);

        View view_edt_item = findViewById(R.id.edt_item);
        final RadioButton radioButton_edt_item= view_edt_item.findViewById(R.id.ok);


        View view_edt_colour = findViewById(R.id.edt_colour);
        final RadioButton radioButton_edt_colour= view_edt_colour.findViewById(R.id.ok);

        View view_edt_ratio = findViewById(R.id.edt_ratio);
        final RadioButton radioButton_edt_ratio= view_edt_ratio.findViewById(R.id.ok);

        View view_edt_total_defect_count = findViewById(R.id.edt_total_defect_count);
        final EditText editText_edt_total_defect_count = view_edt_total_defect_count.findViewById(R.id.atvCommon);

        View btn_next = findViewById(R.id.btn_next);
        Button bt_next = btn_next.findViewById(R.id.btnNext);

        View btn_done = findViewById(R.id.btn_done_measurement);
        Button bt_done = btn_done.findViewById(R.id.btnNext);

        View btn_result = findViewById(R.id.btn_result);
        Button remark_btn = btn_result.findViewById(R.id.btnNext);

        //checkquantity
        final TextView carton_checkquantity = (TextView) findViewById(R.id.checkquantity);

        String crt = editText_edt_cartoon.getText().toString();


        final TextView textView_edt_remarks = (TextView) findViewById(R.id.remarks);


        remark_btn.setText("Show Remark");

        remark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hour1 =  editText_edt_hour.getText().toString();
                String edt_carton = editText_edt_cartoon.getText().toString();
                String total_defect = editText_edt_total_defect_count.getText().toString();

                if(isNullOrEmpty(hour1) || isNullOrEmpty(edt_carton) || isNullOrEmpty(total_defect) )
                {
                    Toast.makeText(AreaOfInsideCartoon.this, "Please enter hour,carton quantity and total default", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int res = getIntOfRedio(radioButton_edt_ratio.isChecked())
                            + getIntOfRedio(radioButton_edt_assorment.isChecked())
                            + getIntOfRedio(radioButton_edt_blister.isChecked())
                            + getIntOfRedio(radioButton_edt_colour.isChecked())
                            + getIntOfRedio(radioButton_edt_damage_blister.isChecked())
                            + getIntOfRedio(radioButton_edt_item.isChecked())
                            + getIntOfRedio(radioButton_edt_quantity.isChecked());
                    String tot = editText_edt_total_defect_count.getText().toString();
                    int tot1 = parseInt(tot);
                    //Toast.makeText(AreaOfInsideCartoon.this, ""+tot1, Toast.LENGTH_SHORT).show();


                    if(res==0 && tot1 == 0)
                    {
                        textView_edt_remarks.setText("Pass");
                    }
                    else {
                        textView_edt_remarks.setText("Fail");
                    }
                }
                }


        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String remark = textView_edt_remarks.getText().toString();
                    if(isNullOrEmpty(remark))
                    {
                        Toast.makeText(AreaOfInsideCartoon.this, "Please enter remark", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                    AreaofInsideCartoonModel areaofInsideCartoonModel=new AreaofInsideCartoonModel();
                    areaofInsideCartoonModel.setHour(editText_edt_hour.getText().toString());
                    areaofInsideCartoonModel.setCartoonquantity(editText_edt_cartoon.getText().toString());
                    areaofInsideCartoonModel.setCheckcartton(editText_edt_cartoon.getText().toString());
                    areaofInsideCartoonModel.setCheckcartton(carton_checkquantity.getText().toString());
                    areaofInsideCartoonModel.setBlisterorpolybag(getStringOfRedio(radioButton_edt_blister.isChecked()));
                    areaofInsideCartoonModel.setDamageblister(getStringOfRedio(radioButton_edt_damage_blister.isChecked()));
                    areaofInsideCartoonModel.setAssortment(getStringOfRedio(radioButton_edt_assorment.isChecked()));
                    areaofInsideCartoonModel.setQuantity(getStringOfRedio(radioButton_edt_quantity.isChecked()));
                    areaofInsideCartoonModel.setItem(getStringOfRedio(radioButton_edt_item.isChecked()));
                    areaofInsideCartoonModel.setColour(getStringOfRedio(radioButton_edt_colour.isChecked()));
                    areaofInsideCartoonModel.setRatio(getStringOfRedio(radioButton_edt_ratio.isChecked()));
                    areaofInsideCartoonModel.setTotaldefectno(editText_edt_total_defect_count.getText().toString());
                    areaofInsideCartoonModelArrayList.add(areaofInsideCartoonModel);
                    Intent i =new Intent(AreaOfInsideCartoon.this, AreaOfInsideCartoon.class);
                    startActivity(i);
                    finish();
                }


            }
        });

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String remark = textView_edt_remarks.getText().toString();
                if(isNullOrEmpty(remark))
                {
                    Toast.makeText(AreaOfInsideCartoon.this, "Please enter remark", Toast.LENGTH_SHORT).show();
                }
                else {
                    AreaofInsideCartoonModel areaofInsideCartoonModel = new AreaofInsideCartoonModel();
                    areaofInsideCartoonModel.setHour(editText_edt_hour.getText().toString());
                    areaofInsideCartoonModel.setCartoonquantity(editText_edt_cartoon.getText().toString());
                    areaofInsideCartoonModel.setCheckcartton(editText_edt_cartoon.getText().toString());
                    areaofInsideCartoonModel.setCheckcartton(carton_checkquantity.getText().toString());
                    areaofInsideCartoonModel.setBlisterorpolybag(getStringOfRedio(radioButton_edt_blister.isChecked()));
                    areaofInsideCartoonModel.setDamageblister(getStringOfRedio(radioButton_edt_damage_blister.isChecked()));
                    areaofInsideCartoonModel.setAssortment(getStringOfRedio(radioButton_edt_assorment.isChecked()));
                    areaofInsideCartoonModel.setQuantity(getStringOfRedio(radioButton_edt_quantity.isChecked()));
                    areaofInsideCartoonModel.setItem(getStringOfRedio(radioButton_edt_item.isChecked()));
                    areaofInsideCartoonModel.setColour(getStringOfRedio(radioButton_edt_colour.isChecked()));
                    areaofInsideCartoonModel.setRatio(getStringOfRedio(radioButton_edt_ratio.isChecked()));
                    areaofInsideCartoonModel.setTotaldefectno(editText_edt_total_defect_count.getText().toString());
                    areaofInsideCartoonModelArrayList.add(areaofInsideCartoonModel);
                    cartoonAuditModel.setAreaofInsideCartoonModelArrayList(areaofInsideCartoonModelArrayList);
                    Intent i = new Intent(AreaOfInsideCartoon.this, AreaOfPackingMaterial.class);
                    startActivity(i);
                }
            }
        });
    }
    private String getStringOfRedio(boolean okButton){
        if(okButton) return "ok";
        else return "notOk";
    }

    private int getIntOfRedio(boolean okButton) {
        if (okButton) return 0;
        else return 1;
    }

    private int getpercentage(int value)
    {
        int res = 0 ;
        int x = 20;
        res = x/100*value;
        return res;
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}
