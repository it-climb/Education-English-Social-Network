
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
<div align="left">
    <c:forEach var="q" items="${passingActivity.content.items}">
        <div>
            <h4>Question: ${q.question} <input type="submit" value="Update"> | <input type="submit" value="Remove"> </h4>
            <c:forEach var="answer" items="${q.answers.answers}">
                <div>
                    Answer: ${answer.answer}
                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>
<div>
    <form method="get" action="/addQuestion">
        <input type="hidden" name="id" value="${activityId}">
        <input type="submit" value="Create new question" >
    </form>
</div>
<div>
    Name author: ${passingActivity.activity.author}
</div>

</body>
</html>
