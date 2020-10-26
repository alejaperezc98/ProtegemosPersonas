package com.protegemos.protegemospersonas.ui.contactanos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactanosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactanosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is contacto fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}