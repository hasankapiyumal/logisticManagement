<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/10/2024
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello,${sessionScope.email}</h1>
<form action="tracking" method="post">
    <table>
        <tr>
            <th>Tracking Number</th>
            <td><input type="text" name="tracking"/></td>
            <td>
                <input type="submit" value="Tracking"/>
            </td>
        </tr>


    </table>
</form>
</body>
</html>
