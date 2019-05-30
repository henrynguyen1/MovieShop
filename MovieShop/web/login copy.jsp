

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<%--
    Document   : index
    Created on : 08/04/2019, 10:44:21 AM
    Author     : Mawgee.Okura
--%>



<html>
    <head>
        <meta charset="UTF-8">
        <title>login page</title>
       <link href="CSS.css" rel="stylesheet" type="text/css">
       <script type="text/javascript" src="js/script.js"></script>
    </head>
      <body onload="startTime()">
    <div><span class="time" id="time" ></span></div>
     <div class="header">
            <h1> Online Movies Store</h1>
            <h2> Login </h2>
        </div>
    
    <form action="loginAction.jsp" method="post">
        <table>
            <tr>
                <td><h5> Username:</h5></td>
                <td> <div class="sdf">  <input type="text" name="name" placeholder ="Enter your ID or Username"> </div> </td>
            </tr>
            <tr>
                <td><h5> Password:</h5></td>
                <td><div class="cdf">  <input type="password" name ="password" placeholder ="Enter your password" minlength="2" required > </div> </td>

            </tr>
        </table>
       
       
        
            <p><input type="submit" value="Login"> </p> 
            <p><button class="button" type="button" onclick="location.href = 'register.jsp'" > Sign up</button> 
            </p>
       
       
       
        </form>
       
       

    </body>
</html>