<%@page import="uts.web.model.OrderLine"%>
<%@page import="uts.web.model.Movie"%>
<%@page import="uts.web.model.Order"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        <h2>Order</h2>
        </div>
             
        
               
                
        
        <div class="container" style="background-color: white; height: 600px;">
        <form action="./save_order.jsp" method="post">
            <table class="table">
                <thead>
                <tr class="table-warning">
                    <th></th>
                    <th scope="col">Item</th>
                    <th scope="col">Price</th>
                    <th scope="col">Total</th>
                    <th></th>
                </tr>
                </thead>
                  <tr><td>Order ID:</td><td><input size="23" type="text" name="orderID"></td></tr>
                <tr><td>Movie ID:</td><td><input size="23" type="text" name="movieID"></td></tr>
                <tr><td>Price</td><td><input size="23" type="number" name="price"></td></tr>
                <tr>
                    <c:forEach var="ol" items="${listOrderLine}">
                     <td><c:out value="${ol.orderID}" /></td>
                     <td><c:out value="${ol.movieID}"/></td>
                     <td><c:out value="${ol.price}"/></td>
                    </c:forEach>          
                </tr>
               
            </table>
        
            <div class="col" style="text-align: right;">
                <input class="btn btn-warning" value="Save"type="submit" onclick="location.href = 'order_save.jsp'"/>
                        &nbsp;&nbsp;&nbsp;
                <a class="btn btn-warning" href="./shipment.jsp">Proceed to Shipment</a>
                
            </div>
           </form>             
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
