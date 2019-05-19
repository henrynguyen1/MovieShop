/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uts.web.model.Payment;

/**
 * Data Access Object (DAO) for payment-related queries.
 * Based on the "Preparing DAO Class" section of the following website:
 * https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
 * @author Ben Stevens (02078018)
 */
public class PaymentDAO {
    private final DBConnector DBCONN;
    private Connection conn;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY;
    private final String PAYMENT_SELECT;
    private final String USER_SELECT;
    private final String DATE_SELECT;
    private String sql;

    /**
     * Default constructor which creates a DBConnector object send queries to
     * the payments table on MovieStoreDB.
     */
    public PaymentDAO() {
        INSERT_QUERY = "INSERT INTO payments (OrderID, UserID, Amount, Date, Status)"
                + " VALUES (?, ?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE payments SET OrderID = ?, UserID = ?, Amount = ?,"
                + " Date = ?, Status = ? WHERE PaymentID = ?";
        DELETE_QUERY = "DELETE FROM payments WHERE PaymentID = ?";
        PAYMENT_SELECT = "SELECT * FROM payments WHERE PaymentID = ?";
        USER_SELECT = "SELECT * FROM payments WHERE UserID = ?";
        DATE_SELECT = "SELECT * FROM payments WHERE PaymentID = ?";
        
        DBCONN = new DBConnector();
    }
    
    /**
     * Add a new payment to MovieStoreDB.
     * @param payment - payment data to be added to DB.
     * @return - Boolean indicating whether the payment has been added to
     *           MovieStoreDB.
     * @throws SQLException - Connection to MovieStoreDB could not be created.
     */
    public boolean addNewPayment(Payment payment) throws SQLException {
        boolean rowInserted = false;
        
        // TODO: Use INSERT_QUERY to create PreparedStatement object.
        
        return rowInserted;
    }
    
    /**
     * Update an existing payment in MovieStoreDB. A payment can only be updated
     * if it is in a SUBMITTED or SAVED state.
     * @param payment - payment to be amended.
     * @return - boolean indicating whether the payment has been updated.
     * @throws SQLException - connection to MovieStoreDB could not be created.
     */
    public boolean updatePayment(Payment payment) throws SQLException {
        boolean rowUpdated = false;
        
        // TODO: Use UPDATE_QUERY to create PreparedStatement object.

        
        return rowUpdated;
    }
    
    /**
     * Delete an existing payment from MovieStoreDB. A payment can only be
     * deleted if it is in a SUBMITTED or SAVED state.
     * @param payment - payment to be deleted.
     * @return - boolean indicating whether the payment has been deleted from
     *           MovieStoreDB.
     * @throws SQLException - connection to MovieStoreDB could not be created.
     */
    public boolean deletePayment(Payment payment) throws SQLException {
        boolean rowDeleted = false;
        
        // TODO: Use DELETE_QUERY to create PreparedStatement object.
        
        return rowDeleted;
    }
    
    /**
     * Find a specific payment in MovieStoreDB.
     * @param paymentID - payment ID number to search for.
     * @return - payment data from MovieStoreDB.
     * @throws SQLException - connection to MovieStoreDB could not be created.
     */
    public Payment getPayment(int paymentID) throws SQLException {
        Payment payment = null;
        
        // TODO: Use PAYMENT_SELECT to create PreparedStatement object.
        
        return payment;
    }

    /**
     * Find a user's entire payment history.
     * @param userID - user ID number to search for.
     * @return - list of payments made by user.
     * @throws SQLException - connection to MovieStoreDB could not be created.
     */
    public List<Payment> getPayments(int userID) throws SQLException {
        ArrayList<Payment> userPayments = null;
        
        // TODO: Use USER_SELECT to create PreparedStatement object.
        
        return userPayments;
    }
    
    /**
     * Find all payments made on the specified date.
     * @param date - user ID number to search for.
     * @return - list of payments made on the date.
     * @throws SQLException - connection to MovieStoreDB could not be created.
     */
    public List<Payment> getPayments(LocalDate date) throws SQLException {
        ArrayList<Payment> userPayments = null;
        
        // TODO: Use DATE_SELECT to create PreparedStatement object.
        
        return userPayments;
    }

}
