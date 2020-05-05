package com.example.saurabhomer.qualityapp.cardviewmenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.AreaofOutsideCartoon;
import com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit;
import com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAuditModel;
import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.GetUp.DailyFinishingDefectAnalysisGetup;
import com.example.saurabhomer.qualityapp.Measurement.Measurment;
import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPage;
import com.example.saurabhomer.qualityapp.OutSide.DailyFinishingDefectAnalysisOutside;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page1;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page2;
import com.example.saurabhomer.qualityapp.admin.CartoonAuditAdmin;
import com.example.saurabhomer.qualityapp.admin.DailyfinishingAdmin;
import com.example.saurabhomer.qualityapp.admin.DailyfinishingGetUpAdmin;
import com.example.saurabhomer.qualityapp.admin.DailyfinishingOutsideAdmin;
import com.example.saurabhomer.qualityapp.admin.MetelDetectionAdmin;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.pref.LoginPref;
import com.example.saurabhomer.qualityapp.utils.CommonDailyDateFilter;
import com.example.saurabhomer.qualityapp.utils.CommonDateFilter;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class CardMenuP extends AppCompatActivity
{
    private ProgressDialog progressDialog;
    static CartoonAuditModel cartoonAuditModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu_p);
        CardView inside = findViewById(R.id.cardview_inside);
        CardView outside = findViewById(R.id.cardview_outside);
        CardView getup = findViewById(R.id.cardview_getup);
        CardView measurmentreport = findViewById(R.id.cardview_measurmentreport);
        CardView hourlyreport = findViewById(R.id.cardview_hourlyreport);
        CardView meteldetection = findViewById(R.id.cardview_meteldetecttion);
        CardView skutest = findViewById(R.id.cardview_sku);
        CardView cartoonaudit = findViewById(R.id.cardview_cartoon);
        CardView inlinefinal = findViewById(R.id.cardview_inline);

        progressDialog = new ProgressDialog(this);
        if (getIntent() != null) {
            Intent i = getIntent();


        }
        inside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyFinishingcheck();
            }
        });
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyFinishingOutsidecheck();
            }
        });
        getup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyFinishingGetupcheck();
            }
        });
        measurmentreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardMenuP.this, Measurment.class);
                startActivity(i);
            }
        });
        hourlyreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        meteldetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                    Intent i =  new Intent(CardMenuP.this, MetelDetectionAdmin.class);
                    i.putExtra("Name","Metel");
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(CardMenuP.this, MetelDetectionPage.class);
                    startActivity(i);

                }
                progressDialog.hide();
            }
        });

        skutest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                    Intent i =  new Intent(CardMenuP.this, SkuAdmin.class);
                    i.putExtra("Name","Skutest");
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(CardMenuP.this, SkuCheckReport100Page1.class);
                    startActivity(i);

                }
                progressDialog.hide();
            }

        });


        cartoonaudit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                    Intent i =  new Intent(CardMenuP.this, CartoonAuditAdmin.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(CardMenuP.this, AreaofOutsideCartoon.class);
                    startActivity(i);

                }
                progressDialog.hide();
            }
        });

        inlinefinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    void openDailyFinishingcheck(){
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
            i.putExtra("Name","DialyInside");
            startActivity(i);
        }
        else {
            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysis.class);
            startActivity(i);

        }
        progressDialog.hide();

    }
    void openDailyFinishingGetupcheck(){
        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
            i.putExtra("Name","DailyGetup");
            startActivity(i);
        }
        else {
            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysisGetup.class);
            startActivity(i);

        }
        progressDialog.hide();
    }

    void openDailyFinishingOutsidecheck(){
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
            i.putExtra("Name","DailyOutSide");
            startActivity(i);
        }
        else {
            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysisOutside.class);
            startActivity(i);
        }
        progressDialog.hide();

    }
}