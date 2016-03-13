<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu box" width="auto">
<%--<div class="box">--%>
    <tr>

    </tr>
    <tr>
        <td>
            <form method="get" action="/activities">
                <input type="text" name="author">
                <input type="hidden" name="number" value="${paginator.pageSize}">
                <input type="submit" value="Search for author">
            </form>
            <form method="get" action="/activities">
            <input type="submit" value="Show All">
            </form>
            <form method="get" action="/activities">
                <input type="hidden" name="onlyMy" value="true">
                <input type="submit" value="Show yours">
            </form>
        </td>
    </tr>
    <tr></tr>
    <tr>
        <td><b>All activities </b> <c:if test="${author != null}">for <b> ${author}</b></c:if></td>
    </tr>
<%--</div>--%>
    <%--<div class="box">--%>
        <tr>
            <td class="subBox">Author of activity</td>
            <td class="subBox">Author first name</td>
            <td class="subBox">Author second name</td>
            <td class="subBox">Author age</td>
            <td class="subBox">Activity name</td>
            <td class="subBox">Activity target age</td>
            <td class="subBox">Activity type</td>
            <td class="subBox">Subject</td>
        </tr>
    <%--</div>--%>
    <c:forEach var="activity" items="${activities}">
        <tr>
            <div class="menu">
            <td>${activity.author.user.email}</td>
            <td>${activity.author.firstName}</td>
            <td>${activity.author.secondName}</td>
            <td>${activity.author.age}</td>
            <td>${activity.name}</td>
            <%--<td>${activity.targetAge}</td>--%>
            <%--<td>${activity.type}</td>--%>
            <%--<td>${activity.subject}</td>--%>
                <c:if test="${activity.type.ordinal()==1}">
                    <td><a href="/watchActivity?id=${activity.id}">View</a>
                        <c:if test="${activity.author.user.email == email}">|
                        <a href="/updateWatchActivity?id=${activity.id}">Edit</a> |
                        <a href="/deleteWatchActivity?id=${activity.id}">Delete</a></td>
                    </c:if>
                </c:if>
                <c:if test="${activity.type.ordinal()==2}">
                    <td><a href="/readActivity?id=${activity.id}">View</a>
                    <c:if test="${activity.author.user.email == email}">|
                        <a href="/updateReadActivity?id=${activity.id}">Edit</a> |
                        <a href="/deleteReadActivity?id=${activity.id}">Delete</a></td></c:if>
                </c:if>
                <c:if test="${activity.type.ordinal()==0}">
                    <c:if test="${activity.author.user.email == email}">
                        <td><a href="/passingTestActivity?id=${activity.id}">View</a> |
                        <a href="/editPassingTestActivity?id=${activity.id}">Edit</a> |
                        <a href="/deletePassingActivity?id=${activity.id}">Delete</a></td>
                    </c:if>
                    <c:if test="${activity.author.user.email != email}">
                <td><a href="/passingActivitiesUser?id=${activity.id}">View</a>
                </c:if>
                </c:if>
            </>

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
    <tr>
        <td>
            <form method="post" action="/createActivities">
                <input type="checkbox" name="num" value="watch">Watching Activity<Br>
                <input type="checkbox" name="num" value="read">Reading Activity<Br>
                <input type="checkbox" name="num" value="test">Test Activity<Br>
                <input type="submit" value="Create activities">
            </form>
        </td>
        <td><p>Show on page by number</p>
            <form method="get" action="/activities">
                <input type="text" name="number" value="${paginator.pageSize}">
                <c:if test="${author != null}"><input type="hidden" name="author" value="${author}"></c:if>
                <input type="submit" value="Number of activities">
            </form>
        </td>
    </tr>
</table>
<div align="right"><strong>${email}</strong></div>
</body>
