package com.example.saurabhomer.qualityapp.Measurement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetListModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import customView.DailyFinishingEditText;
import customView.DailyFinishingEditTextDForMesurement;
import customView.DoneButton;
import customView.DropDownSelectWithSize;
import customView.NextButton;

import static com.example.saurabhomer.qualityapp.Measurement.Measurment.measurementListModel;
import static com.example.saurabhomer.qualityapp.Measurement.Measurment.measurementListModelList;
import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;


public class Mesurement1 extends AppCompatActivity implements DropDownSelectWithSize.DropDownListener {
    NextButton btn;
    DoneButton doneButton;
    EditText hour;
    LinearLayout layout;
    static public ArrayList<String> data = new ArrayList<>();
    ArrayList<DailyFinishingEditTextDForMesurement> editTexts = new ArrayList<>();
    DropDownSelectWithSize dropDownSelectWithSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesurement1);

        View view_measurment = findViewById(R.id.edt_hour);
        hour = view_measurment.findViewById(R.id.atvCommon);

        layout = findViewById(R.id.layout);

        btn = (NextButton) findViewById(R.id.btn_next1);
        doneButton = (DoneButton) findViewById(R.id.btn_done);
        dropDownSelectWithSize = findViewById(R.id.dropdown);
        dropDownSelectWithSize.initListener(this);
        Button nextbtn = (Button) btn.findViewById(R.id.btnNext);
        Button submit = (Button) doneButton.findViewById(R.id.btnNext);
        DatabaseReference users = FirebaseDatabase.getInstance().getReference("mainSeet");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String s = "";
                MainSeetListModel mainSeetListModel = dataSnapshot.getValue(MainSeetListModel.class);
                if (mainSeetListModel.getMainSeetModel2() != null) {
                    for (int i = 0; i < mainSeetListModel.getMainSeetModel2().size(); i++) {
                        s = mainSeetListModel.getMainSeetModel2().get(i).getMeasurementDiscription();
                        size(s);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("mesurement").child(STYLE_NUMBER)
                        .addListenerForSingleValueEvent(new ValueEventListener() {

                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                MeasurementListModel measurementListModel = dataSnapshot.getValue(MeasurementListModel.class);
                                if (measurementListModel == null) {
                                    measurementListModel = new MeasurementListModel();
                                }
                                List<MeasurementModel> measurementListModelList;
                                if (measurementListModel.getMeasurementModels() != null) {
                                    measurementListModelList = measurementListModel.getMeasurementModels();
                                } else {
                                    measurementListModelList = new ArrayList<MeasurementModel>();
                                }

                                int tobeAddDataInIndex = DropDownSelectWithSize.spinner.getSelectedItemPosition();
                                String res = "";
                                for (int i = 0; i < editTexts.size(); i++) {
                                    if (i == 0) {
                                        res = editTexts.get(i).getText();
                                    } else {
                                        res = res + "," + editTexts.get(i).getText();
                                    }
                                }
                                Mesurement1.data.set(tobeAddDataInIndex, res);
                                MeasurementModel measurementModel = new MeasurementModel();
                                measurementModel.setHours(hour.getText().toString());
                                measurementModel.setValues(Mesurement1.data);
                                measurementListModelList.add(measurementModel);
                                measurementListModel.setMeasurementModels(measurementListModelList);
                                FirebaseDatabase.getInstance().getReference("mesurement").child(STYLE_NUMBER).setValue(measurementListModel)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Intent i1 = new Intent(Mesurement1.this, Mesurement1.class);
                                                startActivity(i1);
                                            }
                                        });


                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("mesurement").child(STYLE_NUMBER)
                        .addListenerForSingleValueEvent(new ValueEventListener() {

                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                MeasurementListModel measurementListModel = dataSnapshot.getValue(MeasurementListModel.class);
                                if (measurementListModel == null) {
                                    measurementListModel = new MeasurementListModel();
                                }
                                List<MeasurementModel> measurementListModelList;
                                if (measurementListModel.getMeasurementModels() != null) {
                                    measurementListModelList = measurementListModel.getMeasurementModels();
                                } else {
                                    measurementListModelList = new ArrayList<MeasurementModel>();
                                }

                                int tobeAddDataInIndex = DropDownSelectWithSize.spinner.getSelectedItemPosition();
                                String res = "";
                                for (int i = 0; i < editTexts.size(); i++) {
                                    if (i == 0) {
                                        res = editTexts.get(i).getText();
                                    } else {
                                        res = res + "," + editTexts.get(i).getText();
                                    }
                                }
                                Mesurement1.data.set(tobeAddDataInIndex, res);
                                MeasurementModel measurementModel = new MeasurementModel();
                                measurementModel.setHours(hour.getText().toString());
                                measurementModel.setValues(Mesurement1.data);
                                measurementListModelList.add(measurementModel);
                                measurementListModel.setMeasurementModels(measurementListModelList);
                                FirebaseDatabase.getInstance().getReference("mesurement").child(STYLE_NUMBER).setValue(measurementListModel)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Intent i1 = new Intent(Mesurement1.this, CardMenuP.class);
                                                startActivity(i1);
                                                finish();
                                            }
                                        });
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });



            }

        });

    }

    String text ="";
    @Override
    public void change(int position) {
        String res = "";
        for (int i = 0; i < editTexts.size(); i++) {
            if (i == 0) {
                res = editTexts.get(i).getText();
            } else {
                res = res + "," + editTexts.get(i).getText();
            }
        }
        Mesurement1.data.set(position, res);
//        for (int i = 0; i < editTexts.size(); i++) {
//            if (editTexts.get(i).getText().trim().isEmpty()) {
//                Toast.makeText(Mesurement1.this, "opps! some fields are empty please check", Toast.LENGTH_SHORT).show();
//                break;
//
//            }
//            if (i == editTexts.size() - 1) {
//                insertData();
//            }
//        }

    }

    private void insertData() {
        int tobeAddDataInIndex = DropDownSelectWithSize.spinner.getSelectedItemPosition();
        String res = "";
        for (int i = 0; i < editTexts.size(); i++) {
            if (i == 0) {
                res = editTexts.get(i).getText();
            } else {
                res = res + "," + editTexts.get(i).getText();
            }
        }
        Mesurement1.data.set(tobeAddDataInIndex, res);
        MeasurementModel measurementModel = new MeasurementModel();
        measurementModel.setHours(hour.getText().toString());
        measurementModel.setValues(Mesurement1.data);
        // measurementListModelList.add(measurementModel);
        for (int i = 0; i < editTexts.size(); i++) {
            DailyFinishingEditTextDForMesurement view = editTexts.get(i);
            view.clear();


        }
    }

    private void size(String size) {
        String[] arraySize = size.split(",");
        for (String string : arraySize) {
            if (string.trim().isEmpty()) {

            } else {
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
