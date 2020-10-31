package com.protegemos.protegemospersonas.ui.revista;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RevistaViewModel  extends ViewModel {

    private MutableLiveData<String> mText;

    public RevistaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Revista fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
