package customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.saurabhomer.qualityapp.R;

public class AdminResult extends RelativeLayout {
    EditText atvCommon;
    TextView r1,r2;
    public AdminResult(Context context) {
        super(context);
        init(context);
    }

    public AdminResult(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AdminResult(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.daily_finishing_text, this);
            atvCommon = view.findViewById(R.id.atvCommon);
            r1= (TextView) view.findViewById(R.id.r1);
            r2 = (TextView) view.findViewById(R.id.r2);


        }
    }
    public  void setText(String re1,String re2){
      r1.setText(re1);
      r2.setText(":"+re2);


    }

    public void setTextColor(int textColor) {
        r1.setTextColor(textColor);
        r2.setTextColor(textColor);
    }
}
