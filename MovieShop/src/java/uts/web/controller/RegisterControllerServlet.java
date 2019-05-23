/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.web.model.User;
/**
 *
 * @author francobuena
 */
public class RegisterControllerServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, java.io.IOException {
    try {	    
     User user = new User();
     user.setName(request.getParameter("un"));
     user.setPassword(request.getParameter("pw"));

     user = RegisterDAO.login(user);
	   		    
     if (user.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("userLogged.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("invalidLogin.jsp"); //error page 
    } 
		
		
catch (Throwable theException)  {
     System.out.println(theException); 
        }   
    }
}
    
    
    
