/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avalon.dev.j130.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author eag
 */
public class MainForm extends JFrame{
    
    private JButton exbtn;
    private JTextArea logs;
    
    public MainForm() {
        
        super("TCP-SERVER"); //название формы
        setBounds(300, 200, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        
        // отрисовываем и наполняем элементами toolBar
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        
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
        logs.setSize(200, 300);
        logs.setText("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n!!!!!!!!!!!!!!!!!");
        jPanelLogs.add(logs);
        
        c.add(jPanelLogs);
        c.add(jPanel);
        
        
    }
    
    
}
