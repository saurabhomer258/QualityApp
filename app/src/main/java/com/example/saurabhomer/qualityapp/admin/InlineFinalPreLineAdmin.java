package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.CartoonAudit.model.AreaofOutsideCartoonModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel;
import com.example.saurabhomer.qualityapp.InlinePrelineFinal.inlinemodel.InlinePrelineFinalModel1;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import customView.AdminResult;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class InlineFinalPreLineAdmin extends AppCompatActivity {

    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_final_pre_line_admin);
        layout = findViewById(R.id.dailyLayout);

        if (!NetworkUtils.isNetworkConnected(InlineFinalPreLineAdmin.this))
        {
            return;
        }
        progressDialog = new ProgressDialog(InlineFinalPreLineAdmin.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        FirebaseDatabase.getInstance().getReference("inlinepreline")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                InlinePrelineFinalModel inlinePrelineFinalModel = dataSnapshot.getValue(InlinePrelineFinalModel.class);
                setLayout("Date", inlinePrelineFinalModel.getDate());
                setLayout("Finishing line",inlinePrelineFinalModel.getFinishing_line());
                TextView textView= new TextView(InlineFinalPreLineAdmin.this);
                textView.setText("_________________________________________________");
                layout.addView(textView);

                setLayout("Wash Label ",inlinePrelineFinalModel.getWashlabel());
                setLayout("Main Label ",inlinePrelineFinalModel.getMainlabel());
                setLayout("Size Label ",inlinePrelineFinalModel.getSizelabel());
                setLayout("Hang Tag",inlinePrelineFinalModel.getHangtag());
                setLayout("Care Label ",inlinePrelineFinalModel.getCarelabel());
                setLayout("Price Tag",inlinePrelineFinalModel.getPricetag());
                setLayout("Carton Marking",inlinePrelineFinalModel.getCartoonmarking());
                setLayout("Carton Measurement",inlinePrelineFinalModel.getCartonmeasurement());
                setLayout("Carton Quality",inlinePrelineFinalModel.getCartonquality());
                setLayout("Gross Weight",inlinePrelineFinalModel.getGrossweight());
                setLayout("Net Weight",inlinePrelineFinalModel.getNetweight());
                setLayout("Brust Weight",inlinePrelineFinalModel.getBurstweight());
                setLayout("Colour",inlinePrelineFinalModel.getColour());
                setLayout("Cut Quantity",inlinePrelineFinalModel.getCutquantity());
                setLayout("Thread Colour",inlinePrelineFinalModel.getThreadcolour());
                setLayout("Button Colour",inlinePrelineFinalModel.getButtoncolour());

                TextView textView1= new TextView(InlineFinalPreLineAdmin.this);
                textView1.setText("_________________________________________________");
                layout.addView(textView1);

                setLayout("Quantity",inlinePrelineFinalModel.getQuantity());
                setLayout("Select Level",inlinePrelineFinalModel.getSelect_level());
                setLayout("Inspection Level",inlinePrelineFinalModel.getInspection_level());

                TextView textView2= new TextView(InlineFinalPreLineAdmin.this);
                textView2.setText("_________________________________________________");
                layout.addView(textView2);

                ArrayList<InlinePrelineFinalModel1> list = inlinePrelineFinalModel.getInlinePrelineFinalModel1();
                for(InlinePrelineFinalModel1 items:list)
                {
                    setLayout("AQL",items.getAql());
                    setLayout("Inspection",items.getInspection());
                    setLayout("Sample Size", items.getSamplesize());
                    setLayout("Defect Name", items.getDefectname());
                    setLayout("Critical", items.getCritical());
                    setLayout("Major", items.getMajor());
                    setLayout("Minor", items.getMinor());
                    setLayout("Total", items.getTotal());
                    setLayout("Result", items.getResult());
                    setLayout("Remark", items.getRemark());
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
        if(result!=null) {
            AdminResult textView = new AdminResult(InlineFinalPreLineAdmin.this);
            String res = "";

            textView.setText(object, result);
            layout.addView(textView);
        }
    }
}
