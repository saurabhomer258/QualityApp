package com.example.saurabhomer.qualityapp.Measurement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.DailyFinishingAnalysis.DailyFinishingAnalysis2;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.cardviewmenu.CardMenuP;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetListModel;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetModel2;
import com.example.saurabhomer.qualityapp.utils.CommonStyleData;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;


public class ResultViewForActivity extends AppCompatActivity {
    TextView data41, data42, data43;
    LinearLayout layout;
    Button Ok;
    private ProgressDialog progressDialog;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        int totalVal = 0;
        setContentView(R.layout.common_total1);
        TextView total = findViewById(R.id.tv_total);
        TextView totalPer = findViewById(R.id.tv_Defect_per);
        Ok = findViewById(R.id.btn_ok);
        data41 = findViewById(R.id.data41);
        data42 = findViewById(R.id.data42);
        data43 = findViewById(R.id.data43);
        layout = findViewById(R.id.dailyLayout);

        if (!NetworkUtils.isNetworkConnected(ResultViewForActivity.this)) {
            return;
        }
        progressDialog = new ProgressDialog(ResultViewForActivity.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("styles");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(dataSnapshot!=null)
                {
                    StyleSheetModel styleSheetModel = dataSnapshot.getValue(StyleSheetModel.class);
                    setLayout("Sheet Number",STYLE_NUMBER);
                    setLayout("BuyersName",styleSheetModel.getBuyersName());
                    setLayout("ProduectName",styleSheetModel.getProduectName());
                    setLayout("OrderQuality",styleSheetModel.getOrderQuality());
                    setLayout("ShipmentDate",styleSheetModel.getShipmentDate());
                    setLayout("color",styleSheetModel.getColor());
                    setLayout("size",styleSheetModel.getSize());
                    setNew(styleSheetModel.getSize());

                }
                else
                {

                }
                progressDialog.dismiss();
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ResultViewForActivity.this,Mesurement1.class);
                startActivity(i);
            }
        });

    }
    private void setLayout(String object ,String result)
    {
        TextView textView= new TextView(ResultViewForActivity.this);
        textView.setText(object + " : "+result);
        textView.setTextColor(Color.BLACK);
        layout.addView(textView);
    }

    public void setNew(final String size1) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("mainSeet");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                MainSeetListModel mainSeetListModel = dataSnapshot.getValue(MainSeetListModel.class);
                ArrayList<MainSeetModel2> mainSeetModel2 =  mainSeetListModel.getMainSeetModel2();
                if(mainSeetListModel!=null){
                    for(int i=0;i<mainSeetModel2.size();i++){
                        setLayout("Measurement Description",mainSeetModel2.get(i).getMeasurementDiscription());
                        String arr[] = mainSeetModel2.get(i).getSize().split(",");
                        String  size2[] = size1.split(",");
                        int min = Math.min(arr.length,size2.length);
                        for(int j = 0;j<min;j++){
                            setLayout(size2[j],arr[j]);
                        }
                        setLayout("tolerance",mainSeetModel2.get(i).getToerance());
                    }
                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });

    }
}
