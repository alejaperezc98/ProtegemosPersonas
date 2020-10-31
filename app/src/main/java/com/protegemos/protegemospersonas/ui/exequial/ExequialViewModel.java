package com.protegemos.protegemospersonas.ui.exequial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExequialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExequialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("CONDICIONES DE PLANES CON PREVISIÓN EXEQUIAL");
    }

    public LiveData<String> getText() {
        return mText;
    }
}