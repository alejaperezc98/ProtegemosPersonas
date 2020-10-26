package com.protegemos.protegemospersonas.ui.renovar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RenovarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RenovarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is renovar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
