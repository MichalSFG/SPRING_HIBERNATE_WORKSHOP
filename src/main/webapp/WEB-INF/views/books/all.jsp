<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table style="width: 100%" border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    <th>action</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><a href="/admin/books/edit?id=${book.id}">Edit</a>
                <a href="/admin/books/delete?id=${book.id}">Delete</a>
                <a href="/admin/books/get?id=${book.id}">Get</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3><a href="/admin/books/add"/>Add new book</h3>
</body>
</html>

