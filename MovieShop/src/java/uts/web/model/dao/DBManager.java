package uts.web.model.dao;

import java.sql.*;
import uts.web.model.Movie;
import uts.web.model.Order;
import uts.web.model.Shipment;
import uts.web.model.User;
import java.util.*;

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
    
    /**
     * author Zaain
     * @param movieID
     * @param title
     * @param genre
     * @param duration
     * @param price
     * @throws SQLException 
     */
    
    public void addMovie(String movieID, String title, String genre, String duration, String price) throws SQLException{
        String query = "insert into MOVIE" + " values ('" + movieID + "', '" + title + "', '" + genre + "', '" + duration + "', '" + price + "')";
         boolean recordCreated = st.executeUpdate(query) > 0;
                
         if (recordCreated){
         System.out.println("record created");
         }
         else {
         System.out.println("record not created");
         }
         
    }
    
    /*
    author Yanto
    */
    
    public Order findOrder(String userID) throws SQLException {
        //setup the select sql query string
        String query = "SELECT * from ORDER_T where userID = '" + userID + "' AND status != 'CANCELLED'";
        //execute this query using the statement field
       //add the results to a ResultSet
         ResultSet rs = st.executeQuery(query);
        //search the ResultSet for a student using the parameters
         boolean hasOrder = rs.next();
         Order orderFromDB = null;
                 
         if(hasOrder){
         //int orderID, String userID, String status, Date date, double total
             String orderID = rs.getString("orderID");
             String uID = rs.getString("userID"); 
             String movieID = rs.getString("movieID");
             String status = rs.getString("status");
             String date = rs.getString("date");
             String price = rs.getString("price");
             String total = rs.getString("total");
            //int orderID, String userID, String movieID, String status, String date, double price, double total
             orderFromDB = new Order (orderID, uID, movieID, status, date, price, total);
         }
        
         rs.close();
        // st.close();
         
         return orderFromDB;
    }
        
         public void addOrder(String ID, String userID, String movieID, String status, String date, String price, String total) throws SQLException {        
        //code for add-operation
        
         String query = "insert into ORDER_T" + " values ('" + ID + "', '" + userID + "', '" + movieID + "', '"+ status + "', '" + date + "', '" + price + "', '" + total + "')";
         boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record created");
         }
         else {
         System.out.println("record not created");
         }
             
    }
           public void updateOrder(String ID, String status) throws SQLException {        
        //code for add-operation
        
         String query = "UPDATE ORDER_T SET status = '" + status + "'" +  " where userID = '" + ID + "'";
         boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record updated");
         }
         else {
         System.out.println("record not updated");
         }
      }
          public void movieTitle(String ID, String movieID) throws SQLException{
               String query ="UPDATE ORDER_T SET movieID = '" + movieID + "'" + " where userID = '" + ID + "'";
               boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record updated");
         }
         else {
         System.out.println("record not updated");
         }
           }
          
          public void addShipment(String shipID, String address,  String type, String trackingNo, String userID, String status) throws SQLException {        
        //code for add-operation
        
         String query = "insert into SHIPMENT" + " values ('" + shipID + "', '" + address + "', '" + type + "', '"+ trackingNo + "', '" + userID + "', '" + status +"')";
         boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record created");
         }
         else {
         System.out.println("record not created");
         }

    
        }
          
          public Shipment listShipments()throws SQLException{
          
          
          String query = "SELECT * FROM shipment";
          ResultSet resultSet = st.executeQuery(query);
          boolean hasShip = resultSet.next();
          Shipment shipFromDB = null;
          
          while(resultSet.next()){
          String shipID = resultSet.getString("shipID"); 
          String address= resultSet.getString("address");
          String type= resultSet.getString("type"); 
          String trackingNo= resultSet.getString("trackingNo");
          String userID= resultSet.getString("userID");
          String status= resultSet.getString("status");
          Shipment shipment =  new Shipment( shipID, address,  type, status, trackingNo, userID);
          shipFromDB =  new Shipment( shipID, address,  type, status, trackingNo, userID);
          
          
          }
          resultSet.close();
          return shipFromDB;
          
          }
          
          
          
        public Shipment findShipment(String userID) throws SQLException {
        //setup the select sql query string
        String query = "SELECT * from SHIPMENT where userID = '" + userID + "' AND status != 'SUBMITTED'";
        //execute this query using the statement field
       //add the results to a ResultSet
         ResultSet resultSet = st.executeQuery(query);
        //search the ResultSet for a student using the parameters
         boolean hasShip = resultSet.next();
         Shipment shipFromDB = null;
                 
         if(hasShip){
         //int orderID, String userID, String status, Date date, double total
           String shipID = resultSet.getString("shipmentID"); 
          String address= resultSet.getString("address");
          String type= resultSet.getString("type"); 
          String trackingNo= resultSet.getString("trackingNo");
          String ID= resultSet.getString("userID");
          String status= resultSet.getString("status");
            //int orderID, String userID, String movieID, String status, String date, double price, double total
             shipFromDB =  new Shipment( shipID, address,  type, status, trackingNo, userID);
         }
        
         resultSet.close();
        
         
         return shipFromDB;
    }
          public void updateShipment(String address, String type) throws SQLException {        
        
         String query = "UPDATE SHIPMENT SET status = '" + address+ "'" +  " where shipmentID = '" + type + "'";
         boolean recordCreated = st.executeUpdate(query) > 0;
         
         if (recordCreated){
         System.out.println("record updated");
         }
         else {
         System.out.println("record not updated");
         }
          
          }
}
