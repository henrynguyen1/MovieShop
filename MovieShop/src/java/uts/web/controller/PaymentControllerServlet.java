/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uts.web.model.Payment;
/**
 * Servlet for sending data between Payment JSPs model class.
 * Based on the CRUD example supplied on UTS Online.
 * (https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example)
 * @author Ben Stevens (02078018)
 */
public class PaymentControllerServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private final PaymentDAO PDAO = new PaymentDAO();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        //try {
            switch(action) {
                case "/new":
                    // TODO: show new_payment.jsp
                    break;
                case "/insert":
                    // TODO: add new payment to database
                    break;
                case "/delete":
                    // TODO: delete payment from database before it's finalised
                    break;
                case "/edit":
                    // TODO: show new_payment.jsp with payment preloaded
                    break;
                case "/update":
                    // TODO: update payment in database before it's finalised
                    break;
                default:
                    // TODO: get payment history for user
                    break;
            }
        //}
        /*catch (SQLException sqle) {
            throw new ServletException(sqle);
        }*/
        
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}