/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import uts.web.model.Movie;
import uts.web.model.Order;
import uts.web.model.Shipment;
import uts.web.model.dao.*;

/**
 *
 * @author zaain
 */
public class MovieDAO {
    private final DBConnector DBCONN;
    private Connection conn;
    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY; 
    private final String MOVIE_SELECT;
    private final String MOVIE_VIEW;
    private final String TITLE_SELECT; 
    private final String GENRE_SELECT; 
    private String sql; 
     
    public MovieDAO() {
        INSERT_QUERY = "INSERT INTO movies (movieID, title, genre, duration, price)"
                + " VALUES (?, ?, ?, ?, ?)";
        UPDATE_QUERY = "UPDATE movies SET email = ?, address = ?, date = ?, name = ?, type = ?, status = ?"
                + " WHERE movieID = ?";
        DELETE_QUERY = "DELETE FROM movie WHERE movieID = ?";
        MOVIE_SELECT = "SELECT * FROM movie WHERE movieID = ?";
        MOVIE_VIEW = "SELECT * FROM movie";
        TITLE_SELECT = "SELECT * FROM movie WHERE name = ?";
        GENRE_SELECT = "SELECT * FROM movie where genre = ?"; 
        DBCONN = new DBConnector(); 
        
    }
     protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        
     
 
    }
     
    public int addMovie(Movie movie) throws SQLException{
    Connection connect = DBCONN.openConnection();  
    PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY); {
    pstmt.setString(1, movie.getmovieID());
    pstmt.setString(2, movie.gettitle());
    pstmt.setString(2, movie.getgenre());
    pstmt.setString(3, movie.getduration());
    pstmt.setDouble(4, movie.getprice());
    }
        
        int rowInserted = pstmt.executeUpdate();
        pstmt.close();
        disconnect();
        return rowInserted;

}
    public int updateMovie(Movie movie) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
        
    pstmt.setString(1, movie.getmovieID());
    pstmt.setString(2, movie.gettitle());
    pstmt.setString(2, movie.getgenre());
    pstmt.setString(3, movie.getduration());
    pstmt.setDouble(4, movie.getprice());
    
    int update = pstmt.executeUpdate();
        pstmt.close();
        disconnect();
        return update;
     
    
}
    public int deleteMovie(Movie movie) throws SQLException {
    Connection connect = DBCONN.openConnection();    
    PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);
    int rowDeleted = 0;
    pstmt.setString(1, movie.getmovieID());
    return rowDeleted; 
    }
    
    public List<Movie> ListMovie()throws SQLException{
        List<Movie> listMovie = new ArrayList<>();
        Connection connect = DBCONN.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(MOVIE_VIEW);
        ResultSet rst = pstmt.executeQuery();
         
        while (rst.next()) {
            String movieID = rst.getString("movieID");
            String title = rst.getString("title");
            String genre = rst.getString("genre");
            String duration = rst.getString("duration");
            double price = rst.getDouble("price"); 
             
           Movie movie = new Movie(movieID, title, genre, duration, price);
            listMovie.add(movie);
        }
         
        rst.close();
        pstmt.close();
         
        disconnect();
         
        return listMovie;
    }
}

    
    
    
    
    
     