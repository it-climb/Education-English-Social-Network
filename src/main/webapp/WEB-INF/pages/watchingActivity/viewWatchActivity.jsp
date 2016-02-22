
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
    <table>
        <tr>
            <td><h1>Name activity: ${nameActivity}</h1></td>
        </tr>
        <tr>
            <td>Name author: ${nameAuthor}</td>
        </tr>
        <tr>
            <iframe width="560" height="315" src="${URL}" frameborder="0" allowfullscreen></iframe>
        </tr>
        <tr>
            <td>Describe: ${describe}</td>
        </tr>
    </table>
</body>
</html>
