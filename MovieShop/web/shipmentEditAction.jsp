<%-- 
    Document   : shipmentEditAction
    Created on : 01-Jun-2019, 17:30:47
    Author     : henry117
--%>
<%@page import="uts.web.model.dao.DBManager"%>
<%@page import="uts.web.model.dao.DBConnector"%>
<%@page import="uts.web.model.*"%>
<%@page import="uts.web.controller.*"%>
<%@page import="java.sql.Connection"%>
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
         
 String address = request.getParameter("address");
 String type = request.getParameter("type");
    
 DBConnector connector = new DBConnector();
           
 Connection conn = connector.openConnection();
 DBManager db = new DBManager(conn);
 session.setAttribute("manager", db);     
 Shipment shipment = (Shipment) session.getAttribute("shipments");
 DBManager manager = (DBManager)session.getAttribute("manager");
 manager.updateShipment(address, type);  

%>
         
         


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
       
        <div class="col" style="text-align: center;" >
        
        </div>
    
             <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: bisque;">
               <div class="row" style="background-color: bisque;">
                   <div class="col mt-5" style="text-align: left;">
                         <h2> Your new details are now saved. </h2>
                         <p>Address: <%= shipment.getAddress()%> </p>
                         <p>Type: <%= shipment.getType()%> </p>
                        
                   </div>
               </div>
             
       
    </body>
</html>
