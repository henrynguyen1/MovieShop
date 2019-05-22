/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.*;

/**
 *
 * @author HenryNguyen
 */
public class DBManager {
    private final Statement STATEMENT;
    private final DBConnector DBCONN;
    private final Connection CONN;
    private ResultSet resSet;
    private String query;
    
    /*
     * Constructor using default connection from DBConnector class.
     */
    public DBManager() throws ClassNotFoundException, SQLException {
        DBCONN = new DBConnector();
        CONN = DBCONN.openConnection();
        STATEMENT = CONN.createStatement();
    }

    public DBManager(Connection conn) throws ClassNotFoundException, SQLException {
        CONN = conn;
        STATEMENT = CONN.createStatement();
        DBCONN = new DBConnector();
    }
    
}
