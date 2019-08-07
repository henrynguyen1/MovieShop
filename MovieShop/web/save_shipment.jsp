<%-- 
    Document   : save_shipment
    Created on : 31/05/2019, 11:37:58 PM
    Author     : HenryNguyen
--%>


<%@page import="uts.web.model.User"%>
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
        <%
            
        int ID = (new Random()).nextInt(999999);
        int ID2 = (new Random()).nextInt(99999999);         
        String shipID = "" + ID;
        String trackingNo = "" + ID2;       
        String address = request.getParameter("address");
        String type = request.getParameter("type");  
        String userID = request.getParameter("userID");
        String status = request.getParameter("status");
    
    
            DBConnector connector = new DBConnector();           
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);
            session.setAttribute("manager", db);            
            DBManager manager = (DBManager)session.getAttribute("manager");
            Shipment shipment =  new Shipment(shipID, address, type, trackingNo, userID, status);
            manager.addShipment(shipID, address, type, trackingNo, userID, status);
            session.setAttribute("shipment",shipment);                        
        %>
       <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: bisque;">
               <div class="row" style="background-color: bisque;">
                   
                       <div class="col">
                         <h2> Shipment Created...</h2>
                     
                   </div>
               </div>
                   <div class="row">
                       <div class="col">
                         <table class="table">
                             <thead>
                                 <tr>
                                     <th>Shipment Information </th>
                                     <th> Data </th>
                                 </tr>
                             </thead>
                             <tbody>
                          
                                 <tr>
                                     <td> Shipment ID </td>
                                     <td> <%=shipID%> </td>
                                 </tr>
                                 <tr>
                                     <td>Address</td>
                                     <td><%=address%></td>
                                 </tr>
                                 <tr>
                                     <td> Tracking Number </td>
                                     <td> <%=trackingNo%> </td>
                                 </tr>
                                 <tr>
                                     <td> User ID</td>
                                     <td> <%=userID%> </td>
                                 </tr>
                                 <tr>
                                     <td>Status</td>
                                     <td><%=status%></td>
                                 </tr>
                                 
                                 <button class="btn btn-danger" onClick="location.href='cancel_order.jsp'">Cancel Order</button>
                                 <button class="btn btn-warning" onClick="location.href='update_order.jsp'">Update Order</button>
                                 
                                
                             </tbody>
                         </table>
                       </div>
                   </div>
                                 <div class="row">
                                     <div class="col">
                                          <button class="btn btn-danger" type="submit" onClick="location.href ='cancel_shipment.jsp'">Cancel</button>
                                          <button class="btn btn-warning" type="submit" onclick= "location.href = 'main.jsp'"> Back to Main </button>
                                           <button class="btn btn-warning" type="submit" onclick="location.href = 'viewshipmentDetails.jsp'"> View Shipments </button>
                                               
                                               
                                               
                                        
                                     </div>
                                 </div>
    
       
       
       
       </body>
</html>
