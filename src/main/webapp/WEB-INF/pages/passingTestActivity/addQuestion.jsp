<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="post" action="/addQuestion" modelAttribute="ptaDto">
    <table>
        <div>
            <td> Question with Answers</td>
        </div>

        <tr>
            <td>Question</td>
            <td><input type="text" value="${ptaDto.question}" name="question"></td>
        </tr>
        <tr>
            <td>Answers</td>
        </tr>

        <tr>
            <td>Answer 1</td>
            <c:if test="${ptaDto.returnRightAnswer1 != null}">
                <td>
                <input type="checkbox"  name="rightAnswer1" checked>
                </td>
            </c:if>
            <c:if test="${ptaDto.returnRightAnswer1 == null}">
                <td>
                <input type="checkbox"  name="rightAnswer1">
                </td>
            </c:if>
            <td><input type="text" value="${ptaDto.answer1}" name="answer1"></td>
        </tr>

        <tr>
            <td>Answer 2</td>
            <c:if test="${ptaDto.returnRightAnswer2 != null}">
                <td>
                    <input type="checkbox"  name="rightAnswer2" checked>
                </td>
            </c:if>
            <c:if test="${ptaDto.returnRightAnswer2 == null}">
                <td>
                    <input type="checkbox"  name="rightAnswer2">
                </td>
            </c:if>
            <td><input type="text" value="${ptaDto.answer2}" name="answer2"></td>
        </tr>

        <tr>
            <td>Answer 3</td>
            <c:if test="${ptaDto.returnRightAnswer3 != null}">
                <td>
                    <input type="checkbox"  name="rightAnswer3" checked>
                </td>
            </c:if>
            <c:if test="${ptaDto.returnRightAnswer3 == null}">
                <td>
                    <input type="checkbox"  name="rightAnswer3">
                </td>
            </c:if>
            <td><input type="text" value="${ptaDto.answer3}" name="answer3"></td>
        </tr>

        <tr>
            <td >Answer 4</td>
            <c:if test="${ptaDto.returnRightAnswer4 != null}">
                <td>
                    <input type="checkbox"  name="rightAnswer4" checked>
                </td>
            </c:if>
            <c:if test="${ptaDto.returnRightAnswer4 == null}">
                <td>
                    <input type="checkbox"  name="rightAnswer4">
                </td>
            </c:if>
            <td><input type="text" value="${ptaDto.answer4}" name="answer4" ></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="hidden" name="id" value="${passingActivity.activity.id}">
                <input type="hidden" name="numberQuestion" value="${numberQuestion}">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td style="color: red">
                    ${warnMessage}
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
