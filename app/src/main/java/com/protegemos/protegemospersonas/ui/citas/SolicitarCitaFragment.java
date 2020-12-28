package com.protegemos.protegemospersonas.ui.citas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.ServiceProtegemos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

import static androidx.navigation.Navigation.findNavController;

public class SolicitarCitaFragment extends Fragment {

    private SolicitarCitaViewModel solicitarCitaViewModel;

    ArrayList<String> especialidadList = new ArrayList<>();
    ArrayList<String> medicoList = new ArrayList<>();

    /**/
    private Spinner  spn_medi;
    private EditText nombre, telefono;
    Button btn_enviar;

    ServiceProtegemos util = new ServiceProtegemos();
    View root;
    

    @BindView(R.id.spin_especialidad)
    Spinner spn_esp;

    /*@BindView(R.id.btn_enviar)
    Button enviar;*/

    /*@OnClick
    public void btn(Button enviar){
        sendMail();
    }*/


    @OnItemSelected(R.id.spin_especialidad)
    public void onSpinnerItemSelected(int index){
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String res = util.recibirObjeto("?espe_codi="+spn_esp.getSelectedItem().toString(), "http://181.62.161.60/kubica/app/medico.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        medicoList = util.objMedicos(res);

                        if (medicoList.size() > 0) {
                            spn_medi.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, medicoList));
                        }
                    }
                });
            }
        };
        tr.start();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        solicitarCitaViewModel = new ViewModelProvider(this).get(SolicitarCitaViewModel.class);
        root = inflater.inflate(R.layout.fragment_solicitarcita, container, false);
        ButterKnife.bind(this,root);

        nombre = (EditText) root.findViewById(R.id.editTxt_name);
        telefono = (EditText) root.findViewById(R.id.editTxt_phone);
        spn_medi = (Spinner) root.findViewById(R.id.spin_medico);
        btn_enviar = (Button) root.findViewById(R.id.btn_enviar);


        Thread tr = new Thread() {
            @Override
            public void run() {
                final String res = util.recibirObjeto("", "http://181.62.161.60/kubica/app/especialidad.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        especialidadList = util.objEspecialidades(res);
                        if (especialidadList.size() > 0) {
                            spn_esp.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, especialidadList));
                        } else {
                            Snackbar.make(root, "No se encontraron datos en la BD", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                });
            }
        };
        tr.start();

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Enviando Mensaje...", Toast.LENGTH_LONG).show();
                Thread tr = new Thread() {
                    @Override
                    public void run() {
                        final String res = util.recibirObjeto("?nombre" +
                                "="+nombre.getText().toString().trim()+"&telefono="+telefono.getText().toString().trim()+"&especialista="+spn_esp.getSelectedItem().toString()+"&medico="+spn_medi.getSelectedItem().toString(), "http://181.62.161.60/kubica/validacita.php");
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int i = util.objCitas(res);
                                if (i == 1) {
                                    getActivity().onBackPressed();

                                } else {
                                    Toast.makeText(getContext(),"Mensaje enviado", Toast.LENGTH_LONG).show();
                                    /*Snackbar.make(root, "Mensaje Enviado", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();*/
                                }
                            }
                        });
                    }
                };
                tr.start();
            }
        });

        return root;
    }

    private void sendMail() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String res = util.recibirObjeto("?nombre="+nombre.getText().toString().trim()+"&telefono="+telefono.getText().toString().trim()+"&especialista="+spn_esp.getSelectedItem().toString()+"&medico="+spn_medi.getSelectedItem().toString(), "http://181.62.161.60/kubica/validacita.php");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = util.objCitas(res);
                        if (i == 1) {
                            getActivity().onBackPressed();
                        } else {

                        }
                    }
                });
            }
        };
        tr.start();
    }
}

