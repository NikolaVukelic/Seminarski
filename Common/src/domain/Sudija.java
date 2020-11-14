package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikola
 */
public class Sudija extends User implements GeneralEntity {

    private String ime;
    private String prezime;

    public Sudija(String ime, String prezime, int userID, String username, String password, String email) {
        super(userID, username, password, email);
        this.ime = ime;
        this.prezime = prezime;
    }

    public Sudija(int userID, String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        setUserID(userID);
    }

    public Sudija() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String getAtrValue() {
        return (getUserID() == -1 ? null : "'" + getUserID() + "'") + ", " + (ime == null ? null : "'" + ime + "'") + ", " + (prezime == null ? null : "'" + prezime + "'");
    }

    @Override
    public String setAtrValue() {
        return "userID=" + (getUserID() == -1 ? null : "'" + getUserID() + "'") + ", ime=" + (ime == null ? null : "'" + ime + "'") + ", prezime=" + (prezime == null ? null : "'" + prezime + "'");
    }

    @Override
    public String getTableName() {
        return "sudija";
    }

    @Override
    public String getWhereCondition() {
        return "userID= " + (getUserID() == -1 ? null : "'" + getUserID() + "'");
    }

    @Override
    public List<GeneralEntity> getList(ResultSet rs) throws Exception {
        List<GeneralEntity> lista = new ArrayList<>();
        while (rs.next()) {
            int userID = rs.getInt("userID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            Sudija s = new Sudija(ime, prezime, userID, "", "", "");
            lista.add(s);
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
        Sudija sudija = null;
        if (rs.next()) {
            int id = rs.getInt("userID");
            sudija = new Sudija(id, ime, prezime);
        }
        if (ime != null) {
            return sudija;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return getUserID()+" "+ime + " " + prezime;
    }
}
