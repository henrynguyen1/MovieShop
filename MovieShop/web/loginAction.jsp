<%-- 
    Document   : loginAction
    Created on : Aug 11, 2018, 9:34:47 PM
    Author     : George
--%>

<%@page import="uts.model1.Login"%>
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
        <title>Login Action Page</title>
    </head>
    <body>

        <%
            //Activate the database search-validate once DBManager functions are completed
            
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);
            
            
            String ID = request.getParameter("name");
          
            String password = request.getParameter("password");            
            Login logins = db.findLogin(ID, password);
            Login login = new Login( Integer.parseInt(ID),password);
            if (logins != null) {
                session.setAttribute("userLogin", login);
                response.sendRedirect("loginWelcome.jsp");                        
            }else{
                session.setAttribute("existErr", "Student profile does not exist!");
                response.sendRedirect("login.jsp");                               
            }             
        %>
        
    </body>
</html>
