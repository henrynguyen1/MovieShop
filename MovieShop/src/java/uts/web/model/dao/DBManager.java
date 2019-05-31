package uts.web.model.dao;

import java.sql.*;
import uts.web.model.User;

/**
 *
 * @author HenryNguyen
 */
public class DBManager {
    private Statement st;
  
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /**
     * @author - Franco Buena
     * @param ID
     * @param password
     * @return 
     * @throws java.sql.SQLException
     */
    
    public User findUser(String email, String password) throws SQLException {
        //setup the select sql query string
        String query = "select * from Users where email='" + email + "' AND password='" + password + "'";
        //execute this query using the statement field
       //add the results to a ResultSet
         ResultSet rs = st.executeQuery(query);
        //search the ResultSet for a student using the parameters
         boolean hasUser = rs.next();
         User userFromDB = null;
                 
         if(hasUser){
         
             String sID = rs.getString("ID");
             String sPassword = rs.getString("password"); 
             String sEmail = rs.getString("email");
             String sName = rs.getString("name");
             String sPhonenumber = rs.getString("phonenumber");
             
             userFromDB = new User (sID, sEmail, sName, sPassword, sPhonenumber);
         }
        
         rs.close();
        // st.close();
         
         return userFromDB;
    }
    
    public void addUser(String ID, String email, String name, String password, String phonenumber) throws SQLException {        
        //code for add-operation
        
         String query = "insert into USERS" + " values ('" + ID + "', '" + email + "', '" + name + "', '" + password + "', '" + phonenumber + "')";
         boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record created");
         }
         else {
         System.out.println("record not created");
         }
             
    }
    
    public void updateUser(String ID, String email, String name, String password, String phonenumber) throws SQLException {
        //code for update-operation
        
        String query = "update Users set email = '" + email + "', name= '" + name + "', password = '"  + password + "', phonenumber = '" + phonenumber + "' where ID='" + ID + "'";
        boolean recordUpdated = st.executeUpdate(query) > 0;
         
         if (recordUpdated){
         System.out.println("record updated");
         }
         else {
         System.out.println("record not updated");
         }
       
    }
    
    public void deleteUser(String ID) throws SQLException{
        //code for delete-operation
        
        String query = "delete from Users where ID= '" + ID + "' ";
        boolean recordDeleted = st.executeUpdate(query) > 0;
         
         if (recordDeleted){
         System.out.println("record deleted");
         }
         else {
         System.out.println("record not deleted");
         }
    }
}
