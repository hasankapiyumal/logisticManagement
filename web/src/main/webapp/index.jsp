<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/9/2024
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><input type="password" name="password"/></td>
        </tr>
        <td></td>
        <td>
            <input type="submit" value="Login"/>
        </td>
    </table>
</form>
</body>
</html>
