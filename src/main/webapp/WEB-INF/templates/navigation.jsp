<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top scrollclass">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">EESN</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"> <spring:message code="home.home"/> </a></li>
                <li><a href="/login"><spring:message code="home.login"/></a></li>
                <li><a href="/dep"><spring:message code="home.departments"/> </a></li>
                <li><a href="/chat"><spring:message code="home.chat"/></a></li>
                <li><a href="/points">POINTS</a></li>
                <li><a href="/translate"><spring:message code="home.translator"/></a></li>
                <%--<li><a href="/login">SIGN IN</a></li>--%>
                <%--<li><a href="/regSave">SIGN UP</a></li>--%>
                <li><a href="/video">VIDEO</a></li>
                <%--<li><a href="#contact"><spring:message code="home.contact"/></a></li>--%>
                <li><a href="/activities">ACTIVITIES</a></li>
                <%--<li><a href="#social-section"><spring:message code="home.social"/></a></li>--%>
                <li><a href="/account">ACCOUNT</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>


