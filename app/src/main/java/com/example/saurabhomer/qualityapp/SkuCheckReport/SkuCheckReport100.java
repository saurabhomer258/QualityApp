package com.example.saurabhomer.qualityapp.SkuCheckReport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.R;

public class SkuCheckReport100 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku_check_report100);

        View view_readyquantity = findViewById(R.id.edt_readyquantity);
        final EditText editText_readyquantity = view_readyquantity.findViewById(R.id.atvCommon);

        View view_checkquantity = findViewById(R.id.edt_checkquantity);
        final EditText editText_checkquantity = view_checkquantity.findViewById(R.id.atvCommon);

        View view_size = findViewById(R.id.edt_size);
        final EditText editText_size = view_size.findViewById(R.id.atvCommon);

        View view_radio_hbc = findViewById(R.id.countryhasbeencheck);
        final RadioButton radio_country_hbc = view_radio_hbc.findViewById(R.id.ok);

        View view_label_hbc = findViewById(R.id.labelhasbeenchecked);
        final RadioGroup radio_label_hbc = view_label_hbc.findViewById(R.id.common_radio_group);

        View view_barcode_hbc = findViewById(R.id.barcodehasbeencheck);
        final RadioGroup radio_barcode_hbc = view_barcode_hbc.findViewById(R.id.common_radio_group);

        View view_color_hbc = findViewById(R.id.colourhasbeencheck);
        final RadioGroup radio_color_hbc = view_color_hbc.findViewById(R.id.common_radio_group);

        View view_polybag_hbc = findViewById(R.id.polybaghasbeencheck);
        final RadioGroup radio_polybag_hbc = view_polybag_hbc.findViewById(R.id.common_radio_group);

        View view_polysticker_hbc = findViewById(R.id.polystickerhasbeencheck);
        final RadioGroup radio_polysticker_hbc = view_polysticker_hbc.findViewById(R.id.common_radio_group);

        View view_pricetag_hbc = findViewById(R.id.pricetaghasbeencheck);
        final RadioGroup radio_pricetag_hbc = view_pricetag_hbc.findViewById(R.id.common_radio_group);

        View view_hanger_hbc = findViewById(R.id.hangerhasbeencheck);
        final RadioGroup radio_hanger_hbc = view_hanger_hbc.findViewById(R.id.common_radio_group);

        View view_hangertag_hbc = findViewById(R.id.hangtaghasbeencheck);
        final RadioGroup radio_hangertag_hbc = view_hangertag_hbc.findViewById(R.id.common_radio_group);

        View view_othertag_hbc = findViewById(R.id.otherhasbeencheck);
        final RadioGroup radio_othertag_hbc = view_othertag_hbc.findViewById(R.id.common_radio_group);

        View view_packingmethod_hbc = findViewById(R.id.packingmethodhasbeencheck);
        final RadioGroup radio_packingmethod_hbc = view_packingmethod_hbc.findViewById(R.id.common_radio_group);

        View view_sizesticker_hbc = findViewById(R.id.sizestickershasbeencheck);
        final RadioGroup radio_sizesticker_hbc = view_sizesticker_hbc.findViewById(R.id.common_radio_group);

        View view_done = findViewById(R.id.btn_done_sku);
        final Button btn_sku = view_done.findViewById(R.id.btnNext);

        btn_sku.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SkuCheckReport100Model skuCheckReport100Model = new SkuCheckReport100Model();
                skuCheckReport100Model.setEdt_readyquantity(editText_readyquantity.getText().toString());
                skuCheckReport100Model.setEdt_checkquantity(editText_checkquantity.getText().toString());
                skuCheckReport100Model.setEdt_size(editText_size.getText().toString());
                skuCheckReport100Model.setColorhasbeencheck(getStringOfRedio(radio_country_hbc.isChecked()));
            }
        });
    }

   private String getStringOfRedio(boolean okButton){
        if(okButton) return "ok";
        else return "notOk";
   }
}
