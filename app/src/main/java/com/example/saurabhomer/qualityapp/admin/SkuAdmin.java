package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page2;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.MainSkuModel;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuDateModel;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class SkuAdmin extends AppCompatActivity
{
    LinearLayout layout;
    SkuCheckReport100Page2 skuCheckReport100Page2 = new SkuCheckReport100Page2();
    String result1;
    String result2;
    Button info_btn;
    private ProgressDialog progressDialog;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_admin);
        layout = findViewById(R.id.dailyLayout);
        progressDialog = new ProgressDialog(this);
        info_btn = (Button)findViewById(R.id.info_daily);
        if (!NetworkUtils.isNetworkConnected(SkuAdmin.this))
        {
            return;
        }
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("100perSKU").child(STYLE_NUMBER)
                .addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        SkuDateModel skuCheckReport100Model = dataSnapshot.getValue(SkuDateModel.class);
                        setLayout("Date", skuCheckReport100Model.getDate());
                        if (skuCheckReport100Model != null) {
                            setLayout("Ready quantity        ", skuCheckReport100Model.getSkuCheckReport100Model().getEdt_readyquantity());
                            setLayout("Check quantity        ", skuCheckReport100Model.getSkuCheckReport100Model().getEdt_checkquantity());
                            setLayout("Size                           ", skuCheckReport100Model.getSkuCheckReport100Model().getEdt_size());
                            TextView textView3 = new TextView(SkuAdmin.this);
                            textView3.setText("__________________________________________________________");
                            layout.addView(textView3);
                            ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList1 = skuCheckReport100Model.getSkuCheckReport100Model().getSkuCheckReport100ModelList();
                            if (skuCheckReport100ModelList1 != null) {
                                for (SkuCheckReport100ModelList skuCheckReport100ModelList : skuCheckReport100ModelList1) {
                                    setLayout("Country Has been check                 ", skuCheckReport100ModelList.getCountryhasbeencheck());
                                    setLayout("Label has been Check                     ", skuCheckReport100ModelList.getLabelhasbeencheck());
                                    setLayout("Barcode has been check                ", skuCheckReport100ModelList.getBarcodehasbeencheck());
                                    setLayout("Color has been check                      ", skuCheckReport100ModelList.getColorhasbeencheck());
                                    setLayout("Polybag has been check                 ", skuCheckReport100ModelList.getPolybaghasbeencheck());
                                    setLayout("Price tag has been check                ", skuCheckReport100ModelList.getPricetaghasbeencheck());
                                    setLayout("Polystiker has been check              ", skuCheckReport100ModelList.getPolystikerhasbeencheck());
                                    setLayout("Size tag has been check                 ", skuCheckReport100ModelList.getSizestickerhasbeencheck());
                                    setLayout("Hanger has been check                   ", skuCheckReport100ModelList.getHagertaghasbeencheck());
                                    setLayout("Hager tag has been check              ", skuCheckReport100ModelList.getHagertaghasbeencheck());
                                    setLayout("Other has been check                      ", skuCheckReport100ModelList.getOtherhasbeencheck());
                                    setLayout("Packing method has been check   ", skuCheckReport100ModelList.getPackingmethodhasbeencheck());
                                    setLayout("Size sticker has been check           ", skuCheckReport100ModelList.getSizestickerhasbeencheck());
                                    setLayout1("Result ", skuCheckReport100ModelList.getResult());
                                    setLayout1("Remark", skuCheckReport100ModelList.getRemark());
                                    TextView textView2 = new TextView(SkuAdmin.this);
                                    textView2.setText("__________________________________________________________");
                                    layout.addView(textView2);
                                }
                            }
                        }
                        else
                            {

                            Toast.makeText(SkuAdmin.this, "Opps! No data found", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        progressDialog.hide();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.hide();
                    }
                });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkuAdmin.this, CommonStyleData.class);
                startActivity(intent);
            }
        });
    }
    private void setLayout(String object ,String result){
        TextView textView= new TextView(SkuAdmin.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }
    private void setLayout1(String object, String result)
    {
        TextView textView= new TextView(SkuAdmin.this);
        textView.setText(object + " : "+result);
        textView.setTextSize(18);
        textView.setTextColor(0xFF00FF00);
        layout.addView(textView);
    }

}