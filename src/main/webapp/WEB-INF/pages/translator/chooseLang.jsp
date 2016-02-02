<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<%--<tiles:insertDefinition name="base-template" />--%>
        <select name="${param.selectName}">
            <c:forEach var="language" items="${translatorDto2.languages}">
                <c:choose>
                    <c:when test="${param.languageFlag == language.languageName}">
                        <option selected>${language.languageName}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${language.languageName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>

</body>
</html>
