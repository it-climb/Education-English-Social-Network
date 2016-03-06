<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="post" action="/addPassingTestActivity" modelAttribute="ptaDto">
    <table>
        <tr>
            <td>Create new Passing Test Activity</td>
        </tr>
            <%--<tr>--%>
            <%--<td>Name:</td>--%>
            <%--<td><input type="text" name="name" value="${ptaDto.name}"/></td>--%>
            <%--</tr>--%>
        <tr>
            <td>Question</td>
            <td><input type="text" value="${ptaDto.question}" name="question"></td>
        </tr>
        <tr>
            <td>Answers</td>

        </tr>
        <tr>
            <td>Answer 1</td>

            <td>
                <input type="checkbox" value="${ptaDto.rightAnwer1}" name="rightAnwer1">
            </td>
            <td><input type="text" value="${ptaDto.answer1}" name="answer1"></td>
        </tr>
        <tr>
            <td>Answer 2</td>
            <td><input type="checkbox" value="${ptaDto.rightAnwer2}" name="rightAnwer2"></td>
            <td><input type="text" value="${ptaDto.answer2}" name="answer2"></td>
        </tr>
        <tr>
            <td>Answer 3</td>
            <td><input type="checkbox" value="${ptaDto.rightAnwer3}" name="rightAnwer3"></td>
            <td><input type="text" value="${ptaDto.answer3}" name="answer3"></td>
        </tr>
        <tr>
            <td>Answer 4</td>
            <td><input type="checkbox" value="${ptaDto.rightAnwer4}" name="rightAnwer4"></td>
            <td><input type="text" value="${ptaDto.answer4}" name="answer4"></td>
        </tr>


        <tr>
            <td colspan="2">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
