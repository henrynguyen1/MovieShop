package uts.web.controller;


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
public class DBConnector{
    private final String URL;
    private final String DBUSER;
    private final String DBPASS;
    private final String DRIVER;
    private Connection conn;
    
    /**
     * Default constructor for creating connections to MovieShopDB.
     */
    public DBConnector() {
        URL = "jdbc:derby://localhost:1527/MovieShopDB";
        DBUSER = "movieshop"; 
        DBPASS = "movieshop";
        DRIVER = "org.apache.derby.jdbc.ClientDriver";
        conn = null;
    }

    /**
     * Open a connection to MovieShopDB for CRUD operations.
     * @return - connection to MovieShopDB.
     * @throws SQLException - No connections can be created if the DB is not
     *                        running.
     */
    protected Connection openConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
        }
        catch (ClassNotFoundException cnfe) {
            //connection to DB could not be created.
            throw new SQLException(cnfe);
        }
        return this.conn;
    }
    
    /**
     * Close the connection to MovieShopDB when it is no longer needed.
     * @throws SQLException - Connection to MovieShopDB not found.
     */
    protected void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            this.conn.close();
        }
    }
}
