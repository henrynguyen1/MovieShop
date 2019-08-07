<%-- 
    Document   : shipment_edit
    Created on : 27/05/2019, 5:50:18 PM
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
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        Shipment shipment = (Shipment) session.getAttribute("shipment");
        
        
        
        %>
            
          <div align="center">
          <form action="shipmentEditAction.jsp" method="post">
          <table border="1" cellpadding="5">
        
            <h1>Edit Shipment Details</h1>
            <input type="hidden" name="updated" value="updated" />" 
           
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="newddress" size="10"
                     value = "address">
                </td>
                </th>
            </tr>
                <th>Shipment Type</th>
                <td>
                    <select name="newtype">
                          <option value="Standard">Standard</option>
                          <option value="Express"> Express</option>
                    </select>
                 </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="button" type="submit" onclick="location.href = 'shipmentEditAction.jsp'"> Save Changes </button>
                    <button class="button" type="submit" onclick="location.href = 'main.jsp'" > Return to Main </button>
                </td>
                 
            </tr>
        </table>
        </form>
      </div>
    </body>
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      
</html>
