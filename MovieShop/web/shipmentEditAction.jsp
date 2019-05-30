<%-- 
    Document   : shipmentEditAction
    Created on : 30/05/2019, 5:50:01 PM
    Author     : HenryNguyen
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Random"%>
<%@page import="uts.web.model.*"%>
<%@page import="uts.web.controller.*"%>

<%@page import="uts.web.model.dao.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        
     
        
        
        
        
        %>
        
        
        
        <% 
         DBConnector connector = new DBConnector();
         Connection conn = connector.openConnection();
         DBManager db = new DBManager(conn);
            
        session.setAttribute("manager", db);
        DBManager manager = (DBManager) session.getAttribute("manager");
       
        String email = request.getParameter("newemail");
        String address = request.getParameter("newaddress");
        String type = request.getParameter("newtype");
        
        User user = (User) session.getAttribute("newuser");
        Shipment shipment = new Shipment(email, address, type);
        manager.updateShipment(shipment);
        session.setAttribute("newshipment", shipment);
        
       
      
        
         %>
    </body>
</html>
