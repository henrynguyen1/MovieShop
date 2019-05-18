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
    private final String URL = "jdbc:derby://localhost:1527/studentsdb";
    private final String DBUSER = "isduser"; 
    private final String DBPASS = "admin";
    private final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final Connection CONN;
    

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        CONN = DriverManager.getConnection(URL, DBUSER, DBPASS);
    }

    public Connection openConnection(){
        return this.CONN;
    }
    
    public void closeConnection() throws SQLException {
        this.CONN.close();
    }
}
