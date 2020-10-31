package com.protegemos.protegemospersonas.ui.beneficiario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Beneficiario;

import java.util.List;

public class BeneficiarioAdapter extends ArrayAdapter<Beneficiario> {

    TextView lbl_nomb, lbl_apeb, lbl_edadb, lbl_parb;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Beneficiario beneficiario=getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.datos_beneficiarios, parent, false);
        }

        /*Asignar los text view al controlador de la vista*/
        lbl_nomb=(TextView)convertView.findViewById(R.id.lbl_nomb);
        lbl_apeb=(TextView)convertView.findViewById(R.id.lbl_apeb);
        lbl_edadb=(TextView)convertView.findViewById(R.id.lbl_edadb);
        lbl_parb=(TextView)convertView.findViewById(R.id.lbl_parb);

        /*Ingreso de datos a los text view de la vista usando el modelo*/
        lbl_nomb.setText(beneficiario.getBenNom());
        lbl_apeb.setText(beneficiario.getBenApe());
        lbl_edadb.setText(beneficiario.getBenEdad());
        lbl_parb.setText(beneficiario.getBenPar());

        return convertView;
    }

    public BeneficiarioAdapter(@NonNull Context context, @NonNull List<Beneficiario> beneficiarios) {
        super(context, 0, beneficiarios);
    }


}
