package uts.web.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Initiate connection with the jdbc derby database and initialize the super class conn field
 * 
 * @author George
 */
public class DBConnector{
    private String URL = "jdbc:derby://localhost:1527/studentsdb";
    private String dbuser = "isduser"; 
    private String dbpass = "admin";
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private Connection conn;
    

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL, dbuser, dbpass);
    }

    public Connection openConnection(){
        return this.conn;
    }
    
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
