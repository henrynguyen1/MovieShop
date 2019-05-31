<%-- 
    Document   : new_payment
    Created on : 18/05/2019, 10:41:39 PM
    Author     : Ben Stevens (02078018)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="uts.web.model.Payment" %>
<%@page import="uts.web.controller.PaymentControllerServlet" %>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Pay For Order</title>
        <meta http-equiv="Content-Type" content="text/html">
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
            
            
            <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: lightgray;">
               <div class="row" style="background-color: lightgray;">
                   <div class="col mt-5" style="text-align: left;">
                         <h2> How would you like to pay for your order? </h2>
                   </div>
               </div>
                <br>
                <c:if test="${payment != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${payment == null}">
                    <form action="insert" method="post">
                </c:if>
                <c:if test="${payment != null}">
                    <input type="hidden" name="payid" value="<c:out value='${payment.getPaymentID().toString()}' />" disabled />
                    <input type="hidden" name="date" value="<c:out value='${payment.getDate().toString()}' />" disabled />
                    <input type="hidden" name="userid" value="<c:out value='${payment.getUserID().toString()}' />" disabled />
                    <input type="hidden" name="status" value="<c:out value='${payment.getStatus()}' />" disabled />
                </c:if>
                <c:if test="${payment == null}">
                    <input type="hidden" name="userid" value="from shipment page" disabled />
                </c:if>
                <table>
                <tr></tr>
                    <tr>
                        <td>Order ID:</td>
                        <td>
                            <c:if test="${payment != null}">
                                <input type="text" name="orderid" value="<c:out value='${payment.getOrderID()}' />" disabled />
                            </c:if>
                            <c:if test="${payment == null}">
                                <input type="text" name="orderid" value="from shipment page" disabled />
                            </c:if>    
                    </tr>
                    <tr>
                        <td>Amount($):</td>
                        <td>
                            <c:if test="${payment != null}">
                                <input type="text" name="amount" value="<c:out value='${payment.getAmount().toString()}' />" disabled />
                            </c:if>
                            <c:if test="${payment == null}">
                                <input type="text" name="amount" value="from shipment page" disabled />
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Payment Type:</td>
                        <td>
                            <c:if test="${payment != null}">
                                    <input type="text" name="method" value="<c:out value='${payment.getMethod()}' />" disabled />
                            </c:if>
                            <c:if test="${payment == null}">
                                <select name="method">
                                    <option value="VISA">VISA</option>
                                    <option value="MASTER_CARD">MASTER_CARD</option>
                                    <option value="PAYPAL" selected>PAYPAL</option>
                                </select>
                            </c:if>
                        </td>
                </tr>
                <tr><td>Card Number:</td><td><input size="16" type="text" name="cardnum" /></td></tr>
                <tr><td>Name On Card:</td><td><input size="50" type="text" name="cardname" /></td></tr>
                <tr><td>Expiry Date:</td>
                    <td>
                        <input size="4" type="text" name="cardyear" default="YYYY" />
                        <input size="2" type="text" name="cardmonth" default="MM" />
                    </td></tr>
                <tr><td>CVV2:</td><td><input size="3" type="text" name="cvv2" /></td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="confirm" onclick="location.href = 'new'"> 
                        &nbsp; 
                        <button class="button" type="button" onclick="location.href = 'index.html'" > Home Page </button>
                    </td>
                </tr>
            </table>
            </form>
            
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
  
            
            
            
        <h1>Pay For Order</h1>
    </body>
</html>
