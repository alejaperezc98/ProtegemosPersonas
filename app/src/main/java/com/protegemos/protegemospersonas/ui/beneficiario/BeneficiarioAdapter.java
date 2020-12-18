package com.protegemos.protegemospersonas.ui.beneficiario;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Beneficiario;

import java.util.List;

public class BeneficiarioAdapter extends BaseAdapter {

    private Activity actividad;
    private List<Beneficiario> list;

    public BeneficiarioAdapter(Activity context, List<Beneficiario> beneficiarios) {
        actividad=context;
        list=beneficiarios;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.datos_beneficiarios, null);
        }
        Beneficiario movimiento = list.get(position);
        /*Asignar los text view al controlador de la vista*/
        TextView lbl_nomb=(TextView)v.findViewById(R.id.lbl_nomb);
        TextView lbl_apeb=(TextView)v.findViewById(R.id.lbl_apeb);
        TextView lbl_edadb=(TextView)v.findViewById(R.id.lbl_edadb);
        TextView lbl_parb=(TextView)v.findViewById(R.id.lbl_parb);

        /*Ingreso de datos a los text view de la vista usando el modelo*/
        lbl_nomb.setText(movimiento.getBenNom());
        lbl_apeb.setText(movimiento.getBenApe());
        lbl_edadb.setText(movimiento.getBenEdad());
        lbl_parb.setText(movimiento.getBenPar());

        return v;
    }
}
