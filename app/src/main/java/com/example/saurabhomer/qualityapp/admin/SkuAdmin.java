package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page2;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
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
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_admin);
        layout = findViewById(R.id.dailyLayout);
        progressDialog = new ProgressDialog(this);
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

                        SkuCheckReport100Model skuCheckReport100Model =   dataSnapshot.getValue(SkuCheckReport100Model.class);

                        setLayout("Ready quantity",skuCheckReport100Model.getEdt_readyquantity());
                        setLayout("Check quantity",skuCheckReport100Model.getEdt_checkquantity());
                        setLayout("size",skuCheckReport100Model.getEdt_size());
                        ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList1 = skuCheckReport100Model.getSkuCheckReport100ModelList();
                        for(SkuCheckReport100ModelList skuCheckReport100ModelList : skuCheckReport100ModelList1) {


                        setLayout("Country Has been check",skuCheckReport100ModelList.getCountryhasbeencheck());
                        setLayout("Label has been Check",skuCheckReport100ModelList.getLabelhasbeencheck());
                        setLayout("Barcode has been check",skuCheckReport100ModelList.getBarcodehasbeencheck());
                        setLayout("Color has been check",skuCheckReport100ModelList.getColorhasbeencheck());
                        setLayout("Polybag has been check",skuCheckReport100ModelList.getPolybaghasbeencheck());
                        setLayout("Price tag has been check",skuCheckReport100ModelList.getPricetaghasbeencheck());
                        setLayout("Polystiker has been check",skuCheckReport100ModelList.getPolystikerhasbeencheck());
                        setLayout("Size tag has been check",skuCheckReport100ModelList.getSizestickerhasbeencheck());
                        setLayout("Hanger has been check",skuCheckReport100ModelList.getHagertaghasbeencheck());
                        setLayout("Hager tag has been check",skuCheckReport100ModelList.getHagertaghasbeencheck());
                        setLayout("Otherhasbeencheck",skuCheckReport100ModelList.getOtherhasbeencheck());
                        setLayout("Other has been check",skuCheckReport100ModelList.getOtherhasbeencheck());
                        setLayout("Packing method has been check",skuCheckReport100ModelList.getPackingmethodhasbeencheck());
                        setLayout("Size sticker has been check",skuCheckReport100ModelList.getSizestickerhasbeencheck());

                            TextView textView2= new TextView(SkuAdmin.this);
                            textView2.setText("_________________________________________________");
                            layout.addView(textView2);
                        }

                        progressDialog.hide();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.hide();
                    }
                });
    }
    private void setLayout(String object ,String result){
        TextView textView= new TextView(SkuAdmin.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }

}