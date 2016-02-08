<%@ page import="evg.testt.model.Chat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>All</title>
    <link href="resources/assets/css/style.css" rel="stylesheet">
</head>
<body class="no-js">
<table class="menu">
    <tr>
        <td><b>Users List</b></td>
    </tr>
    <tr>
        <td></td>
        <td>
            <form method="get" action="/writeTo">
                <input type="hidden" name="recEmail" value="">
                <input type="submit" value="Write to all">
            </form>
        </td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <c:if test="${email != user.email}">
            <td><a href="/writeTo?recEmail=${user.email}">${user.email}</a></td>
            <!--
                <td>
                <form method="get" action="/writeTo">
                    <input type="hidden" name="recEmail" value=${user.email}>
                    <input type="submit" value="Write">
                </form>
            </td>
            -->
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

<div align="right"><strong>${email} </strong><a href="/">   Home</a></div>
<div id="chat">
    <form:form method="post" action="/chatAdd">
        <div id="containerChat">
            <table>
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
                <td width="50%">
                    <input type="text" name="message">
                </td>
                <td width="10%">
                    <input type="hidden" name="is121" value="false">
                    <input type="hidden" name="email" value="${email}">
                    <input type="hidden" name="recEmail" value="${receiver}">
                    <input type="submit" value="Send">
                </td>
                <td width="40%">
                    to: ${receiver}
                </td>
            </tr>
            <tr>
                <td><input type="hidden" name="receiver" value="${receiver}"></td>
            </tr>
        </table>
    </form:form>
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