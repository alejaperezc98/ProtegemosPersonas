package com.protegemos.protegemospersonas.ui.beneficiario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeneficiarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BeneficiarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is beneficiario fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}