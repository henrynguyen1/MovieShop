package uts.web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Initiate connection with the JDBC derby database and initialize
 * the super class conn field.
 * Based on the "Preparing DAO Class" section of the following website:
 * https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
 * @author George and Ben Stevens (02078018)
 */
public class DBConnector extends DB {
    
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL, dbuser, dbpass);
    }

    public Connection openConnection() {        
        return this.conn;
    }

    public void closeConnection() throws SQLException {
            this.conn.close();
    }
}
