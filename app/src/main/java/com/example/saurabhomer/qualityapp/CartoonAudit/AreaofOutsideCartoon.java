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

import com.example.saurabhomer.qualityapp.CartoonAudit.model.AreaofOutsideCartoonModel;
import com.example.saurabhomer.qualityapp.R;

import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.areaofOutsideCartoonModelArrayList;
import static com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit.cartoonAuditModel;

public class AreaofOutsideCartoon extends AppCompatActivity
{
        TextView defectCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areaof_outside_audit);

        View view_edt_hour = findViewById(R.id.edt_hour);
        final EditText editText_edt_hour = view_edt_hour.findViewById(R.id.atvCommon);
        defectCount = findViewById(R.id.total_defect);
        View view_edt_cartoon = findViewById(R.id.edt_cartoon);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);

        View view_edt_cartoon_shiping = findViewById(R.id.edt_cartoon_shiping);
        final RadioButton radioButton_edt_cartoon_shiping = view_edt_cartoon_shiping.findViewById(R.id.ok);

        View view_edt_printing= findViewById(R.id.edt_printing);
        final RadioButton radioButton_edt_printing = view_edt_printing.findViewById(R.id.ok);

        View view_edt_car_size = findViewById(R.id.edt_car_size);
        final RadioButton radioButton_edt_car_size = view_edt_car_size.findViewById(R.id.ok);

        View view_edt_cartoon_no = findViewById(R.id.edt_cartoon_no);
        final RadioButton radioButton_edt_cartoon_no = view_edt_cartoon_no.findViewById(R.id.ok);

        View view_edt_barcode = findViewById(R.id.edt_barcode);
        final RadioButton radioButton_edt_barcode = view_edt_barcode.findViewById(R.id.ok);

        View view_edt_car_fly = findViewById(R.id.edt_car_fly);
        final RadioButton radioButton_edt_car_fly= view_edt_car_fly.findViewById(R.id.ok);


        final TextView textView_edt_remarks = (TextView) findViewById(R.id.remarks);

        View btn_next = findViewById(R.id.btn_next);
        Button bt_next = btn_next.findViewById(R.id.btnNext);

        View btn_done = findViewById(R.id.btn_done_measurement);
        Button bt_done = btn_done.findViewById(R.id.btnNext);

        View btn_result = findViewById(R.id.btn_result);
        Button remark_btn = btn_result.findViewById(R.id.btnNext);

        remark_btn.setText("Show Remark");
        remark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String hour1 = editText_edt_hour.getText().toString();
                String edt_carton = editText_edt_cartoon.getText().toString();

                if(isNullOrEmpty(hour1) || isNullOrEmpty(edt_carton))
                {
                    Toast.makeText(AreaofOutsideCartoon.this, "Please Enter the Hour and Carton Lot Quantity", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int res =  getIntOfRedio(radioButton_edt_cartoon_shiping.isChecked())
                            +getIntOfRedio(radioButton_edt_printing.isChecked())
                            +getIntOfRedio(radioButton_edt_car_size.isChecked())
                            +getIntOfRedio(radioButton_edt_cartoon_no.isChecked())
                            +getIntOfRedio(radioButton_edt_barcode.isChecked())
                            +getIntOfRedio(radioButton_edt_car_fly.isChecked());
                    if(res==0) {
                        textView_edt_remarks.setText("Pass");
                    }
                    else {
                        textView_edt_remarks.setText("Fail");
                    }
                    defectCount.setText(res +"");
                }
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hour1 = editText_edt_hour.getText().toString();
                String edt_carton = editText_edt_cartoon.getText().toString();

                if(isNullOrEmpty(hour1) || isNullOrEmpty(edt_carton))
                {
                    Toast.makeText(AreaofOutsideCartoon.this, "Please Enter the Hour and Carton Lot Quantity", Toast.LENGTH_SHORT).show();
                }
                else {

                    AreaofOutsideCartoonModel areaofOutsideCartoonModel = new AreaofOutsideCartoonModel();
                    areaofOutsideCartoonModel.setHour(editText_edt_hour.getText().toString());
                    areaofOutsideCartoonModel.setCartoonlotquantity(editText_edt_cartoon.getText().toString());
                    areaofOutsideCartoonModel.setCartoonshipingmark(getStringOfRedio(radioButton_edt_cartoon_shiping.isChecked()));
                    areaofOutsideCartoonModel.setPrinting(getStringOfRedio(radioButton_edt_printing.isChecked()));
                    areaofOutsideCartoonModel.setCartoonsize(getStringOfRedio(radioButton_edt_car_size.isChecked()));
                    areaofOutsideCartoonModel.setCartoonno(getStringOfRedio(radioButton_edt_cartoon_no.isChecked()));
                    areaofOutsideCartoonModel.setBarcode(getStringOfRedio(radioButton_edt_barcode.isChecked()));
                    areaofOutsideCartoonModel.setCartoonfly(getStringOfRedio(radioButton_edt_car_fly.isChecked()));
                    areaofOutsideCartoonModel.setRemarks(textView_edt_remarks.getText().toString());
                    areaofOutsideCartoonModelArrayList.add(areaofOutsideCartoonModel);
                    Intent i =new Intent(AreaofOutsideCartoon.this, AreaofOutsideCartoon.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        bt_done.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String hour1 = editText_edt_hour.getText().toString();
                String edt_carton = editText_edt_cartoon.getText().toString();

                if(isNullOrEmpty(hour1) || isNullOrEmpty(edt_carton))
                {
                    Toast.makeText(AreaofOutsideCartoon.this, "Please Enter the Hour and Carton Lot Quantity", Toast.LENGTH_SHORT).show();
                }
                else {
                    AreaofOutsideCartoonModel areaofOutsideCartoonModel = new AreaofOutsideCartoonModel();
                    areaofOutsideCartoonModel.setHour(editText_edt_hour.getText().toString());
                    areaofOutsideCartoonModel.setCartoonlotquantity(editText_edt_cartoon.getText().toString());
                    areaofOutsideCartoonModel.setCartoonshipingmark(getStringOfRedio(radioButton_edt_cartoon_shiping.isChecked()));
                    areaofOutsideCartoonModel.setPrinting(getStringOfRedio(radioButton_edt_printing.isChecked()));
                    areaofOutsideCartoonModel.setCartoonsize(getStringOfRedio(radioButton_edt_car_size.isChecked()));
                    areaofOutsideCartoonModel.setCartoonno(getStringOfRedio(radioButton_edt_cartoon_no.isChecked()));
                    areaofOutsideCartoonModel.setBarcode(getStringOfRedio(radioButton_edt_barcode.isChecked()));
                    areaofOutsideCartoonModel.setCartoonfly(getStringOfRedio(radioButton_edt_car_fly.isChecked()));
                    areaofOutsideCartoonModel.setRemarks(textView_edt_remarks.getText().toString());
                    areaofOutsideCartoonModelArrayList.add(areaofOutsideCartoonModel);
                    cartoonAuditModel.setAreaofOutsideCartoonModelArrayList(areaofOutsideCartoonModelArrayList);
                    Intent i = new Intent(AreaofOutsideCartoon.this, AreaOfInsideCartoon.class);
                    startActivity(i);
                }
            }
        });
    }

    private String getStringOfRedio(boolean okButton)
    {
        if(okButton) return "ok";
        else return "notOk";
    }

    private int getIntOfRedio(boolean okButton) {
        if (okButton) return 0;
        else return 1;
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}
