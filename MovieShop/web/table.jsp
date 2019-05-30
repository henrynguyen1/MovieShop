
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Online Moive Store </title>
</head>
<body>
    <center>
        <h1>Login Management</h1>
        <h2>
           
            &emsp; 
            <a class="link" href="logout.jsp">Logout</a> 
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Login</h2></caption>
            <tr>
                <th>Row</th>
                <th>ID</th>
                <th>LoginDate</th>
                <th>LogoutDate</th>
                
                <th>Actions</th>
                
            </tr>
            <c:forEach var="login" items="${listLogin}">
                <tr>
                    <td><c:out value="${login.Row}" /></td>
                    <td><c:out value="${login.ID}" /></td>
                    <td><c:out value="${login.LoginDate}" /></td>
                    <%
    Date date = new Date();
   out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
   %>
                    <td><c:out value="${login.LogoutDate}" /></td>
                    <td><c:out value="${login.Actions}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${login.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${login.id}' />">Delete</a> 
                       
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>