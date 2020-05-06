package com.example.saurabhomer.qualityapp.Measurement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetListModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import customView.DailyFinishingEditTextDForMesurement;
import customView.DoneButton;
import customView.DropDownSelectWithSize;
import customView.NextButton;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class Measurement2 extends AppCompatActivity {

    LinearLayout layout;
    DoneButton btn;
    ArrayList<DailyFinishingEditTextDForMesurement> editTexts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement2);
        layout = findViewById(R.id.layout);
        btn = (DoneButton) findViewById(R.id.btn_done);
        Button doneBtn = (Button)  findViewById(R.id.btnNext);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tobeAddDataInIndex  =  DropDownSelectWithSize.spinner.getSelectedItemPosition();
                String res = "";
                for(int i =0;i< editTexts.size();i++){
                    if(i==0){
                        res = editTexts.get(i).getText();
                    }
                    else {
                        res = res + ","+editTexts.get(i).getText();
                    }
                }
                Mesurement1.data.set(tobeAddDataInIndex,res);
                finish();
            }
        });
        // data : for chese
        //DropDownSelectWithSize.spinner.getSelectedItemPosition() //  DropDownSelectWithSize.spinner.getSelectedItem()
        int tobeAddDataInIndex  =  DropDownSelectWithSize.spinner.getSelectedItemPosition();
        String oldItem =  Mesurement1.data.get(tobeAddDataInIndex);
        DatabaseReference users = FirebaseDatabase.getInstance().getReference("mainSeet");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String s ="";
                MainSeetListModel mainSeetListModel = dataSnapshot.getValue(MainSeetListModel.class);
                if (mainSeetListModel.getMainSeetModel2() != null) {
                    for(int i=0;i< mainSeetListModel.getMainSeetModel2().size();i++){
                        s=  mainSeetListModel.getMainSeetModel2().get(i).getMeasurementDiscription();
                        size(s);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

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
                layout2.setOrientation(LinearLayout.HORIZONTAL);
                layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                layout2.setWeightSum(10);
                layout2.setGravity(Gravity.CENTER);
                valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                        400,
                        LinearLayout.LayoutParams.WRAP_CONTENT));

                layout2.setPadding(14, 0, 14, 14);

                valueTV.setTextColor(getResources().getColor(R.color.common_text_color));
                valueTV.setTextSize(16);

                valueTV.setText(string);
                DailyFinishingEditTextDForMesurement dailyFinishingEditText = new DailyFinishingEditTextDForMesurement(this);
                layout2.addView(valueTV);
                layout2.addView(dailyFinishingEditText);
                editTexts.add(dailyFinishingEditText);
                layout.addView(layout2);


            }

        }
    }
}
