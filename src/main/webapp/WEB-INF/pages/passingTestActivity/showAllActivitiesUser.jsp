<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title></title>
</head>
<body class="no-js">
<table width="600px">

    <p>Passing Test Activities:</p>

    <c:forEach var="activity" items="${activities}">
        <tr>
            <td>${activity.key}</td>
            <td>
                <form method="get" action="/showQuestion">
                    <input type="hidden" name="id" value=${activity.value}>
                    <input type="hidden" name="test" value="2">

                    <input type="submit" value="Test">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>