
<%@page import="sun.security.jgss.GSSUtil.login(GSSCaller, Oid)"%>
<%@page import="uts.dao.DBManager"%>
<%@page import="uts.model1.Login"%>
<%@page import="uts.dao.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="uts.controller.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.model1.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css"> 
        <script type="text/javascript" src="js/script.js"></script>
        <title>Insert title here</title>
    </head>

    
   
        <div><span class="time" id="time" ></span></div>

        <h1>My Account</h1>        
        <form action="edit_user.jsp" method="POST">
            <table>
                <tr><td>Student ID</td><td><%= login.getID()%></td></tr>
                <tr><td>Full name</td><td><input type="text" value="<%= login.getName()%>" name="name"></td></tr>
                <tr><td>Email</td><td><input type="text" value="<%= login.getEmail()%>" name="email"></td></tr>                
                <tr><td>Password</td><td><input type="password" value="<%= login.getPassword()%>" name="password"></td></tr>   
                <tr><td>Date of Birth</td><td><input type="date" value="<%= login.getDob()%>" name="dob"></td></tr> 
               
                <tr><td><input type="hidden" value="updated" name="updated"></td>
                    <td><input class="button" type="submit" value="Save"> 
                        &emsp; 
                        <button class="button" type="button" onclick="location.href = 'main.jsp'" > Main Page </button>
                    </td>
                </tr>
            </table>
        </form>
        <%           
            DBManager manager = (DBManager)session.getAttribute("manager"); 

            if (request.getParameter("updated") != null) {
                manager.updateLogin(login.getID(), request.getParameter("name"), request.getParameter("email"),
                        request.getParameter("password"), request.getParameter("dob"), request.getParameter("favcol"));
                Login loginEdit = manager.findLogin(login.getID(), request.getParameter("password"));

                if (loginEdit != null) {
                    session.setAttribute("login", loginEdit);
                %>
                    <p class="outline"> Login details updated.</p>
                <%} else {%>
                    <p class="outline"> Could not update database!</p> 
                <%}%>
            <%}%>
    </body>
</html>