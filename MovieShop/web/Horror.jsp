<%-- 
    Document   : MovieSearch.jsp
    Created on : May 15, 2019, 3:02:14 PM
    Author     : zaain
--%>

<%@page contentType="text/html" import="java.util.*" import="uts.web.model.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horror Movies</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body> 
         <div class="container-fluid" style="background-color: silver; height: 910px; width: 100%;">
             
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3">Horror Movies!</h1>
                  <a class="nav-link" href="./login.jsp">SIGN IN</a>
                  
                 
                 
             </div>
            
                 
             
         <div class="w-100">   
                 <div class="col bg-dark">
                 <nav class="navbar navbar-expand-lg navbar-dark" >
                     
                     <a class="nav-link" href="./index.html">HomePage</a>
                     <a class="nav-link" href="./MovieSearch.jsp">All Movies</a>
                     <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                         <a class="nav-link" href="./Action.jsp">Action</a>
                        
                        
                        
                        <a class="nav-link" href="./Comedy.jsp">Comedy</a>
                       
                       
                        <a class="nav-link" href="./Drama.jsp">Drama</a>
    
                       
                        <a class="nav-link" href="./Horror.jsp">Horror</a>
                          <input type="text" name="search" placeholder="Search..">
                    </ul>
                     </div>
                       
                    
                    
                     
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        
                      
                      <li class="nav-item active">
                        <a class="nav-link" href="./Horror.jsp"></a>
                        </li>
                      
                           
                    </ul>
                </div>
                 </nav>
                 
                 </div>
         </div>
            
             </div>
             <img src="./img/Ins.jpg" alt="Insidious" style="width:150px;height:200px;"> 
             
             <a class="nav-link" href="">Insidious</a>
             <a class="nav-link" href="">Buy</a>           
             <a class="nav-link" href="">Edit</a>
             <img src="./img/Omen.jpg" alt="The Omen" style="width:150px;height:200px;">
             <a class="nav-link" href="">The Omen</a> 
              <a class="nav-link" href="">Buy</a>
              <a class="nav-link" href="">Edit</a>
         </div>
        
        
        <div class="row" style="text-align: center; background-color: linen">
                   <div class="col-sm border border-dark pt-5 pb-5 mt-5 mb-5 ml-2 mr-1">
                        <h3><a>Click Movie</a> to purchase.</h3>
                   </div>
        </div> 
    
    
   
        
        
    </body>
</html>
