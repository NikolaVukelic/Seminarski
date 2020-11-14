/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import domain.GeneralEntity;
import domain.Igrac;
import domain.Sudija;
import domain.Takmicenje;
import domain.Ucesce;
import domain.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractGenericOperation;
import so.igrac.DodajIgracaSO;
import so.igrac.StornirajIgracaSO;
import so.igrac.VratiIgraceSO;
import so.igrac.VratiIgracaZaIzabranoTakmicenjeSO;
import so.sudija.VratiSudijuZaIzabranoTakmicenjeSO;
import so.sudija.DodajSudijuSO;
import so.sudija.StornirajSudijuSO;
import so.sudija.VratiSudijeSO;
import so.takmicenje.VratiTakmicenjaSO;
import so.ucesce.ObrisiUcesceSO;
import so.ucesce.SacuvajUcesceSO;
import so.ucesce.VratiUcescaZaIzabranoTakmicenjeSO;
import so.user.DodajUseraSO;
import so.user.PrijavljivanjeSO;

/**
 *
 * @author Nikola
 */
public class Controler {

    private static Controler instance;

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public GeneralEntity login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        AbstractGenericOperation op = new PrijavljivanjeSO();
        op.templateExecute(user);
        return ((PrijavljivanjeSO) op).getEntity();
    }

    public List<GeneralEntity> vratiIgrace() throws SQLException, Exception {
        AbstractGenericOperation op = new VratiIgraceSO();
        op.templateExecute(new Igrac());
        return ((VratiIgraceSO) op).getList();
    }

    public List<GeneralEntity> vratiSudije() throws SQLException, Exception {
        AbstractGenericOperation op = new VratiSudijeSO();
        op.templateExecute(new Sudija());
        return ((VratiSudijeSO) op).getList();
    }

    public List<GeneralEntity> vratiTakmicenja() throws SQLException, Exception {
        AbstractGenericOperation op = new VratiTakmicenjaSO();
        op.templateExecute(new Takmicenje());
        return ((VratiTakmicenjaSO) op).getList();
    }

    public List<GeneralEntity> vratiIgraceZaIzabranoTakmicenje(int userID) throws SQLException, Exception {
        Igrac i = new Igrac();
        i.setUserID(userID);
        AbstractGenericOperation op = new VratiIgracaZaIzabranoTakmicenjeSO();
        op.templateExecute(i);
        return ((VratiIgracaZaIzabranoTakmicenjeSO) op).getList();
    }

    public List<GeneralEntity> vratiSudijeZaIzabranoTakmicenje(int userID) throws SQLException, Exception {
        Sudija s = new Sudija();
        s.setUserID(userID);
        AbstractGenericOperation op = new VratiSudijuZaIzabranoTakmicenjeSO();
        op.templateExecute(s);
        return ((VratiSudijuZaIzabranoTakmicenjeSO) op).getList();
    }

    public void obrisiUcesce(int ucesceID) throws Exception {
        Ucesce u = new Ucesce();
        u.setUcesceID(ucesceID);
        AbstractGenericOperation op = new ObrisiUcesceSO();
        op.templateExecute(u);
    }

    public void dodajIgraca(Igrac igrac) throws SQLException, Exception {
        AbstractGenericOperation op = new DodajIgracaSO();
        op.templateExecute(igrac);
    }

    public void dodajUsera(User user) throws SQLException, Exception {
        AbstractGenericOperation op = new DodajUseraSO();
        op.templateExecute(user);
    }

    public void dodajSudiju(Sudija sudija) throws SQLException, Exception {
        AbstractGenericOperation op = new DodajSudijuSO();
        op.templateExecute(sudija);
    }

    public void sacuvajUcesca(ArrayList<Ucesce> listaUcesca) throws SQLException, Exception {
        AbstractGenericOperation op = new SacuvajUcesceSO();
        op.templateExecute(listaUcesca);
    }

    public List<GeneralEntity> vratiUcescaZaIzabranoTakmicenje(int takmicenjeID) throws Exception {
        Ucesce u = new Ucesce();
        u.setTakmicenjeID(takmicenjeID);
        AbstractGenericOperation op = new VratiUcescaZaIzabranoTakmicenjeSO();
        op.templateExecute(u);
        return ((VratiUcescaZaIzabranoTakmicenjeSO) op).getList();
    }

    public void stornirajIgraca(Igrac i) throws SQLException, Exception {
        AbstractGenericOperation op = new StornirajIgracaSO();
        op.templateExecute(i);
    }

    public void stornirajSudiju(Sudija s2) throws Exception {
        AbstractGenericOperation op = new StornirajSudijuSO();
        op.templateExecute(s2);
    }
}
