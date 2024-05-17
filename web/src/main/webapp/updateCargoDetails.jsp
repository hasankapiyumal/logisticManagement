<%@ page import="com.zaviron.ejb.entity.Cargo" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/14/2024
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Cargo Details</title>
</head>
<body>
<%
Cargo cargo=(Cargo) request.getAttribute("cargo");
%>
<form action="updateCargo" method="post">
    <table>
        <tr>
            <th>Cargo Id</th>
            <td><input type="text" name="id" value="<%=cargo.getId()%>"/></td>
        </tr>
        <tr>
            <th>Current Location</th>
            <td><input type="text" name="currentLocation" value="<%=cargo.getCurrentLocation()%>"/></td>
        </tr>
        <tr>
            <th>Destination Location</th>
            <td><input type="text" name="destinationLocation" value="<%=cargo.getDestinationLocation()%>"/></td>
        </tr>
        <tr>
            <th>Origin Location</th>
            <td><input type="text" name="originLocation" value="<%=cargo.getOriginLocation()%>"/></td>
        </tr>
        <tr>
            <th>Details</th>
            <td><input type="text" name="details" value="<%=cargo.getDetails()%>"/></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="text" name="status" value="<%=cargo.getStatus()%>"/></td>
        </tr>
        <td></td>
        <td>
            <input type="submit" value="UpdateCargo"/>
        </td>
    </table>
</form>
</body>
</html>
