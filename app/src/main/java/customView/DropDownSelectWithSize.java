package customView;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.Measurement.Mesurement1;
import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.MainDailyFinishingModel;
import com.example.saurabhomer.qualityapp.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.qualityapp.R;
import com.example.saurabhomer.qualityapp.ui.gallery.MainSheet;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetListModel;
import com.example.saurabhomer.qualityapp.ui.gallery.model.MainSeetModel2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.saurabhomer.qualityapp.ui.home.HomeFragment.STYLE_NUMBER;

public class DropDownSelectWithSize extends RelativeLayout {
    public static  Spinner spinner;
    public static String selectedItem;
    DropDownListener dropDownListener;
    public DropDownSelectWithSize(Context context) {
        super(context);
        init(context);
    }

    public DropDownSelectWithSize(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropDownSelectWithSize(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    ArrayList<String> list = new ArrayList<>();


    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.common_drop_down, this);
            spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    dropDownListener.change(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            FirebaseDatabase.getInstance().getReference().child("styles").child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() != null) {
                        StyleSheetModel styleSheetModel = dataSnapshot.getValue(StyleSheetModel.class);
                        String[] arraySize = styleSheetModel.getSize().split(",");

                        for (String string1 : arraySize) {
                            list.add(string1);
                            Mesurement1.data.add("-1");
                        }
                        setAdapter(list);
                        if (list.size() > 0)
                            selectedItem = list.get(0);

                    }
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            // }

        }

    }

    private void setAdapter(ArrayList<String> list) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    public void initListener(DropDownListener mesurement1) {
        dropDownListener = mesurement1;
    }
   public interface DropDownListener{
        public void change(int position);
    }

}
