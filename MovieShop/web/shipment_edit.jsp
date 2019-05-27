<%-- 
    Document   : shipment_edit
    Created on : 27/05/2019, 5:50:18 PM
    Author     : HenryNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    </head>
    <body>
        <h1>Edit Shipment Details</h1>
         <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${shipment.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="address" size="5"
                            value="<c:out value='${shipment.address}' />"
                    />
                </td>
                <td>
                <th>Name: </th>
                    <input type="text" name="name" size="5"
                            value="<c:out value='${shipment.name}' />"
                    />
                </td>
                <td>
                <th>Shipment Type</th>
                    <input type="text" name="type" size="5"
                            value="<c:out value='${shipment.type}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
    </body>
</html>
