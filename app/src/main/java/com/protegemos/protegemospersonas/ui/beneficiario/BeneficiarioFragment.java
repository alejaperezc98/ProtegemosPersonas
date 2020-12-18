package com.protegemos.protegemospersonas.ui.beneficiario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.protegemos.protegemospersonas.MainActivity;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.ServiceProtegemos;
import com.protegemos.protegemospersonas.data.model.Beneficiario;
import com.protegemos.protegemospersonas.ui.login.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BeneficiarioFragment extends Fragment {

    private BeneficiarioViewModel beneficiarioViewModel;
    List<Beneficiario> beneficiariosArrayList = new ArrayList<>();
    ListView listado;
    ServiceProtegemos util = new ServiceProtegemos();
    View root;

    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        beneficiarioViewModel =
                new ViewModelProvider(this).get(BeneficiarioViewModel.class);
        root = inflater.inflate(R.layout.fragment_beneficiario, container, false);

        SharedPreferences prefs = getActivity().getSharedPreferences("Preferences", 0);
        String contrato = prefs.getString("contrato", "");

        listado = (ListView) root.findViewById(R.id.lista_beneficiarios);
        requestDatos(contrato);
        return root;
    }

    public void requestDatos(String contrato) {
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String res = util.recibirObjeto("?con_cod=" + contrato + "&prefijo=D", "http://181.62.161.60/kubica/app/beneficiarios.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        beneficiariosArrayList = util.objBeneficiarios(res);
                        if (beneficiariosArrayList.size() > 0) {
                            BeneficiarioAdapter adapter = new BeneficiarioAdapter(getActivity(), beneficiariosArrayList);
                            listado.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        } else {
                            Snackbar.make(root, "No se encontraron beneficiaros en la BD", Snackbar.LENGTH_LONG)
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






