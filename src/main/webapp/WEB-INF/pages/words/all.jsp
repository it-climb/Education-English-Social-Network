<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>All</title>
</head>
<body class="no-js">
<table width="600px">
  <tr>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="word" items="${words}">
    <tr>
      <td>${word.name}</td>
      <td>
        <form method="post" action="/wordDelete">
          <input type="hidden" name="id" value=${word.id}>
          <input type="submit" value="Delete">
        </form>
      </td>
      <td><form method="post" action="/wordEdit">
            <input type="hidden" name="id" value=${word.id}>
            <input type="submit" value="Update">
          </form>
      </td>
      <td><form method="get" action="/description">
        <input type="hidden" name="id" value=${word.id}>
        <input type="submit" value="Description">
      </form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <form method="post" action="/wordEdit">
        <input type="submit" value="Add new word">
      </form>
    </td>
  </tr>
</table>

<br>
<a href="/">Home</a>
</body>
</html>