
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video play</title>
</head>
<body>

    <h2 align="center">${content.name}</h2>

    <iframe width="560" height="315" src="${content.url}" frameborder="3" allowfullscreen></iframe>

    <p><a href="/video">Back to catalog</a></p>

</body>
</html>
