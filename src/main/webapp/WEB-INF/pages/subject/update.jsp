
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

    <form action="/subjectSave" method="post">
        <table>
            <tr>
                <td>Subject name:</td>
                <td><input type="text" value="${subject.name}" name="name"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value="${subject.id}"></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>

</body>
</html>
