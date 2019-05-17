<%@page import="uts.web.dao.*"%>
<%@page import="uts.web.controller.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" import="java.util.*" import="uts.isd.model.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        
        <% 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String shipID = request.getParameter("id");
        
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saved Shipment Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
