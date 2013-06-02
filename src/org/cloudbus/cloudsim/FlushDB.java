/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sabarish
 */
public class FlushDB {
public void FlushDB()
{
 
    try 
    {
 
  System.out.println("Flushing Databases");
  Connection connect = null;
  Statement statement = null;
  //PreparedStatement preparedStatement = null;
  //ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      statement.executeUpdate("Delete from zone_1");
     // connect.close();
      Log.printLine("Zone 1 flushed");
      Flushzone2();
}
    catch(Exception e){
    Log.printLine(e);}
}

    private void Flushzone2() {
        //throw new UnsupportedOperationException("Not yet implemented");
    try 
    {
 
  System.out.println("Flushing Databases");
  Connection connect = null;
  Statement statement = null;
  //PreparedStatement preparedStatement = null;
  //ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      statement.executeUpdate("Delete from zone_2");
     // connect.close();
      Log.printLine("Zone 2 Flushed");
      Flushzone3();
}
    catch(Exception e){
    Log.printLine(e);}}

    private void Flushzone3() {
        //throw new UnsupportedOperationException("Not yet implemented");
    try 
    {
 
  System.out.println("Flushing Databases");
  Connection connect = null;
  Statement statement = null;
  //PreparedStatement preparedStatement = null;
  //ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      statement.executeUpdate("Delete from zone_3");
     // connect.close();
      Log.printLine("Zone 3 Flushed");
      Flushzone4();
    }
    catch(Exception e){
    Log.printLine(e);}}

    private void Flushzone4() {
        //throw new UnsupportedOperationException("Not yet implemented");
    try 
    {
 
  System.out.println("Flushing Databases");
  Connection connect = null;
  Statement statement = null;
  //PreparedStatement preparedStatement = null;
  //ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      statement.executeUpdate("Delete from zone_4");
     // connect.close();
      Log.printLine("Zone 4 Flushed");
}
    catch(Exception e){
    Log.printLine(e);}}
    
}