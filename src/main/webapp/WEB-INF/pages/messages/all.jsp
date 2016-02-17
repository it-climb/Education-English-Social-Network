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
        <td>
            <b>Users List</b>
        </td>
        <td>
            <form method="get" action="/chat">
                <input type="hidden" name="recEmail" value=${user.email}>
                <input type="submit" value="All chat">
            </form>
        </td>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:if test="${email != user.email}">
        <tr>
            <td>
                ${user.email}
            </td>
            <td>
                <form method="get" action="/messages">
                    <input type="hidden" name="recEmail" value=${user.email}>
                    <input type="submit" value="OneToOne">
                </form>
            </td>
        </tr>
        </c:if>
    </c:forEach>
</table>
<div align="right"><strong>${email}</strong></div>
<div id="chat" style="float:right">
    <form:form method="post" action="/chatAdd">
        <div id="containerChat">
            <table>
                <tr><td>My companion : ${receiver}</td></tr>
                <c:forEach var="chat" items="${chat}">
                    <c:if test="${chat.receiver == email && receiver == chat.user.email}">
                        <tr>
                            <td><span class="whisperF">From ${chat.getUser().email} : ${chat.message}</span></td>
                        </tr>
                    </c:if>
                    <c:if test="${chat.user.email == email && receiver == chat.receiver}">
                        <tr>
                            <td><span class="whisperT">To ${chat.receiver} : ${chat.message}</span></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
        <div id = "containerSender">
        <table>
            <tr>
                <td>
                    <input width="30%" type="text" name="message">
                </td>
                <td colspan="5">
                    <input type="hidden" name="is121" value="true">
                    <input type="hidden" name="email" value="${email}">
                    <input type="hidden" name="recEmail" value="${receiver}">
                    <input type="submit" value="Send">
                </td>
            </tr>
            <tr>
                <%--<td>(not required)Receiver:</td>--%>
                <td><input type="hidden" name="receiver" value="${receiver}"></td>
            </tr>
        </table>
        </div>
    </form:form><%--
    <tr>
        <td colspan="5">
            <input type="button" href="/chat" value="Chat for all"/>
        </td>
        <td colspan="5">
            <input type="button" href="/" value="Home"/>
        </td>
    </tr>--%>
</div>
<a href="/">Home</a>
</body>
</html>