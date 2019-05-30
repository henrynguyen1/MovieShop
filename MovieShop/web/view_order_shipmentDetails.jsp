<%-- 
    Document   : view_order_shipment details
    Created on : 27/05/2019, 6:09:25 PM
    Author     : HenryNguyen
--%>

<%-- 
    Document   : ViewShipment
    Created on : 20/05/2019, 1:24:10 PM
    Author     : HenryNguyen
--%>
<%@page import="uts.web.model.*"%>
<%@page import="uts.web.controller.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" import="java.util.*" import="uts.web.model.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Shipments</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Shipment Options during Order Page</title>
    </head>
    
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phonenumber = request.getParameter("phone");
        User user = (User) session.getAttribute("user");
        Shipment shipment = (Shipment) session.getAttribute("shipment");
        Order order = (Order) session.getAttribute("order");
    %>
    <body>
         <div class="container-fluid" style="background-color: silver; height: 900px; width: 100%;">
             
              <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3"> Shipment History </h1>    
             </div>
            
             <div class="w-100">   
                 <div class="col bg-dark">
                 <nav class="navbar navbar-expand-lg navbar-dark" >
                     <a class="navbar-brand" href="./index.html">Movie Store</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                         <a class="nav-link" href="./index.html">HOME</a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link" href="">ABOUT</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">PRICES</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">CONTACT</a>
                        </li>
                        <li class="nav-item active">
                        <a class="nav-link" href="./login.jsp">MY ACCOUNT</a>
                        </li>
                    </ul>
                </div>
                 </nav>
                 
                 </div>
             </div>
         </div>
       
        <div class="col" style="text-align: center;" >
        
        </div>
    <body>
        
        
        
        
    <div class="container-fluid" style="background-color: silver; height: 2200px; width: 100%;">
             
        <form>
            <table class="table" border="1" cellpadding="5">
                
                <thead>
            <tr class="table-warning">
                
                <th scope = "col"> ID</th>
                <th scope = "col" >Order Date</th>
                <th scope = "col" >Order Details</th>
                <th scope = "col">Price</th>
                <th scope = "col">Tracking Number</th>
                <th scope = "col">Status</th>
            </tr>
                </thead>
            <c:forEach var="shipment" items="${listShipment}">
                <tr>
                    <td><c:out value="${shipment.shipID}" /></td>
                    <td><c:out value="${shipment.date}" /></td>
                    <td><c:out value="${shipment.email}" /></td>
                    <td><c:out value="${shipment.address}" /></td>
                    <td><c:out value="${order.movieID}" /></td>
                    <td><c:out value="${order.total}" /></td>
                    <td><c:out value="${shipment.trackingNo}" /></td>
                    <td><c:out value="${shipment.type}" /></td>
                    <td><c:out value="${shipment.status}" /></td>
                    <td>
                        <a href = "/modify?id=<c:out value= <%shipment.getShipID();%> /> ">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value= <%shipment.getShipID();%> />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
                 </table> 
             </div>
        </div>
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
             
       
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            
    </body>
</html>
