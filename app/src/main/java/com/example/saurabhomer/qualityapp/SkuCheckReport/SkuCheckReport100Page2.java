package com.example.saurabhomer.qualityapp.SkuCheckReport;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAuditModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.MainSkuModel;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuDateModel;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.example.saurabhomer.qualityapp.pref.LoginPref;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import customView.NextButton;

import static com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page1.skuCheckReport100Model;
import static com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page1.skuCheckReport100ModelList1;

import static com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page1.txtDate;
import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class SkuCheckReport100Page2 extends AppCompatActivity {
    private ProgressDialog progressDialog;
    Button btn_done;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_check_report100);

        progressDialog = new ProgressDialog(this);
        View view_radio_hbc = findViewById(R.id.countryhasbeencheck);
        final RadioButton radio_country_hbc = view_radio_hbc.findViewById(R.id.ok);

        View view_label_hbc = findViewById(R.id.labelhasbeenchecked);
        final RadioButton radio_label_hbc = view_label_hbc.findViewById(R.id.ok);

        View view_barcode_hbc = findViewById(R.id.barcodehasbeencheck);
        final RadioButton radio_barcode_hbc = view_barcode_hbc.findViewById(R.id.ok);

        View view_color_hbc = findViewById(R.id.colourhasbeencheck);
        final RadioButton radio_color_hbc = view_color_hbc.findViewById(R.id.ok);

        View view_polybag_hbc = findViewById(R.id.polybaghasbeencheck);
        final RadioButton radio_polybag_hbc = view_polybag_hbc.findViewById(R.id.ok);

        View view_polysticker_hbc = findViewById(R.id.polystickerhasbeencheck);
        final RadioButton radio_polysticker_hbc = view_polysticker_hbc.findViewById(R.id.ok);

        View view_pricetag_hbc = findViewById(R.id.pricetaghasbeencheck);
        final RadioButton radio_pricetag_hbc = view_pricetag_hbc.findViewById(R.id.ok);

        View view_hanger_hbc = findViewById(R.id.hangerhasbeencheck);
        final RadioButton radio_hanger_hbc = view_hanger_hbc.findViewById(R.id.ok);

        View view_hangertag_hbc = findViewById(R.id.hangtaghasbeencheck);
        final RadioButton radio_hangertag_hbc = view_hangertag_hbc.findViewById(R.id.ok);

        View view_othertag_hbc = findViewById(R.id.otherhasbeencheck);
        final RadioButton radio_othertag_hbc = view_othertag_hbc.findViewById(R.id.ok);

        View view_packingmethod_hbc = findViewById(R.id.packingmethodhasbeencheck);
        final RadioButton radio_packingmethod_hbc = view_packingmethod_hbc.findViewById(R.id.ok);

        View view_sizesticker_hbc = findViewById(R.id.sizestickershasbeencheck);
        final RadioButton radio_sizesticker_hbc = view_sizesticker_hbc.findViewById(R.id.ok);

        View view_done = findViewById(R.id.btn_done_sku);
        btn_done = view_done.findViewById(R.id.btnNext);
        NextButton v = findViewById(R.id.btn_next_1);
        if (v != null) {
            btn_next = v.getbutton();
        }

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FirebaseDatabase.getInstance().getReference("100perSKU").child(STYLE_NUMBER)
//                      .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot)
//                    {
//                        MainSkuModel mainSkuModel =dataSnapshot.getValue(MainSkuModel.class);
//
//                        if(mainSkuModel!=null)
//                        {
////                            SkuDateModel skuDateModelArrayList;
////                            if(mainSkuModel.getSkuDateModels()!=null)
////                            {
////                                skuDateModelArrayList = mainSkuModel.getSkuDateModels();
////                            }
////                            else
////                                {
////                                skuDateModelArrayList = new SkuDateModel;
////                            }
//
//  //                          MainSkuModel mainSkuModel = new MainSkuModel();
//
//                            SkuDateModel skuDateModel =new SkuDateModel();
//
//                           // skuDateModelArrayList.add(skuDateModel);
//
//                            skuDateModel.setDate(txtDate.getText().toString());
//                            skuDateModel.setSkuCheckReport100Model(skuCheckReport100Model);
//
//
//                            SkuCheckReport100ModelList skuCheckReport100ModelList = new SkuCheckReport100ModelList();
//                            skuCheckReport100ModelList.setCountryhasbeencheck(getStringOfRedio(radio_country_hbc.isChecked()));
//                            skuCheckReport100ModelList.setLabelhasbeencheck(getStringOfRedio(radio_label_hbc.isChecked()));
//                            skuCheckReport100ModelList.setBarcodehasbeencheck(getStringOfRedio(radio_barcode_hbc.isChecked()));
//                            skuCheckReport100ModelList.setColorhasbeencheck(getStringOfRedio(radio_color_hbc.isChecked()));
//                            skuCheckReport100ModelList.setPolybaghasbeencheck(getStringOfRedio(radio_polybag_hbc.isChecked()));
//                            skuCheckReport100ModelList.setPolystikerhasbeencheck(getStringOfRedio(radio_polysticker_hbc.isChecked()));
//                            skuCheckReport100ModelList.setPricetaghasbeencheck(getStringOfRedio(radio_pricetag_hbc.isChecked()));
//                            skuCheckReport100ModelList.setHangerhasbeencheck(getStringOfRedio(radio_hanger_hbc.isChecked()));
//                            skuCheckReport100ModelList.setHagertaghasbeencheck(getStringOfRedio(radio_hangertag_hbc.isChecked()));
//                            skuCheckReport100ModelList.setOtherhasbeencheck(getStringOfRedio(radio_othertag_hbc.isChecked()));
//                            skuCheckReport100ModelList.setPackingmethodhasbeencheck(getStringOfRedio(radio_packingmethod_hbc.isChecked()));
//                            skuCheckReport100ModelList.setSizestickerhasbeencheck(getStringOfRedio(radio_sizesticker_hbc.isChecked()));
//                            skuCheckReport100ModelList1.add(skuCheckReport100ModelList);
//                            skuCheckReport100Model.setSkuCheckReport100ModelList(skuCheckReport100ModelList1);
////                            mainSkuModel.setSkuDateModels(skuDateModelArrayList);
//
//                            FirebaseDatabase.getInstance().getReference("100perSKU").child(STYLE_NUMBER).setValue(skuDateModel).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (!task.isComplete()) {
//                                        Toast.makeText(SkuCheckReport100Page2.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
//                                    }
//                                    progressDialog.dismiss();
//                                    finish();
//                                }
//                            });
//                            skuCheckReport100ModelList1.clear();
//                        }
//                        else
                //   {
                MainSkuModel mainSkuModel = new MainSkuModel();
                //   ArrayList<SkuDateModel> skuDateModelArrayList = mainSkuModel.getSkuDateModels();


                //                          MainSkuModel mainSkuModel = new MainSkuModel();

                SkuDateModel skuDateModel = new SkuDateModel();

                // skuDateModelArrayList.add(skuDateModel);

                skuDateModel.setDate(txtDate.getText().toString());
                skuDateModel.setSkuCheckReport100Model(skuCheckReport100Model);


                SkuCheckReport100ModelList skuCheckReport100ModelList = new SkuCheckReport100ModelList();
                skuCheckReport100ModelList.setCountryhasbeencheck(getStringOfRedio(radio_country_hbc.isChecked()));
                skuCheckReport100ModelList.setLabelhasbeencheck(getStringOfRedio(radio_label_hbc.isChecked()));
                skuCheckReport100ModelList.setBarcodehasbeencheck(getStringOfRedio(radio_barcode_hbc.isChecked()));
                skuCheckReport100ModelList.setColorhasbeencheck(getStringOfRedio(radio_color_hbc.isChecked()));
                skuCheckReport100ModelList.setPolybaghasbeencheck(getStringOfRedio(radio_polybag_hbc.isChecked()));
                skuCheckReport100ModelList.setPolystikerhasbeencheck(getStringOfRedio(radio_polysticker_hbc.isChecked()));
                skuCheckReport100ModelList.setPricetaghasbeencheck(getStringOfRedio(radio_pricetag_hbc.isChecked()));
                skuCheckReport100ModelList.setHangerhasbeencheck(getStringOfRedio(radio_hanger_hbc.isChecked()));
                skuCheckReport100ModelList.setHagertaghasbeencheck(getStringOfRedio(radio_hangertag_hbc.isChecked()));
                skuCheckReport100ModelList.setOtherhasbeencheck(getStringOfRedio(radio_othertag_hbc.isChecked()));
                skuCheckReport100ModelList.setPackingmethodhasbeencheck(getStringOfRedio(radio_packingmethod_hbc.isChecked()));
                skuCheckReport100ModelList.setSizestickerhasbeencheck(getStringOfRedio(radio_sizesticker_hbc.isChecked()));
                skuCheckReport100ModelList1.add(skuCheckReport100ModelList);
                skuCheckReport100Model.setSkuCheckReport100ModelList(skuCheckReport100ModelList1);
                //  mainSkuModel.setSkuDateModels(skuDateModelArrayList);

                FirebaseDatabase.getInstance().getReference("100perSKU").child(STYLE_NUMBER).setValue(skuDateModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isComplete()) {
                            Toast.makeText(SkuCheckReport100Page2.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                        finish();
                    }
                });
                skuCheckReport100ModelList1.clear();
            }
    });
        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SkuCheckReport100ModelList skuCheckReport100ModelList = new SkuCheckReport100ModelList();
                skuCheckReport100ModelList.setCountryhasbeencheck(getStringOfRedio(radio_country_hbc.isChecked()));
                skuCheckReport100ModelList.setLabelhasbeencheck(getStringOfRedio(radio_label_hbc.isChecked()));
                skuCheckReport100ModelList.setBarcodehasbeencheck(getStringOfRedio(radio_barcode_hbc.isChecked()));
                skuCheckReport100ModelList.setColorhasbeencheck(getStringOfRedio(radio_color_hbc.isChecked()));
                skuCheckReport100ModelList.setPolybaghasbeencheck(getStringOfRedio(radio_polybag_hbc.isChecked()));
                skuCheckReport100ModelList.setPolystikerhasbeencheck(getStringOfRedio(radio_polysticker_hbc.isChecked()));
                skuCheckReport100ModelList.setPricetaghasbeencheck(getStringOfRedio(radio_pricetag_hbc.isChecked()));
                skuCheckReport100ModelList.setHangerhasbeencheck(getStringOfRedio(radio_hanger_hbc.isChecked()));
                skuCheckReport100ModelList.setHagertaghasbeencheck(getStringOfRedio(radio_hangertag_hbc.isChecked()));
                skuCheckReport100ModelList.setOtherhasbeencheck(getStringOfRedio(radio_othertag_hbc.isChecked()));
                skuCheckReport100ModelList.setPackingmethodhasbeencheck(getStringOfRedio(radio_packingmethod_hbc.isChecked()));
                skuCheckReport100ModelList.setSizestickerhasbeencheck(getStringOfRedio(radio_sizesticker_hbc.isChecked()));
                skuCheckReport100ModelList1.add(skuCheckReport100ModelList);
                Intent i = new Intent(SkuCheckReport100Page2.this, SkuCheckReport100Page2.class);
                startActivity(i);
                finish();
            }
        });
    }


    private String getStringOfRedio(boolean okButton) {
        if (okButton) return "ok";
        else return "notOk";
    }

    private void senddonedata(SkuCheckReport100ModelList skuCheckReport100ModelList) {

    }

}
