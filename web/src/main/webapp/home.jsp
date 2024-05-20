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
<%--<form action="tracking" method="post">--%>
<h1 id="details"></h1>
<table>
    <tr>
        <th>Tracking Number</th>
        <td><input id="tracking" type="text" name="tracking"/></td>
        <td>
            <input onclick="realTimeTracking()" type="submit" value="Tracking"/>
        </td>
    </tr>


</table>
<%--</form>--%>
<script>
    function realTimeTracking() {
        let id = document.getElementById("tracking").value;
        let details = document.getElementById("details")
        const request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.readyState == 4) {
                if (request.status == 200) {
                    let text =request.responseText;
                    details.innerText=text;
                    setInterval(realTimeTracking,1000);
                }
            }
        }
        request.open("get", "http://localhost:8080/web/tracking?tracking="+id,true);
        request.send();
    }

</script>
</body>
</html>
