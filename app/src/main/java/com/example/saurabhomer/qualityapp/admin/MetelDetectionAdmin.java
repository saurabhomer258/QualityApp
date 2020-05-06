package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPageListModel;
import com.example.saurabhomer.qualityapp.MetelDetectionPage.MetelDetectionPageModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100Model;
import com.example.saurabhomer.qualityapp.SkuCheckReport.model.SkuCheckReport100ModelList;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class MetelDetectionAdmin extends AppCompatActivity
{
    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metel_detection_admin);
        layout = findViewById(R.id.dailyLayout);
        progressDialog = new ProgressDialog(this);
        if (!NetworkUtils.isNetworkConnected(MetelDetectionAdmin.this))
        {
            return;
        }

        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("matelDetectionPage").child(STYLE_NUMBER)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        MetelDetectionPageListModel metelDetectionPageModel1 =   dataSnapshot.getValue(MetelDetectionPageListModel.class);

                        for(MetelDetectionPageModel metelDetectionPageModel : metelDetectionPageModel1.getmMetelDetectionPageModel()) {
                            setLayout("Date                      ", metelDetectionPageModel.getEdt_date());
                            setLayout("Time                     ", metelDetectionPageModel.getEdt_time());
                            setLayout("Calibrated            ", metelDetectionPageModel.getEdt_calibrated());
                            setLayout("Garment Pass     ", metelDetectionPageModel.getEdt_garment_pass());
                            setLayout("Garment check   ", metelDetectionPageModel.getEdt_no_of_garment_check());
                            setLayout("Garment fail        ", metelDetectionPageModel.getEdt_garment_fail());
                            setLayout1("Remark",metelDetectionPageModel.getRemark());
                            TextView textView1= new TextView(MetelDetectionAdmin.this);
                            textView1.setText("__________________________________________________________");
                            layout.addView(textView1);
                        }
                        progressDialog.hide();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.hide();
                    }
                });
    }

    private void setLayout(String object ,String result){
        TextView textView= new TextView(MetelDetectionAdmin.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }

    private void setLayout1(String object ,String result){
        TextView textView= new TextView(MetelDetectionAdmin.this);
        textView.setText(result);
        textView.setTextSize(18);
        layout.addView(textView);
    }

}
