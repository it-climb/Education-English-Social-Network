<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
    <h5><b>We are will translate here !!</b></h5>

    <form action="/translate/doTransl" method="post">
        <c:set var="translatorDto2" value="${translatorDto}" scope="request"/>

        Input Language:
        <jsp:include page="chooseLang.jsp">
            <jsp:param name="languageFlag" value="${translatorDto.languageIn.fullName}" />
            <jsp:param name="selectName" value="languageIn" />
        </jsp:include>
        <textarea rows="7" cols="70" name="textIn" autofocus maxlength="350">${translatorDto.textIn}</textarea><br><br>
        <p style="color: red">
            ${errorMassage}
        </p>
        Output Language:
        <jsp:include page="chooseLang.jsp">
            <jsp:param name="languageFlag" value="${translatorDto.languageOut.fullName}" />
            <jsp:param name="selectName" value="languageOut" />
        </jsp:include>
        <textarea rows="7" cols="70" name="textOut" readonly>${translatorDto.textOut}</textarea><br><br>

        <input type="submit" value="Translate !">
    </form>
</body>
</html>
