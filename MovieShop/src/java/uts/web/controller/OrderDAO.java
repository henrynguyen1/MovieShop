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
import uts.web.model.dao.DBConnector;
/**
 *
 * @author yantoyanto
 */
public class OrderDAO {
    private final DBConnector DBCONN;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String USER_SELECT;
    private final String ORDER_SELECT;

     
    
    public OrderDAO() {
        INSERT_QUERY = "INSERT INTO ORDER_T(userID, status, date, total) VALUES (?,?,?,?)";
        UPDATE_QUERY = "UPDATE ORDER_T SET status = ? where orderID = ?";
        USER_SELECT = "SELECT * FROM ORDER_T where userID = ?";
        ORDER_SELECT = "SELECT * FROM ORDER_T where orderID = ?";
        DBCONN = new DBConnector();
    }
     
     public boolean addOrder(Order order) throws SQLException{
         Connection conn = DBCONN.openConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
         
  
         ps.setInt(1, order.getUserID());

         ps.setString(2, order.getStatus());
         ps.setObject(3, order.getDate());
         ps.setDouble(4, order.getTotal());
         
         boolean rowInserted = ps.executeUpdate() > 0;
         ps.close();
         conn.close();
         return rowInserted;
     }
      
     public boolean updateOrder(Order order) throws SQLException{
         Connection conn = DBCONN.openConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
         
        
         ps.setString(2, order.getStatus());
         
         boolean rowUpdated = ps.executeUpdate() > 0;
         ps.close();
         conn.close();
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
    
    public List<Order> listAllOrder(int orderID) throws SQLException {
        List<Order> listOrder = new ArrayList<>();
         
         Connection conn = DBCONN.openConnection();
         PreparedStatement ps = conn.prepareStatement(USER_SELECT);
         
        ps.setInt(1, orderID);
        ResultSet resultSet = ps.executeQuery();
         
        while (resultSet.next()) {
            orderID = resultSet.getInt("orderID");
            int userID = resultSet.getInt("userID");
            String status = resultSet.getString("status");
            Date date = resultSet.getDate("date");
            double total = resultSet.getDouble("total");
             
            Order order = new Order(orderID, userID, status, date, total);
            listOrder.add(order);
        }
         
        resultSet.close();
        ps.close();
         
        conn.close();
         
        return listOrder;
    }
    
    public Order getOrder(int orderID) throws SQLException {
        Order order = null;
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(ORDER_SELECT);
    
         
        
        ps.setInt(1, orderID);
         
        ResultSet resultSet = ps.executeQuery();
         
        if (resultSet.next()) {
            orderID = resultSet.getInt("orderID");
            int userID = resultSet.getInt("userID");
            String status = resultSet.getString("status");
            Date date = resultSet.getDate("date");
            double total = resultSet.getDouble("total");
             
            order = new Order(orderID, userID, status, date, total);
        }
         
        resultSet.close();
        ps.close();
         
        return order;
    }

  
    
}
 