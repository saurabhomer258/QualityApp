package com.example.saurabhomer.qualityapp.utils;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.MainSheet;
import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.example.saurabhomer.qualityapp.ui.home.HomeFragment;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class CommonStyleData extends AppCompatActivity
{
    Button Ok;
    LinearLayout layout;
    private ProgressDialog progressDialog;
    private String styleNu;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_style_data);
        layout = findViewById(R.id.dailyLayout);
        Ok = (Button)findViewById(R.id.ok);

        progressDialog = new ProgressDialog(this);
        if (!NetworkUtils.isNetworkConnected(CommonStyleData.this))
        {
            return;
        }
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("styles");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(dataSnapshot!=null)
                {
                    StyleSheetModel styleSheetModel = dataSnapshot.getValue(StyleSheetModel.class);
                    setLayout("Sheet Number",STYLE_NUMBER);
                    setLayout("BuyersName",styleSheetModel.getBuyersName());
                    setLayout("ProduectName",styleSheetModel.getProduectName());
                    setLayout("OrderQuality",styleSheetModel.getOrderQuality());
                    setLayout("ShipmentDate",styleSheetModel.getShipmentDate());
                    setLayout("color",styleSheetModel.getColor());
                    setLayout("size",styleSheetModel.getSize());

                    progressDialog.hide();
                }
                else
                {
                     progressDialog.hide();
                }
              
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });



        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (progressDialog != null)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    private void setLayout(String object ,String result)
    {
        TextView textView= new TextView(CommonStyleData.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }
}
