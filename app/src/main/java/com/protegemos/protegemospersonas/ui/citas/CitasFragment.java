
package com.protegemos.protegemospersonas.ui.citas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.protegemos.protegemospersonas.data.model.Cita;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CitasFragment extends Fragment {

    private CitasViewModel citasViewModel;

    List<Cita> citaArrayList = new ArrayList<>();
    ListView listado;
    ServiceProtegemos util = new ServiceProtegemos();
    View root;

    @BindView(R.id.txt_citaNomb) TextView txt_citaNomb;
    @BindView(R.id.txt_citaApe) TextView txt_citaApe;
    @BindView(R.id.txt_citaFec) TextView txt_citaFec;
    @BindView(R.id.txt_citaHora) TextView txt_citaHora;
    @BindView(R.id.txt_citaMed) TextView txt_citaMed;
    @BindView(R.id.txt_citaEsp) TextView txt_citaEsp;
    @BindView(R.id.txt_citaTel) TextView txt_citaTel;
    @BindView(R.id.txt_citaObs) TextView txt_citaObs;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        citasViewModel = new ViewModelProvider(this).get(CitasViewModel.class);
        root = inflater.inflate(R.layout.fragment_citas, container, false);
        final TextView textView = root.findViewById(R.id.txt_cita);

        ButterKnife.bind(this, root);
        requestDatos("200247");
        return root;
    }

    public void requestDatos(String contrato) {
        Thread tr = new Thread(){

            @Override
            public void run() {
                final String res = util.recibirObjeto("?con_cod=" + contrato + "&prefijo=D", "http://181.62.161.60/kubica/app/citas.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        citaArrayList = util.objCita(res);
                        if (citaArrayList.size() > 0) {

                            CitasAdapter adapter = new CitasAdapter(getActivity(), citaArrayList);
                            listado.setAdapter(adapter);

                            adapter.notifyDataSetChanged();
                        } else {
                            Snackbar.make(root, "No se encontraron citas", Snackbar.LENGTH_LONG)
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
