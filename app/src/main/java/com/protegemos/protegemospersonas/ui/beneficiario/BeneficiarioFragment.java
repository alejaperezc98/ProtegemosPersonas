package com.protegemos.protegemospersonas.ui.beneficiario;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Beneficiario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BeneficiarioFragment extends Fragment {

    private BeneficiarioViewModel beneficiarioViewModel;
    ArrayList <Beneficiario> beneficiariosArrayList = new ArrayList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beneficiarioViewModel =
                new ViewModelProvider(this).get(BeneficiarioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        beneficiarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void requestDatos(){

        String contrato=null;

        RequestQueue cola = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://181.62.161.60/kubica/app/beneficiarios.php?con_cod=" + contrato + "&prefijo=D", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //dato.setText(response.toString());
                        parserJson(response);
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Error en la conexion", Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                // headers.put("Content-Type", "application/json");
                return headers;
            }
        };
        cola.add(jsonObjectRequest);
    }
    public void parserJson(JSONObject response){
        try {

            JSONArray nowPlaying = response.getJSONArray("results");
            for (int i = 0 ; i<nowPlaying.length(); i++) {
                JSONObject ben = nowPlaying.getJSONObject(i);
                String nombre = ben.getString("ben_nom");
                String apellido = ben.getString("ben_ape");
                String edad = ben.getString("ben_edad");
                String parentesco = ben.getString("ben_par");


                // String id = pel.getString("id");


                Beneficiario pe = new Beneficiario(nombre,apellido,edad,parentesco);
                this.beneficiariosArrayList.add(pe);
            }
        } catch (JSONException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}