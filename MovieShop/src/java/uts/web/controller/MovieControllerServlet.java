/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import uts.web.model.*;
import uts.web.model.dao.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author zaain
 */
public class MovieControllerServlet extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
    private Connection conn;
    private MovieDAO movieDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override //Create and instance of DBConnector for the deployment session
    public void init() {
       db = new DBConnector();
       movieDAO = new MovieDAO();
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String action = request.getServletPath();
        try {
            switch (action) {
            case "/new":
                insertMovie(request, response);
                break;
            case "/update":
                updateMovie(request, response);
                break;
            case "/delete":
                deleteMovie(request, response);
                break;
            default:
                listMovie(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void insertMovie (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        String movieID = request.getParameter("movieID");   
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String duration = request.getParameter("duration");
        double price = Double.parseDouble(request.getParameter("price")); 
        
        
        Movie newMovie  = new Movie(movieID, title, genre, duration, price);
        MovieDAO dao = new MovieDAO();
        dao.addMovie(newMovie);
        
        
        response.sendRedirect("list");
        
       
    }
    private void updateMovie (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String movieID = request.getParameter("movieID");   
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String duration = request.getParameter("duration");
        double price = Double.parseDouble(request.getParameter("price")); 
        
        
        Movie newMovie  = new Movie(movieID, title, genre, duration, price);
        MovieDAO dao = new MovieDAO();
        dao.updateMovie(newMovie);
        
        
        response.sendRedirect("list");
    }
    private void deleteMovie (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        String movieID = request.getParameter("movieID");
        
        Movie newMovie = new Movie(movieID, "title", "genre", "duration", 0.00);
        MovieDAO dao = new MovieDAO();
        dao.deleteMovie(newMovie);
        response.sendRedirect("list");}
    
    private void listMovie (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Movie> listMovie = new ArrayList<>();
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("MovieSearch.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
     @Override //Destroy the servlet and release the resources of the application
    public void destroy() {
        try {
            db.closeConnection();
        }
        catch(SQLException sqle) {
            sqle.getStackTrace();
        }
    }
}