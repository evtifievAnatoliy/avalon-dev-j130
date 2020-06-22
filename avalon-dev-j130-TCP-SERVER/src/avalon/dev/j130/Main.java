/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eag
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket srvSock = new ServerSocket(7_020)){
            while (true){
                Socket cliSock = srvSock.accept();
                (new ClientThread(cliSock)).start();
            }
        }
        
    }
    
    private static class  ClientThread extends Thread{
        private Socket clientSock;
        
        public ClientThread(Socket clientSock){
            super();
            this.clientSock = clientSock;
        }

        @Override
        public void run() {
            String clientHostPost = String.format("%s,%s", clientSock.getInetAddress(), clientSock.getPort());
            System.out.printf("Client from %s has been connected. \n", clientHostPost);
            try(ObjectOutputStream oos = new ObjectOutputStream(clientSock.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(clientSock.getInputStream())){
                while(true){
                    String line = (String) ois.readObject();
                    Date d = new Date();
                    System.out.printf("%s, %s, %s \n" , clientHostPost, line, d);
                    oos.writeObject(new Object[]{line, d});
                }
            } catch (Exception ex) {
                
            }
            System.out.printf("%s disconnected.", clientHostPost);
            
        }
        
        
    }
    
}
