package com.protegemos.protegemospersonas.ui.citas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CitasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CitasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Citas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}