<%-- 
    Document   : add_shipment
    Created on : 31/05/2019, 10:47:19 PM
    Author     : HenryNguyen
--%>

<%@page import="uts.web.model.Shipment"%>
<%@page import="uts.web.model.dao.*"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <body>
       
        
        
        <div class="col" style="text-align: center;" >
        <h2>ADD SHIPMENT</h2>
        </div>
              <div class="container" style="background-color: white; height: 600px;">
        <form action="save_shipment.jsp" method="post">
            <table class="table">
              
                
                
                 <tr><td>Address:</td><td><input size="50" type="text" name="address"></td></tr>
                <tr><td>Type</td><td><input size="10" type="text" name="type"></td></tr>
                <tr><td>Status</td><td><input size="10" type="text" name="status"></td></tr>
                <tr><td>User ID</td><td><input size="9" type="text" name="userID"></td></tr>
                
                <input size="10" type="hidden" name="status" value="NOT SUBMITTED"/>
                
            </table>
        
            <div class="col" style="text-align: right;">
                <input class="btn btn-warning" value="Save Shipment" type="submit">
                        &nbsp;&nbsp;&nbsp;
                
                
            </div>
           </form>     
       
    </body>
</html>
