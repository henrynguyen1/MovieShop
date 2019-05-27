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
import uts.isd.model.dao.DBConnector;

import uts.web.model.Payment;

/**
 * Data Access Object (DAO) for payment-related queries.
 * Based on the "Preparing DAO Class" section of the following website:
 * https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
 * @author Ben Stevens (02078018)
 */
public class PaymentDAO {
    private final DBConnector DBCONN;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY;
    private final String PAYMENT_SELECT;
    private final String USER_SELECT;
    private final String DATE_SELECT;
    private final String USER_DATE_SELECT;

    /**
     * Default constructor which creates a DBConnector object send queries to
     * the payments table on the database.
     */
    public PaymentDAO() {
        INSERT_QUERY = "INSERT INTO payments (OrderID, UserID, Amount, Date,"
                + " Status, Type) VALUES (?, ?, ?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE payments SET OrderID = ?, UserID = ?, Amount = ?,"
                + " Date = ?, Status = ?, Type = ? WHERE PaymentID = ?";
        DELETE_QUERY = "DELETE FROM payments WHERE PaymentID = ?";
        PAYMENT_SELECT = "SELECT * FROM payments WHERE PaymentID = ?";
        USER_SELECT = "SELECT * FROM payments WHERE UserID = ?";
        DATE_SELECT = "SELECT * FROM payments WHERE Date = ?";
        USER_DATE_SELECT = "SELECT * FROM payments WHERE UserID = ? AND Date = ?";
        
        DBCONN = new DBConnector();
    }
    
    /**
     * Add a new payment to the database.
     * @param payment - payment data to be added to the database.
     * @return - integer indicating whether the payment has been added to
     *           the database. It will be set to either 0 or 1.
     * @throws SQLException - Connection to the database could not be created.
     */
    public int addNewPayment(Payment payment) throws SQLException {
        int rowInserted = 0;
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
        // Database fields to be inserted.
        ps.setInt(1, payment.getOrderID());
        ps.setInt(2, payment.getUserID());
        ps.setDouble(3, payment.getAmount());
        ps.setObject(4, payment.getDate());
        ps.setString(5, payment.getStatus());
        ps.setString(6, payment.getMethod());

        // Primary key will be autogenerated by the database.
        //ps.setInt(7, payment.getPaymentID());
        
        // Update the database and count how many rows were inserted.
        rowInserted = ps.executeUpdate();

        // Close PreparedStatement object then close the connection to the DB.
        ps.close();
        conn.close();
        
        return rowInserted;
    }
    
    /**
     * Update an existing payment in the database. A payment can only be updated
     * if it is in a SUBMITTED or SAVED state.
     * @param payment - payment to be amended.
     * @return - integer indicating whether the payment has been updated.
     *           It will be set to either 0 or 1.
     * @throws SQLException - connection to the database could not be created.
     */
    public int updatePayment(Payment payment) throws SQLException {
        int rowUpdated = 0;
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
        // Database fields to be updated.
        ps.setInt(1, payment.getOrderID());
        ps.setInt(2, payment.getUserID());
        ps.setDouble(3, payment.getAmount());
        ps.setObject(4, payment.getDate());
        ps.setString(5, payment.getStatus());
        ps.setString(6, payment.getMethod());

        // Primary key to search for.
        ps.setInt(7, payment.getPaymentID());
        
        // Only SUBMITTED or SAVED payments can be updated.
        if(payment.getStatus().equalsIgnoreCase("SUBMITTED") ||
                payment.getStatus().equalsIgnoreCase("SAVED")) {
            rowUpdated = ps.executeUpdate();
        } // else, don't update the row and rowUpdated remains at 0.

        // Close PreparedStatement object then close the connection to the DB.
        ps.close();
        conn.close();
        
        return rowUpdated;
    }
    
    /**
     * Delete an existing payment from the database. A payment can only be
     * deleted if it is in a SUBMITTED or SAVED state.
     * @param payment - payment to be deleted.
     * @return - integer indicating whether the payment has been deleted from
     *           the database. It will be set to either 0 or 1.
     * @throws SQLException - connection to the database could not be created.
     */
    public int deletePayment(Payment payment) throws SQLException {
        int rowDeleted = 0;
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);
        
        // Primary key to search for.
        ps.setInt(1, payment.getPaymentID());
        
        // Only SUBMITTED or SAVED payments can be deleted.
        if(payment.getStatus().equalsIgnoreCase("SUBMITTED") ||
                payment.getStatus().equalsIgnoreCase("SAVED")) {
            rowDeleted = ps.executeUpdate();
        } // else, don't delete the row and rowDeleted remains at 0.

        // Close PreparedStatement object then close the connection to the DB.
        ps.close();
        conn.close();
        
        return rowDeleted;
    }
    
    /**
     * Find a specific payment in the database.
     * @param paymentID - payment ID number to search for.
     * @return - payment data from the database.
     * @throws SQLException - connection to the database could not be created.
     */
    public Payment getPayment(int paymentID) throws SQLException {
        Payment payment = new Payment();
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(PAYMENT_SELECT);
        ps.setInt(1, paymentID);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            payment.setPaymentID(rs.getInt("PaymentID"));
            payment.setUserID(rs.getInt("UserID"));
            payment.setOrderID(rs.getInt("OrderID"));
            payment.setAmount(rs.getDouble("Amount"));
            payment.setDate(rs.getObject("Date", LocalDate.class));
            payment.setStatus(rs.getString("Status"));
            payment.setMethod(rs.getString("Type"));
        } // else, return new payment object.
        
        // Close ResultSet and PreparedStatement objects then close the
        // connection to the DB.
        rs.close();
        ps.close();
        conn.close();
        
        // Either found payment or new payment object.
        return payment;
    }

    /**
     * Find a user's entire payment history.
     * @param userID - user ID number to search for.
     * @return - list of payments made by user.
     * @throws SQLException - connection to the database could not be created.
     */
    public List<Payment> getPayments(int userID) throws SQLException {
        ArrayList<Payment> userPayments = new ArrayList<>();
        Payment nextPay = new Payment();
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(USER_SELECT);
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();

        // Construct the list using the recrods from the query results.
        while(rs.next()) {
            nextPay.setPaymentID(rs.getInt("PaymentID"));
            nextPay.setUserID(rs.getInt("UserID"));
            nextPay.setOrderID(rs.getInt("OrderID"));
            nextPay.setAmount(rs.getDouble("Amount"));
            nextPay.setDate(rs.getObject("Date", LocalDate.class));
            nextPay.setStatus(rs.getString("Status"));
            nextPay.setMethod(rs.getString("Type"));

            userPayments.add(nextPay);
        }
        
        // Close ResultSet and PreparedStatement objects then close the
        // connection to the DB.
        rs.close();
        ps.close();
        conn.close();
        
        // List of payments.
        return userPayments;
    }
    
    /**
     * Find all payments made on the specified date.
     * @param date - payment date to search for.
     * @return - list of payments made on the date.
     * @throws SQLException - connection to the database could not be created.
     */
    public List<Payment> getPayments(LocalDate date) throws SQLException {
        ArrayList<Payment> datePayments = new ArrayList<>();
        Payment nextPay = new Payment();
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(DATE_SELECT);
        ps.setObject(1, date);
        ResultSet rs = ps.executeQuery();

        // Construct the list using the recrods from the query results.
        while(rs.next()) {
            nextPay.setPaymentID(rs.getInt("PaymentID"));
            nextPay.setUserID(rs.getInt("UserID"));
            nextPay.setOrderID(rs.getInt("OrderID"));
            nextPay.setAmount(rs.getDouble("Amount"));
            nextPay.setDate(rs.getObject("Date", LocalDate.class));
            nextPay.setStatus(rs.getString("Status"));
            nextPay.setMethod(rs.getString("Type"));

            datePayments.add(nextPay);
        }
        
        // Close ResultSet and PreparedStatement objects then close the
        // connection to the DB.
        rs.close();
        ps.close();
        conn.close();
        
        // List of payments.
        return datePayments;
    }
    
    /**
     * Find all payments made on a specific date by a specific user.
     * @param userID - user ID to search for.
     * @param date - payment date to search for.
     * @return - list of payments made by a particular user on a specific date.
     * @throws SQLException - connection to the database could not be created.
     */
    public List<Payment> getPayments(int userID, LocalDate date) throws SQLException {
        ArrayList<Payment> userPayments = new ArrayList<>();
        Payment nextPay = new Payment();
        
        // Connect to DB and set query up.
        Connection conn = DBCONN.openConnection();
        PreparedStatement ps = conn.prepareStatement(USER_DATE_SELECT);
        ps.setInt(1, userID);
        ps.setObject(2, date);
        ResultSet rs = ps.executeQuery();
        
        // Construct the list using the recrods from the query results.
        while(rs.next()) {
            nextPay.setPaymentID(rs.getInt("PaymentID"));
            nextPay.setUserID(rs.getInt("UserID"));
            nextPay.setOrderID(rs.getInt("OrderID"));
            nextPay.setAmount(rs.getDouble("Amount"));
            nextPay.setDate(rs.getObject("Date", LocalDate.class));
            nextPay.setStatus(rs.getString("Status"));
            nextPay.setMethod(rs.getString("Type"));

            userPayments.add(nextPay);
        }
        
        // Close ResultSet and PreparedStatement objects then close the
        // connection to the DB.
        rs.close();
        ps.close();
        conn.close();
        
        // List of payments.
        return userPayments;
    }
}
