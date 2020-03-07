package com.example.saurabhomer.qualityapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.saurabhomer.qualityapp.pref.LoginPref;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(LoginPref.getInstance(this).getUserName().isEmpty())
        {
            Intent i = new Intent();
            startActivity(i);
            finish();
        }
    }
}
