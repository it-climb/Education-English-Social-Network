
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>

    <div>
        <h3>Name activity: ${nameActivity}</h3>
    </div>
    <div>
        Name author: ${nameAuthor}
    </div>
    <table width="auto">
        Text: ${text}
    </table>
    <div><input type="button" value="I have already read"></div>
</body>
</html>
