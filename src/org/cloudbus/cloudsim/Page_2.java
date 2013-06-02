/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;
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
public class Page_2 extends JFrame implements ActionListener 
{
    JFrame frame= new JFrame();
 JLabel label1;
JButton proceed;
JPanel panel=new JPanel();
BufferedImage image;
public Page_2() 
{
    setSize(500,500);
    setVisible(true);
        try {
            label1=new JLabel();
            label1.setText("The following Topology shows the hyper-cubic peer to peer topology");
            
            proceed=new JButton("proceed");
            proceed.setText("Proceed");
            System.out.println("page2");
            panel=new JPanel(new GridLayout(3,1));
            image=ImageIO.read(getClass().getResource("Topology.jpg"));
            JLabel img=new JLabel(new ImageIcon(image));
            panel.add(label1);
            panel.add(img);
            panel.add(proceed);
            add(panel,BorderLayout.CENTER);
            proceed.addActionListener(this);
            setTitle("Topology");
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Page_2.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
    public void actionPerformed(ActionEvent ae)
{
    System.out.print("page_2 execution over");
    System.out.println("Start step 3: PARTITION TOPOLOGY");
    // Not able to reference non static method 
    //Dc_initialise.class.getConstructors();
    Page_3 p=new Page_3();
    p.Page_3();
    
}

}