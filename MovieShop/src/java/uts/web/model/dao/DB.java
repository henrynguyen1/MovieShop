/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model.dao;
import java.sql.Connection;
/**
 *
 * @author francobuena
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/MovieDB";//replace empty-string with jdbc:derby local host url
    protected String db = "MovieDB";//name of the database
    protected String dbuser = "movieuser";//db root user
    protected String dbpass = "password"; //db root password
    protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}
