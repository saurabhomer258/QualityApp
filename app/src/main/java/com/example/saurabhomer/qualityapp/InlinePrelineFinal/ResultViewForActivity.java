package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;
import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel1ArrayList;

public class ResultViewForActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_total);

        Button ok = (Button)findViewById(R.id.btn_ok);
//       // InlinePrelineFinalModel inlinePrelineFinalModel = new InlinePrelineFinalModel();
//        inlinePrelineFinalModel.setDate(inlinePrelineFinalModel.getDate());
//        inlinePrelineFinalModel.setFinishing_line(inlinePrelineFinalModel.getFinishing_line());
//        inlinePrelineFinalModel.setQuantity(inlinePrelineFinalModel.getQuantity());
//        inlinePrelineFinalModel.setSelect_level(inlinePrelineFinalModel.getSelect_level());
//        inlinePrelineFinalModel.setInspection_level(inlinePrelineFinalModel.getInspection_level());
//        inlinePrelineFinalModel.setInlinePrelineFinalModel1(inlinePrelineFinalModel1ArrayList);




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

        TextView textView6 = findViewById(R.id.data6);
        textView6.setText("Wash Label               :" + inlinePrelineFinalModel.getWashlabel());

        TextView textView7 = findViewById(R.id.data7);
        textView7.setText("Main Label              :" + inlinePrelineFinalModel.getMainlabel());

        TextView textView8 = findViewById(R.id.data8);
        textView8.setText("Size Label               :" + inlinePrelineFinalModel.getSizelabel());

        TextView textView9 = findViewById(R.id.data9);
        textView9.setText("Hang Tag              :" + inlinePrelineFinalModel.getHangtag());

        TextView textView10 = findViewById(R.id.data10);
        textView10.setText("Price Tag               :" + inlinePrelineFinalModel.getPricetag());

        TextView textView11 = findViewById(R.id.data11);
        textView11.setText("Care Label               :" + inlinePrelineFinalModel.getCarelabel());

        TextView textView12 = findViewById(R.id.data12);
        textView12.setText("Carton Marking               :" + inlinePrelineFinalModel.getCartoonmarking());

        TextView textView13 = findViewById(R.id.data13);
        textView13.setText("Carton Measurement               :" + inlinePrelineFinalModel.getCartonmeasurement());

        TextView textView14 = findViewById(R.id.data14);
        textView14.setText("Carton Quality               :" + inlinePrelineFinalModel.getCartonquality());

        TextView textView15 = findViewById(R.id.data15);
        textView15.setText("Gross Weight               :" + inlinePrelineFinalModel.getGrossweight());

        TextView textView16 = findViewById(R.id.data16);
        textView16.setText("Net Weight               :" + inlinePrelineFinalModel.getNetweight());

        TextView textView17 = findViewById(R.id.data17);
        textView17.setText("Burst Weight               :" + inlinePrelineFinalModel.getBurstweight());

        TextView textView18 = findViewById(R.id.data18);
        textView18.setText("Color              :" + inlinePrelineFinalModel.getColour());

        TextView textView19 = findViewById(R.id.data19);
        textView19.setText("Cut Quantity               :" + inlinePrelineFinalModel.getCutquantity());

        TextView textView20 = findViewById(R.id.data20);
        textView20.setText("Thread Color               :" + inlinePrelineFinalModel.getThreadcolour());

        TextView textView21 = findViewById(R.id.data21);
        textView21.setText("Button Color               :" + inlinePrelineFinalModel.getButtoncolour());




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
