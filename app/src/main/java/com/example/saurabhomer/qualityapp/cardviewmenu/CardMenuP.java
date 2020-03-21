package com.example.saurabhomer.qualityapp.cardviewmenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAudit;
import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.Measurement.Measurment;
import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPage;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100Page1;
import com.example.saurabhomer.qualityapp.admin.DailyfinishingAdmin;
import com.example.saurabhomer.qualityapp.admin.SkuAdmin;
import com.example.saurabhomer.qualityapp.pref.LoginPref;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class CardMenuP extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                openDailyFinishing();
            }
        });
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyFinishing();
            }
        });
        getup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyFinishing();
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
                Intent i = new Intent(CardMenuP.this, MetelDetectionPage.class);
                startActivity(i);
            }
        });
        skutest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("100perSKU")
                        .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(!NetworkUtils.isNetworkConnected(CardMenuP.this))
                        {
                            progressDialog.hide();
                            return;
                        }
                        if (dataSnapshot.getValue() == null) {
                            Intent i = new Intent(CardMenuP.this, SkuCheckReport100Page1.class);
                            startActivity(i);
                        }
                        else if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                            Intent i = new Intent(CardMenuP.this, SkuAdmin.class);
                            startActivity(i);

                        }
                        else {
                            Toast.makeText(CardMenuP.this,"This is completed.",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

        });


        cartoonaudit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardMenuP.this, CartoonAudit.class);
                startActivity(intent);
            }
        });
        inlinefinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void openDailyFinishing(){
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("dailyFinishing")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(!NetworkUtils.isNetworkConnected(CardMenuP.this))
                {
                    progressDialog.hide();
                    return;
                }
                if (dataSnapshot.getValue() == null) {
                    Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysis.class);
                    startActivity(i);
                } else if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                    Intent i =  new Intent(CardMenuP.this, DailyfinishingAdmin.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(CardMenuP.this,"This is completed.",Toast.LENGTH_LONG).show();
                }
                progressDialog.hide();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
