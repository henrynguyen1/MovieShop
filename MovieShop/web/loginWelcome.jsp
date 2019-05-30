<%@page import="uts.dao.*"%>
<%@page import="uts.model1.*"%>
<%@page import="uts.controller.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.model1.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css"> 
        <script type="text/javascript" src="js/script.js"></script>
        <title>Welcome Page</title>
    </head>    
    <%
        Login login = (Login)session.getAttribute("userLogin");
//        String co;
//        if (student != null) {
//            color = student.getFavcol();
//        } else {
//            color = "#AED6F1";
//        }
    %>
    <body>
        <div><span class="time" id="time" ></span></div>
        <% if(login != null) { %>        
        <h1>Hello <%= login.getName() %></h1> 
        <p>Your ID is: <%= login.getId() %></p>
       
    
             
<!--        <p>Your Favorite color is: </p>        -->
        <%            
            session.setAttribute("user22",login);
        %>
        <button class="button" type="button" onclick="location.href = 'main.jsp'" > Main Page </button>
        <%}else{%>
        <p class="outline"> Login unsuccessful! </p>
        <button class="button" type="button" onclick="location.href = 'main.jsp'" > Main Page </button>
        <%}%>        
        <button class="button" type="button" onclick="location.href = 'index.jsp'" > Home Page </button>
    </body>
</html>
