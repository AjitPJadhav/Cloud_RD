/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sabarish
 */
public class Final extends JFrame implements ActionListener
{

 
JPanel panel;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8;
    JButton finish;
    JFrame frame;
    /**
     *
     * @param Mips
     * @param mips
     * @param Ram
     * @param ram
     * @param Storage
     * @param size
     * @param BW
     * @param bw
     * @param pe
     * @param pesNumber
     * @param vm
     * @param vmm
     * @param name
     */
    public void Final(int Mips, int mips, int Ram, int ram, int Storage, long size, int BW, long bw, int pe, int pesNumber, String vm, String vmm, String name) 
    {
        //throw new UnsupportedOperationException("Not yet implemented");
   try
   { 
       frame.setSize(500,500);
    frame.setVisible(true);
panel=new JPanel(new GridLayout(8,1));
finish=new JButton("Finish");
    label1=new JLabel();
label1.setText("The VM Parameters");
label2=new JLabel();
label2.setText("Mips:"+mips);
label3=new JLabel();
label3.setText("Ram:"+ram);
label4=new JLabel();
label4.setText("Storage:"+size);
label5=new JLabel();
label5.setText("BW:"+bw);
label6=new JLabel();
label6.setText("PES:"+pe);
label7=new JLabel();
label7.setText("VMM:"+vm);
label8=new JLabel();
label8.setText("alocated to"+name);
panel.add(label1);
panel.add(label2);
   panel.add(label3);
   panel.add(label4);
   panel.add(label5);
   panel.add(label6);
   panel.add(label7);
   panel.add(label8);
   panel.add(finish);
   add(panel,BorderLayout.CENTER);
   finish.addActionListener(this);
   }
    catch(Exception e)
    {
    Log.printLine(e);
    }}
    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        System.out.println("THE END");
        try
        { Connection connect=null; 
        Statement statement = null;
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
     //connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      int a=statement.executeUpdate("Delete * from zone_1");
        }
    catch(Exception e)
    {
    }}
}