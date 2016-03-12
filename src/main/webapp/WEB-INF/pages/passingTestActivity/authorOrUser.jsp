<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title></title>
</head>
<body class="no-js">
<h5>Author or User:</h5>
<table width="200px">
    <tr>
            <td>
                <form method="get" action="/passingActivities">
                    <input type="submit" value="Author">
                </form>
            </td>
            <td>
                <form method="get" action="/passingActivitiesUser">
                    <input type="submit" value="User">
                </form>
            </td>
    </tr>
</table>
</body>
</html>