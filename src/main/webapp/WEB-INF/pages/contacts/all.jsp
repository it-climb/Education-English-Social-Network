<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>ID</b></td>
        <td><b>Name</b></td>
        <td><b>Number</b></td>
        <td><b>E-mail</b></td>
        <td><b>Action</b></td>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.number}</td>
            <td>${contact.email}</td>
            <td><a href="/edit?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5
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