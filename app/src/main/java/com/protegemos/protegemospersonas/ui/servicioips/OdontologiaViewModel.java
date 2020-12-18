package com.protegemos.protegemospersonas.ui.servicioips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OdontologiaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public OdontologiaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is odontologia fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
