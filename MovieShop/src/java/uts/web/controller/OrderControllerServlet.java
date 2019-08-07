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
import javax.servlet.http.HttpSession;
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
         HttpSession session = request.getSession();
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
           String userID =request.getParameter("userID");
        //List<Order> listOrder = orderDAO.listAllOrder(userID);
         List<Order> listOrder = orderDAO.listAllOrder();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
    }
      
       private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
         //orderID, userID, movieID, status, date, price, total
          String orderID = request.getParameter("orderID");
        String userID = request.getParameter("userID");
        String movieID = request.getParameter("movieID");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String total = request.getParameter("total");
       
       
 
        Order order = new Order(orderID, userID, movieID, status, date, price, total);
        orderDAO.addOrder(order);
        response.sendRedirect("listOrder");
    }
       
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String orderID = request.getParameter("orderID");
        String userID = request.getParameter("userID");
        String movieID = request.getParameter("movieID");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        String price = request.getParameter("price");
        String total = request.getParameter("total");
       
 
        Order order = new Order(orderID, userID, movieID, status, date, price, total);
 
     
        orderDAO.updateOrder(order);
        response.sendRedirect("listOrder");
    }
 

}

