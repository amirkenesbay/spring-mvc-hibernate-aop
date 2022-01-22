<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2022
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department info</title>
</head>
<body>
<h2>Department info</h2>
<br>
<form:form action="saveDepartment" modelAttribute="department">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Max salary: <form:input path="maxSalary"/>
    <form:errors path="maxSalary"/>
    <br><br>
    Min salary: <form:input path="minSalary"/>
    <form:errors path="minSalary"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
