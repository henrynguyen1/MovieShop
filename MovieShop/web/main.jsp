<%-- 
    Document   : main
    Created on : 31/05/2019, 12:27:40 PM
    Author     : francobuena
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
        User user = (User)session.getAttribute("user");
        %>
            
        <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: bisque;">
               <div class="row" style="background-color: bisque;">
                   <div class="col mt-5" style="text-align: left;">
                         <h2> Hello, <%=user.getName()%>!</h2>
                         
                   </div>
               </div>   
            
        <div
        
        <h3> Hot Sellers</h3>
        
            <img src =" ./Picture/Ave.jpg" alt =" Avengers" style =" width: 150px;height:200px">
            <img src =" ./Picture/gD.jpg" alt =" Godzilla" style =" width: 150px;height:200px">
            <img src =" ./Picture/Mask.jpg" alt =" The Mask" style =" width: 150px;height:200px">
            <img src =" ./Picture/DD.jpg" alt =" Dumb and Dumber" style =" width: 150px;height:200px">
        
        </div>
                         
                         
                         <h4 align = "center">Genres</h4>
                         
                         
                         
                         
                         <div class="row" style="height:200px; width: 100%;">
                             <div class="col-2 mr-5 mt-3 ml-5 border border-primary bg-danger" style="color: white; ">
                                 <a class="nav-link"  href="./horror.jsp" style="font-size: 50px; align-content: center; text-align: center">Horror</a>
                             </div>
                             <div class="col-2 mr-5 mt-3 border border-primary bg-warning" style="color: white; ">
                                 <a class="nav-link" href="./comedy.jsp"style="font-size: 40px; align-content: center; text-align: center">Comedy</a>
                             </div>
                             <div class="col-2 mr-5 mt-3 border border-primary bg-success" style="color: white; ">
                                 <a class="nav-link" href="./drama.jsp" style="font-size: 50px; align-content: center; text-align: center">Drama</a>
                             </div>
                             <div class="col-2 mr-5 mt-3 border border-primary bg-info" style="color: white; ">
                                 <a class="nav-link" href="./action.jsp" style="font-size: 50px; align-content: center; text-align: center">Action</a>
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
        </div>
        
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
    </body>
</html>

     
