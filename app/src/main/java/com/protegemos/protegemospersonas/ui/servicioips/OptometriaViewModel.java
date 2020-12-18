package com.protegemos.protegemospersonas.ui.servicioips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OptometriaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OptometriaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is optometria fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
