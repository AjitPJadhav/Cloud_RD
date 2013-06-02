/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;
//import org.cloudbus.cloudsim.Page_1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sabarish
 */

public class Login_1 extends JFrame implements ActionListener
{int flag;
 JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 final JTextField  text1,text2;
  public Login_1()
  {
  label1 = new JLabel();
  label1.setText("Username:");
  text1 = new JTextField(15);

  label2 = new JLabel();
  label2.setText("Password:");
  text2 = new JPasswordField(15);
 
  SUBMIT=new JButton("SUBMIT");
  
  panel=new JPanel(new GridLayout(3,1));
  panel.add(label1);
  panel.add(text1);
  panel.add(label2);
  panel.add(text2);
  panel.add(SUBMIT);
  add(panel,BorderLayout.CENTER);
  SUBMIT.addActionListener(this);
  setTitle("LOGIN FORM");
  }
    @Override
 public void actionPerformed(ActionEvent ae)
  {
  String value1=text1.getText();
  String value2=text2.getText();
  
     try 
    {
  Connection connect = null;
  Statement statement = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("select * from users where name='"+text1.getText()+"'and password='"+text2.getText()+"'");
       
      if(resultSet.first())
      {
            
            //Log.printLine(b);
          
                  //System.out.println(r_a);
        System.out.println("Logged");
        //Page_1 page = new Page_1();
        //page.setVisible(true);
        //JLabel label = new JLabel("Welcome:"+value1); 
        Page_2 page=new Page_2();
        
      }
      else 
          System.out.println("No logged");
          
    }
    catch(Exception e)
            {
                System.out.println(e);
            }


  
  //page.getContentPane().add(label);
  
 
}
  public static void main(String arg[])
  {
  try
  {
  Login_1 frame=new Login_1();
  frame.setSize(300,100);
  frame.setVisible(true);
  Plot_Compare x=new Plot_Compare();
  x.Plot_Compare();
  }
  catch(Exception e)
  {JOptionPane.showMessageDialog(null, e.getMessage());}
  }   
}
