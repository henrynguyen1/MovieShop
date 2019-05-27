/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import uts.web.model.dao.DBManager;
import uts.web.model.dao.DBConnector;
import uts.web.model.User;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author francobuena
 */
public class TestDB {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector(); //Create a connection and initialize DB conn-field
            Connection conn = connector.openConnection(); //Get the protected connection instance from DB superclass to share for the application classes
            DBManager db = new DBManager(conn); //DBManger instance provide users with access to CRUD operations
            
          //  int key = (new Random()).nextInt(999999);
         //   String ID = "" + key; 
            System.out.print("User ID: ");
            String  ID = in.nextLine();
            System.out.print("User email: ");
            String email = in.nextLine();
            System.out.print("User name: ");
            String name = in.nextLine();
            System.out.print("User password: ");
            String password = in.nextLine();
            System.out.print("Student Phone Number: ");
            String phone = in.nextLine();
            
            User user = db.findUser(ID, password); //This method must be completed in DBManager class
            
           if (user != null) {
            System.out.println("User is found in the database." + user.getID() + user.getName());
            }
           
           if (user != null) {
            db.deleteUser(ID); // This method must be completed in DBManager class
            System.out.println("Student is deleted from the database.");
            }
            
            connector.closeConnection(); //Professional practice is to close connection to database once operations are finalized
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
