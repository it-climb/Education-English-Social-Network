<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="resources/assets/css/stylepages.css" rel="stylesheet">
    <title>Translate</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="/resources/assets/jsp/navigationbar.jsp"%>
  </div>
    <div id="content">

           <h5><b>We are will translate here !!</b></h5>

           <form action="/doTransl" method="post">
            <c:set var="translatorDto2" value="${translatorDto}" scope="request"/>
            Input Language:
            <jsp:include page="chooseLang.jsp">
                <jsp:param name="languageFlag" value="${translatorDto.languageIn.languageName}" />
                <jsp:param name="selectName" value="languageIn" />
            </jsp:include>
            <textarea rows="7" cols="70" name="textIn" autofocus maxlength="350">${translatorDto.textIn}</textarea><br><br>

            Output Language:
            <jsp:include page="chooseLang.jsp">
                <jsp:param name="languageFlag" value="${translatorDto.languageOut.languageName}" />
                <jsp:param name="selectName" value="languageOut" />
            </jsp:include>
            <textarea rows="7" cols="70" name="textOut" readonly>${translatorDto.textOut}</textarea><br><br>
            <input type="submit" value="Translate !">
        </form>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>

