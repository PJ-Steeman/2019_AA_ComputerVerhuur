/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerverhuur_client;

import javax.ejb.EJB;
import beans.OpvragenRemote;
import beans.Computers;
import java.util.List;
import java.util.Iterator;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;  
import java.awt.BorderLayout;
/**
 *
 * @author pieji
 */

public class Main {
    @EJB private static OpvragenRemote obean;
    /**
     * @param args the command line arguments
     */
    //List<Object> compLijst = obean.opvragenComp();
    static JLabel l;
    public static void main(String[] args) {
        JFrame f=new JFrame();//creating instance of JFrame  
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        GridLayout experimentLayout = new GridLayout(0,2);  
        panel.setLayout(experimentLayout); 
        panel2.setLayout(new BorderLayout());
        List<String> compLijst = obean.opvragenCompClient();
        JTextArea text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text); //place the JTextArea in a scroll pane
        panel2.add(scroll, BorderLayout.CENTER); //add the JScrollPane to the panel
        // CENTER will use up all available space
        for(int i = 0; i<compLijst.size();i++){
            System.out.println(compLijst.get(i));
            l = new JLabel(compLijst.get(i));
            panel.add(l);
            JButton b = new JButton("Toon reservaties");
            final int k = i;
            b.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                    String[] arr = compLijst.get(k).split(" -", -1);
                    int c = Integer.parseInt(arr[0]);
                    List<String> reslist = obean.opvragenResClient(c);
                    text.setText("");
                    String totaal = "";
                    for(int j = 0; j<reslist.size();j++){
                        System.out.println(reslist.get(j));
                        totaal += reslist.get(j);
                        totaal += "\n";
                    }
                    text.setText(totaal);
                    
                }  
            });
            panel.add(b);
        }
        f.add(panel); 
        f.add(panel2);
        //f.add(b);//adding button in JFrame  
        //f.pack();
        f.setSize(800,300);//400 width and 500 height  
        //f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // TODO code application logic here
        //view V= new view();
    }
    
}
