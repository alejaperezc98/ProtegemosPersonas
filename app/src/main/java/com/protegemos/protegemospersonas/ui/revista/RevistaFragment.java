package com.protegemos.protegemospersonas.ui.revista;

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

public class RevistaFragment extends Fragment {

    private RevistaViewModel revistaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        revistaViewModel =
                new ViewModelProvider(this).get(RevistaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_revista, container, false);
        final TextView textView = root.findViewById(R.id.text_revista);
        revistaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
