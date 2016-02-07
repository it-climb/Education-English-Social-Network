<%@ page import="evg.testt.model.Chat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu" width="1000px">
    <tr>
        <td><b>Users List</b></td>
    </tr>
    <tr>
        <td><td>
        <td>
            <form method="get" action="/writeTo">
                <input type="hidden" name="recEmail" value="">
                <input type="submit" value="Write to all">
            </form>
        </td>
        <td></td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <c:if test="${email != user.email}">
            <td>${user.email}</td>
            <td>
                <form method="get" action="/writeTo">
                    <input type="hidden" name="recEmail" value=${user.email}>
                    <input type="submit" value="Write">
                </form>
            </td>
            <td>
                <form method="get" action="/messages">
                <input type="hidden" name="recEmail" value=${user.email}>
                <input type="submit" value="OneToOne">
                </form>
            </td>
            </c:if>
        </tr>
    </c:forEach>
</table>

<div align="right"><strong>${email}</strong></div>
<div class="chat">
    <form:form method="post" action="/chatAdd">
        <div id="containerChat">
            <table>
                <tr><td>My companion : ${receiver}</td></tr>
                <c:forEach var="chat" items="${chat}">
                    <c:if test="${chat.receiver == null}">
                        <tr>
                            <td>${chat.getUser().email}:${chat.message}</td>
                        </tr>
                    </c:if>
                    <c:if test="${chat.receiver == email}">
                        <tr>
                            <td><span class="whisperF">From ${chat.getUser().email} : ${chat.message}</span></td>
                        </tr>
                    </c:if>
                    <c:if test="${chat.user.email == email && (chat.receiver != null)}">
                        <tr>
                            <td><span class="whisperT">To ${chat.receiver} : ${chat.message}</span></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
        <table class="chat">
            <tr>
                <td>
                    <input width="30%" type="text" name="message">
                </td>
                <td colspan="5">
                    <input type="hidden" name="is121" value="false">
                    <input type="hidden" name="email" value="${email}">
                    <input type="hidden" name="recEmail" value="${receiver}">
                    <input type="submit" value="Send">
                </td>
            </tr>
            <tr>
                <td><input type="hidden" name="receiver" value="${receiver}"></td>
            </tr>
        </table>
    </form:form>
</div>
<a href="/">Home</a>
</body>
</html>