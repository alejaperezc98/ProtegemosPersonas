package com.protegemos.protegemospersonas.ui.servicioips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LaboratorioViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public LaboratorioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is laboratorio fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
