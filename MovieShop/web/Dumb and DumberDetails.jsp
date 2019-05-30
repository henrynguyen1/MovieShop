<%@page contentType="text/html" import="java.util.*" import="uts.web.model.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body> 
         <div class="container-fluid" style="background-color: silver; height: 910px; width: 100%;">
             
        <div class="row" style="background-color: orange;  height: auto;">
             <div class="col" style="text-align: center;">
                 <h1 class="mt-3">Dumb and Dumber!</h1>
                  
                  
                 
                 
             </div>
            
            <table>
                <tr><td>MovieID:</td><td><input size="25" type="text" name="movieID"></td></tr>
                <tr><td>Title:</td><td><input size="25" type="text" name="title"></td></tr>
                <tr><td>Genre:</td><td><input size="25" type="text" name="genre"></td></tr>
                <tr><td>Duration:</td><td><input size="25" type="text" name="duration"></td></tr>
                <tr><td>Price:</td><td><input size="25" type="text" name="price"></td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="Update" onclick="location.href = 'MovieSearch.jsp'"> 
                        &nbsp; 
                        <button class="button" type="button" onclick="location.href = 'index.html'" > Delete </button>
                    </td>
                </tr>
            </table>
            
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