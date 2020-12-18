package com.protegemos.protegemospersonas.ui.guia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Guia;

import java.util.List;

public class GuiaAdapter  extends BaseAdapter {

    private Activity actividad;
    private List<Guia> list;

    public GuiaAdapter(Activity context, List<Guia> guias) {
        actividad=context;
        list=guias;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.datos_guia, null);
        }

        Guia movimiento = list.get(position);
        /*Asignar los text view al controlador de la vista*/
        TextView lbl_convenioNombre=(TextView)v.findViewById(R.id.lbl_convenioNombre);
        TextView lbl_especialidad=(TextView)v.findViewById(R.id.lbl_especialidad);
        TextView lbl_direccion=(TextView)v.findViewById(R.id.lbl_direccion);

        /*Ingreso de datos a los text view de la vista usando el modelo*/
        lbl_convenioNombre.setText(movimiento.getMediNomb());
        lbl_especialidad.setText(movimiento.getEspeNomb());
        lbl_direccion.setText(movimiento.getMediDire());

        return v;
    }
}
