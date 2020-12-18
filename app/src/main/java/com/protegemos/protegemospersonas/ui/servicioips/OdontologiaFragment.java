package com.protegemos.protegemospersonas.ui.servicioips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.protegemos.protegemospersonas.R;

public class OdontologiaFragment extends Fragment {

    private OdontologiaViewModel odontologiaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        odontologiaViewModel =
                new ViewModelProvider(this).get(OdontologiaViewModel.class);
        View root = inflater.inflate(R.layout.popup_odontologia, container, false);
        return root;
    }
}
