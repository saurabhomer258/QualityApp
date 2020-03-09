package com.example.saurabhomer.qualityapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class NetworkUtils {
    public  static String STYLENUMBER="";
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected())
        {
           return true;
        }
        else {
            Toast.makeText(context,"Internet is not working",Toast.LENGTH_LONG).show();
            return false;
        }
    }

}
