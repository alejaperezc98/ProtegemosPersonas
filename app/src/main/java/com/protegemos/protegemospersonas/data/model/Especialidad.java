package com.protegemos.protegemospersonas.data.model;

public class Especialidad {

    private String espe_codi;
    private String espe_nomb;

    public Especialidad() {

    }

    public Especialidad(String espe_codi, String espe_nomb) {
        this.espe_codi = espe_codi;
        this.espe_nomb = espe_nomb;
    }

    public String getEspe_codi() {
        return espe_codi;
    }

    public void setEspe_codi(String espe_codi) {
        this.espe_codi = espe_codi;
    }

    public String getEspe_nomb() {
        return espe_nomb;
    }

    public void setEspe_nomb(String espe_nomb) {
        this.espe_nomb = espe_nomb;
    }
}
