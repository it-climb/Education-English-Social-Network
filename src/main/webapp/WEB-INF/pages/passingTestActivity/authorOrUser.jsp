<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
    <title></title>
</head>
<body class="no-js">
<table width="600px">

    <p>    Author or User:</p>

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