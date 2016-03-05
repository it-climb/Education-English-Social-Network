<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu" width="1000px">
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
<c:if test="${author != null}"><input type="hidden" name="author" value="${author}"></c:if>
                <input type="submit" value="Number of activities">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/activities">
                <input type="text" name="author">
                <input type="hidden" name="number" value="${paginator.pageSize}">
                <input type="submit" value="Search for author">
            </form>
        </td>
    </tr>
    <tr></tr>
    <tr>
        <td><b>All activities </b> <c:if test="${author != null}">for <b> ${author}</b></c:if></td>
    </tr>
    <tr>
        <td>Author of activity</td>
        <td>Author first name</td>
        <td>Author second name</td>
        <td>Author age</td>
        <td>Activity name</td>
        <td>Activity target age</td>
        <td>Activity type</td>
        <td>Subject</td>
    </tr>
    <c:forEach var="activity" items="${activities}">
        <tr>
            <td>${activity.author.user.email}</td>
            <td>${activity.author.firstName}</td>
            <td>${activity.author.secondName}</td>
            <td>${activity.author.age}</td>
            <td>${activity.name}</td>
            <c:if test="${activity.type.ordinal()==1}">
                <td><a href="/watchActivity?id=${activity.id}">View</a> |
                    <a href="/updateWatchActivity?id=${activity.id}">Edit</a> |
                    <a href="/deleteWatchActivity?id=${activity.id}">Delete</a></td>
            </c:if>


         <%--   <td>${activity.targetAge}</td>--%>
        <%--<c:forEach var="subject" items="${activity.subjects}">--%>
            <%--<td>${subject.name}</td>--%>
        <%--</c:forEach>--%>
            <%--<td>--%>
                <%--<form method="post" action="/addSubjectInActivity">--%>
                    <%--<input type="text" name="name">--%>
                    <%--<input type="hidden" name="activityID" value="${activity.id}">--%>
                    <%--<input type="submit" value="add">--%>
                <%--</form>--%>
            <%--</td>--%>
            <%--<td>${activity.}</td>--%>
        </tr>
    </c:forEach>
    <tr>
        <td>
<c:if test="${author == null}">
        <%--<a href="/activities?page=1">first</a>  |--%>
            <c:if test="${paginator.hasPrevious()}">
                <a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}">previous</a>  |
                </c:if>
            current: ${paginator.getPageNumber()+1}  |
            <a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}">next</a>  |
        <%--<a href="/activities?page="></a>last--%>
</c:if>
<c:if test="${author != null}">
    <c:if test="${paginator.hasPrevious()}">
        <a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}&author=${author}">previous</a>  |
    </c:if>
    current: ${paginator.getPageNumber()+1}  |
    <a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}&author=${author}">next</a>  |
</c:if>
        </td>
    </tr>
</table>
<div align="right"><strong>${email}</strong></div>
</body>
