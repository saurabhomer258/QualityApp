package com.example.saurabhomer.qualityapp.InlinePrelineFinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.admin.InlineFinalPreLineAdmin;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;

import java.util.ArrayList;

import customView.AdminResult;

import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel;
import static com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal.inlinePrelineFinalModel1ArrayList;

public class ResultViewForActivity extends AppCompatActivity {
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_total2);
        layout = findViewById(R.id.dailyLayout);
        Button ok = (Button)findViewById(R.id.btn_ok);
       // InlinePrelineFinalModel inlinePrelineFinalModel = new InlinePrelineFinalModel();
        inlinePrelineFinalModel.setDate(inlinePrelineFinalModel.getDate());
        inlinePrelineFinalModel.setFinishing_line(inlinePrelineFinalModel.getFinishing_line());
        inlinePrelineFinalModel.setQuantity(inlinePrelineFinalModel.getQuantity());
        inlinePrelineFinalModel.setSelect_level(inlinePrelineFinalModel.getSelect_level());
        inlinePrelineFinalModel.setInspection_level(inlinePrelineFinalModel.getInspection_level());
        inlinePrelineFinalModel.setInlinePrelineFinalModel1(inlinePrelineFinalModel1ArrayList);
        ArrayList<InlinePrelineFinalModel1> inlinelist = new ArrayList<>();
        inlinelist = inlinePrelineFinalModel.getInlinePrelineFinalModel1();





        setLayout("Date       ", inlinePrelineFinalModel.getDate());

        setLayout("Finishing Line     :" , inlinePrelineFinalModel.getFinishing_line());


        setLayout("Quantity             :" , inlinePrelineFinalModel.getQuantity());

        setLayout("Select Level        :" , inlinePrelineFinalModel.getSelect_level());


        setLayout("Inspection Level               :" , inlinePrelineFinalModel.getInspection_level());

        setLayout("Wash Label ",inlinePrelineFinalModel.getWashlabel());
        setLayout("Main Label ",inlinePrelineFinalModel.getMainlabel());
        setLayout("Size Label ",inlinePrelineFinalModel.getSizelabel());
        setLayout("Hang Tag",inlinePrelineFinalModel.getHangtag());
        setLayout("Care Label ",inlinePrelineFinalModel.getCarelabel());
        setLayout("Price Tag",inlinePrelineFinalModel.getPricetag());
        setLayout("Carton Marking",inlinePrelineFinalModel.getCartoonmarking());
        setLayout("Carton Measurement",inlinePrelineFinalModel.getCartonmeasurement());
        setLayout("Carton Quality",inlinePrelineFinalModel.getCartonquality());
        setLayout("Gross Weight",inlinePrelineFinalModel.getGrossweight());
        setLayout("Net Weight",inlinePrelineFinalModel.getNetweight());
        setLayout("Brust Weight",inlinePrelineFinalModel.getBurstweight());
        setLayout("Colour",inlinePrelineFinalModel.getColour());
        setLayout("Cut Quantity",inlinePrelineFinalModel.getCutquantity());
        setLayout("Thread Colour",inlinePrelineFinalModel.getThreadcolour());
        setLayout("Button Colour",inlinePrelineFinalModel.getButtoncolour());

        for(InlinePrelineFinalModel1 items:inlinePreLineFInal2.inlinePrelineFinalModel1List)
        {
            setLayout("AQL",items.getAql());
            setLayout("Inspection",items.getInspection());
            setLayout("Sample Size", items.getSamplesize());
            setLayout("Defect Name", items.getDefectname());
            setLayout("Critical", items.getCritical());
            setLayout("Major", items.getMajor());
            setLayout("Minor", items.getMinor());
            setLayout("Total", items.getTotal());
            setLayout("Result", items.getResult());
            setLayout("Remark", items.getRemark());
        }

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
    private void setLayout(String object ,String result){
        if(result!=null) {
            TextView textView = new TextView(ResultViewForActivity.this);
            String res = "";

            textView.setText(object +" : "+ result);
            layout.addView(textView);
        }
    }
}
