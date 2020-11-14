/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controler.Controler;
import domain.GeneralEntity;
import domain.Igrac;
import domain.Sudija;
import domain.Ucesce;
import domain.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Nikola
 */
public class ClientThread extends Thread {

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            handleRequest();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleRequest() throws IOException, ClassNotFoundException {
        while (true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) ois.readObject();
            Response response = new Response();

            try {
                int operation = request.getOperation();
                switch (operation) {
                    case Operation.LOGIN:
                        User dataUser = (User) request.getData();
                        GeneralEntity user = Controler.getInstance().login(dataUser.getUsername(), dataUser.getPassword());
                        if (user != null) {
                            response.setStatus(ResponseStatus.OK);
                            response.setData(user);
                        } else {
                            response.setStatus(ResponseStatus.ERROR);
                        }
                        break;
                    case Operation.VRATI_IGRACE:
                        List<GeneralEntity> igraci = Controler.getInstance().vratiIgrace();
                        response.setData(igraci);
                        break;
                    case Operation.VRATI_SUDIJE:
                        List<GeneralEntity> sudije = Controler.getInstance().vratiSudije();
                        response.setData(sudije);
                        break;

                    case Operation.VRATI_TAKMICENJA:
                        List<GeneralEntity> takmicenja = Controler.getInstance().vratiTakmicenja();
                        response.setData(takmicenja);
                        break;

                        case Operation.VRATI_UCESCA_ZA_IZABRANO_TAKMICENJE:
                        int takmicenjeID = (int) request.getData();
                        List<GeneralEntity> ucescaZaIzabranoTakmicenje = Controler.getInstance().vratiUcescaZaIzabranoTakmicenje(takmicenjeID);
                        response.setData(ucescaZaIzabranoTakmicenje);
                        break;
                        
                    case Operation.VRATI_IGRACE_ZA_IZABRANO_TAKMICENJE:
                        int userID = (int) request.getData();
                        List<GeneralEntity> igraciZaIzabranoTakmicenje = Controler.getInstance().vratiIgraceZaIzabranoTakmicenje(userID);
                        response.setData(igraciZaIzabranoTakmicenje);
                        break;
                    case Operation.VRATI_SUDIJE_ZA_IZABRANO_TAKMICENJE:
                        int userID1 = (int) request.getData();
                        List<GeneralEntity> sudijeZaIzabranoTakmicenje = Controler.getInstance().vratiSudijeZaIzabranoTakmicenje(userID1);
                        response.setData(sudijeZaIzabranoTakmicenje);
                        break;

                    case Operation.OBRISI_UCESCE:
                        int ucesceID = (int) request.getData();
                        Controler.getInstance().obrisiUcesce(ucesceID);
                        response.setStatus(ResponseStatus.OK);
                        break;


                    case Operation.DODAJ_IGRACA:
                        Igrac igrac = (Igrac) request.getData();
                        Controler.getInstance().dodajIgraca(igrac);
                        response.setStatus(ResponseStatus.OK);
                        break;

                    case Operation.DODAJ_SUDIJU:
                        Sudija s = (Sudija) request.getData();
                        Controler.getInstance().dodajSudiju(s);
                        response.setStatus(ResponseStatus.OK);
                        break;
                        
                        case Operation.DODAJ_USERA:
                        User u = (User) request.getData();
                        Controler.getInstance().dodajUsera(u);
                        response.setStatus(ResponseStatus.OK);
                        break;

                    case Operation.SACUVAJ_UCESCA:
                        ArrayList<Ucesce> uc =  (ArrayList<Ucesce>) request.getData();
                        Controler.getInstance().sacuvajUcesca(uc);
                        response.setStatus(ResponseStatus.OK);
                        break;
                        
                        case Operation.STORNIRAJ_IGRACA:
                        Igrac i = (Igrac) request.getData();
                        Controler.getInstance().stornirajIgraca(i);
                        response.setStatus(ResponseStatus.OK);
                        break;
                        
                        case Operation.STORNIRAJ_SUDIJU:
                        Sudija s2 = (Sudija) request.getData();
                        Controler.getInstance().stornirajSudiju(s2);
                        response.setStatus(ResponseStatus.OK);
                        break;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                response.setStatus(ResponseStatus.ERROR);
                response.setError(ex);
            }
            sendResponse(response);
        }
    }

    private void sendResponse(Response response) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(response);
    }
}
