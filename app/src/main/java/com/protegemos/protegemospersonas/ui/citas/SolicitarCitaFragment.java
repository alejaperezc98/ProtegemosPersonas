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
import butterknife.OnItemSelected;

public class SolicitarCitaFragment extends Fragment {

    private SolicitarCitaViewModel solicitarCitaViewModel;

    List<String> especialidadList = new ArrayList<>();
    List<String> medicoList = new ArrayList<>();

    /**/
    private Spinner  spn_medi;
    private EditText nombre, telefono;
    private Button enviar;

    ServiceProtegemos util = new ServiceProtegemos();
    View root;

    @BindView(R.id.spin_especialidad)
    Spinner spn_esp;

    @OnItemSelected(R.id.spin_especialidad)
    public void onSpinnerItemSelected(int index){ spn_esp.getSelectedItem().toString();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        solicitarCitaViewModel = new ViewModelProvider(this).get(SolicitarCitaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_solicitarcita, container, false);
        ButterKnife.bind(this,root);

        nombre = (EditText) root.findViewById(R.id.editTxt_name);
        telefono = (EditText) root.findViewById(R.id.editTxt_phone);
        spn_medi = (Spinner) root.findViewById(R.id.spin_medico);
        enviar = (Button) root.findViewById(R.id.btn_enviar);



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

        spn_esp.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn, android.view.View v, int posicion, long id) {
                        //onSpinnerItemSelected(posicion);
                        spn.getItemIdAtPosition(posicion);
                        Toast.makeText(getContext(),posicion, Toast.LENGTH_LONG).show();
                        Thread tr = new Thread() {
                            @Override
                            public void run() {
                                final String res = util.recibirObjeto("medico.php?"+posicion, "http://181.62.161.60/kubica/app/medico.php");
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

                    }
                    public void onNothingSelected(AdapterView<?> spn) {
                    }
                });


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        return root;
    }


    private void sendMail() {
        /*String nomb=nombre.getText().toString();
        String tel= telefono.getText().toString();

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"alejaperez98@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Solicitar cita");
        intent.putExtra(Intent.EXTRA_TEXT,"Nombre: "+nomb+"\n Telefono: "+tel);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Cliente email"));*/
    }


}

