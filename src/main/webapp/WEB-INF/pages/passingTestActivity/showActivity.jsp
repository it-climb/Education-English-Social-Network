
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>

<div>
    <h3>Name activity: ${passingActivity.activity.name}</h3>

</div>

<table>
<c:forEach var="item" items="${passingActivity.content.items}">
    <tr>
        <td width="20">
            #${item.numberQuestion}
        </td>
        <td width="50" height="20">   ${item.question}</td>
        <td width="50">
            <form method="post" action="/editQuestion">
                <input type="hidden" name="numberQuestion" value="${item.numberQuestion}">
                <input type="hidden" name="id" value="${passingActivity.activity.id}">
                <input type="submit" value="Edit">
            </form>
        </td>
            <td>
    <form method="post" action="/deleteQuestion">
        <input type="hidden" name="numberQuestion" value="${item.numberQuestion}">
        <input type="hidden" name="id" value="${passingActivity.activity.id}">
        <input type="submit" value="Delete">
    </form>
        </td>
    </tr>
</c:forEach>

<tr>
<td>
    <form method="get" action="/addQuestion">
        <input type="hidden" name="id" value="${passingActivity.activity.id}">
        <input type="submit" value="Create new question" >
    </form>
</td>
</tr>
</table>
<div>
    Name author: ${passingActivity.activity.author}

</div>

</body>
</html>
