<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
    <title>All</title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>ID</b></td>
        <td><b>Comment</b></td>
        <td><b>Date</b></td>
        <td><b>User</b></td>
        <td><b>Action</b></td>
    </tr>

    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.objectForComments}</td>
            <td>${comment.data}</td>
            <td>${comment.userAcc}</td>
            <td><a href="/editComment?id=${comment.id}">Edit</a> | <a href="/deleteComment?id=${comment.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/addComment">Add new one</a>
        </td>
    </tr>
</table>
</body>


<!--data-ads="//agora-direct.mediagraph.com/vast/RXk6A-V6m5qhulVM.xml"-->

<script src="http://localhost:9000/_adaptivem.js" data-player
        data-placement="12746-4835f8fb470588a894dc3c1e5e19d497"
        data-placement-url="//data.mediagraph.com/widgets/{{id}}.jsonp"
        data-ads="null"
        data-width="425"
        data-height="319"
        data-debug="true">
</script>

</html>