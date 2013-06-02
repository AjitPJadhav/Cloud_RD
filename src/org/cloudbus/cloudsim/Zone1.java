/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.sql.SQLException;
import java.util.Timer;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
/**
 *
 * @author Sabarish
 */
public class Zone1
{ public int f=0;
 
    /**
     *
     * @param mips
     * @param size
     * @param ram
     * @param bw
     * @param pesNumber
     * @param vmm
     */
    public static int Zone1(int mips, long size, int ram, long bw, int pesNumber, String vmm) {
        //throw new UnsupportedOperationException("Not yet implemented');
        long starttime = System.currentTimeMillis();
int flag = 0;      
        int request=0;
    try 
    {
 
  System.out.println("Vm submitted to Zone 1");
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
      resultSet=statement.executeQuery("select * from zone_1");
    //int flag=0;
      while(resultSet.next()&&flag==0)
      {int Mips=Integer.parseInt(resultSet.getString("mips"));
    int Ram=Integer.parseInt(resultSet.getString("ram"));
    int Storage=Integer.parseInt(resultSet.getString("storage"));
    int BW=Integer.parseInt(resultSet.getString("bw"));
    int pe=Integer.parseInt(resultSet.getString("pes"));
    String vm=resultSet.getString("vmm");
    String name=resultSet.getString("datacenter");
    int hostid=Integer.parseInt(resultSet.getString("host"));
    Log.printLine("Host"+hostid+" present in"+name+" in the the Zone 2");
    Log.printLine(name);
    if(Mips>mips)
    {
            if(Ram>ram)
            {
                if(Storage>size)
                {
                    if(BW>bw)
                    {
                        
                        if(pe>pesNumber)
                        {
                            if(vm.equals(vmm))
                            {Zone1 z=new Zone1();
                          z.disp();
                            z.f++;
                                request++;
                                flag=1;
                                Log.printLine("vm allocated successfuly to "+hostid+"in "+name);
                                Log.printLine(name+" Debt:");
                                Log.printLine("Mips: "+mips );
                                Log.printLine("RAM: "+ram);
                                Log.printLine("Storage: "+size);
                                Log.printLine("BW:"+bw);
                                Log.printLine("PES: "+pesNumber);
                                Log.printLine("VMM:"+vm);
                                 //Final.Final(Mips,mips,Ram,ram,Storage,size,BW,bw,pe,pesNumber,vm,vmm,name);
                               long finishtime=System.currentTimeMillis();
                               long executiontime=finishtime-starttime;
                               Log.printLine("Runtime: "+executiontime);
                            }else Log.printLine("Failed by VMM");
                        }else Log.printLine("Failed by PE");
                    }else Log.printLine("Failed by BW");
                }else Log.printLine("Failed by storage");
            }else Log.printLine("Failed by RAM");
    }else Log.printLine("Failed by MIPS");
      }
    }catch(Exception e)
            {
                System.out.println(e);
            }
        //int request = 0;
        return request;
    }
    
 
        //return 0;

    static void submitcloudlet(int t1,int id, long length, long fileSize, long outputSize) {
        //throw new UnsupportedOperationException("Not yet implemented");
    Zone1 z=new Zone1();
     
    {
        Log.printLine("The Cloudlet sumbitted to the VM at zone 1 with parameters:");
        Log.printLine("id:"+id);
        Log.printLine("Length:"+length);
        Log.printLine("Filesize:"+fileSize);
        Log.printLine("outputsize:"+outputSize);
        
    }
    }
   void disp() {
Vector columnNames = new Vector();
Vector data = new Vector();
JPanel p=new JPanel();
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");
     
String sql = "Select * from zone_1";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++){
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println(e);
}
JTable table = new JTable(data, columnNames);
TableColumn col;
for (int i = 0; i < table.getColumnCount(); i++) {
col = table.getColumnModel().getColumn(i);
col.setMaxWidth(250);
}
JScrollPane scrollPane = new JScrollPane( table );
p.add( scrollPane );
JFrame f=new JFrame();
f.add(p);
f.setTitle("Zone 1 Resources");
f.setSize(600,400);
f.setVisible(true);
}
}
