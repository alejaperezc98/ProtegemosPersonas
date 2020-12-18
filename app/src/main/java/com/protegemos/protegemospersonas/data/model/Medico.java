package com.protegemos.protegemospersonas.data.model;

public class Medico {

    private String medi_codi;
    private String medi_nomb;
    private String espe_codi;

    public  Medico(){
    }

    public Medico(String medi_codi, String medi_nomb, String espe_codi) {
        this.medi_codi = medi_codi;
        this.medi_nomb = medi_nomb;
        this.espe_codi = espe_codi;
    }

    public String getMedi_codi() {
        return medi_codi;
    }

    public void setMedi_codi(String medi_codi) {
        this.medi_codi = medi_codi;
    }

    public String getMedi_nomb() {
        return medi_nomb;
    }

    public void setMedi_nomb(String medi_nomb) {
        this.medi_nomb = medi_nomb;
    }

    public String getEspe_codi() {
        return espe_codi;
    }

    public void setEspe_codi(String espe_codi) {
        this.espe_codi = espe_codi;
    }
}
