///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uts.web.model.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import uts.web.model.Order;
//
//
///**
// *
// * @author yantoyanto
// */
//public class OrderDAO {
//    private final DBConnector DBCONN;
//    private Connection conn;
//    private final String INSERT_QUERY;
//    private final String UPDATE_QUERY;
//    private final String DELETE_QUERY;
//    private final String PAYMENT_SELECT;
//
//    private final String DATE_SELECT;
//    private String sql;
//          
//     public OrderDAO() {
//        INSERT_QUERY = "INSERT INTO order (orderID, movieID, userID, trackingNo, status, date, price)"
//                + " VALUES (?, ?, ?, ?, ?)";
//        UPDATE_QUERY = "UPDATE payments SET movieID = ?, userID = ?, trackingNo = ?,  price= ?"
//                + " date = ?, status = ? WHERE orderID = ?";
//        DELETE_QUERY = "DELETE FROM payments WHERE orderID = ?";
//        PAYMENT_SELECT = "SELECT * FROM payments WHERE orderID = ?";
//        
//        DATE_SELECT = "SELECT * FROM payments WHERE orderID = ?";
//        
//        DBCONN = new DBConnector();
//    }
//     
//       /**
//     * Add a new order to MovieStoreDB.
//     * @param order - order data to be added to DB.
//     * @return - Boolean indicating whether the order has been added to
//     *           MovieStoreDB.
//     * @throws SQLException - Connection to MovieStoreDB could not be created.
//     */
//    public boolean addNewOrder(Order order) throws SQLException {
//        boolean rowInserted = false;
//        
//        // TODO: Use INSERT_QUERY to create PreparedStatement object.
//        
//        return rowInserted;
//    }
//    
//    /**
//     * Update an existing order in MovieStoreDB. A payment can only be updated
//     * if it is in a SUBMITTED or SAVED state.
//     * @param order - payment to be amended.
//     * @return - boolean indicating whether the order has been updated.
//     * @throws SQLException - connection to MovieStoreDB could not be created.
//     */
//    public boolean updateOrder(Order order) throws SQLException {
//        boolean rowUpdated = false;
//        
//        // TODO: Use UPDATE_QUERY to create PreparedStatement object.
//
//        
//        return rowUpdated;
//    }
//    
//    /**
//     * Delete an existing order from MovieStoreDB. A payment can only be
//     * deleted if it is in a SUBMITTED or SAVED state.
//     * @param order - order to be deleted.
//     * @return - boolean indicating whether the order has been deleted from
//     *           MovieStoreDB.
//     * @throws SQLException - connection to MovieStoreDB could not be created.
//     */
//    public boolean deleteOrder(Order order) throws SQLException {
//        boolean rowDeleted = false;
//        
//        // TODO: Use DELETE_QUERY to create PreparedStatement object.
//        
//        return rowDeleted;
//    }
//    
//    /**
//     * Find a specific order in MovieStoreDB.
//     * @param orderID - order ID number to search for.
//     * @return - order data from MovieStoreDB.
//     * @throws SQLException - connection to MovieStoreDB could not be created.
//     */
//    public Order getPOrder(int orderID) throws SQLException {
//        Order order = null;
//        
//        // TODO: Use PAYMENT_SELECT to create PreparedStatement object.
//        
//        return order;
//    }
//
//  
//    
//}
