package com.protegemos.protegemospersonas.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import com.protegemos.protegemospersonas.data.model.Beneficiario;
import com.protegemos.protegemospersonas.data.model.Cita;
import com.protegemos.protegemospersonas.data.model.Especialidad;
import com.protegemos.protegemospersonas.data.model.Guia;
import com.protegemos.protegemospersonas.data.model.Medico;
import com.protegemos.protegemospersonas.data.model.Perfil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Henry Jaramillo on 07/09/2017.
 */

public class ServiceProtegemos {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    ArrayList<String> especialidades;
    ArrayList<String> medicos;

    public String recibirObjeto(String parametros, String urlin) {
        HttpURLConnection connection = null;
        String respuesta = "";
        try {
            URL url = new URL(urlin + parametros);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(parametros.getBytes().length));

            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(parametros);
            wr.close();

            Scanner inStream = new Scanner(connection.getInputStream());
            while (inStream.hasNextLine()) {
                respuesta += (inStream.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta.toString();
    }

    //servicio necesario para login
    public int objJSON(String respuesta, Activity act){
        int res = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    String usu = object.getString("usu_log");
                    String pas = object.getString("usu_cc");

                    SharedPreferences prefs = act.getSharedPreferences("configuracion", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("user", usu);
                    editor.putString("cc", pas);
                    editor.commit();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Beneficiario> objBeneficiarios(String respuesta){
        int res = 0;
        List<Beneficiario> beneficiarios= new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    Beneficiario beneficiario = new Beneficiario();
                    beneficiario.setBenNom(object.getString("ben_nom"));
                    beneficiario.setBenApe(object.getString("ben_ape"));
                    beneficiario.setBenCc(object.getString("ben_cc"));
                    beneficiario.setBenEdad(object.getString("ben_edad"));
                    beneficiario.setBenPar(object.getString("ben_par"));
                    beneficiarios.add(beneficiario);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beneficiarios;
    }

    public ArrayList<String> objEspecialidades(String respuesta){
        int res = 0;
        ArrayList<String> especialidads= new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    String especialidad = object.getString("espe_nomb");
                    especialidads.add(especialidad);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return especialidads;
    }

    public List<Guia> objGuia(String respuesta){
        int res = 0;
        List<Guia> guias= new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    Guia guia = new Guia();
                    guia.setMediNomb(object.getString("medi_nomb"));
                    guia.setEspeNomb(object.getString("espe_nomb"));
                    guia.setMediDire(object.getString("medi_dire"));
                    guias.add(guia);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return guias;
    }

    public Perfil objPerfil(String respuesta){
        int res = 0;
        Perfil perfil= new Perfil();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    perfil.setPerNom(object.getString("per_nom"));
                    perfil.setPerApe(object.getString("per_ape"));
                    perfil.setPerTel(object.getString("per_tel"));
                    perfil.setPerCel(object.getString("per_cel"));
                    perfil.setPerCiu(object.getString("per_ciu"));
                    perfil.setPerBar(object.getString("per_bar"));
                    perfil.setPerMail(object.getString("per_mail"));
                    perfil.setPerEmp(object.getString("per_emp"));
                    perfil.setPerDir(object.getString("per_dir"));
                    perfil.setPerRef(object.getString("per_ref"));
                    perfil.setPerRtel(object.getString("per_rtel"));
                    perfil.setFvenc(object.getString("per_fvenc"));
                    perfil.setNomplan(object.getString("nom_plan"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return perfil;
    }

    public List<Cita> objCita(String respuesta){
        int res = 0;
        List<Cita> citas= new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    Cita cita = new Cita();
                    cita.setCitaNomb(object.getString("cita_nom"));
                    cita.setCitaApel(object.getString("cita_ape"));
                    cita.setCitaFeci(object.getString("cita_fecha"));
                    cita.setCitaHora(object.getString("cita_hora"));
                    cita.setMediNomb(object.getString("med_nomb"));
                    cita.setEspeNomb(object.getString("esp_nom"));
                    cita.setCitaTele(object.getString("cita_tel"));
                    cita.setCitaObse(object.getString("cita_obs"));
                    citas.add(cita);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return citas;
    }

    public List<Especialidad> objEsp(String respuesta){
        int res = 0;
        ArrayList<Especialidad> especialidads=new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    Especialidad especialidad = new Especialidad();
                    especialidad.setEspe_codi(object.getString("espe_codi"));
                    especialidad.setEspe_nomb(object.getString("espe_nomb"));
                    especialidads.add(especialidad);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return especialidads;
    }

    public ArrayList<String> objMedicos(String respuesta){
        int res = 0;
        ArrayList<String> medicos= new ArrayList<>();
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    String medico = object.getString("medi_nomb");
                    medicos.add(medico);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    public int objCitas(String respuesta){
        int res = 0;
        try {
            JSONArray json = new JSONArray(respuesta);
            if (json.length() > 0) {
                res = 1;
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

}
