package com.protegemos.protegemospersonas.ui.guia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuiaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GuiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Convenios");
    }

    public LiveData<String> getText() {
        return mText;
    }

}

