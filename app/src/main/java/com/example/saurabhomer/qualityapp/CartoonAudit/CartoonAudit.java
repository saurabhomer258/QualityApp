package com.example.saurabhomer.qualityapp.CartoonAudit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.BaseActivity;

public class CartoonAudit extends BaseActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_audit);

        View view_edt_cartoon = findViewById(R.id.edt_cartoonlotquantity);
        final EditText editText_edt_cartoon = view_edt_cartoon.findViewById(R.id.atvCommon);

        View view_edt_hour1 = findViewById(R.id.edt_hour1);
        final EditText editText_edt_hour1 = view_edt_hour1.findViewById(R.id.atvCommon);

        View view_edt_hour2 = findViewById(R.id.edt_hour2);
        final EditText editText_edt_hour2 = view_edt_hour2.findViewById(R.id.atvCommon);

        View view_edt_hour3 = findViewById(R.id.edt_hour3);
        final EditText editText_edt_hour3 = view_edt_hour3.findViewById(R.id.atvCommon);

        View view_edt_hour4 = findViewById(R.id.edt_hour4);
        final EditText editText_edt_hour4 = view_edt_hour4.findViewById(R.id.atvCommon);

        View view_edt_hour5 = findViewById(R.id.edt_hour5);
        final EditText editText_edt_hour5 = view_edt_hour5.findViewById(R.id.atvCommon);

        View view_edt_hour6 = findViewById(R.id.edt_hour6);
        final EditText editText_edt_hour6 = view_edt_hour6.findViewById(R.id.atvCommon);

        View view_edt_hour7 = findViewById(R.id.edt_hour7);
        final EditText editText_edt_hour7 = view_edt_hour7.findViewById(R.id.atvCommon);

        View view_edt_hour8 = findViewById(R.id.edt_hour8);
        final EditText editText_edt_hour8 = view_edt_hour8.findViewById(R.id.atvCommon);


        final Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(CartoonAudit.this, AreaofOutsideCartoon.class);
                startActivity(i);
            }
        });
    }
}
