package com.example.saurabhomer.qualityapp.cardviewmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.saurabhomer.qualityapp.DailyFinishingDefectAnalysis;
import com.example.saurabhomer.qualityapp.R;

public class CardMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
        CardView cardView1 = findViewById(R.id.cardView1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(CardMenu.this, DailyFinishingDefectAnalysis.class);
                startActivity(i);
            }
        });
    }
}
