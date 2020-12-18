package com.protegemos.protegemospersonas.ui.perfil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.protegemos.protegemospersonas.R;
import com.protegemos.protegemospersonas.data.model.Beneficiario;
import com.protegemos.protegemospersonas.data.model.Perfil;

import java.util.List;

public class PerfilAdapter extends BaseAdapter {

    private Activity actividad;
    private List<Perfil> list;

    public PerfilAdapter(Activity context, List<Perfil> perfiles) {
        actividad=context;
        list=perfiles;
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.datos_perfil, null);
        }
        Perfil movimiento = list.get(position);
        /*Asignar los text view al controlador de la vista*/
        TextView lbl_pNom=(TextView)v.findViewById(R.id.lbl_pNom);
        TextView lbl_pApe=(TextView)v.findViewById(R.id.lbl_pApe);
        TextView lbl_pTel=(TextView)v.findViewById(R.id.lbl_pTel);
        TextView lbl_pCel=(TextView)v.findViewById(R.id.lbl_pCel);
        TextView lbl_pCiudad=(TextView)v.findViewById(R.id.lbl_pCiudad);
        TextView lbl_pBar=(TextView)v.findViewById(R.id.lbl_pBar);
        TextView lbl_pDir=(TextView)v.findViewById(R.id.lbl_pDir);
        TextView lbl_mail=(TextView)v.findViewById(R.id.lbl_mail);
        TextView lbl_pRef=(TextView)v.findViewById(R.id.lbl_pRef);
        TextView lbl_pRtel=(TextView)v.findViewById(R.id.lbl_pRtel);
        TextView lbl_pPlan=(TextView)v.findViewById(R.id.lbl_pPlan);
        TextView lbl_pFecv=(TextView)v.findViewById(R.id.lbl_pFecv);
        TextView lbl_pEmp=(TextView)v.findViewById(R.id.lbl_pEmp);


        /*Ingreso de datos a los text view de la vista usando el modelo*/
        lbl_pNom.setText(movimiento.getPerNom());
        lbl_pApe.setText(movimiento.getPerApe());
        lbl_pTel.setText(movimiento.getPerTel());
        lbl_pCel.setText(movimiento.getPerCel());
        lbl_pCiudad.setText(movimiento.getPerCiu());
        lbl_pBar.setText(movimiento.getPerBar());
        lbl_pDir.setText(movimiento.getPerDir());
        lbl_mail.setText(movimiento.getPerMail());
        lbl_pRef.setText(movimiento.getPerRef());
        lbl_pRtel.setText(movimiento.getPerRtel());
        lbl_pPlan.setText(movimiento.getNomplan());
        lbl_pFecv.setText(movimiento.getFvenc());
        lbl_pEmp.setText(movimiento.getPerEmp());

        return v;
    }

}
