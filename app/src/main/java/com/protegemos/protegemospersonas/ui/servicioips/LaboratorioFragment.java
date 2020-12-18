package com.protegemos.protegemospersonas.ui.servicioips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.ui.slideshow.SlideshowViewModel;

public class LaboratorioFragment extends Fragment {

    private LaboratorioViewModel laboratorioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        laboratorioViewModel =
                new ViewModelProvider(this).get(LaboratorioViewModel.class);
        View root = inflater.inflate(R.layout.popup_laboratorio, container, false);
        return root;
    }
}
