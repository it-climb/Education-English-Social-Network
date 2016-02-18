<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit content</title>
</head>
<body>
    <h2>${content.name}</h2>


<form:form action="/video/${type}/save" modelAttribute="newcontent">
    <table>
        <tr>
            <td>Name of ${type}: </td>
            <td><input type="text" name="name" value="${content.name}"></td>
        </tr>

        <c:if test="${type == 'video'}">
            <tr>
                <td>URL: </td>
                <td><input type="text" name="url" value="${content.url}"></td>
            </tr>
        </c:if>
        <tr>
            <td>Describe :</td>
            <td><input type="text" name="describe" value="${content.describe}"></td>
        </tr>

        <tr>
            <td>
                <c:choose>
                    <c:when test="${id != null}">
                        <input type="hidden" name="id" value="${id}">
                        <input type="hidden" name="seasonNumber" value="${content.seasonNumber}">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="id" value="${content.id}">
                    </c:otherwise>
                </c:choose>
               <%-- <input type="hidden" name="season" value="${season}"></td>--%>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
