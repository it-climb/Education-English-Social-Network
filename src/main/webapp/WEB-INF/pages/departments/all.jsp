<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<head>
  <title>All Departments</title>
</head>
<body class="no-js">
<div align="right"><strong>${email}</strong></div>
<table width="600px">
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
</body>
</html>
