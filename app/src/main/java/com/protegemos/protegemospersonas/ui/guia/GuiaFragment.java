package com.protegemos.protegemospersonas.ui.guia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.ServiceProtegemos;
import com.protegemos.protegemospersonas.data.model.Guia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GuiaFragment extends Fragment {
    private GuiaViewModel guiaViewModel;

    List<Guia> guiaArrayList = new ArrayList<>();
    ListView listado;
    ServiceProtegemos util = new ServiceProtegemos();
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        guiaViewModel = new ViewModelProvider(this).get(GuiaViewModel.class);
        root = inflater.inflate(R.layout.fragment_guia, container, false);
        final TextView textView = root.findViewById(R.id.txt_guia);
        guiaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.datos_guia);
        Intent i = getActivity().getIntent();
        String numBeneficiario = i.getStringExtra("contrato");
        listado = (ListView) root.findViewById(R.id.lista_guia);
        requestDatos("46712");
        return root;
    }

    public void requestDatos(String contrato) {
        Thread tr = new Thread(){

            @Override
            public void run() {
                final String res = util.recibirObjeto("?con_cod=" + contrato + "&prefijo=D","http://181.62.161.60/kubica/app/guia.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        guiaArrayList = util.objGuia(res);
                        if (guiaArrayList.size() > 0) {

                            GuiaAdapter adapter = new GuiaAdapter(getActivity(), guiaArrayList);
                            listado.setAdapter(adapter);

                            adapter.notifyDataSetChanged();

                        } else {

                            Snackbar.make(root, "No se encontraron guias ", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                });
            }
        };
        tr.start();
    }

    public void parserJson(JSONObject response) {
        try {

            JSONArray nowPlaying = response.getJSONArray("results");

        } catch (JSONException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}
