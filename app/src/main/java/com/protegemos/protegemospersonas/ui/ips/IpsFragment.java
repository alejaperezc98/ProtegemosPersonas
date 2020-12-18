package com.protegemos.protegemospersonas.ui.ips;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.ui.contactanos.ContactanosViewModel;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static androidx.navigation.Navigation.findNavController;

public class IpsFragment extends Fragment {

    private IpsViewModel ipsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ipsViewModel =
                new ViewModelProvider(this).get(IpsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ips, container, false);

        ImageButton odontologia = root.findViewById(R.id.img_odo);
        ImageButton optometria = root.findViewById(R.id.img_opto);
        ImageButton laboratorio = root.findViewById(R.id.img_lab);

        odontologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {findNavController(v).navigate(R.id.nav_odontologia);}
        });

        optometria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {findNavController(v).navigate(R.id.nav_optometria); }
        });

        laboratorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {findNavController(v).navigate(R.id.nav_laboratorio);}
        });

        return root;
    }
}