<%-- 
    Document   : horror
    Created on : 31/05/2019, 2:42:26 PM
    Author     : HenryNguyen
--%>

<%@page import="uts.web.model.dao.*"%>
<%@page import="uts.web.controller.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" import="java.util.*" import="uts.web.model.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Welcome Page</title>
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
                         <a class="nav-link" href="./main.jsp">HOME</a>
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
                        <a class="nav-link" href="./accountmanagement.jsp">ACCOUNT MANAGEMENT</a>
                        </li>
                        <li class="nav-item ">
                        <a class="nav-link" href="./shipment_detail.jsp.jsp">SHIPMENTS</a>
                        </li>
                        <li class="nav-item ">
                        <a class="nav-link" href="./saved_orders.jsp">SAVED ORDERS</a>
                        </li>
                    </ul>
                </div>
                 </nav>
                 
                 </div>
             </div>
        </div>
            
        <% 
        User user = (User)session.getAttribute("userLogin");
        %>
           
        <h1 align = "center "> Horror Films</h1>
        
        <div>
            <img src="./Picture/Ins.jpg" alt="Insidious" style=width:150px;height:200px;">
             <a class="nav-link" href="InsidiousDetails.jsp">Insidious</a>
             <img src="./Picture/Omen.jpg" alt="Omen" style=width:150px;height:200px;"> 
             <a class="nav-link" href="The OmenDetails.jsp">The Omen</a> 
            
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
    
</html>
