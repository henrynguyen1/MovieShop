<%-- 
    Document   : login
    Created on : 16/04/2019, 9:44:35 PM
    Author     : yantoyanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
       
        
    </head>
    <body>
        <div class="container-fluid" style="background-color: silver; height: 900px; width: 100%;">
         <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3"> Welcome to Movie Store! </h1>    
             </div>
            
             <div class="w-100">   
                 <div class="col bg-dark">
                 <nav class="navbar navbar-expand-lg navbar-dark" >
                     <a class="navbar-brand" href="./index.html">Movie Store</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu" aria-controls="navbarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                         <a class="nav-link" href="./index.html">HOME</a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link" href="">ABOUT</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">PRICES</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="#">CONTACT</a>
                        </li>
                        <li class="nav-item active">
                        <a class="nav-link" href="./login.jsp">MY ACCOUNT</a>
                        </li>
                    </ul>
                </div>
                 </nav>
                 
                 </div>
             </div>
         </div>
            
            
       
            <div class="container mt-lg-4 mt-sm-2" style="width:70%; height:650px; background-color:  bisque;">
               
                
                    <div class="col pt-5">
                  <h1 style="font-family: sans-serif; color: orange;">Sign In</h1>
                    </div>
                    <form>
                    <div class="form-group row">
                        <label for="colFormLabel" class="col-sm-2 col-form-label">Username</label>
                            <div class="form-group col-md-6">
                                 <div class="col-sm-10">
                                 <input type="username" class="form-control" id="colFormLabel" >
                                 </div>
                            </div>
                    </div>
                    <div class="form-group row">
                         <label for="colFormLabel" class="col-sm-2 col-form-label">Password</label>
                            <div class="col-sm-10">
                                <div class="form-group col-md-6">
                                <input type="password" class="form-control" id="colFormLabel" >
                                </div>
                            </div>
                   
                    </div>
                  

                            <button type="submit" class="btn btn-warning">Sign In</button>
                            <input type="reset" class="btn btn-warning" value="Clear">
            
                </form>
              
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
        </div>
        
    </body>
</html>
