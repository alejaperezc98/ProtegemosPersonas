package com.protegemos.protegemospersonas.ui.revista;

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
import com.protegemos.protegemospersonas.ui.slideshow.SlideshowViewModel;

import butterknife.BindView;

import static androidx.navigation.Navigation.findNavController;

public class RevistaFragment extends Fragment {

    private RevistaViewModel revistaViewModel;

    @BindView(R.id.img_rev1)
    ImageButton rev1;

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

        ImageButton rev1 = root.findViewById(R.id.img_rev1);
        ImageButton rev2 = root.findViewById(R.id.img_rev2);
        ImageButton rev3 = root.findViewById(R.id.img_rev3);
        ImageButton rev4 = root.findViewById(R.id.img_rev4);
        ImageButton rev5 = root.findViewById(R.id.img_rev5);
        ImageButton rev6 = root.findViewById(R.id.img_rev6);
        ImageButton rev7 = root.findViewById(R.id.img_rev7);
        ImageButton rev8 = root.findViewById(R.id.img_rev8);
        ImageButton rev9 = root.findViewById(R.id.img_rev9);
        ImageButton rev10 = root.findViewById(R.id.img_rev10);
        ImageButton rev11 = root.findViewById(R.id.img_rev11);
        ImageButton rev12 = root.findViewById(R.id.img_rev12);
        ImageButton rev13 = root.findViewById(R.id.img_rev13);
        ImageButton rev14 = root.findViewById(R.id.img_rev14);
        ImageButton rev15 = root.findViewById(R.id.img_rev15);
        ImageButton rev16 = root.findViewById(R.id.img_rev16);


        rev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        rev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        rev16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://revistaprotegemos.com.co/revistas.html");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        return root;
    }
}
