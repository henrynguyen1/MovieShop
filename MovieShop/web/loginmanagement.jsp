<%-- 
    Document   : loginmanagement
    Created on : 31/05/2019, 5:22:39 PM
    Author     : franco/fan
--%>

<%@page import="uts.web.model.User"%>
<%@page import="uts.web.model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Movie Store </title>
</head>
<body>
    <center>
        <h1>Login Management</h1>
        <h2>
            &emsp; 
            <a class="link" href="logout.jsp">Logout</a> 
        </h2>
    </center>
    <%
        Login login = (Login)session.getAttribute("login");
        User user = (User)session.getAttribute("user");
    %>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Login</h2></caption>
            <tr>

                <th> Email </th>
                <th> Login Date </th>
                <th> Logout Date </th>

                <th>Actions</th>

            </tr>
                <td> <%= user.getEmail() %> </td>
                <td> <%= login.getLoginDate() %> </td>
                <td> <%= login.getLogoutDate() %> </td>
                                
         </table>
                <button type="delete" class="btn btn-warning"> Delete</button>>
    </div>
</body>
</html>