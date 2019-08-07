<%-- 
    Document   : save_order
    Created on : 29/05/2019, 3:46:04 PM
    Author     : yantoyanto
--%>

<%@page import="java.sql.Connection"%>
<%@page import="uts.web.model.dao.DBConnector"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uts.web.model.Order"%>
<%@page import="uts.web.model.dao.DBManager"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Saved Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid" style="background-color: silver; height: 900px; width: 100%;">
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3"> Welcome to Movie Store! </h1>    
             </div>
            
             <div class="w-100">   
                 <div class="col bg-dark">
                 <nav class="navbar navbar-expand-lg navbar-dark" >
                     <a class="navbar-brand" href="MovieCatalogueManagement.jsp">Movie Catalogue </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                         <a class="nav-link" href="./main.jsp">HOME</a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link" href="#">ABOUT</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="order.jsp">ORDER</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="payment_history.jsp">PAYMENTS</a>
                        </li>
                        <li class="nav-item ">
                        <a class="nav-link" href="accountmanagement.jsp">ACCOUNT MANAGEMENT</a>
                        </li>
                        <li class="nav-item ">
                        <a class="nav-link" href="add_shipment.jsp">SHIPMENTS</a>
                        </li>                        
                    </ul>
                </div>
                 </nav>
                 
                 </div>
             </div>
        </div>
            
            
        <%
            //int orderID, String userID, String movieID, String status, String date, double price, double total
        int ID = (new Random()).nextInt(999999);
        String orderID = "" + ID;
        String userID = request.getParameter("userID");
        String movieID = request.getParameter("movieID");
        String status = request.getParameter("status");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        String date = localDate.format(formatter);
        String price = request.getParameter("price");
        String total = price;
        %>
            
        <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: bisque;">
               <div class="row" style="background-color: bisque;">
                   
                       <div class="col">
                         <h2> Your order has been saved! Thank you!</h2>
                     
                   </div>
               </div>
                   <div class="row">
                       <div class="col">
                         <table class="table">
                             <thead>
                                 <tr>
                                     <th>Order Information </th>
                                     <th> Data </th>
                                 </tr>
                             </thead>
                             <tbody>
                          
                                 <tr>
                                     <td> Order ID </td>
                                     <td> <%=orderID%> </td>
                                 </tr>
                                 <tr>
                                     <td>Email Address</td>
                                     <td><%=userID%></td>
                                 </tr>
                                 <tr>
                                     <td> Movie Title </td>
                                     <td> <%=movieID%> </td>
                                 </tr>
                                 <tr>
                                     <td> Price</td>
                                     <td> <%=price%> </td>
                                 </tr>
                                 <tr>
                                     <td>Order Saved</td>
                                     <td><%=date%></td>
                                 </tr>
                                 
                                 
                                 
                                
                             </tbody>
                         </table>
                       </div>
                   </div>
                                 <div class="row">
                                     <div class="col">
                                          <button class="btn btn-danger" type="submit" onClick="location.href ='cancel_order.jsp'">Delete Order</button>
                                          <button class="btn btn-warning" type="submit" onclick="location.href = 'main.jsp'"> Back to Main </button>
                                        
                                     </div>
                                 </div>
              
            
           
            
            
         <%    
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);
            session.setAttribute("manager", db);
            DBManager manager = (DBManager)session.getAttribute("manager");
            Order order = new Order(orderID, userID, movieID, status, date, price, total);
            manager.addOrder(orderID, userID, movieID, status, date, price, total);
            session.setAttribute("order",order);
        %>
        
          
             
            <div class="fixed-bottom" style="background-color: orange; ">
            <div class ="row">
               
                <div class="col-sm-1 ">
                    <a>We accept: </a>
                </div>
                <div class="col-lg-8 col-sm">
                    <img  title="mastercard" src="./Picture/master.jpg">
                    <img  title="visa" src="./Picture/visa.png">
                    <img  title="paypal" src="./Picture/paypal.png">
                </div>
                 <div class="col-sm">
                    <h3 style="font-size:20px">© MOVIE STORE 2019</h3>
                </div>
                
            </div>
            </div>
        </div>
