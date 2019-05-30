<%-- 
    Document   : save_shipment_details
    Created on : 30/05/2019, 6:55:01 PM
    Author     : HenryNguyen
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%
        
        String newemail = request.getParameter("newemail");
        String password = request.getParameter("password");
        String newphone = request.getParameter("newphone");
        int key = (new Random()).nextInt(999999);
        String ID = "" + key;
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>
