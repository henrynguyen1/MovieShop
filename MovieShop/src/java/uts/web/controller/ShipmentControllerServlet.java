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
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * ControllerServlet.java
 * Servlet for sending data between Shipment JSPs and corresponding model class.
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author henry117
 */
public class ShipmentControllerServlet extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
    private Connection conn;
    private ShipmentDAO shipmentDAO;
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
       shipmentDAO = new ShipmentDAO();
    }
    
     /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                insertShipment(request, response);
                break;
            case "/modify":
                modifyShipment(request, response);
                break;
            case "/delete":
                deleteShipment(request, response);
                break;
            default:
                listShipments(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

   
    private void insertShipment (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        String email = request.getParameter("email");   
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        
        
        Shipment newShipment  = new Shipment(email, address,  name, type);
        ShipmentDAO dao = new ShipmentDAO();
        dao.addShipment(newShipment);
        
        
        response.sendRedirect("list");
        
       
    }
    
    private void modifyShipment (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");   
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        
        
        Shipment newShipment  = new Shipment(email, address,  name, type);
        ShipmentDAO dao = new ShipmentDAO();
        dao.updateShipment(newShipment);
        
        
        response.sendRedirect("list");
    }
   
    private void deleteShipment (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        int shipID = Integer.parseInt(request.getParameter("shipID"));
        
        Shipment shipment = new Shipment(shipID);
        ShipmentDAO dao = new ShipmentDAO();
        dao.deleteShipment(shipment);
        response.sendRedirect("list");}
    
    private void listShipments (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Shipment> listShipment = new ArrayList<>();
        request.setAttribute("listShipment", listShipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewShipment.jsp");
        dispatcher.forward(request, response);
    }
    
    

    
    @Override //Destroy the servlet and release the resources of the application
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ShipmentControllerServlet.class.getName()).log(Level.SEVERE, null, ex);

           }

       }
}

