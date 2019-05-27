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
import uts.isd.model.dao.DBConnector;
import uts.web.model.dao.DBConnector;



/**
 *
 * @author henry117
 */

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
        INSERT_QUERY = "INSERT INTO shipments (email, address, name, type)"
                + " VALUES (?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE shipments SET email = ?, address = ?, name = ?, type = ?"
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


public int addShipment(Shipment shipment) throws SQLException{
    Connection connect = DBCONN.openConnection();  
    PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY); {
    pstmt.setString(1, shipment.getEmail());
    pstmt.setString(2, shipment.getName());
    pstmt.setString(3, shipment.getAddress());
    pstmt.setInt(4, shipment.getUserID());
    pstmt.setString(5, shipment.getType());
    pstmt.setString(6, shipment.getStatus());
    }
        int rowInserted = pstmt.executeUpdate();
        pstmt.close();
        disconnect();
        return rowInserted;

}

public int updateShipment(Shipment shipment) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
    int rowUpdated = 0;
        
    pstmt.setString(2, shipment.getEmail());
    pstmt.setString(2, shipment.getName());
    pstmt.setString(3, shipment.getAddress());
    pstmt.setString(6, shipment.getType());
    
    if (shipment.getStatus()=="SUBMITTED"){
    rowUpdated = pstmt.executeUpdate();
    }
    pstmt.close();
    disconnect();
    return rowUpdated; 

}
public int deleteShipment(Shipment shipment) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);
    int rowDeleted  = 0;
    pstmt.setInt(1,shipment.getShipID());
    
    if (shipment.getStatus()=="COMPLETED"){
       rowDeleted = pstmt.executeUpdate();
    }
    pstmt.close();
    disconnect();
    return rowDeleted;
}




public List<Shipment> listShipments()throws SQLException{
        List<Shipment> listShipment = new ArrayList<>();
        Connection connect = DBCONN.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(SHIPMENT_VIEW);
        ResultSet rst = pstmt.executeQuery();
         
        while (rst.next()) {
            int shipID = rst.getInt("book_id");
            String email = rst.getString("title");
            String address = rst.getString("address");
            String trackingNo = rst.getString("trackingNo");
            String name = rst.getString("name");
            int userID = rst.getInt("userID");
            String type = rst.getString("type");
            LocalDate date = rst.getObject("date", LocalDate.class);
            String status = rst.getString("status");;
             
            Shipment shipment = new Shipment(shipID);
                  
            listShipment.add(shipment);
        }
         
        rst.close();
        pstmt.close();
         
        disconnect();
         
        return listShipment;
    }
        
        
        
}





