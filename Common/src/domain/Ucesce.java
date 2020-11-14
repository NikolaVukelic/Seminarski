/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Ucesce implements GeneralEntity {

    private int ucesceID;
    private int takmicenjeID;
    private int igracID;
    private int sudijaID;

    public Ucesce() {
    }

    public Ucesce(int ucesceID, int takmicenjeID, int igracID, int sudijaID) {
        this.ucesceID = ucesceID;
        this.takmicenjeID = takmicenjeID;
        this.igracID = igracID;
        this.sudijaID = sudijaID;
    }

    public int getUcesceID() {
        return ucesceID;
    }

    public void setUcesceID(int ucesceID) {
        this.ucesceID = ucesceID;
    }

    public int getTakmicenjeID() {
        return takmicenjeID;
    }

    public void setTakmicenjeID(int takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    public int getIgracID() {
        return igracID;
    }

    public void setIgracID(int igracID) {
        this.igracID = igracID;
    }

    public int getSudijaID() {
        return sudijaID;
    }

    public void setSudijaID(int sudijaID) {
        this.sudijaID = sudijaID;
    }

    @Override
    public String getAtrValue() {
        return (ucesceID == -1 ? null : "'" + ucesceID + "'") + ", " + (takmicenjeID == -1 ? null : "'" + takmicenjeID + "'") + ", " + (igracID == -1 ? null : "'" + igracID + "'") + ", " + (sudijaID == -1 ? null : "'" + sudijaID + "'");
    }

    @Override
    public String setAtrValue() {
        return "ucesceID=" + (ucesceID == -1 ? null : "'" + ucesceID + "'");

    }

    @Override
    public String getTableName() {
        return "ucesce";
    }

    @Override
    public String getWhereCondition() {
        return "takmicenjeID= " + (takmicenjeID == -1 ? null : "'" + takmicenjeID + "'")+ " OR ucesceID=" + (ucesceID == -1 ? null : "'" + ucesceID + "'");
    }

    @Override
    public List<GeneralEntity> getList(ResultSet rs) throws Exception {
        List<GeneralEntity> lista = new ArrayList<>();
        while (rs.next()) {
            int ucesceID = rs.getInt("ucesceID");
            int takmicenjeID = rs.getInt("takmicenjeID");
            int igracID = rs.getInt("igracID");
            int sudijaID = rs.getInt("sudijaID");
            Ucesce u = new Ucesce(ucesceID, takmicenjeID, igracID, sudijaID);
            lista.add(u);
        }

        return lista;
    }

    @Override
    public void setPrimaryKey(int id) {

    }

    @Override
    public List<GeneralEntity> vratiListu() {
        return null;
    }

    @Override
    public GeneralEntity getEntity(ResultSet rs) throws Exception {
        Ucesce u = null;
        if (rs.next()) {
            u = new Ucesce(ucesceID, takmicenjeID, igracID, sudijaID);
        }
        if (ucesceID != -1) {
            return u;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return ucesceID + " " + takmicenjeID + " " + igracID + " " + sudijaID;
    }

}
