<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu" width="1000px">
    <tr>
        <td><b>Users List</b></td>
    </tr>
    <tr>
        <td><td>
        <td>
            <form method="get" action="/writeTo">
                <input type="hidden" name="recEmail" value="">
                <input type="submit" value="Write to all">
            </form>
        </td>
        <td></td>
    </tr>
    <c:forEach var="activity" items="${activities}">
        <tr>
            <td>${activity.name}</td>
        </tr>
    </c:forEach>
</table>
