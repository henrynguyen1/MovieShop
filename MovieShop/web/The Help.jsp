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
        <title>The Help</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body> 
         <div class="container-fluid" style="background-color: silver; height: 910px; width: 100%;">
             
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3">The Help!</h1>
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
                        <a class="nav-link" href="./Comedy.jsp"></a>
                        </li>
                      
                           
                    </ul>
                </div>
                 </nav>
                 
                 </div>
         </div>
            
             </div>
               <img src="./img/Help.jpg" alt="The Help" style=width:150px;height:200px;">
             <a class="nav-link" href="The HelpDetails.jsp">The Help</a>
             
              
         </div>
        
        
       
        <div class="fixed-bottom" style="background-color: orange; ">
            <div class ="row">
               
                <div class="col-sm-1 ">
                    <a>We accept: </a>
                </div>
                <div class="col-lg-8 col-sm">
                    <img  title="mastercard" src="./Picture/master.jpg">
                    <img  title="visa" src="./Picture/visa.png">
                    <img  title="paypal" src="./Picture/paypal.png">
                </div>
                 <div class="col-sm">
                    <h3 style="font-size:20px">© MOVIE STORE 2019</h3>
                </div>
                
            </div>
            </div>
    
    
   
        
        
    </body>
</html>
