/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

/**
 *
 * @author Sabarish
 */
import java.io.File;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author Sabarish
 */
public class Page_3 extends JFrame implements ActionListener 
{
    JFrame frame= new JFrame();
 JLabel label1;
JButton proceed;
JPanel panel=new JPanel();
BufferedImage image;
public void Page_3() 
{
    setSize(800,800);
    setVisible(true);
        try {
            label1=new JLabel();
            label1.setText("The following Topology shows the hyper-cubic peer to peer topology");
            
            proceed=new JButton("proceed");
            
            proceed.setText("CREATE DATACENTERS AND SCHEDULE");
            System.out.println("page3");
            panel=new JPanel();
            image=ImageIO.read(getClass().getResource("Iso.jpg"));
            JLabel img=new JLabel(new ImageIcon(image));
            panel.add(label1);
            panel.add(img);
            panel.add(proceed);
            add(panel,BorderLayout.CENTER);
            proceed.addActionListener(this);
            setTitle("Isomorphic partitioned Topology");
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Page_3.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
    public void actionPerformed(ActionEvent ae)
{
    System.out.print("page_3 execution over");
    System.out.println("Start step 4: Initialise datacenters");
    // Not able to reference non static method 
    //Dc_initialise.class.getConstructors();
    Page_4 a=new Page_4();
    a.Page_4();
    
}


    
}
