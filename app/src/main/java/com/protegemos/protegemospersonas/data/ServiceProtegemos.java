package com.protegemos.protegemospersonas.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Henry Jaramillo on 07/09/2017.
 */

public class ServiceProtegemos {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
}
