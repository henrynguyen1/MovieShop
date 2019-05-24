/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.resource.spi.ConnectionManager;

import uts.web.model.User;
/**
 *
 * @author francobuena
 */
public class RegisterDAO {
    private String jdbcURL;
    private String jdbcName;
    private String jdbcPassword;
    private String jdbcEmail;
    private String jdbcPhone;
    private Connection jdbcConnection;
    static Connection currentCon = null;
    static ResultSet rs = null; 
    
    public RegisterDAO(String jdbcURL, String jdbcName, String jdbcPassword, String jdbcEmail, String jdbcPhone) {
        this.jdbcURL = jdbcURL;
        this.jdbcName = jdbcName;
        this.jdbcPassword = jdbcPassword;
        this.jdbcEmail = jdbcEmail;
        this.jdbcPhone = jdbcPhone;
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcName, jdbcPassword);
        }
    }
    
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public static User login(User user) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String username = user.getName();    
         String password = user.getPassword();   
	
         String searchQuery =
               "select * from users where username='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try {
         //connect to DB 
         currentCon = RegisterConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            user.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) {
            String name = rs.getString("FirstName");
	     	
            System.out.println("Welcome " + name);
            user.setName(name);
            user.setValid(true);
         }
      } 

      catch (Exception ex) {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally {
         if (rs != null)	 {
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

    return user;
	
      }	
}
