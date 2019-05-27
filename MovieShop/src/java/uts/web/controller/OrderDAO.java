/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import uts.web.model.Order;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author yantoyanto
 */
public class OrderDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    
    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
          
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
     protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
     public boolean addOrder(Order order) throws SQLException{
         String sql = "INSERT INTO Order_T(userID, movieID, trackingNo, status, date, price) VALUES (?,?,?,?,?,?)";
         connect();
         
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setInt(1, order.getUserID());
         statement.setInt(2, order.getOrderID());
         statement.setString(3, order.getTrackingNo());
         statement.setString(4, order.getStatus());
         statement.setObject(5, order.getDate());
         statement.setDouble(6, order.getPrice());
         
         boolean rowInserted = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowInserted;
     }
      
     public boolean updateOrder(Order order) throws SQLException{
         String sql = "UPDATE ORDER_T SET status = ?";
         
         connect();
         
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setString(4, order.getStatus());
         
         boolean rowUpdated = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowUpdated; 
     }
    
     /*
    public boolean deleteOrder(Order order) throws SQLException {
        String sql = "DELETE FROM ORDER_T where orderid = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }*/
    
    public List<Order> listAllOrder() throws SQLException {
        List<Order> listOrder = new ArrayList<>();
         
        String sql = "SELECT * FROM ORDER_T";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            int movieID = resultSet.getInt("movieID");
            String trackingNo = resultSet.getString("trackingNo");
            String status = resultSet.getString("status");
            Date date = resultSet.getDate("date");
            double price = resultSet.getDouble("price");
             
            Order order = new Order(userID, movieID, trackingNo, status, date,  price);
            listOrder.add(order);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listOrder;
    }
    
    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM ORDER_T WHERE orderID = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            int movieID = resultSet.getInt("movieID");
            String trackingNo = resultSet.getString("trackingNo");
            String status = resultSet.getString("status");
            Date date = resultSet.getDate("date");
            double price = resultSet.getDouble("price");
             
            order = new Order(userID, movieID, trackingNo, status, date,  price);
        }
         
        resultSet.close();
        statement.close();
         
        return order;
    }

  
    
}
 