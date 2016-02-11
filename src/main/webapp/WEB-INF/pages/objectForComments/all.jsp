<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">

    <c:forEach var="objectForComment" items="${}">
        <tr>
            <td>${objectForComment.id}</td>
            <td><form method="get" action="/comment">
                <input type="hidden" name="id" value=${objectForComment.id}>
                <input type="submit" value="Comments">
            </form>
            <td><a href="/edit?id=${objectForComment.id}">Edit</a> | <a href="/delete?id=${objectForComment.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/add">Add new one</a>
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