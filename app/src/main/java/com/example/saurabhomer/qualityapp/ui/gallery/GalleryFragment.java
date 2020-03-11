package com.example.saurabhomer.qualityapp.ui.gallery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetModel2;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {


    AutoCompleteTextView styleNu;
    AutoCompleteTextView productName;
    AutoCompleteTextView orderNumber;
    AutoCompleteTextView shipDate;
    AutoCompleteTextView color;
    AutoCompleteTextView size;

    AutoCompleteTextView fabicDes;
    AutoCompleteTextView buyerName;
    Button submitBtn;
    static StyleSheetModel styleSheetModel;
    static ArrayList<MainSeetModel2> mainSeetModel2 = new ArrayList<>();
    private ProgressDialog progressDialog;
    // this is new style

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        styleNu = root.findViewById(R.id.edt_style_no).findViewById(R.id.atvCommon);
        productName = root.findViewById(R.id.edt_product_name).findViewById(R.id.atvCommon);
        buyerName = root.findViewById(R.id.edt_buyer_name).findViewById(R.id.atvCommon);
        orderNumber = root.findViewById(R.id.edt_order_quality).findViewById(R.id.atvCommon);
        shipDate = root.findViewById(R.id.edt_shipment_date).findViewById(R.id.atvCommon);
        color = root.findViewById(R.id.edt_color).findViewById(R.id.atvCommon);
        size = root.findViewById(R.id.edt_Size).findViewById(R.id.atvCommon);

        fabicDes = root.findViewById(R.id.edt_fabricdescription).findViewById(R.id.atvCommon);
        submitBtn = root.findViewById(R.id.btn_done1).findViewById(R.id.btnNext);
        progressDialog = new ProgressDialog(getContext());
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();
        submitBtn.
                setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                progressDialog.setMessage("Verificating...");
                                progressDialog.show();

                                if(!NetworkUtils.isNetworkConnected(getContext()))
                                {
                                    return;
                                }

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference users = firebaseDatabase.getReference("styles");
                                users.
                                        child(styleNu.getText().toString()).
                                        addListenerForSingleValueEvent(new ValueEventListener() {
                                                                           @Override
                                                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                                                               if (dataSnapshot.getValue() == null) {

                                                                                   styleSheetModel = new StyleSheetModel(styleNu.getText().toString(),
                                                                                           buyerName.getText().toString(),
                                                                                           productName.getText().toString(),
                                                                                           orderNumber.getText().toString(),
                                                                                           shipDate.getText().toString(),
                                                                                           color.getText().toString(),
                                                                                           size.getText().toString(),
                                                                                           fabicDes.getText().toString());
                                                                                   //    ));
                                                                                   startActivity(new Intent(getActivity(), MainSheet.class));


                                                                               }
                                                                               else{
                                                                                   Toast.makeText(getContext(),"Please check style Number. Style number should be unique.",Toast.LENGTH_LONG).show();;
                                                                               }

                                                                           }

                                                                           @Override
                                                                           public void onCancelled(DatabaseError databaseError) {

                                                                           }
                                                                       }
                                        );

                            }
                        });
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
