package customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.saurabhomer.qualityapp.R;

public class NextButton extends RelativeLayout {
    View view;
    public NextButton(Context context) {
        super(context);
        init(context);
    }

    public NextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
             view = inflater.inflate(R.layout.daily_finishing_button, this);
        }
    }

    public Button getbutton(){
         return (Button) view.findViewById(R.id.btnNext);
    }
}
