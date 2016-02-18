<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<table>
    <tr>
        <td><b>${typeName} name</b></td>
    </tr>
    <c:forEach var="content" items="${contents}">
        <tr>
            <c:choose>
                <c:when test="${id != null}">
                    <td> ${content.name}</td>
                    <td>
                        <form:form action="/video/${type}/delete" method="post">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="id" value="${id}">
                            <c:if test="${type == 'movie'}">
                                <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                            </c:if>
                            <c:if test="${type == 'tvshow'}">
                                <input type="hidden" name="seasonNumber" value="${content.seasonNumber}">
                            </c:if>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/video/${type}/update" method="post">
                            <input type="submit" value="Update">
                            <input type="hidden" name="id" value="${id}">
                            <c:if test="${type == 'movie'}">
                                <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                            </c:if>
                            <c:if test="${type == 'tvshow'}">
                                <input type="hidden" name="seasonNumber" value="${content.seasonNumber}">
                            </c:if>
                        </form:form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td><a href="/video/${type}/admin?id=${content.id}"> ${content.name}</a></td>
                    <td>
                        <form:form action="/video/${type}/delete" method="post">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="id" value="${content.id}">
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/video/${type}/update" method="post">
                            <input type="submit" value="Update">
                            <input type="hidden" name="id" value="${content.id}">
                        </form:form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    <c:choose>
        <c:when test="${id != null}">
            <c:if test="${type == 'movie'}">
                <form:form action="/video/${type}/addSerie" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="submit" value="Add new ${typeName}">
                </form:form>
            </c:if>
            <c:if test="${type == 'tvshow'}">
                <form:form action="/video/${type}/addSeason" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="submit" value="Add new Season">
                </form:form>
            </c:if>





        </c:when>
        <c:otherwise>
            <form:form action="/video/${type}/update" method="post">
                <input type="submit" value="Add new ${typeName}">
            </form:form>
        </c:otherwise>
    </c:choose>

</table>
<br>


<p><a href="/video">Back to Catalog</a></p>

</body>
</html>
