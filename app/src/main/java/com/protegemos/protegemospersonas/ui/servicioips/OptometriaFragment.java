package com.protegemos.protegemospersonas.ui.servicioips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.protegemos.protegemospersonas.R;

public class OptometriaFragment extends Fragment {

    private OptometriaViewModel optometriaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        optometriaViewModel =
                new ViewModelProvider(this).get(OptometriaViewModel.class);
        View root = inflater.inflate(R.layout.popup_optometria, container, false);
        return root;
    }
}
