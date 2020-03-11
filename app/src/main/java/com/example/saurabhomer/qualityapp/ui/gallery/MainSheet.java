package com.example.saurabhomer.qualityapp.ui.gallery;

import android.app.ProgressDialog;
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

import com.example.saurabhomer.qualityapp.HomeActivity;
import com.example.saurabhomer.qualityapp.LoginActivity;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetModel2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.ArrayList;

import customView.DailyFinishingEditText;

import static com.example.saurabhomer.qualityapp.ui.gallery.GalleryFragment.styleSheetModel;

public class MainSheet extends AppCompatActivity {
    ArrayList<DailyFinishingEditText> editTexts = new ArrayList<>();
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sheet2);
        progressDialog = new ProgressDialog(this);
        Button nextbtns = findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button submitbtn = findViewById(R.id.btn_done_sku).findViewById(R.id.btnNext);
        final EditText  edt_finishing_working_hour= findViewById(R.id.edt_finishing_working_hour).findViewById(R.id.atvCommon);
        final EditText edt_toerance = findViewById(R.id.edt_toerance).findViewById(R.id.atvCommon);
        LinearLayout layout = findViewById(R.id.layout);

        String[] arraySize = styleSheetModel.getSize().split(",");
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
                valueTV.setTextSize(12);

                valueTV.setText(string);
                DailyFinishingEditText dailyFinishingEditText = new DailyFinishingEditText(this);
                editTexts.add(dailyFinishingEditText);
                layout.addView(layout2);
                layout.addView(dailyFinishingEditText);
                layout2.addView(valueTV);
            }

        }
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                String string = "";
                for(DailyFinishingEditText list : editTexts){
                    string =string +  list+",";
                }
                MainSeetModel2 mainSeetModel2 = new MainSeetModel2(edt_finishing_working_hour.getText().toString(),edt_toerance.getText().toString(),string);
                GalleryFragment.mainSeetModel2.add(mainSeetModel2);

                FirebaseDatabase.getInstance().getReference("styles").
                                        child(styleSheetModel.getSheetNumber().toString()).
                                        setValue(styleSheetModel);

                for(int i=0;i<GalleryFragment.mainSeetModel2.size();i++)
                {
                    FirebaseDatabase.getInstance().getReference("mainSeet")
                            .child(styleSheetModel.getSheetNumber().toString())
                            .child(i+"")
                            .setValue(GalleryFragment.mainSeetModel2.get(i)).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()|| task.isComplete()) {
                                startActivity(new Intent(MainSheet.this, HomeActivity.class));
                                finish();
                                progressDialog.dismiss();
                                Toast.makeText(MainSheet.this,"Data is successfully inserted ",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainSheet.this,"oops ! Please try again ",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }


            }
        });
        nextbtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = "";
                for (DailyFinishingEditText list : editTexts) {
                    string = string + list + ",";
                }
                MainSeetModel2 mainSeetModel2 = new MainSeetModel2(edt_finishing_working_hour.getText().toString(), edt_toerance.getText().toString(), string);
                GalleryFragment.mainSeetModel2.add(mainSeetModel2);
                Intent intent =new Intent(MainSheet.this, MainSheet.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }


        });
    }
}
