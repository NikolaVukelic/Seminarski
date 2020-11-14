/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Takmicenje implements GeneralEntity {

    private int takmicenjeID;
    private Date datum;
    private String dodatniOpis;

    public Takmicenje() {
    }

    public Takmicenje(int takmicenjeID, Date datum, String dodatniOpis) {
        this.takmicenjeID = takmicenjeID;
        this.datum = datum;
        this.dodatniOpis = dodatniOpis;
    }

    @Override
    public String getAtrValue() {
        return (takmicenjeID == -1 ? null : "'" + takmicenjeID + "'");
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getTableName() {
        return "takmicenje";
    }

    @Override
    public String getWhereCondition() {
        return "ime= " + (takmicenjeID == -1 ? null : "'" + takmicenjeID + "'");
    }

    @Override
    public List<GeneralEntity> getList(ResultSet rs) throws Exception {
        List<GeneralEntity> lista = new ArrayList<>();
        while (rs.next()) {
            int tID = rs.getInt("takmicenjeID");
            Date dat = rs.getDate("datum");
            String dodatniOpis = rs.getString("dodatniOpis");
            Takmicenje t = new Takmicenje(tID, dat, dodatniOpis);
            lista.add(t);
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
        Takmicenje t = null;
        if (rs.next()) {
            t = new Takmicenje(takmicenjeID, datum, dodatniOpis);
        }
        if (takmicenjeID != -1) {
            return t;
        } else {
            return null;
        }
    }

    public int getTakmicenjeID() {
        return takmicenjeID;
    }

    public void setTakmicenjeID(int takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDodatniOpis() {
        return dodatniOpis;
    }

    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }

    @Override
    public String toString() {
        return takmicenjeID + " " + datum;
    }
    
}
