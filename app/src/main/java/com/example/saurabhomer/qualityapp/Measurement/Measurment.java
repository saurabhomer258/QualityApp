package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import customView.DailyFinishingEditText;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class Measurment extends AppCompatActivity
{
    EditText edt_measurement;
    EditText edt_tolerance_plus;
    EditText edt_tolerance_minus;

    Button next;
    LinearLayout layout;
    ArrayList<DailyFinishingEditText> editTexts = new ArrayList<>();
    Button done;
    static MeasurementListModel measurementListModel = new MeasurementListModel();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        if(i!=null){
             String hours= i.getStringExtra("hours");
        }
        setContentView(R.layout.activity_measurment_description);
       layout = findViewById(R.id.layout);
        View  view_measurment= findViewById(R.id.edt_measurment);
        edt_measurement = view_measurment.findViewById(R.id.atvCommon);

        View  view_tolerance_plus= findViewById(R.id.edt_tolerance_plus);
        edt_tolerance_plus = view_tolerance_plus.findViewById(R.id.atvCommon);

        View  view_tolerance_minus= findViewById(R.id.edt_tolerance_minus);
        edt_tolerance_minus = view_tolerance_minus.findViewById(R.id.atvCommon);

//        final CheckBox  check40= findViewById(R.id.checkbox_40);
//
//        final CheckBox  check42= findViewById(R.id.checkbox_42);
//
//        final CheckBox  check44= findViewById(R.id.checkbox_44);
//
//        final CheckBox  check46= findViewById(R.id.checkbox_46);
//
//        final CheckBox  check48= findViewById(R.id.checkbox_48);



        View view_done = findViewById(R.id.btn_done_measurement);
        done = view_done.findViewById(R.id.btnNext);
      Button nextbtn =  findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        FirebaseDatabase.getInstance().getReference().child("styles").child(STYLE_NUMBER).child("size").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                size(dataSnapshot.getValue()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Measurment.this,Mesurement1.class));
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeasurementModel measurementModel  = new MeasurementModel();

                measurementModel.setEdt_measur(edt_measurement.getText().toString());
                measurementModel.setEdt_tolerance_plus(edt_tolerance_plus.getText().toString());
                measurementModel.setEdt_tolerance_minus(edt_tolerance_minus.getText().toString());
                List<MeasurementModel> measurementModels  = new ArrayList<>();
                measurementModels.add(measurementModel);
                measurementListModel.setMeasurementModels(measurementModels);


            }
        });
    }
    private void senddonedata(MeasurementModel measurementModel)
    {

    }
    private void size(String size) {
        String[] arraySize = size.split(",");
        for(String string : arraySize)
        {
            if(string.trim().isEmpty())
            {

            }
            else {
                TextView valueTV = new TextView(this);
                LinearLayout layout2 = new LinearLayout(this);
                layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                layout2.setOrientation(LinearLayout.VERTICAL);
                layout2.setWeightSum(10);
                layout2.setGravity(Gravity.CENTER);
                valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                layout2.setPadding(14, 0, 14, 14);

                valueTV.setTextColor(getResources().getColor(R.color.common_text_color));
                valueTV.setTextSize(16);

                valueTV.setText(string);
                DailyFinishingEditText dailyFinishingEditText = new DailyFinishingEditText(this);
                editTexts.add(dailyFinishingEditText);
                layout.addView(layout2);
                layout.addView(dailyFinishingEditText);
                layout2.addView(valueTV);
            }

        }
    }
}
