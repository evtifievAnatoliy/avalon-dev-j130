/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;


public class ClientThread extends Thread{
    private Socket clientSock;
    private String clientHostPost;
    private MainForm mainForm;
    
        
    public ClientThread(Socket clientSock, MainForm mainForm){
        super();
        this.clientSock = clientSock;
        this.mainForm = mainForm;
        
    }

    @Override
    public void run() {
            
        clientHostPost = String.format("%s,%s", clientSock.getInetAddress(), clientSock.getPort());
        mainForm.setLogs(clientHostPost + " connected.");
        try(ObjectOutputStream oos = new ObjectOutputStream(clientSock.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSock.getInputStream())){
            while(true){
                String line = (String) ois.readObject();
                Date d = new Date();
                mainForm.setLogs(clientHostPost + ", " +  line + ", " + d);
                   
                oos.writeObject(new Object[]{line, d});
            }
        } catch (Exception ex) {
                
        }
            mainForm.setLogs(clientHostPost + " disconnected.");
            
        }

   
}
