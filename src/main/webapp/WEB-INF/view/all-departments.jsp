<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2022
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Deparments</title>
</head>
<body>
<h2>All departments</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;Max salary</th>
        <th>&nbsp;&nbsp;&nbsp;&nbsp;Min salary</th>
    </tr>

    <c:forEach var="dep" items="${allDeps}">
        <tr>
            <td>${dep.name}</td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;${dep.minSalary}</td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;${dep.maxSalary}</td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
    onclick="window.location.href = 'addNewDepartment'">
</body>
</html>
