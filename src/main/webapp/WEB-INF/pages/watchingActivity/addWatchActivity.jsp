<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sergei-bragin
  Date: 28.02.16
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="post" action="/addWatchActivity">
    <table>
        <tr>
            <td>Name activity</td>
            <td><input type="text" value="${activityW.name}"></td>
        </tr>
        <tr>
            <td>Activity author</td>
            <td><input type="text"  value="${activityW.author}"></td>
        </tr>
        <tr>
            <td>Activity Content Description</td>
            <td><input type="text" value="${activityCW.description}"></td>
        </tr>
        <tr>
            <td>Activity Content URL</td>
            <td><input type="text" value="${activityCW.url}"></td>
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
