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
        <title>View Past/Saved Shipments Page</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Shipments</h1>
        <div class="container-fluid" style="background-color: silver; height: 2200px; width: 100%;">
             
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Order Date</th>
                <th>Order Details</th>
                <th>Price</th>
                <th>Tracking Number</th>
                <th>Status</th>
            </tr>
            <c:forEach var="shipment" items="${listShipments}">
                <tr>
                    <td><c:out value="${shipment.shipID}" /></td>
                    <td><c:out value="${shipment.date}" /></td>
                    <td><c:out value="${order.movieID}" /></td>
                    <td><c:out value="${order.price}" /></td>
                    <td><c:out value="${shipment.trackingNo}" /></td>
                    <td><c:out value="${shipment.status}" /></td>
                    <td>
                        <a class="nav-link" href="./shipment_edit.jsp/>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${shipment.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
                 
             </div>
            
    </body>
</html>
