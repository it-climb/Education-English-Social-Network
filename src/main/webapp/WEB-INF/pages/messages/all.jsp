<%@ page import="evg.testt.model.Chat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<div id = "navBar"><a href="/">Home</a></div>
<div id = "userInfo"><strong>${email}</strong></div>
<div style="clear: both"></div>

<table class="menu">
    <tr>
        <td>
            <form method="get" action="/chat">
                <input type="hidden" name="recEmail" value=${user.email}>
                <input type="submit" value="All chat">
            </form>
        </td>
    </tr>

    <tr>
        <td>
            <b>Users List</b>
        </td>
    </tr>

    <c:forEach var="user" items="${users}">
        <c:if test="${email != user.email}">
        <tr>
            <td>
                <a href="/messages?recEmail=${user.email}">${user.email}</a>
            </td>
            <!--
            <td>
                <form method="get" action="/messages">
                    <input type="hidden" name="recEmail" value=${user.email}>
                    <input type="submit" value="OneToOne">
                </form>
            </td>
            -->
        </tr>
        </c:if>
    </c:forEach>
</table>
<div id="chat">
    <div>
        <span style="background: grey; color: white">My companion: ${receiver}</span>
        </div>
    <form:form method="post" action="/chatAdd">
        <div id="containerChat">
            <table>
                <tr>
                    <td></td>
                </tr>
                <c:forEach var="chat" items="${chat}">
                    <c:if test="${chat.receiver == email && receiver == chat.user.email}">
                        <tr>
                            <td><span class="pWhisperF">To me: ${chat.message}</span></td>
                        </tr>
                    </c:if>
                    <c:if test="${chat.user.email == email && receiver == chat.receiver}">
                        <tr>
                            <td><span class="pWhisperT">From me: ${chat.message}</span></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
        <div id = "containerSender">
        <table>
            <tr>
                <td>
                    <input class="inputField" type="text" name="message">
                </td>
                <td width="10%">
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

<script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script>
    $(document).ready(function(){
        var height = $('#containerChat')[0].scrollHeight;
        $('#containerChat').scrollTop(height);
    });
</script>

</body>
</html>