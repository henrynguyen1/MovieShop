<%-- 
    Document   : MovieSearch.jsp
    Created on : May 15, 2019, 3:02:14 PM
    Author     : zaain
--%>

<%@page contentType="text/html" import="java.util.*" import="uts.web.model" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Search</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body> 
         <div class="container-fluid" style="background-color: silver; height: 2200px; width: 100%;">
             
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3">Search for Movies</h1>
                 <input type="text" name="search" placeholder="Search.."> <a class="nav-link" href="./login.jsp">SIGN IN</a>
                 
             </div>
            
                 
             
         <div class="w-100">   
                 <div class="col bg-dark">
                 <nav class="navbar navbar-expand-lg navbar-dark" >
                     
                     <a class="nav-link" href="./MovieSearch.jsp">GENRE: </a>
                     
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                         <a class="nav-link" href="">Action</a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link" href="">Comedy</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">Drama</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">Horror</a>
                        </li>
                        
                      
                      <li class="nav-item active">
                        <a class="nav-link" href="./MovieSearch.jsp"></a>
                        </li>
                      
                           
                    </ul>
                </div>
                 </nav>
                 
                 </div>
         </div>
            
             </div>
             <img src="av.jpg.jpg" alt="Avengers" style="width:150px;height:200px;"> 
             
             <a class="nav-link" href="">The Avengers</a>
                        
             <img src="god.jpg.jpg" alt="Godzilla" style="width:150px;height:200px;">
             <a class="nav-link" href="">Godzilla</a> 
             <img src="Msk.jpg" alt="The Mask" style="width:150px;height:200px;">
             <a class="nav-link" href="">The Mask</a>
             <img src="DD.jpg" alt="Dumb and Dumberer" style="width:150px;height:200px;">
             <a class="nav-link" href="">Dumb and Dumberer</a> 
             <img src="rev.jpg" alt="The Revenant" style=width:150px;height:200px;"> 
             <a class="nav-link" href="">The Revenant</a>
             <img src="help.jpg" alt="The Help style" style=width:150px;height:200px;">
             <a class="nav-link" href="">The Help</a>
             <img src="insid.jpg" alt="Insidious" style=width:150px;height:200px;">
             <a class="nav-link" href="">Insidious</a>
             <img src="omen.jpg" alt="The Omen" style=width:150px;height:200px;"> 
             <a class="nav-link" href="">The Omen</a> 
         </div>
        
        
        <div class="row" style="text-align: center; background-color: linen">
                   <div class="col-sm border border-dark pt-5 pb-5 mt-5 mb-5 ml-2 mr-1">
                        <h3><a>Click Movie</a> to purchase.</h3>
                   </div>
        </div> 
    
    
   
        
        
    </body>
</html>
