<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<head>
  <%--<link href="resources/assets/css/stylepages.css" rel="stylesheet">--%>
  <title>All</title>
</head>
<body>

  <table width="200px">
    <tr>
      <td width="200"><b>Departments:</b></td>
    </tr>
  </table>
  <table width="500" border="2" valign="middle">

    <tr>
      <td width="50" align="center" ><b>ID</b></td>
      <td width="100" align="center" ><b>Name</b></td>
      <td colspan="3" align="center"><b>Actions</b></td>
    </tr>

    <c:forEach var="department" items="${departments}">

          <tr>
            <td width="50" align="center">${department.id}</td>
            <td width="100">   ${department.name}</td>

            <td width="70" align="center" valign="middle">
              <form method="post" action="/depDelete">
                <input type="hidden" name="id" value=${department.id}>
                <input type="submit" value="Delete">
              </form>
            </td>


            <td width="70" align="center" valign="middle">
              <form method="post" action="/depEdit">
              <input type="hidden" name="id" value=${department.id}>
              <input type="submit" value="Update">
              </form>
            </td>

            <td width="100" align="center" valign="middle">
              <form method="get" action="/employees">
              <input type="hidden" name="id" value=${department.id}>
              <input type="submit" value="Employees">
              </form>
            </td>

          </tr>
        </c:forEach>
    <br>
    </table>
    <table width=300px valign="middle">
      <tr>
        <td align="center" valign="middle">
          <form method="post" action="/depEdit">
            <input type="submit" value="Add new one">
          </form>
        </td>
      </tr>
    </table>

</body>
</html>
