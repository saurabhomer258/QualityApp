package customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.saurabhomer.qualityapp.R;

import java.util.ArrayList;
import java.util.List;

public class DailyFinishingEditTextDForMesurement extends RelativeLayout {
    EditText atvCommon;
    public DailyFinishingEditTextDForMesurement(Context context) {
        super(context);
        init(context);
    }

    public DailyFinishingEditTextDForMesurement(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DailyFinishingEditTextDForMesurement(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    Spinner spinner;

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.daily_finishing_int_edit_text, this);

              spinner = (Spinner) findViewById(R.id.spinner2);
            List<String> list = new ArrayList<String>();
            list.add("0");

            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
            list.add("8");
            list.add("9");
            list.add("10");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }
    }
    public  String getText(){
      return spinner.getSelectedItem().toString();
    }
    public  void clear(){

    }

}
