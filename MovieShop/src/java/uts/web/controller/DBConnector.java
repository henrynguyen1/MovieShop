package uts.web.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Initiate connection with the jdbc derby database and initialize
 * the super class conn field 
 * @author George and Ben
 */
public class DBConnector{
    private final String URL = "jdbc:derby://localhost:1527/studentsdb";
    private final String DBUSER = "isduser"; 
    private final String DBPASS = "admin";
    private final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private Connection conn;
    
    /**
     * Default constructor for creating connections to MovieStoreDB.
     */
    public DBConnector() {
    }

    /**
     * Open a connection to MovieStoreDB for CRUD operations.
     * @return - connection to MovieStoreDB.
     * @throws SQLException - No connections can be created if the DB is not
     *                        running.
     */
    protected Connection openConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException cnfe) {
            //connection to DB could not be created.
            throw new SQLException(cnfe);
        }
        conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
        return this.conn;
    }
    
    /**
     * Close the connection to MovieStoreDB when it is no longer needed.
     * @throws SQLException - Connection to MovieStoreDB not found.
     */
    protected void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            this.conn.close();
        }
    }
}
