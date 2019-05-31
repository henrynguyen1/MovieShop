<%-- 
    Document   : loginAction
    Created on : 31/05/2019, 12:03:59 PM
    Author     : francobuena
--%>

<%@page import="uts.web.model.User"%>
<%@page import="uts.web.model.dao.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="uts.web.model.dao.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            //Activate the database search-validate once DBManager functions are completed
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);
            session.setAttribute("manager", db);            
            DBManager manager = (DBManager)session.getAttribute("manager");
                        
            String mail = request.getParameter("email");
            String password = request.getParameter("password");            
            User loguser = manager.findUser(mail, password);
            User user = new User(loguser.getID(), loguser.getEmail(), loguser.getName(), loguser.getPassword(), loguser.getPhoneNumber());
            if (loguser != null) {
                session.setAttribute("userLogin", user);
                response.sendRedirect("loginWelcome.jsp");                        
            }else{
                session.setAttribute("existErr", "Student profile does not exist!");
                response.sendRedirect("login.jsp");                               
            }             
        %>
    </body>
</html>
