<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="get" action="/showQuestion" modelAttribute="ptaDto">
    <table>
        <div>
            <td> Question #${numberQuestion}</td>

        </div>

        <tr>
            <td>Question</td>
            <td><input type="text" value="${ptaDto.question}" name="question" disabled></td>
        </tr>
        <tr>
            <td>Answers</td>

        </tr>
        <tr>
            <td>Answer 1</td>
            <td>
                <input type="checkbox"  name="rightAnswer1">
            </td>
            <td><input type="text" value="${ptaDto.answer1}" name="answer1" disabled></td>
        </tr>
        <tr>
            <td>Answer 2</td>
            <td><input type="checkbox"  name="rightAnswer2"></td>
            <td><input type="text" value="${ptaDto.answer2}" name="answer2" disabled></td>
        </tr>
        <tr>
            <td>Answer 3</td>
            <td><input type="checkbox"  name="rightAnswer3"></td>
            <td><input type="text" value="${ptaDto.answer3}" name="answer3" disabled></td>
        </tr>
        <tr>
            <td>Answer 4</td>
            <td><input type="checkbox"  name="rightAnswer4"></td>
            <td><input type="text" value="${ptaDto.answer4}" name="answer4" disabled></td>
        </tr>
    </table>
<div>
    <table>
        <tr>
            <td colspan="2">
                    <input type="hidden" name="numberQuestion" value="${numberQuestion}">
                    <input type="hidden" name="test" value="1">
                    <input type="hidden" name="id" value="${passingActivity.activity.id}">
                    <input type="submit" value="Ok">
            </td>
        </tr>

    </table>
</div>
</form:form>

<div align="center">
    <table>
        <c:forEach var="item" items="${passingActivity.content.items}">
            <form method="get" action="/showQuestion">
                <input type="hidden" name="numberQuestion" value="${item.numberQuestion}">
                <input type="hidden" name="id" value="${passingActivity.activity.id}">
                <input type="submit" value="${item.numberQuestion}">
            </form>
        </c:forEach>
    </table>
</div>
<div>
    <table>
        <tr>
           <form:form method="get" action="/resultTest">
        <td colspan="2" align="right">
        <input type="hidden" name="endTest" value="1">
        <input type="hidden" name="id" value="${passingActivity.activity.id}">
        <input type="submit" value="Завершить тест">
        </td>
           </form:form>
        </tr>
    </table>
</div>
</body>
</html>
