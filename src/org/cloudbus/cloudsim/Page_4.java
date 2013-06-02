/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sabarish
 */
public class Page_4 extends JFrame implements ActionListener 
{
    JFrame frame= new JFrame();
 JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;
JButton proceed;
JPanel panel=new JPanel();
JTextField text1,text2,text3,text4,text5,text6,text7,text8;
public void Page_4() 
{
    setSize(800,800);
    setVisible(true);
        try 
        {
            label1=new JLabel();
            label1.setText("# of Hosts in Datacenter 1");
            label2=new JLabel();
            label2.setText("# of Hosts in Datacenter 2");
            label3=new JLabel();
            label3.setText("# of Hosts in Datacenter 3");
            label4=new JLabel();
            label4.setText("# of Hosts in Datacenter 4");
            label5=new JLabel();
            label5.setText("# of Hosts in Datacenter 5");
            label6=new JLabel();
            label6.setText("# of Hosts in Datacenter 6");
            label7=new JLabel();
            label7.setText("# of Hosts in Datacenter 7");
            label8=new JLabel();
            label8.setText("# of Hosts in Datacenter 8");
            text1=new JTextField();
            text2=new JTextField();
            text3=new JTextField();
            text4=new JTextField();
            text5=new JTextField();
            text6=new JTextField();
            text7=new JTextField();
            text8=new JTextField();
            
            proceed=new JButton("proceed");
            
            proceed.setText("CREATE DATACENTERS AND SCHEDULE");
            System.out.println("page4");
            panel=new JPanel(new GridLayout(10,2));
            panel.add(label1);
            panel.add(text1);
            panel.add(label2);
            panel.add(text2);
            panel.add(label3);
            panel.add(text3);
            panel.add(label4);
            panel.add(text4);
            panel.add(label5);
            panel.add(text5);
            panel.add(label6);
            panel.add(text6);
            panel.add(label7);
            panel.add(text7);
            panel.add(label8);
            panel.add(text8);
            panel.add(proceed);
            add(panel,BorderLayout.CENTER);
            proceed.addActionListener(this);
            setTitle("Specify hosts");
        } 
        catch(Exception e)
            
                {
            }
        }

    @Override
    public void actionPerformed(ActionEvent ae)
{
    int a=Integer.parseInt(text1.getText());
    int b=Integer.parseInt(text2.getText());
    int c=Integer.parseInt(text3.getText());
    int d=Integer.parseInt(text4.getText());
    int e=Integer.parseInt(text5.getText());
    int f=Integer.parseInt(text6.getText());
    int g=Integer.parseInt(text7.getText());
    int h=Integer.parseInt(text8.getText());
    System.out.print("page_3 execution over");
    System.out.println("Start step 4: Initialise datacenters");
    // Not able to reference non static method 
    //Dc_initialise.class.getConstructors();
    DC.DC(a,b,c,d,e,f,g,h);
    
}

    
}
