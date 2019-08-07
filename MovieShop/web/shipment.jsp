<%@page import="uts.web.model.*"%>
<%@page import="uts.web.controller.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" import="java.util.*" import="uts.web.model.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        
        <% 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String shipID = request.getParameter("id");
        
         %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipment Options during Order Page</title>
    </head>
    <body>
        <div class="container-fluid" style="background-color: silver; height: 900px; width: 100%;">
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1>Shipment Details</h1>
                     Address line: <input type ="text" name ="Address Line">
                     Suburb: <input type ="text" name ="Suburb">
                     State: <input type ="text" name ="State">
                     Postcode: <input type ="text" name ="Postcode">
                     Contact Number <input type ="text" name ="Contact Number">
                     <h2>Shipment Options</h2>
             <form action="confirm_payment.jsp">
                 <pre>
                     Standard : <input type ="submit" value ="Select"><br/>
                     Express : <input type ="submit" value ="Select"><br/>
                 </pre>
             </form>
                     <button class="button" type="submit" onclick="location.href = 'new_payment.jsp'"> Continue to Payment</button>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
