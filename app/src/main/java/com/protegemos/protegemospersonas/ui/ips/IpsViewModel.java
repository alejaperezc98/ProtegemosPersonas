package com.protegemos.protegemospersonas.ui.ips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IpsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IpsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is IPS fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
