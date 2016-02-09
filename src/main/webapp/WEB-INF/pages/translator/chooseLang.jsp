<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<select name="${param.selectName}">
    <c:forEach var="language" items="${translatorDto2.languages}">
        <c:choose>
            <c:when test="${param.languageFlag == language.fullName}">
                <option selected value="${language.shortName}">${language.fullName}</option>
            </c:when>
            <c:otherwise>
                <option value="${language.shortName}">${language.fullName}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select><br>

</body>
</html>
