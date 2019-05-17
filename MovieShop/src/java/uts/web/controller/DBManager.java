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
    private Statement st;

 

public DBManager(Connection conn) throws SQLException {

st = conn.createStatement();

}
    
}
