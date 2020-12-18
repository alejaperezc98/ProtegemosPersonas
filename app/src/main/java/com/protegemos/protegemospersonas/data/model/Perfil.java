package com.protegemos.protegemospersonas.data.model;

import java.time.LocalDate;

public class Perfil {

    private String perNom;
    private String perApe;
    private String perTel;
    private String perCel;
    private String perCiu;
    private String perBar;
    private String perDir;
    private String perMail;
    private String perRef;
    private String perRtel;
    private String nomplan;
    private String fvenc;
    private String perEmp;

    public Perfil() {
    }

    public Perfil(String perNom, String perApe, String perTel, String perCel, String perCiu, String perBar, String perDir, String perMail, String perRef, String perRtel, String nomplan, String fvenc, String perEmp) {

        this.perNom=perNom;
        this.perApe=perApe;
        this.perTel=perTel;
        this.perCel=perCel;
        this.perCiu=perCiu;
        this.perBar=perBar;
        this.perDir=perDir;
        this.perMail=perMail;
        this.perRef=perRef;
        this.perRtel=perRtel;
        this.nomplan=nomplan;
        this.fvenc=fvenc;
        this.perEmp=perEmp;
    }

    public String getPerNom() {
        return perNom;
    }

    public void setPerNom(String perNom) {
        this.perNom = perNom;
    }

    public String getPerApe() {
        return perApe;
    }

    public void setPerApe(String perApe) {
        this.perApe = perApe;
    }

    public String getPerMail() {
        return perMail;
    }

    public void setPerMail(String perMail) {
        this.perMail = perMail;
    }

    public String getPerDir() {
        return perDir;
    }

    public void setPerDir(String perDir) {
        this.perDir = perDir;
    }

    public String getPerTel() {
        return perTel;
    }

    public void setPerTel(String perTel) {
        this.perTel = perTel;
    }

    public String getPerCel() {
        return perCel;
    }

    public void setPerCel(String perCel) {
        this.perCel = perCel;
    }

    public String getPerCiu() {
        return perCiu;
    }

    public void setPerCiu(String perCiu) {
        this.perCiu = perCiu;
    }

    public String getPerBar() {
        return perBar;
    }

    public void setPerBar(String perBar) {
        this.perBar = perBar;
    }

    public String getPerEmp() {
        return perEmp;
    }

    public void setPerEmp(String perEmp) {
        this.perEmp = perEmp;
    }

    public String getPerRef() {
        return perRef;
    }

    public void setPerRef(String perRef) {
        this.perRef = perRef;
    }

    public String getPerRtel() {
        return perRtel;
    }

    public void setPerRtel(String perRtel) {
        this.perRtel = perRtel;
    }

    public String getFvenc() {
        return fvenc;
    }

    public void setFvenc(String fvenc) {
        this.fvenc = fvenc;
    }

    public String getNomplan() {
        return nomplan;
    }

    public void setNomplan(String nomplan) {
        this.nomplan = nomplan;
    }
}
