
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
  <c:forEach var="question" items="${questions}">
      <div>
          ${question}
      </div>
  </c:forEach>
</div>
<div>
    Name author: ${nameAuthor}
</div>

</body>
</html>
