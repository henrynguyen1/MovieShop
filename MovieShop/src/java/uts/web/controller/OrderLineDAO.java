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
import java.util.Date;
import java.util.List;
import uts.web.model.Movie;
import uts.web.model.Order;
import uts.web.model.OrderLine;
import uts.web.model.dao.DBConnector;

/**
 *
 * @author yantoyanto
 */
public class OrderLineDAO {
    private final DBConnector DBCONN;
    private final String INSERT_QUERY;
    private final String DELETE_QUERY;
    private final String ORDER_SELECT;
    private final String ORDER_MOVIE_SELECT;
    
    
    public OrderLineDAO() {
        INSERT_QUERY = "INSERT INTO ORDERLINE_T(orderID, movieID, price) VALUES (?,?,?)";
        DELETE_QUERY = "DELETE FROM ORDERLINE_T where orderID = ? and movieID = ?" ;
        ORDER_SELECT = "SELECT * FROM ORDERLINE_T where orderID = ?";
        ORDER_MOVIE_SELECT = "SELECT * FROM ORDERLINE_T where orderID = ? and movieID = ?";
        DBCONN = new DBConnector();
    }
    
     
          
 
     public boolean addOrderLine(OrderLine orderLine) throws SQLException{
           
         Connection conn = DBCONN.openConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
       
         
         ps.setInt(1, orderLine.getOrderID());
         ps.setInt(2, orderLine.getMovieID());
         ps.setDouble(3, orderLine.getPrice());
         
         boolean rowInserted = ps.executeUpdate() > 0;
         ps.close();
        conn.close();
         return rowInserted;
     }
   
    
     
    public boolean deleteOrderLine(OrderLine orderLine) throws SQLException {
         
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
     
        ps.setInt(1, orderLine.getOrderID());
        ps.setInt(2, orderLine.getMovieID());
         
        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        conn.close();
        return rowDeleted;     
    }
    
    public List<OrderLine> listAllOrderLine(int orderID) throws SQLException {
        List<OrderLine> listOrder = new ArrayList<>();
        OrderLine orderLine = new OrderLine();
         
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(ORDER_SELECT);
        ps.setInt(1, orderID);
        ResultSet resultSet = ps.executeQuery();
         
        while (resultSet.next()) {
            orderLine.setOrderID(resultSet.getInt("orderID"));
            orderLine.setMovieID(resultSet.getInt("movieID"));
            orderLine.setPrice(resultSet.getDouble("price"));
            
            listOrder.add(orderLine);
        }
         
        resultSet.close();
        ps.close();
        conn.close();
         
        return listOrder;
    }
    
    public OrderLine getOrderLine(int orderid, int movieid) throws SQLException {
        OrderLine orderLine = new OrderLine();
         
        Connection conn = DBCONN.openConnection();
         
        PreparedStatement ps = conn.prepareStatement(ORDER_MOVIE_SELECT);
        ps.setInt(1, orderid);
        ps.setInt(2, movieid);
        ResultSet resultSet = ps.executeQuery();
         
        if (resultSet.next()) {
            int orderID = resultSet.getInt("orderID");
            int movieID = resultSet.getInt("movieID");
            double price = resultSet.getDouble("price");
             
            orderLine = new OrderLine(orderID, movieID, price);
        }
         
        resultSet.close();
        ps.close();
         
        return orderLine;
    }
}
