package com.example.saurabhomer.qualityapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    AutoCompleteTextView styleNu;
    AutoCompleteTextView productName;
    AutoCompleteTextView orderNumber;
    AutoCompleteTextView shipDate;
    AutoCompleteTextView color;
    AutoCompleteTextView size_42;
    AutoCompleteTextView size_40;
    AutoCompleteTextView size_44;
    AutoCompleteTextView size_46;
    AutoCompleteTextView size_48;
    AutoCompleteTextView fabicDes;
    AutoCompleteTextView buyerName;
    Button submitBtn;
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
        size_40 = root.findViewById(R.id.size_40).findViewById(R.id.atvCommon);
        size_42 = root.findViewById(R.id.size_42).findViewById(R.id.atvCommon);
        size_44 = root.findViewById(R.id.size_44).findViewById(R.id.atvCommon);
        size_46 = root.findViewById(R.id.size_46).findViewById(R.id.atvCommon);
        size_48 = root.findViewById(R.id.size_48).findViewById(R.id.atvCommon);
        fabicDes = root.findViewById(R.id.edt_fabricdescription).findViewById(R.id.atvCommon);
        submitBtn = root.findViewById(R.id.btn_done1).findViewById(R.id.btnNext);
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

                                FirebaseDatabase.getInstance().getReference("styles").
                                        child(styleNu.getText().toString()).
                                        setValue(
                                                new StyleSheetModel(styleNu.getText().toString(),
                                                        buyerName.getText().toString(),
                                                        productName.getText().toString(),
                                                        orderNumber.getText().toString(),
                                                        shipDate.getText().toString(),
                                                        color.getText().toString(),
                                                        "",
                                                        fabicDes.getText().toString()
                                                ));

                            }
                        }
                );

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
