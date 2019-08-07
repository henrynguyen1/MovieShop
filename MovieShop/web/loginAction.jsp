<%-- 
    Document   : loginAction
    Created on : 31/05/2019, 12:03:59 PM
    Author     : franco/fan
--%>

<%@page import="uts.web.model.Login"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String loginDate = sdf.format(new Date());
            String logoutDate = sdf.format(new Date());
            String mail = request.getParameter("email");
            String password = request.getParameter("password");            
            User loguser = manager.findUser(mail, password);
            Login login = new Login(loginDate, logoutDate);
            User user = new User(loguser.getID(), loguser.getEmail(), loguser.getName(), loguser.getPassword(), loguser.getPhoneNumber());
            if (loguser != null) {
                session.setAttribute("userLogin", user);
                session.setAttribute("login", login);
                response.sendRedirect("loginWelcome.jsp");                        
            }else{
                session.setAttribute("existErr", "Student profile does not exist!");
                response.sendRedirect("login.jsp");                               
            }             
        %>
    </body>
</html>
