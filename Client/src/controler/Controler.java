/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import communication.Communication;
import domain.Igrac;
import domain.Sudija;
import domain.Takmicenje;
import domain.Ucesce;
import domain.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Nikola
 */
public class Controler {

    private static Controler instance;

    public Controler() {

    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.LOGIN, user);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (User) response.getData();
        } else {
            return null;
        }
    }

    public List<Igrac> vratiIgrace() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.VRATI_IGRACE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Igrac> igraci = (List<Igrac>) response.getData();
        return igraci;
    }

    public List<Sudija> vratiSudije() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.VRATI_SUDIJE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Sudija> sudije = (List<Sudija>) response.getData();
        return sudije;
    }

    public List<Takmicenje> vratiTakmicenja() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setOperation(Operation.VRATI_TAKMICENJA);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Takmicenje> takmicenja = (List<Takmicenje>) response.getData();
        return takmicenja;
    }

    public List<Igrac> vratiIgracaZaIzabranoTakmicenje(int takmicenjeID) throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(takmicenjeID);
        request.setOperation(Operation.VRATI_IGRACE_ZA_IZABRANO_TAKMICENJE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Igrac> igraci = (List<Igrac>) response.getData();
        return igraci;
    }

    public List<Sudija> vratiSudijuZaIzabranoTakmicenje(int takmicenjeID) throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(takmicenjeID);
        request.setOperation(Operation.VRATI_SUDIJE_ZA_IZABRANO_TAKMICENJE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Sudija> sudije = (List<Sudija>) response.getData();
        return sudije;
    }

    public void obrisiUcesce(int ucesceID) throws Exception {
        Request request = new Request();
        request.setData(ucesceID);
        request.setOperation(Operation.OBRISI_UCESCE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public void dodajIgraca(Igrac igrac) throws SQLException, IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(igrac);
        request.setOperation(Operation.DODAJ_IGRACA);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public void dodajSudiju(Sudija sudija) throws SQLException, IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(sudija);
        request.setOperation(Operation.DODAJ_SUDIJU);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public void dodajUsera(User u) throws SQLException, IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(u);
        request.setOperation(Operation.DODAJ_USERA);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public void sacuvajUcesca(ArrayList<Ucesce> listaUcesca) throws SQLException, IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(listaUcesca);
        request.setOperation(Operation.SACUVAJ_UCESCA);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public List<Ucesce> vratiUcescaZaIzabranoTakmicenje(int tID) throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(tID);
        request.setOperation(Operation.VRATI_UCESCA_ZA_IZABRANO_TAKMICENJE);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        List<Ucesce> ucesca = (List<Ucesce>) response.getData();
        return ucesca;
    }

    public void stornirajIgraca(Igrac i) throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setData(i);
        request.setOperation(Operation.STORNIRAJ_IGRACA);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

    public void stornirajSudiju(Sudija s) throws IOException, ClassNotFoundException{
        Request request = new Request();
        request.setData(s);
        request.setOperation(Operation.STORNIRAJ_SUDIJU);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
    }

}
