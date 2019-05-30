<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Online Moives Store</title>
</head>
<body>
    <center>
        <h1>Logins Management</h1>
        <h2>
            <a href="/new.jsp">Add New Logins</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list.jsp">List All Logins</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${login != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${login == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${login != null}">
                        Edit Login
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Login
                    </c:if>
                </h2>
            </caption>
                <c:if test="${login != null}">
                    <input type="hidden" name="id" value="<c:out value='${login.id}' />" />
                </c:if>           
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${login.email}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${login.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="60"
                            value="<c:out value='${login.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dob: </th>
                <td>
                    <input type="text" name="dob" size="50"
                            value="<c:out value='${login.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
