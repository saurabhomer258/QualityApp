package com.example.saurabhomer.qualityapp.admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.CartoonAudit.AreaOfPackingMaterial;
import com.example.saurabhomer.qualityapp.CartoonAudit.AreaOfPackingMaterialModel;
import com.example.saurabhomer.qualityapp.CartoonAudit.AreaofInsideCartoonModel;
import com.example.saurabhomer.qualityapp.CartoonAudit.AreaofOutsideCartoonModel;
import com.example.saurabhomer.qualityapp.CartoonAudit.CartoonAuditModel;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DailyFinishinfModels;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class CartoonAuditAdmin extends AppCompatActivity {
    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon_audit_admin);
        layout = findViewById(R.id.dailyLayout);
        Button btn = findViewById(R.id.btn_ok);
        if (!NetworkUtils.isNetworkConnected(CartoonAuditAdmin.this))
        {
            return;
        }
        progressDialog = new ProgressDialog(CartoonAuditAdmin.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        FirebaseDatabase.getInstance().getReference("cartoonaudit")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                CartoonAuditModel cartoonAuditModel =dataSnapshot.getValue(CartoonAuditModel.class);
                setLayout("Cartoon Lot Quantity",cartoonAuditModel.getCartoonlotquantity());
                setLayout("Hour1",cartoonAuditModel.getHour1());
                setLayout("Hour2",cartoonAuditModel.getHour2());
                setLayout("Hour3",cartoonAuditModel.getHour3());
                setLayout("Hour4",cartoonAuditModel.getHour4());
                setLayout("Hour5",cartoonAuditModel.getHour5());
                setLayout("Hour6",cartoonAuditModel.getHour6());
                setLayout("Hour7",cartoonAuditModel.getHour7());
                setLayout("Hour8",cartoonAuditModel.getHour8());

                TextView textView= new TextView(CartoonAuditAdmin.this);
                textView.setText("_________________________________________________");
                layout.addView(textView);
                ArrayList<AreaofOutsideCartoonModel> list = cartoonAuditModel.getAreaofOutsideCartoonModelArrayList();
                for(AreaofOutsideCartoonModel items:list)
                {
                    setLayout("Hour",items.getHour());
                    setLayout("Cartoon Lot Quantity",items.getCartoonlotquantity());
                    setLayout("Cartoon Shiping Mark",items.getCartoonshipingmark());
                    setLayout("Printing",items.getPrinting());
                    setLayout("Cartoon Size",items.getCartoonsize());
                    setLayout("Cartoon No",items.getCartoonno());
                    setLayout("Barcode",items.getBarcode());
                    setLayout("Cartoon Fly",items.getCartoonfly());
                    setLayout("Remarks",items.getRemarks());
                    TextView textView1= new TextView(CartoonAuditAdmin.this);
                    textView1.setText("_________________________________________________");
                    layout.addView(textView1);
                }

                ArrayList<AreaofInsideCartoonModel> list1 = cartoonAuditModel.getAreaofInsideCartoonModelArrayList();
                for (AreaofInsideCartoonModel items:list1)
                {
                    setLayout("Hour",items.getHour());
                    setLayout("Cartoon Quantity",items.getCartoonquantity());
                    setLayout("Total Check Quantity",items.getTotalcheckquantity());
                    setLayout("Blister or Polybag",items.getBlisterorpolybag());
                    setLayout("Assortment",items.getAssortment());
                    setLayout("Quantity",items.getQuantity());
                    setLayout("Item",items.getItem());
                    setLayout("Colour",items.getColour());
                    setLayout("Ratio",items.getRatio());
                    setLayout("Total Defect No",items.getTotaldefectno());
                    setLayout("Remark",items.getRemarks());

                    TextView textView2= new TextView(CartoonAuditAdmin.this);
                    textView2.setText("_________________________________________________");
                    layout.addView(textView2);
                }

                ArrayList<AreaOfPackingMaterialModel> list3 = cartoonAuditModel.getAreaOfPackingMaterialArrayList();
                for(AreaOfPackingMaterialModel items:list3)
                {
                       setLayout("Hour Inside",items.getHour_inside1());
                       setLayout("Cartoon Lot Quantity",items.getCartoon_lot());
                       setLayout("Check Cartoon Quantity",items.getCheckcartoon());
                       setLayout("Packing Label Or Hangtag",items.getPackinglabel());
                       setLayout("Additional Label Or Hangtag",items.getAdditionlabel());
                       setLayout("Misplace Packing Label Or Hangtag",items.getMisplacelabel());
                       setLayout("Incorrect Packing Label Or Hangtag",items.getIncorrectlabel());
                       setLayout("Damaged Or Insecure Label Or Hangtag",items.getDamagelabel());
                       setLayout("Incorrect UPC",items.getIncorrectupc());
                       setLayout("Incorrect Sizer",items.getIncorrectsize());
                       setLayout("Incorrect Hanger",items.getIncorrecthanger());
                       setLayout("Poly Warning",items.getPolywarning());
                       setLayout("Total Defect Count",items.getTotaldefectcount());

                       TextView textView3= new TextView(CartoonAuditAdmin.this);
                       textView3.setText("_________________________________________________");
                       layout.addView(textView3);

                }
                progressDialog.hide();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                progressDialog.hide();
            }
        });

    }
    private void setLayout(String object ,String result){
        if(result!=null) {
            TextView textView = new TextView(CartoonAuditAdmin.this);
            textView.setText(object + " : " + result);
            layout.addView(textView);
        }
    }
}
