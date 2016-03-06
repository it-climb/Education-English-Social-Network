
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
    <div align="left">
        <iframe width="560" height="315" src="${URL}" frameborder="0" allowfullscreen></iframe>
    </div>
    <div>
        Name author: ${nameAuthor}
    </div>
    <p>
        Describe: ${describe}
    </p>
    <div><input type="button" value="I understood"></div>
</body>
</html>
