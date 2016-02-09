<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<head>
  <title>All</title>
  <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table id="menu" width="1000px">
  <tr>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td>${department.name}</td>
      <td>
        <form method="post" action="/depDelete">
          <input type="hidden" name="id" value=${department.id}>
          <input type="submit" value="Delete">
        </form>
      </td>
      <td><form method="post" action="/depEdit">
            <input type="hidden" name="id" value=${department.id}>
            <input type="submit" value="Update">
          </form>
      </td>
      <td><form method="get" action="/employees">
        <input type="hidden" name="id" value=${department.id}>
        <input type="submit" value="Employees">
      </form>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <form method="post" action="/depEdit">
        <input type="submit" value="Add new one">
      </form>
    </td>
  </tr>
</table>
<div align="right"><strong>${email}</strong></div>
<a href="/">Home</a>
</body>
</html>