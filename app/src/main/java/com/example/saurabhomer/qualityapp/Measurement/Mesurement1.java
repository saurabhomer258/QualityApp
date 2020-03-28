package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.qualityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import customView.DailyFinishingEditText;
import customView.NextButton;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;


public class Mesurement1 extends AppCompatActivity {
    NextButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesurement1);
        final DailyFinishingEditText edt_hours = findViewById(R.id.edt_hours);
        btn=  (NextButton) findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt_hours.getText().toString();
                Intent i = new Intent(Mesurement1.this,Measurment.class);
                i.putExtra("hours",data);
                startActivity(i);
            }
        });

        FirebaseDatabase.getInstance().getReference().child("styles").child(STYLE_NUMBER).child("size").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("aaa",dataSnapshot.getKey());
                Log.d("aaa",dataSnapshot.getValue()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
