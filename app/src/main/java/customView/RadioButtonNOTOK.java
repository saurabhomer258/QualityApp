package customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.saurabhomer.qualityapp.R;

public class RadioButtonNOTOK extends RelativeLayout {
    public RadioButtonNOTOK(Context context) {
        super(context);
        init(context);
    }

    public RadioButtonNOTOK(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RadioButtonNOTOK(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.common_radio_button, this);
        }
    }

}