package customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.saurabhomer.qualityapp.R;

public class LoginEditText extends RelativeLayout {
    public LoginEditText(Context context) {
        super(context);
        init(context);
    }

    public LoginEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.login_edit_text, this);
        }
    }
}
