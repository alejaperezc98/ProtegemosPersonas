package com.protegemos.protegemospersonas.ui.citas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Cita;

import java.util.List;

public class CitasAdapter extends BaseAdapter {

    private Activity actividad;
    private List<Cita> list;

    public CitasAdapter(Activity context, List<Cita> citas) {
        actividad=context;
        list=citas;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.datos_citas, null);
        }
        Cita movimiento = list.get(position);
        /*Asignar los text view al controlador de la vista*/
        TextView txt_citaNomb=(TextView)v.findViewById(R.id.txt_citaNomb);
        TextView txt_citaApe=(TextView)v.findViewById(R.id.txt_citaApe);
        TextView txt_citaFec=(TextView)v.findViewById(R.id.txt_citaFec);
        TextView txt_citaHora=(TextView)v.findViewById(R.id.txt_citaHora);
        TextView txt_citaMed=(TextView)v.findViewById(R.id.txt_citaMed);
        TextView txt_citaEsp=(TextView)v.findViewById(R.id.txt_citaEsp);
        TextView txt_citaTel=(TextView)v.findViewById(R.id.txt_citaTel);
        TextView txt_citaObs=(TextView)v.findViewById(R.id.txt_citaObs);

        /*Ingreso de datos a los text view de la vista usando el modelo*/
        txt_citaNomb.setText(movimiento.getCitaNomb());
        txt_citaApe.setText(movimiento.getCitaApel());
        txt_citaFec.setText(movimiento.getCitaFeci());
        txt_citaHora.setText(movimiento.getCitaHora());
        txt_citaMed.setText(movimiento.getMediNomb());
        txt_citaEsp.setText(movimiento.getEspeNomb());
        txt_citaTel.setText(movimiento.getCitaTele());
        txt_citaObs.setText(movimiento.getCitaObse());
        return v;
    }
}
