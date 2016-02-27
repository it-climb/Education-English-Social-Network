<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add general controller</title>
</head>
<body>
    <form id="global" action="/addGeneralActivity" method="post">
       <p><b>Name activity</b><br>
           <input type="text" name="activityName" size="40">
       </p>
        <p>Subject <b>English</b>
            <select>
                <option value="EASY">EASY</option>
                <option value="NORMAL">NORMAL</option>
                <option value="HARD">HARD</option>
            </select>
        </p>
        <p>
            <input type="submit" value="Send">
            <input type="reset" value="Reset">
        </p>
    </form>

</body>
</html>
