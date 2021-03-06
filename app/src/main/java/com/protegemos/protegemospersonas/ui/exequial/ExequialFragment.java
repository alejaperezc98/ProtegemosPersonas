package com.protegemos.protegemospersonas.ui.exequial;

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

public class ExequialFragment extends Fragment {

    private ExequialViewModel exequialViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exequialViewModel =
                new ViewModelProvider(this).get(ExequialViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exequial, container, false);
        final TextView textView = root.findViewById(R.id.txt_exe);
        exequialViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
