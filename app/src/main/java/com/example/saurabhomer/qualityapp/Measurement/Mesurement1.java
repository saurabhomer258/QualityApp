package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetListModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import customView.DailyFinishingEditText;
import customView.DoneButton;
import customView.DropDownSelectWithSize;
import customView.NextButton;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;


public class Mesurement1 extends AppCompatActivity {
    NextButton btn;
    DoneButton doneButton;
    static public ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesurement1);

        btn = (NextButton) findViewById(R.id.btn_next1);
        doneButton = (DoneButton) findViewById(R.id.btn_done);

        Button nextbtn = (Button)  btn.findViewById(R.id.btnNext);
        Button submit  = (Button)  doneButton.findViewById(R.id.btnNext);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Mesurement1.this, Measurement2.class);
                startActivity(i1);

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo check data value
            }
        });
    }
}
