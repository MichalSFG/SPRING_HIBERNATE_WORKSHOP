<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your book</title>
</head>
<body>
<table style="width: auto" border="1">
    <thead><th>Book details</th></thead>
    <tbody>
    <tr>
        <th>Title</th>
        <td>${book.title}</td>
    </tr>
    <tr>
        <th>Author</th>
        <td>${book.author}</td>
    </tr>
    <tr>
        <th>Type</th>
        <td>${book.type}</td>
    </tr>
    <tr>
        <th>Publisher</th>
        <td>${book.publisher}</td>
    </tr>
    <tr>
        <th>ISBN</th>
        <td>${book.isbn}</td>
    </tr>
    </tbody>
</table>
<h3>Go to: <a href="/admin/books/all"/>All books</h3>
</body>
</html>
