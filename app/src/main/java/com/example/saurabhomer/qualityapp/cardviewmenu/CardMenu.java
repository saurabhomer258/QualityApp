package com.example.saurabhomer.qualityapp.cardviewmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.Measurement.Measurment;
import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPage;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.SkuCheckReport100;

public class CardMenu extends AppCompatActivity {
public  static String STYLE_NUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
        CardView cardView1 = findViewById(R.id.cardView1);
        if(getIntent()!=null)
        {
           Intent i = getIntent();
            STYLE_NUMBER =i.getStringExtra("style");

        }
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(CardMenu.this, DailyFinishingDefectAnalysis.class);
                startActivity(i);
            }
        });

        CardView cardView2 = findViewById(R.id.cardView2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(CardMenu.this, DailyFinishingDefectAnalysis.class);
               startActivity(i);
            }
        });

        CardView cardView3 = findViewById(R.id.mainfile11);
//        cardView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(CardMenu.this,DailyFinishingDefectAnalysis.class);
//                startActivity(i);
//
//            }
//        });
        CardView mainFile = findViewById(R.id.cardView3);
        mainFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(CardMenu.this, MainSheet.class);
//                startActivity(i);
            }
        });

        CardView cardView4 = findViewById(R.id.cardView4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i = new Intent(CardMenu.this, Measurment.class);
             startActivity(i);
            }
        });

        CardView cardView5 = findViewById(R.id.cardView5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardMenu.this, MetelDetectionPage.class);
                startActivity(i);
            }
        });

        CardView cardView6 = findViewById(R.id.cardView6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardMenu.this, SkuCheckReport100.class);
                startActivity(i);
            }
        });

        CardView cardView7 = findViewById(R.id.cardView7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i = new Intent(CardMenu.this,)
            }
        });

        CardView cardView8 = findViewById(R.id.cardView8);
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

       // CardView cardView5 = findViewById(R.id.)
    }
}
