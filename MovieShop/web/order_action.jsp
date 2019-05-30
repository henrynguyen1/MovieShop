<%-- 
    Document   : order_action.jsp
    Created on : 29/05/2019, 2:32:25 PM
    Author     : yantoyanto
--%>

<%@page import="uts.web.model.OrderLine"%>
<%@page import="uts.web.model.dao.DBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
      <%
            DBManager manager = (DBManager)session.getAttribute("manager");
    
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            String movieID = request.getParameter("movieID");
            double price = Double.parseDouble(request.getParameter("price"));
            OrderLine orderLines = manager.findOrderLine(orderID);
            
            OrderLine orderLine = new OrderLine(orderID,movieID,price);
            if(orderLines != null){
                session.setAttribute("orderLine", orderLine);
                response.sendRedirect("order.jsp");
            }
            else{
            session.setAttribute("empty", "There is no data!");
            response.sendRedirect("index.html");
            }
        %>
        
        
       
    </body>
</html>
