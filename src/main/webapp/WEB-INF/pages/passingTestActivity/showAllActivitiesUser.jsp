<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
    <title></title>
</head>
<body class="no-js">
<table width="600px">

    <p>    Passing Test Activities:</p>

    <c:forEach var="activity" items="${activities}">
        <tr>
            <td><a href="/passingTestActivity?id=${activity.value}">${activity.key}</a>     </td>
            <td>
                <form method="get" action="/showQuestion">
                    <input type="hidden" name="id" value=${activity.value}>
                    <input type="submit" value="Test">
                </form>
            </td>
                <%--<td><form method="post" action="/editPassingTestActivity">--%>
                <%--<input type="hidden" name="id" value=${activity.value}>--%>
                <%--<input type="submit" value="Update">--%>
                <%--</form>--%>
                <%--</td>--%>



        </tr>
    </c:forEach>
    <%--<tr>--%>
    <%--<td colspan="5">--%>
    <%--<form method="post" action="/editPassingTestActivity">--%>
    <%--<input type="submit" value="Add new one">--%>
    <%--</form>--%>
    <%--</td>--%>
    <%--</tr>--%>
</table>
</body>
</html>