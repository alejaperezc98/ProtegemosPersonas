package com.protegemos.protegemospersonas.ui.perfil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import com.protegemos.protegemospersonas.data.model.Beneficiario;
import com.protegemos.protegemospersonas.data.model.Perfil;
import com.protegemos.protegemospersonas.ui.beneficiario.BeneficiarioAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;
    Perfil perfil = new Perfil();
    ServiceProtegemos util = new ServiceProtegemos();
    Button btn_perfil;
    View root;

    @BindView(R.id.lbl_pNom) TextView lbl_pNom;
    @BindView(R.id.lbl_pApe) TextView lbl_pApe;
    @BindView(R.id.lbl_pTel) TextView lbl_pTel;
    @BindView(R.id.lbl_pCel) TextView lbl_pCel;
    @BindView(R.id.lbl_pCiudad) TextView lbl_pCiudad;
    @BindView(R.id.lbl_pBar) TextView lbl_pBar;
    @BindView(R.id.lbl_pDir) TextView lbl_pDir;
    @BindView(R.id.lbl_mail) TextView lbl_mail;
    @BindView(R.id.lbl_pRef) TextView lbl_pRef;
    @BindView(R.id.lbl_pRtel) TextView lbl_pRtel;
    @BindView(R.id.lbl_pPlan) TextView lbl_pPlan;
    @BindView(R.id.lbl_pFecv) TextView lbl_pFecv;
    @BindView(R.id.lbl_pEmp) TextView lbl_pEmp;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);
        root = inflater.inflate(R.layout.fragment_perfil, container, false);

        btn_perfil = (Button) root.findViewById(R.id.btn_datos);

        ButterKnife.bind(this, root);

        SharedPreferences prefs = getActivity().getSharedPreferences("Preferences", 0);
        String contrato = prefs.getString("contrato", "");
        requestDatos(contrato);

        return root;
    }

    public void requestDatos(String contrato) {
        Thread tr = new Thread(){

            @Override
            public void run() {
                final String res = util.recibirObjeto("?con_cod=" + contrato + "&prefijo=D", "http://181.62.161.60/kubica/app/perfil.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        perfil = util.objPerfil(res);
                        if (perfil!=null) {
                            lbl_pNom.setText(perfil.getPerNom());
                            lbl_pApe.setText(perfil.getPerApe());
                            lbl_pTel.setText(perfil.getPerTel());
                            lbl_pCel.setText(perfil.getPerCel());
                            lbl_pCiudad.setText(perfil.getPerCiu());
                            lbl_pBar.setText(perfil.getPerBar());
                            lbl_pDir.setText(perfil.getPerDir());
                            lbl_mail.setText(perfil.getPerMail());
                            lbl_pRef.setText(perfil.getPerRef());
                            lbl_pRtel.setText(perfil.getPerRtel());
                            lbl_pPlan.setText(perfil.getNomplan());
                            lbl_pFecv.setText(perfil.getFvenc());
                            lbl_pEmp.setText(perfil.getPerEmp());
                        } else {
                            Snackbar.make(root, "No se encontraron datos", Snackbar.LENGTH_LONG)
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
