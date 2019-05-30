



<%@page import="uts.model1.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css"> 
        <script type="text/javascript" src="js/script.js"></script>
        <title>Main Page</title>
    </head>
    <%
        {String login;
        //String log;
        Login logins = (Login) session.getAttribute("login");

        //if (login != null) {
            //color = student.getFavcol();
            //log = " &lt " + student.getName() + " &gt";
       // } else {
            //color = "#AED6F1";
            //log = " &lt " + "Guest Student" + " &gt";
        }

    %>
   
        <div><span class="time" id="time" ></span></div>
        <h2 class="outline">Student Profile</h2> 
        <table width="100%" >
            <tr bgcolor="lightgrey" ><td align="right" class="outline">You are logged in as  <%=logins%></td></tr>
            <tr><td align="right">
                    <%if (logins != null) { %>
                    <u><a class="link" href="edit_user.jsp">Account</a></u> 
                        <%} else { %>
                    <u><a class="link" href="register.jsp">Register</a></u>
                        <%}%>
                    &emsp;<u><a class="link" href="logout.jsp">Logout</a></u>
                </td>
            </tr>                  
        </table>        
        <hr>
        <% if (logins != null) { %>
        <table class="account">
            <thead class="h">
                <tr>
                    <td class="a">ID</td>
                    <td class="a">Name</td>
                    <td class="a">DOB</td>
                    <td class="a">Email</td>
                    <td class="a">Password</td>
                    <td class="a">Favorite Color</td>
                </tr>
            </thead>
            <tbody >
                <tr>
                    <td class="a">${login.ID}</td>
                    <td class="a" >${login.name}</td>
                    <td class="a">${login.dob}</td>
                    <td class="a">${login.email}</td>
                    <td class="a">${login.password}</td>
                    
                </tr>
            </tbody>
        </table>
        <% session.setAttribute("loginEdit", logins); %>
        <%}else{ %>
        <p class="outline">Welcome Guest Student</p>
        <%}%>
    </body>
</html>
