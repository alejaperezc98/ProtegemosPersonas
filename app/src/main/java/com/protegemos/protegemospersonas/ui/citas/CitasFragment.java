package com.protegemos.protegemospersonas.ui.citas;

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
import com.protegemos.protegemospersonas.ui.beneficiario.BeneficiarioViewModel;

public class CitasFragment extends Fragment {

    private CitasViewModel citasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        citasViewModel =
                new ViewModelProvider(this).get(CitasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_citas, container, false);
        final TextView textView = root.findViewById(R.id.txt_citas);
        citasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
