/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.*;
import uts.web.model.*;
import java.time.*;
import java.util.*;


/**
 *
 * @author henry117
 */
public class ShipmentDAO {
    private Shipment shipment = new Shipment();
    private final DBConnector DBCONN;
    private Connection conn;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY;
    private final String SHIPMENT_SELECT;
    private final String USER_SELECT;
    private final String DATE_SELECT;
    private final String NAME_SELECT;
    private String sql;
    
    
    public ShipmentDAO(){
        INSERT_QUERY = "INSERT INTO shipmentss (shipID, email, name, movieID, trackingNo, totalPrice, userID, type, date, status)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE payments SET shipID = ?, UserID = ?, Amount = ?,"
                + " Date = ?, Status = ? WHERE PaymentID = ?";
        DELETE_QUERY = "DELETE FROM shipment WHERE ShipmentID = ?";
        SHIPMENT_SELECT = "SELECT * FROM shipment WHERE ShipmentID = ?";
        USER_SELECT = "SELECT * FROM shipment WHERE UserID = ?";
        DATE_SELECT = "SELECT * FROM shipment WHERE date = ?";
        NAME_SELECT = "SELECT * From shipment WHERE name = ?";
        
        DBCONN = new DBConnector();
    }
    protected void connect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

public final Shipment getShipment(Shipment shipment) { 
        return shipment ;
    }


public boolean AddShipment(Shipment shipment) throws SQLException{
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)) {
            pstmt.setString(1, shipment.getShipID());
            pstmt.setString(2, shipment.getEmail());
            pstmt.setString(3, shipment.getName());
            pstmt.setString(4, shipment.getTrackingNo());
            pstmt.setInt(5, shipment.getUserID());
            pstmt.setString(6, shipment.getStatus().toString());
            pstmt.setDouble(7, shipment.getProductPrice());
        }


}




}
