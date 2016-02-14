<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Descriptions</title>
</head>
<body>
<table>
    <tr>
        <td>Word: ${word.name}</td>
    </tr>
<c:forEach var="description" items="${descriptions}">
    <tr>
        <td>${description.name}</td>
        <td>
            <form method="post" action="/descriptionDelete">
                <input type="hidden" name="id" value=${description.id}>
                <input type="submit" value="Delete">
            </form>
        </td>
        <td>
         <form method="post" action="/descriptionEdit">
            <input type="hidden" name="id" value=${description.id}>
            <input type="submit" value="Update">
        </form>
        </td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="5">
            <form method="post" action="/descriptionEdit">
                <input type="hidden" name="word_id" value=${word.id}>
                <input type="submit" value="Add new description">
            </form>
        </td>
    </tr>
</table>

<br>
<a href="/">Home</a>
</body>
</html>
