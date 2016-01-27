<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form method="post" action="/regSave">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"/></td>
            <td colspan="2"><input type="submit" value="OK"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
