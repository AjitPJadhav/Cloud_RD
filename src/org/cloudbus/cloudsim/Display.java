/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import com.mysql.jdbc.ResultSetMetaData;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Sabarish
 */
public class Display extends JPanel {

    public Connection con = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void Display() {
        JFrame frame = new JFrame("Display Resource");
        JScrollPane scrollPane = new JScrollPane();


        frame.getContentPane().add(scrollPane);
        frame.setSize(400, 500);
        frame.setVisible(true);

        try{

            String url = "jdbc:mysql://localhost:3306/cloud_rd";
            String login = "root";
            String password = "";
            
            con = DriverManager.getConnection(url, login, password);
            stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM zone_1");
            ResultSetMetaData md = (ResultSetMetaData) result.getMetaData();
            int columnCount = md.getColumnCount();

            Vector columns = new Vector(columnCount);

            //store column names
            for(int i=1; i<=columnCount; i++)
            
                columns.add(md.getColumnName(i));
            

            Vector data = new Vector();
            Vector row;

            //store row data
            while(result.next())
            {
            row = new Vector(columnCount);
            for(int i=1; i<=columnCount; i++)
            {
            row.add(result.getString(i));
            }
            data.add(row);
            }



            JTable table = new JTable(data, columns);
            this.add(table);

        }catch(SQLException sqle){
            System.err.println(sqle);
        }


    }

    

}

