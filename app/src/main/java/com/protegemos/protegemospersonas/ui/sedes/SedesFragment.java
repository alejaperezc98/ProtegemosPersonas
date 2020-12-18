package com.protegemos.protegemospersonas.ui.sedes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.protegemos.protegemospersonas.R;

public class SedesFragment extends Fragment {

    private SedesViewModel sedesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sedesViewModel =
                new ViewModelProvider(this).get(SedesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        sedesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ImageButton pasto=root.findViewById(R.id.img_pasto);
        ImageButton ipiales=root.findViewById(R.id.img_ipiales);
        ImageButton union=root.findViewById(R.id.img_union);
        ImageButton pasis=root.findViewById(R.id.img_pasis);
        ImageButton mocoa=root.findViewById(R.id.img_mocoa);
        ImageButton tumaco=root.findViewById(R.id.img_tumaco);
        ImageButton pitalito=root.findViewById(R.id.img_pitalito);
        ImageButton popayan=root.findViewById(R.id.img_popayan);
        ImageButton neiva=root.findViewById(R.id.img_neiva);
        ImageButton cali=root.findViewById(R.id.img_cali);

        pasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Protegemos/@1.2122981,-77.27853,15z/data=!4m5!3m4!1s0x0:0xe44df2c9b4e32d62!8m2!3d1.2122981!4d-77.27853");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        ipiales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Centro+Comercial+Zafiro+Ipiales/@0.8243884,-77.6393592,17z/data=!3m1!4b1!4m5!3m4!1s0x8e296b1909590b0f:0x2d632a3b87ea823e!8m2!3d0.8243884!4d-77.6371705");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        union.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Ips+union+salud/@1.5997907,-77.1347148,17z/data=!4m8!1m2!2m1!1scll+1+%2311-65+IPS+uni%C3%B3n!3m4!1s0x8e2f1cf6bf009039:0xc09f3d9c8b264738!8m2!3d1.5997907!4d-77.1325261");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        pasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Cl.+10+%2329-28,+Puerto+As%C3%ADs,+Putumayo/@0.4947236,-76.4983122,17z/data=!3m1!4b1!4m5!3m4!1s0x8e2878ddd226831d:0x5e331d6e7702e8e2!8m2!3d0.4947236!4d-76.4961235");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        mocoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Protegemos/@1.2122981,-77.27853,15z/data=!4m5!3m4!1s0x0:0xe44df2c9b4e32d62!8m2!3d1.2122981!4d-77.27853");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        tumaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Protegemos/@1.2122981,-77.27853,15z/data=!4m5!3m4!1s0x0:0xe44df2c9b4e32d62!8m2!3d1.2122981!4d-77.27853");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        pitalito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Protegemos/@1.2122981,-77.27853,15z/data=!4m5!3m4!1s0x0:0xe44df2c9b4e32d62!8m2!3d1.2122981!4d-77.27853");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        popayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/PROTEGEMOS+POPAY%C3%81N/@2.4539046,-76.600933,17z/data=!3m1!4b1!4m5!3m4!1s0x8e30037459ea66d5:0xa65538ec36b2fd24!8m2!3d2.4539046!4d-76.5987443");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        neiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/Protegemos+Plus/@2.9362606,-75.2909622,17z/data=!4m8!1m2!2m1!1sprotegemos+neiva!3m4!1s0x8e3b7461a0266877:0x78cf4b5f56e471a4!8m2!3d2.9346135!4d-75.2917812");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        cali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://www.google.com/maps/place/PROTEGEMOS+G.C.U+CALI/@3.4601026,-76.5308433,17z/data=!3m1!4b1!4m5!3m4!1s0x8e30a66bb3ea7edb:0x92b49b6ad2195185!8m2!3d3.4601026!4d-76.5286546");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        return root;
    }
}