<%-- 
    Document   : save_order
    Created on : 29/05/2019, 3:46:04 PM
    Author     : yantoyanto
--%>

<%@page import="uts.web.model.OrderLine"%>
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
                     <a class="navbar-brand" href="./index.html">Movie Store</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                         <a class="nav-link" href="./index.html">HOME</a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link" href="#">ABOUT</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">PRICES</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">CONTACT</a>
                        </li>
                        <li class="nav-item ">
                        <a class="nav-link" href="./login.jsp">MY ACCOUNT</a>
                        </li>
                    </ul>
                </div>
                 </nav>
                 </div>
             </div>
        </div>
            
            
        <%
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        String movieID = request.getParameter("movieID");
        double price = Double.parseDouble(request.getParameter("price"));
        %>
            
        <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: bisque;">
               <div class="row" style="background-color: bisque;">
                   <div class="col mt-5" style="text-align: left;">
                         <h2> Your new details are now saved. </h2>
                         <table border="10" width="5" cellspacing="10">
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
                                     <td> Movie ID </td>
                                     <td> <%=movieID%> </td>
                                 </tr>
                                 <tr>
                                     <td> Price</td>
                                     <td> <%=price%> </td>
                                 </tr>
                                 
                                 
                             </tbody>
                         </table>

                   </div>
               </div>
           
            <button class="button" type="submit" onclick="location.href = 'order.jsp'"> Home </button>
            
         <%    
            //Activate the database add-function once DBManager functions are completed
            //DBManager manager = (DBManager)session.getAttribute("manager");
            OrderLine orderLine = new OrderLine(orderID, movieID, price);
            //manager.addStudent(ID, email, name, password, dob, favcol);
            session.setAttribute("orderLine",orderLine);
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
        
