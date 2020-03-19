package com.example.saurabhomer.qualityapp.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class SkuAdmin extends AppCompatActivity {
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_admin);
        layout = findViewById(R.id.dailyLayout);
        FirebaseDatabase.getInstance().getReference("100perSKU").child(STYLE_NUMBER)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        SkuCheckReport100ModelList skuCheckReport100ModelList =   dataSnapshot.getValue(SkuCheckReport100ModelList.class);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
    private void setLayout(String object ,String result){
        TextView textView= new TextView(SkuAdmin.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }

}
