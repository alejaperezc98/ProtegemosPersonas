package com.protegemos.protegemospersonas.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.ServiceProtegemos;

import org.json.JSONObject;

public class GalleryFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    private GalleryViewModel galleryViewModel;
    ServiceProtegemos util = new ServiceProtegemos();
    int bandera=0;

    TextView lbl_nomb, lbl_apeb, lbl_edadb, lbl_parb;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.datos_beneficiarios, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        lbl_nomb=(TextView) root.findViewById(R.id.lbl_nomb);
        lbl_apeb=(TextView) root.findViewById(R.id.lbl_apeb);
        lbl_edadb=(TextView) root.findViewById(R.id.lbl_edadb);
        lbl_parb=(TextView) root.findViewById(R.id.lbl_parb);

        request= Volley.newRequestQueue(getContext());

        /*galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void service(){
        String url="http://181.62.161.60/kubica/app/beneficiarios.php?con_cod=";
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}