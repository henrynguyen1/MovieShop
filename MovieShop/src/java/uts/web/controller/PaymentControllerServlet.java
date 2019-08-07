///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uts.web.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.time.LocalDate;
//
////import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import uts.web.model.Payment;
///**
// * Servlet for sending data between Payment JSPs model class.
// * Based on the CRUD example supplied on UTS Online.
// * (https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example)
// * @author Ben Stevens (02078018)
// */
//public class PaymentControllerServlet extends HttpServlet {
//    
//    private static final long serialVersionUID = 1L;
//    private final PaymentDAO PDAO = new PaymentDAO();
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param req servlet request
//     * @param res servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        String action = req.getServletPath();
//        
//        try {
//            if(action.equalsIgnoreCase("/new")) {
//                showNewPaymentForm(req, res);
//            }
//            else if(action.equalsIgnoreCase("/insert")) {
//                insertPayment(req, res);
//            }
//            else if(action.equalsIgnoreCase("/delete")) {
//                deletePayment(req, res);
//            }
//            else if(action.equalsIgnoreCase("/edit")) {
//                deletePayment(req, res);
//            }
//            else if(action.equalsIgnoreCase("/update")) {
//                deletePayment(req, res);
//            }
//            else if(action.equalsIgnoreCase("/confirm")) {
//                deletePayment(req, res);
//            }
//            else { // list all payments for user
//                listPayments(req, res);
//            }
//            /*switch(action) {
//                case "/new":
//                    showNewPaymentForm(req, res);
//                    break;
//                case "/insert":
//                    insertPayment(req, res);
//                    break;
//                case "/delete":
//                    deletePayment(req, res);
//                    break;
//                case "/edit":
//                    showEditPaymentForm(req, res);
//                    break;
//                case "/update":
//                    updatePayment(req, res);
//                    break;
//                case "/confirm":
//                    showConfirmPage(req, res);
//                    break;
//                default:
//                    listPayments(req, res);
//                    break;
//            }*/
//        }
//        catch (SQLException sqle) {
//            throw new ServletException(sqle);
//        }
//        
//        //response.setContentType("text/html;charset=UTF-8");
//        //try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            /*out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PaymentControllerServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PaymentControllerServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }*/
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param req servlet request
//     * @param res servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        processRequest(req, res);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param req servlet request
//     * @param res servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        processRequest(req, res);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//    
//    private void listPayments(HttpServletRequest req, HttpServletResponse res)
//            throws SQLException, IOException, ServletException {
//        //int userID = Integer.parseInt(req.getParameter("userid"));
//        int userID = 1;
//        ArrayList<Payment> paymentList = PDAO.getPayments(userID);
//        //boolean paymentsAdded = paymentList.addAll(PDAO.getPayments(userID));
//        req.setAttribute("paymentList", paymentList);
//        RequestDispatcher rd = req.getRequestDispatcher("payment_history.jsp");
//        rd.forward(req, res);
//    }
//    
//    private void showNewPaymentForm(HttpServletRequest req, HttpServletResponse res)
//            throws IOException, ServletException {
//        RequestDispatcher rd = req.getRequestDispatcher("new_payment.jsp");
//        rd.forward(req, res);
//    }
//    
//    private void showConfirmPage(HttpServletRequest req, HttpServletResponse res)
//            throws SQLException, IOException, ServletException {
//        int payID = Integer.parseInt(req.getParameter("payid"));
//        Payment existingPayment = PDAO.getPayment(payID);
//        RequestDispatcher rd = req.getRequestDispatcher("confirm_payment.jsp");
//        req.setAttribute("payment", existingPayment);
//        rd.forward(req, res);
//    }
//    
//    private void showEditPaymentForm(HttpServletRequest req, HttpServletResponse res)
//            throws SQLException, IOException, ServletException {
//        int payID = Integer.parseInt(req.getParameter("payid"));
//        Payment existingPayment = PDAO.getPayment(payID);
//        RequestDispatcher rd = req.getRequestDispatcher("new_payment.jsp");
//        req.setAttribute("payment", existingPayment);
//        rd.forward(req, res);
//    }
//    
//    private void insertPayment(HttpServletRequest req, HttpServletResponse res)
//            throws SQLException, IOException, ServletException {
//        //int payID = Integer.parseInt(req.getParameter("payid"));
//        int orderID = Integer.parseInt(req.getParameter("orderid"));
//        int userID = Integer.parseInt(req.getParameter("userid"));
//        double amount = Double.parseDouble(req.getParameter("amount"));
//        LocalDate date = LocalDate.parse(req.getParameter("date"));
//        String type = req.getParameter("method");
//        String status = req.getParameter(req.getParameter("status"));
//        
//        Payment p = new Payment(orderID, userID, amount, type, date, status);
//        int pIns = PDAO.addNewPayment(p);
//        // TODO: What happens if the row isn't updated?
//        res.sendRedirect("confirm");
//    }
//    
//    private void updatePayment(HttpServletRequest req, HttpServletResponse res)
//        throws SQLException, IOException, ServletException {
//        int payID = Integer.parseInt(req.getParameter("payid"));
//        int orderID = Integer.parseInt(req.getParameter("orderid"));
//        int userID = Integer.parseInt(req.getParameter("userid"));
//        double amount = Double.parseDouble(req.getParameter("amount"));
//        LocalDate date = LocalDate.parse(req.getParameter("date"));
//        String type = req.getParameter("method");
//        String status = req.getParameter(req.getParameter("status"));
//        
//        Payment p = new Payment(payID, orderID, userID, amount, type, date, status);
//        int pUp = PDAO.updatePayment(p);
//        // TODO: What happens if the row isn't updated?
//        res.sendRedirect("confirm");
//    }
//    
//    private void deletePayment(HttpServletRequest req, HttpServletResponse res)
//        throws SQLException, IOException, ServletException {
//        int payID = Integer.parseInt(req.getParameter("payid"));
//        
//        Payment p = PDAO.getPayment(payID);
//        int pDel = PDAO.deletePayment(p);
//        res.sendRedirect("new");
//    }
//}