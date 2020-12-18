package com.protegemos.protegemospersonas.data.model;

import java.time.LocalDate;

public class Cita {
    private String citaNomb;
    private String citaApel;
    private String citaTele;
    private String citaFeci;
    private String citaHora;
    private String citaObse;
    private String mediNomb;
    private String espeNomb;

    public Cita() {
    }

    public Cita(String citaNom, String citaApel, String citaTele, String citaFeci, String citaHora, String citaObse, String mediNomb, String espeNomb) {

        this.citaNomb= citaNom;
        this.citaApel=citaApel;
        this.citaTele=citaTele;
        this.citaFeci=citaFeci;
        this.citaHora=citaHora;
        this.citaObse=citaObse;
        this.mediNomb=mediNomb;
        this.espeNomb=espeNomb;

    }

    public String getCitaNomb() {
        return citaNomb;
    }

    public void setCitaNomb(String citaNomb) {
        this.citaNomb = citaNomb;
    }

    public String getCitaApel() {
        return citaApel;
    }

    public void setCitaApel(String citaApel) {
        this.citaApel = citaApel;
    }

    public String getCitaTele() {
        return citaTele;
    }

    public void setCitaTele(String citaTele) {
        this.citaTele = citaTele;
    }

    public String getCitaFeci() {
        return citaFeci;
    }

    public void setCitaFeci(String citaFeci) {
        this.citaFeci = citaFeci;
    }

    public String getCitaHora() {
        return citaHora;
    }

    public void setCitaHora(String citaHora) {
        this.citaHora = citaHora;
    }

    public String getCitaObse() {
        return citaObse;
    }

    public void setCitaObse(String citaObse) {
        this.citaObse = citaObse;
    }

    public String getMediNomb() {
        return mediNomb;
    }

    public void setMediNomb(String mediNomb) {
        this.mediNomb = mediNomb;
    }

    public String getEspeNomb() {
        return espeNomb;
    }

    public void setEspeNomb(String espeNomb) {
        this.espeNomb = espeNomb;
    }
}
