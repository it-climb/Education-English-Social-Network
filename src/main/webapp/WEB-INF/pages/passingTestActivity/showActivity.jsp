
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>

<div>
    <h3>Name activity: ${passingActivity.activity.name}</h3>
    ${passingActivity.activity.id}
</div>

<div>
<c:forEach var="item" items="${passingActivity.content.items}">
    <div>${item.question}
    <form method="post" action="/deleteQuestion">
        <input type="hidden" name="question" value="${item.question}">
        <input type="hidden" name="id" value="${passingActivity.activity.id}">
        <input type="submit" value="Delete">
    </form>
    </div>
</c:forEach>
</div>
<div>
    <form method="get" action="/addQuestion">
        <input type="hidden" name="id" value="${passingActivity.activity.id}">
        <input type="submit" value="Create new question" >
    </form>
</div>
<div>
    Name author: ${passingActivity.activity.author}

</div>

</body>
</html>
