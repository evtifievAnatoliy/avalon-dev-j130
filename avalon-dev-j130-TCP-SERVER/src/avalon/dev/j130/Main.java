/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException{
        
        MainForm mainForm = new MainForm();
        SrvThread srvThread = new SrvThread(mainForm);
        srvThread.start();
                
    }
    
}
