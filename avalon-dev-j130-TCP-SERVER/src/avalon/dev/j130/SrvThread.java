/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class SrvThread extends Thread{
    
    MainForm mainForm;
    ArrayList<ClientThread> clientThreads = new ArrayList<ClientThread>();
    String log;

    public SrvThread(MainForm mainForm) {
        this.mainForm = mainForm;
    }
    
    
    @Override
    public void run() {
     try (ServerSocket srvSock = new ServerSocket(7_020)){
            
            mainForm.setLogs("Сервер LocalHost:" + srvSock.getLocalPort() + " запущен.");
            
            while (true){
                sleep(100);
                Socket cliSocket = srvSock.accept();
                ClientThread clientThread = new ClientThread(cliSocket, mainForm, this, clientThreads);
                clientThread.start();
                clientThreads.add(clientThread);
            }
        } catch (Exception ex) {
            mainForm.setLogs("Error: " + ex.toString());
        } 
    
    }

    public ArrayList<ClientThread> getClientThreads() {
        return clientThreads;
    }

    public String getLog() {
        return log;
    }
    
    public synchronized void sendMessageToAll(String line, String time) throws IOException{
        
        for (ClientThread clientThread : clientThreads){
            try{
                clientThread.getOos().writeObject(new Object[]{line, time});
            }
            catch (Exception ex){
                clientThreads.remove(clientThread);
                mainForm.setLogs(ex.toString());
            }
        }
    }

    
    
    
    
}
