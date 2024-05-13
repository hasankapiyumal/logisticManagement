<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/11/2024
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin Home</h1>
<h2>Add cargo </h2>
<form action="addCargo" method="post">
    <table>
        <tr>
            <th>Current Location</th>
            <td><input type="text" name="currentLocation"/></td>
        </tr>
        <tr>
            <th>Destination Location</th>
            <td><input type="password" name="destinationLocation"/></td>
        </tr>
        <tr>
            <th>Origin Location</th>
            <td><input type="password" name="originLocation"/></td>
        </tr>
        <tr>
            <th>Details</th>
            <td><input type="password" name="details"/></td>
        </tr>
        <tr>
            <th>Status</th>
            <td><input type="password" name="status"/></td>
        </tr>
        <td></td>
        <td>
            <input type="submit" value="AddCargo"/>
        </td>
    </table>
</form>
</body>
</html>
