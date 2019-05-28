/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.web.model.Order;
import uts.web.model.OrderLine;
import uts.web.model.dao.DBConnector;
import uts.web.model.dao.DBManager;

/**
 *
 * @author yantoyanto
 */
public class OrderLineControllerServlet extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
    private Connection conn;
     private OrderLineDAO orderLineDAO;
     
     
     @Override
    public void init() {
        try {
            db = new DBConnector();
            orderLineDAO = new OrderLineDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShipmentControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShipmentControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }
    
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
     
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/add":
                addOrderLine(request, response);
                break;
            case "/update":
                deleteOrderLine(request, response);
                break;
            default:
                listOrderLine(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(OrderControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      private void listOrderLine(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
          int orderID = Integer.parseInt(request.getParameter("orderID"));
        List<OrderLine> listOrderLine = orderLineDAO.listAllOrderLine(orderID);
        request.setAttribute("listOrderLine", listOrderLine);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
    }
      
       private void addOrderLine(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
         
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int movieID = Integer.parseInt(request.getParameter("movieID"));
        
        double price = Double.parseDouble(request.getParameter("price"));
 
        OrderLine orderLine = new OrderLine(orderID, movieID, price);
        orderLineDAO.addOrderLine(orderLine);
        response.sendRedirect("listOrderLine");
    }
       
     private void deleteOrderLine(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int movieID = Integer.parseInt(request.getParameter("movieID"));
          double price = Double.parseDouble(request.getParameter("price"));
 
        OrderLine orderLine = new OrderLine(orderID, movieID, price);
        orderLineDAO.deleteOrderLine(orderLine);
        response.sendRedirect("listOrderLine");
 
    }
 
}
