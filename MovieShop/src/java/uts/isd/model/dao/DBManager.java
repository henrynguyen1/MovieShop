/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.dao.DBConnector;
import java.sql.*;
import uts.web.model.User;

/**
 *
 * @author HenryNguyen
 */
public class DBManager {
    private final Statement STATEMENT;
    private final DBConnector DBCONN;
    private final Connection CONN;
    private ResultSet resSet;
    private String query;
    
    /*
     * Constructor using default connection from DBConnector class.
     */
    public DBManager() throws ClassNotFoundException, SQLException {
        DBCONN = new DBConnector();
        CONN = DBCONN.openConnection();
        STATEMENT = CONN.createStatement();
    }

    public DBManager(Connection conn) throws ClassNotFoundException, SQLException {
        CONN = conn;
        STATEMENT = CONN.createStatement();
        DBCONN = new DBConnector();
    }
    
    /**
     * @author - Franco Buena
     */
    
    public User findUser(String ID, String password) throws SQLException {
        //setup the select sql query string
        String query = "select * from Users where ID='" + ID + "' AND password='" + password + "'";
        //execute this query using the statement field
       //add the results to a ResultSet
         resSet = STATEMENT.executeQuery(query);
        //search the ResultSet for a student using the parameters
         boolean hasStudent = resSet.next();
         User userFromDB = null;
                 
         if(hasStudent){
         
             String sID = resSet.getString("ID");
             String sPassword = resSet.getString("password"); 
             String sEmail = resSet.getString("email");
             String sName = resSet.getString("name");
             String sPhone = resSet.getString("phone");
             
             userFromDB = new User (sID, sEmail, sName, sPassword, sPhone);
         }
        
         resSet.close();
        // st.close();
         
         return userFromDB;
    }
    
    public void addUser(String ID, String email, String name, String password, String phone) throws SQLException {        
        //code for add-operation
        
         String query = "insert into Students" + " values ('" + ID + "', '" + email + "', '" + name + "', '" + password + "', '" + phone + "')";
         boolean recrodCreated = STATEMENT.executeUpdate(query) > 0;
         
         if (recrodCreated){
         System.out.println("record created");
         }
         else {
         System.out.println("record not created");
         }
             
    }
    
    public void deleteUser(String ID) throws SQLException{
        //code for delete-operation
        
        String query = "delete from Users where ID= '" + ID + "' ";
        boolean recordDeleted = STATEMENT.executeUpdate(query) > 0;
         
         if (recordDeleted){
         System.out.println("record deleted");
         }
         else {
         System.out.println("record not deleted");
         }
    }
}
