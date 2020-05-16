package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;

public class ResultViewForActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_total);

        Button ok = (Button)findViewById(R.id.btn_ok);

        InlinePrelineFinalModel inlinePrelineFinalModel = new InlinePrelineFinalModel();
        inlinePrelineFinalModel.setDate(inlinePrelineFinalModel.getDate());
        inlinePrelineFinalModel.setFinishing_line(inlinePrelineFinalModel.getFinishing_line());
        inlinePrelineFinalModel.setQuantity(inlinePrelineFinalModel.getQuantity());
        inlinePrelineFinalModel.setSelect_level(inlinePrelineFinalModel.getSelect_level());
        inlinePrelineFinalModel.setInspection_level(inlinePrelineFinalModel.getInspection_level());

        TextView textView1 = findViewById(R.id.data1);
        textView1.setText("Date          :" + inlinePrelineFinalModel.getDate());

        TextView textView2 = findViewById(R.id.data2);
        textView2.setText("Finishing Line     :" + inlinePrelineFinalModel.getFinishing_line());

        TextView textView3 = findViewById(R.id.data3);
        textView3.setText("Quantity             :" + inlinePrelineFinalModel.getQuantity());

        TextView textView4 = findViewById(R.id.data4);
        textView4.setText("Select Level        :" + inlinePrelineFinalModel.getSelect_level());

        TextView textView5 = findViewById(R.id.data5);
        textView5.setText("Inspection Level               :" + inlinePrelineFinalModel.getInspection_level());

        ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ResultViewForActivity.this, CardMenuP.class);
                startActivity(intent);
            }
        });
    }
}
