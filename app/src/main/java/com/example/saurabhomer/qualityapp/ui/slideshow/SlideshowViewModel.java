package com.example.saurabhomer.qualityapp.ui.slideshow;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.saurabhomer.qualityapp.pref.LoginPref;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("You are sucessfully logout");
    }

    public LiveData<String> getText() {
        return mText;
    }
}