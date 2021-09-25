package com.gestionnaire.notes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Classe implements Serializable {

    @Id
    private int idClasse;
    private String nomClasse;
    private String periode;

    public Classe() {
    }

    public Classe(int idClasse, String nomClasse, String periode) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.periode = periode;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", nomClasse='" + nomClasse + '\'' +
                ", periode='" + periode + '\'' +
                '}';
    }
}
