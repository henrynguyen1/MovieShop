<%-- 
    Document   : cancel_shipment
    Created on : 29-May-2019, 16:57:04
    Author     : henry117
--%>

<%@page import="uts.web.model.User"%>
<%@page import="uts.web.model.Shipment"%>
<%@page import="uts.web.model.dao.DBManager"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.Connection"%>
<%@page import="uts.web.model.dao.DBConnector"%>
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
        DBManager manager = (DBManager)session.getAttribute("manager");
        Shipment shipment = (Shipment) session.getAttribute("shipment");
        
    %>
    <div class="container mt-lg-4 mt-sm-2 pb-4" style="width:100%; height:650px; background-color: lightgray;">
               <div class="row" style="background-color: lightgray; text-align: center;">
                   <div class="col">
                   <form action="confirm_cancelShip.jsp" method="post">
                         <div class="col ">  
                        <h2> Confirm Shipment Cancellation? </h2>
                        <h3>Shipment <%= shipment.getShipID()%></h3>
                         
                         <input type="hidden" value="CANCELLED" name="status"/>
                        <input type="hidden" value="updated" name="updated">
                   </div>
                          <div class="row">
                              <div class="col">
                       <input class="btn btn-danger" type="submit" value="Confirm"/> 
                       &nbsp; 
                       <button class="btn btn-light" type="button" onclick="location.href = 'main.jsp'" > Back to Home</button>
                              </div>
                         </div>
                   </form>
                   </div>     

               </div> 
                   
                             <%
            
             String status = request.getParameter("status");

            if (request.getParameter("updated") != null) {
                manager.updateShipment(shipment.getShipID(),status);
                Shipment CancelShip = manager.findShipment(shipment.getUserID());

                if (CancelShip != null) {
                    session.setAttribute("shipment", CancelShip);
                %>
               
                <%} else {%>
                <p style="color:orange">Shipment Successfully Cancelled</p> 
                <%}
}%>
           
            
              
                         
    
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
