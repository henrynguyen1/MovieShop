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
enum ShipmentStatus {
    PROCESSING,
    DESPATCHED,
    TRANSIT,
    DELIVERED,
    
}
enum ShipmentType{
    STANDARD,
    EXPRESS,
    LOCALPICKUP,

}
public class ShipmentDAO {
    private final DBConnector DBCONN;
    private Connection conn;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY;
    private final String SHIPMENT_SELECT;
    private final String USER_SELECT;
    private final String DATE_SELECT;
    private final String NAME_SELECT;
    private final String SHIPMENT_VIEW;
    private String sql;
    
    
    public ShipmentDAO(){
        INSERT_QUERY = "INSERT INTO shipments (shipID, email, address, trackingNo, userID, type, date, status)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE shipments SET email = ?, address = ?, date = ?, name = ?, type = ?, status = ?"
                + " WHERE ShipmentID = ?";
        DELETE_QUERY = "DELETE FROM shipment WHERE ShipmentID = ?";
        SHIPMENT_SELECT = "SELECT * FROM shipment WHERE ShipmentID = ?";
        SHIPMENT_VIEW = "SELECT * FROM shipment";
        USER_SELECT = "SELECT * FROM shipment WHERE UserID = ?";
        DATE_SELECT = "SELECT * FROM shipment WHERE date = ?";
        NAME_SELECT = "SELECT * From shipment WHERE name = ?";
        
        DBCONN = new DBConnector();
    }
     
    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }


public boolean AddShipment(Shipment shipment) throws SQLException{
    Connection connect = DBCONN.openConnection();  
    PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY); {
    pstmt.setInt(1, shipment.getShipID());
    pstmt.setString(2, shipment.getEmail());
    pstmt.setString(2, shipment.getName());
    pstmt.setString(3, shipment.getAddress());
    pstmt.setString(4, shipment.getTrackingNo());
    pstmt.setInt(5, shipment.getUserID());
    pstmt.setObject(6, shipment.getType());
    pstmt.setObject(7, shipment.getDate());
    pstmt.setObject(8, shipment.getStatus());
    }
        
        boolean rowInserted = pstmt.executeUpdate() > 0;
        pstmt.close();
        disconnect();
        return rowInserted;

}

public boolean updateShipment(Shipment shipment) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
        
    pstmt.setInt(1, shipment.getShipID());
    pstmt.setString(2, shipment.getEmail());
    pstmt.setString(2, shipment.getName());
    pstmt.setString(3, shipment.getAddress());
    pstmt.setString(4, shipment.getTrackingNo());
    pstmt.setInt(5, shipment.getUserID());
    pstmt.setObject(6, shipment.getType());
    pstmt.setObject(7, shipment.getDate());
    pstmt.setObject(8, shipment.getStatus());
    
    boolean update = pstmt.executeUpdate() > 0;
        pstmt.close();
        disconnect();
        return update; 

}
public boolean deleteShipment(Shipment shipment) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);
    

}




public List<Shipment> ListShipments()throws SQLException{
        List<Shipment> listShipment = new ArrayList<>();
        Connection connect = DBCONN.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(SHIPMENT_VIEW);
        ResultSet rst = pstmt.executeQuery();
         
        while (rst.next()) {
            int shipID = rst.getInt("book_id");
            String email = rst.getString("title");
            String address = rst.getString("address");
            String trackingNo = rst.getString("trackingNo");
            int userID = rst.getInt("userID");
            ShipmentType type = rst.getObject("type", ShipmentType.class);
            LocalDate date = rst.getObject("date", LocalDate.class);
            ShipmentStatus status = rst.getObject("status", ShipmentStatus.class);;
             
            Shipment shipment = new Shipment();
            listShipment.add(shipment);
        }
         
        rst.close();
        pstmt.close();
         
        disconnect();
         
        return listShipment;
    }
        
        
        
}





