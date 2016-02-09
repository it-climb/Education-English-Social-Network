<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

    <table>
        <tr>
            <td><b>Movie</b></td>
        </tr>
        <c:forEach var="videocontent" items="videocontents">
            <tr>
                <td>${videocontent.name}</td>
                <td>
                    <form:form method="post" action="/videocontentDelete">
                        <input type="submit" value="Delete">
                    </form:form>
                </td>
                <td>
                    <form:form method="post" action="/videocontentEdit">
                        <input type="submit" value="Edit">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <input type="button" value="Add new Video" formaction="/video">
        </tr>
    </table>

</body>
</html>
