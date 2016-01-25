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
