package com.example.saurabhomer.qualityapp.pref;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class LoginPref {

    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;
    private static  LoginPref mInstance ;
    @SuppressLint("CommitPrefEdits")
    private  LoginPref(Context context) {

        mSharedPreferences = context.getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static synchronized LoginPref getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LoginPref(context);
        }
        return mInstance;
    }
    public void apply() {
        if (mEditor != null) {

            mEditor.apply();

        }
    }

    public void setUsername(String username,String isAdmin)
    {
        mEditor.putString("username", username);
        mEditor.putString("isAdmin", isAdmin);
        mEditor.apply();
    }

    public String getUserName() {
        return mSharedPreferences.getString("username", "");
    }

    public String getAdmin() {
        return mSharedPreferences.getString("isAdmin", "");
    }
}
