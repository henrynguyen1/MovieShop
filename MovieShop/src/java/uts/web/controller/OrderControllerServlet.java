/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author yantoyanto
 */
public class OrderControllerServlet extends HttpServlet{
    private OrderDAO orderDAO;
    
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
                addOrder(request, response);
                break;
            case "/update":
                updateOrder(request, response);
                break;
            default:
                listOrder(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(OrderControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      private void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listOrder = orderDAO.listAllOrder();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
    }
      
       private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
         
        int userID = Integer.parseInt(request.getParameter("userID"));
        int movieID = Integer.parseInt(request.getParameter("movieID"));
        String trackingNo = request.getParameter("trackingNo");
        String status = request.getParameter("status");
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        Date date = format.parse(request.getParameter("date"));
        
        double price = Double.parseDouble(request.getParameter("price"));
 
        Order order = new Order(userID, movieID, trackingNo, status, date, price);
        orderDAO.addOrder(order);
        response.sendRedirect("listOrder");
    }
       
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
         int userID = Integer.parseInt(request.getParameter("userID"));
        int movieID = Integer.parseInt(request.getParameter("movieID"));
        String trackingNo = request.getParameter("trackingNo");
        String status = request.getParameter("status");
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        Date date = format.parse(request.getParameter("date"));
        
        double price = Double.parseDouble(request.getParameter("price"));
 
        Order order = new Order(userID, movieID, trackingNo, status, date, price);
 
     
        orderDAO.updateOrder(order);
        response.sendRedirect("listOrder");
    }
 

}
