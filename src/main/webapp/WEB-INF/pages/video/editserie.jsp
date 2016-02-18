<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/video/${type}/saveserie" modelAttribute="newcontent">
    <table>
        <tr>
            <td>Name of Serie: </td>
            <td><input type="text" name="name" value="${content.name}"></td>
        </tr>
        <tr>
            <td>Unique number of Serie: </td>
            <td><input type="text" name="serieNumber" value="${content.serieNumber}"></td>
        </tr>
        <tr>
            <td>URL of Serie: </td>
            <td><input type="text" name="url" value="${content.url}"></td>
        </tr>
        <tr>
            <td>Describe of Serie: </td>
            <td><input type="text" name="describe" value="${content.describe}"></td>
        </tr>
        <tr>
            <td>
              <c:if test="${type = 'tvshow'}">
                  <input type="hidden" name="seasonNumber" value="${seasonNumber}">
              </c:if>
              <input type="hidden" name="id" value="${id}">
            </td>
            <td><input type="submit" value="Save serie"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
