package com.protegemos.protegemospersonas.ui.citas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SolicitarCitaViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public SolicitarCitaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Solicitar Cita");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
