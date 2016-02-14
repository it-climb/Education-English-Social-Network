<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<link href="resources/assets/css/stylepages.css" rel="stylesheet">--%>
    <title>Edit Department</title>
</head>
<body>
        <form:form method="post" action="/depSaveOrUpdate">
            <table>
                <tr>
                    <td height="50" width="200">New Department Name:</td>
                    <td height="30"><input type="text" name="name" value="${department.name}"/></td>
                </tr>
                </table>
            <table width="200">
                <tr>
                    <td width="50" align="center" height="20">
                        <input type="hidden" name="id" value=${department.id}>
                        <input type="hidden" name="comment_id" value=${comment.id}>
                        <input type="submit" value="Add">
                    </td>
                    <td width="50" height="20">
                        <form method="post" action="/dep">
                            <input type="submit" value="Cancel">
                        </form>
                    </td>


                        <tr>
                            <td colspan="2">
                                <input type="submit" />
                            </td>
                        </tr>


                </tr>
            </table>
        </form:form>

        <table width="600px">
            <tr>
                <td><b>ID</b></td>
                <td><b>className</b></td>
                <td><b>classId</b></td>
                <td><b>Comment</b></td>
                <td><b>Date</b></td>
            </tr>

            <c:forEach var="comment" items="${comments}">
                <tr>
                    <td>${comment.id}</td>
                    <td>${comment.className}</td>
                    <td>${comment.classId}</td>
                    <td>${comment.comment}</td>
                    <td>${comment.data}</td>

                    <td><a href="/editComment?id=${comment.id}">Edit</a> | <a href="/deleteComment?id=${comment.id}">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a href="/addComment">Add new one</a>
                </td>
            </tr>
        </table>
        <%--</div>--%>
<%--</div>--%>
</body>
</html>
