<%-- 
    Document   : Edit_Movie
    Created on : May 31, 2019, 9:31:29 PM
    Author     : Zaain
--%>
 <%@page import="uts.web.model.Movie"%>
 <%@page import="java.util.Random"%>
<!-- Zaain : edit and remove movies 
  -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="uts.web.model.dao.DBManager"%>
<%@page import="uts.web.model.Movie"%>
<%@page import="java.util.Random"%>

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit and Remove Page</title>
    </head>
    <body>
        <%  
            //Get the MovieID from sideNavigation_movies
             String MovieID = request.getParameter("movieID");
       
        %>
                <form action="update movie.jsp" method="POST">
                <table>
                <tr><td>Title</td><td><input type="text"  name="title" required ></td></tr>
                <tr><td>Genre</td><td><input type="text"  name="genre" required></td></tr>                
                <tr><td>Duration</td><td><input type="text" name="duration" required></td></tr>
                <tr><td>Price</td><td><input type="text" name="price" required></td></tr>  
                <tr><td>Available Copies</td><td><input type="number" name="copies" required></td></tr>
                <tr><td><input type="hidden" name="id" value="<%=MovieID%>"></td></tr>
                <tr>
                    <td><input class="button" type="submit" value="Save" name="edit"> 
                        &emsp; 
                        <button class="button" type="button" onclick="location.href = './MovieCatalogueManagement.jsp'" > Main Page </button>
                    </td>
                </tr>
            </table>
                </form>
            <form action="update movie.jsp" method="POST">
                <table>
                    <tr><td><input type="hidden" name="id"  value="<%=MovieID%>"></td></tr>
                    <tr><td>   <input class="button" type="submit" value="Remove" name="remove"> </td></tr>
                </table>
                
                </form>
        <%
            
        %>
        <%
           
            
            DBManager manager = (DBManager)session.getAttribute("manager");
            DBConnector connector = connector.openConnection(); 
            DBManager db = new DBManager(conn); 
            //Check whether the edit form  submited
            if (request.getParameter("edit") != null)
            {
                //Get ID from the submited form above//
                String movieID = request.getParameter("movieID");
                String title = request.getParameter("title");
                String genre = request.getParameter("genre");
                String duration = request.getParameter("duration"); 
                double price = Double.parseDouble(request.getParameter("price"));
               
                //Update the movie details by calling updatemovie function from DBmanager
                manager.updateMovie(movieID, request.getParameter("title"), request.getParameter("genre"), request.getParameter("duration"),  
                        price);
              //Check whether the edit form or the remove form was submited
            }else if (request.getParameter("remove")!=null)
            {
                //Get ID from the submited form above//
                 String movieID = request.getParameter("movieID");
                 String title = request.getParameter("title");
                 String genre = request.getParameter("genre");
                String duration = request.getParameter("duration"); 
                double price = Double.parseDouble(request.getParameter("price"));
                //UPDATE the movie
                manager.updateMovie(movieID, title, genre, duration, price);
            }
            
        %>
    </body>
</html>
