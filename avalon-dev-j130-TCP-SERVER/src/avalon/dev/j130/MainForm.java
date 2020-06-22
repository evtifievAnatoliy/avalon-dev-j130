/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class MainForm extends JFrame{
    
    private JButton exbtn;
    private JTextArea logs;
      
    public MainForm() throws IOException {
        
        super("TCP-SERVER");
        setBounds(300, 200, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        JPanel jPanel = new JPanel();
        
        exbtn = new JButton("Exit");
        exbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        jPanel.add(exbtn);
        
        JPanel jPanelLogs = new JPanel();
        jPanelLogs.setLayout(new BorderLayout());
        
        logs = new JTextArea();
        jPanelLogs.add(logs);
        
        c.add(new JScrollPane(jPanelLogs));
        c.add(jPanel, BorderLayout.SOUTH);
        
        setVisible(true);
        
        
    }
    
    public void setLogs(String string) {
        SwingUtilities.invokeLater(()->{
                this.logs.append(string);
                this.logs.append("\n");
            });
        
    }
    
    
    
}
