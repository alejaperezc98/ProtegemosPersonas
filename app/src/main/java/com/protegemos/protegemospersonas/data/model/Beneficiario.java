package com.protegemos.protegemospersonas.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Beneficiario {
    private String prefijo;
    private String conCod;
    private String benNum;
    private String benCc;
    private String benApe;
    private String benNom;
    private String benEdad;
    private String benPar;
    private String estado;
    private String benMuerte;
    private String fecnac;

    public Beneficiario() {
    }

    public Beneficiario(String benNom, String benApe, String benEdad, String benPar) {

        this.benApe = benApe;
        this.benNom = benNom;
        this.benEdad = benEdad;
        this.benPar = benPar;

    }



    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getConCod() {
        return conCod;
    }

    public void setConCod(String conCod) {
        this.conCod = conCod;
    }

    public String getBenNum() {
        return benNum;
    }

    public void setBenNum(String benNum) {
        this.benNum = benNum;
    }

    public String getBenCc() {
        return benCc;
    }

    public void setBenCc(String benCc) {
        this.benCc = benCc;
    }

    public String getBenApe() {
        return benApe;
    }

    public void setBenApe(String benApe) {
        this.benApe = benApe;
    }

    public String getBenNom() {
        return benNom;
    }

    public void setBenNom(String benNom) {
        this.benNom = benNom;
    }

    public String getBenEdad() {
        return benEdad;
    }

    public void setBenEdad(String benEdad) {
        this.benEdad = benEdad;
    }

    public String getBenPar() {
        return benPar;
    }

    public void setBenPar(String benPar) {
        this.benPar = benPar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBenMuerte() {
        return benMuerte;
    }

    public void setBenMuerte(String benMuerte) {
        this.benMuerte = benMuerte;
    }

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

}
