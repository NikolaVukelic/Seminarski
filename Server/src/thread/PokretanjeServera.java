/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SettingsLoader;

/**
 *
 * @author Kuzner
 */
public class PokretanjeServera extends Thread {
    
    ServerSocket serverSocket;
    private boolean kraj = false;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Integer.valueOf(SettingsLoader.getInstance().getProperty("port")));
            System.out.println("server podignut");
            
            while(!kraj){
                Socket socket = serverSocket.accept();
                System.out.println("klijent povezan");
                
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zaustaviServer() {
        kraj = true;
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
