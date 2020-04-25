package com.example.saurabhomer.qualityapp.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.Measurement.MeasurementListModel;
import com.example.saurabhomer.qualityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class MesurementAdmin extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesurement_admin);
        layout = findViewById(R.id.dailyLayout);
        FirebaseDatabase.getInstance().getReference("mesurement")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                MeasurementListModel measurementListModel =  dataSnapshot.getValue(MeasurementListModel.class);
                setLayout("Date", measurementListModel.getDate());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void setLayout(String object, String result) {
        TextView textView = new TextView(MesurementAdmin.this);
        textView.setText(object + " : " + result);
        layout.addView(textView);
    }

}
