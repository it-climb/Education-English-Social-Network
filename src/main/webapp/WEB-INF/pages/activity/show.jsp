<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu" width="1000px">

    <tr>
        <td><b>All activities</b></td>
    </tr>
    <tr>
        <td>
            <form method="post" action="/createTestActivities">
                <input type="text" name="num">
                <input type="submit" value="Create test activities">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/activities">
                <input type="text" name="number" value="${paginator.pageSize}">
                <%--<input type="hidden" name="page" value="${paginator.pageNumber}">--%>
                <input type="submit" value="Number of activities">
            </form>
        </td>
    </tr>
    <c:forEach var="activity" items="${activities}">
        <tr>
            <td>${activity.author}</td>
            <td>${activity.name}</td>
            <td>${activity.targetAge}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <%--<a href="/activities?page=1">first</a>  |--%>
            <c:if test="${paginator.hasPrevious()}">
                <a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}">previous</a>  |
                </c:if>
            current: ${paginator.getPageNumber()+1}  |
            <a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}">next</a>  |
        <%--<a href="/activities?page="></a>last--%>
        </td>
    </tr>
</table>
<div align="right"><strong>${email}</strong></div>

</body>
