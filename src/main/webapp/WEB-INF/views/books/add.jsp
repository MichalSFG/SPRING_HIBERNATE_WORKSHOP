<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<h3>>>>Add book<<<</h3>
<form:form method="post" modelAttribute="book">
    Title: <form:input path="title"/><br>
    Author: <form:input path="author"/><br>
    Type: <form:input path="type"/><br>
    Publisher: <form:input path="publisher"/><br>
    ISBN: <form:input path="isbn"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
