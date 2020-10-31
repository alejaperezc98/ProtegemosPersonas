package com.protegemos.protegemospersonas.ui.ips;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.ui.contactanos.ContactanosViewModel;

public class IpsFragment extends Fragment {

    private IpsViewModel ipsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ipsViewModel =
                new ViewModelProvider(this).get(IpsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ips, container, false);
        /*final TextView textView = root.findViewById(R.id.txt_ips);
        ipsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}