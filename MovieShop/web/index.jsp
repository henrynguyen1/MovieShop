<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="uts.controller.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Home Page</title>       
    </head>
     <body onload="startTime()">
         <div><span class="time" id="time" ></span></div>      
        <h1 align="center">Online Movies Store</h1>  
        <div align="center"> 
            <a class="link" href="register.jsp"> Sign up </a> 
            &emsp; 
            <a class="link" href="table.jsp">date table</a>
            &emsp; 
            <a class="link" href="logout.jsp">Logout</a> 
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
