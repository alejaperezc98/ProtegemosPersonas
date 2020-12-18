package com.protegemos.protegemospersonas.data.model;

public class Guia {

    private String mediNomb;
    private String mediDire;
    private String espeNomb;

    public Guia(){

    }

    public Guia(String mediNomb, String mediDire, String espeNomb){
        this.mediNomb=mediNomb;
        this.espeNomb=espeNomb;
        this.mediDire=mediDire;
    }


    public String getMediNomb() {
        return mediNomb;
    }

    public void setMediNomb(String mediNomb) {
        this.mediNomb = mediNomb;
    }

    public String getMediDire() {
        return mediDire;
    }

    public void setMediDire(String mediDire) {
        this.mediDire = mediDire;
    }

    public String getEspeNomb() {
        return espeNomb;
    }

    public void setEspeNomb(String espeNomb) {
        this.espeNomb = espeNomb;
    }
}
