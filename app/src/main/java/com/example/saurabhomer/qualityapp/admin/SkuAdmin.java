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

public class SkuAdmin extends AppCompatActivity {
    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                        ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList1 = skuCheckReport100Model.getSkuCheckReport100ModelList();
                        for(SkuCheckReport100ModelList skuCheckReport100ModelList : skuCheckReport100ModelList1) {


                        setLayout("countryhasbeencheck",skuCheckReport100ModelList.getCountryhasbeencheck());
                        setLayout("labelhasbeencheck",skuCheckReport100ModelList.getLabelhasbeencheck());
                        setLayout("barcodehasbeencheck",skuCheckReport100ModelList.getBarcodehasbeencheck());
                        setLayout("colorhasbeencheck",skuCheckReport100ModelList.getColorhasbeencheck());
                        setLayout("polybaghasbeencheck",skuCheckReport100ModelList.getPolybaghasbeencheck());
                        setLayout("pricetaghasbeencheck",skuCheckReport100ModelList.getPricetaghasbeencheck());
                        setLayout("polystikerhasbeencheck",skuCheckReport100ModelList.getPolystikerhasbeencheck());
                        setLayout("sizetaghasbeencheck",skuCheckReport100ModelList.getSizestickerhasbeencheck());
                        setLayout("hangerhasbeencheck",skuCheckReport100ModelList.getHagertaghasbeencheck());
                        setLayout("hagertaghasbeencheck",skuCheckReport100ModelList.getHagertaghasbeencheck());
                        setLayout("otherhasbeencheck",skuCheckReport100ModelList.getOtherhasbeencheck());
                        setLayout("otherhasbeencheck",skuCheckReport100ModelList.getOtherhasbeencheck());
                        setLayout("packingmethodhasbeencheck",skuCheckReport100ModelList.getPackingmethodhasbeencheck());
                        setLayout("sizestickerhasbeencheck",skuCheckReport100ModelList.getSizestickerhasbeencheck());
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
