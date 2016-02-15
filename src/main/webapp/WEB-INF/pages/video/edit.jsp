<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit content</title>
</head>
<body>
    <h2>${content.name}</h2>


<form:form action="/video/${type}/save" modelAttribute="newcontent">
    <table>
        <tr>
            <td>Name of Video: </td>
            <td><input type="text" name="name" value="${content.name}"></td>
        </tr>
        <tr>
            <td>URL: </td>
            <td><input type="text" name="url" value="${content.url}"></td>
        </tr>
        <tr>
            <td>Describe :</td>
            <td><input type="text" name="describe" value="${content.describe}"></td>
        </tr>
        <tr>
            <td><input type="hidden" name="id" value="${content.id}"></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>


</body>
</html>
