<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Passing Test Activity</title>
</head>
<body>
<table>
    <div align="center">
        <b>Activity Show Page</b>
    </div>

   <div class="bot-navigation" align="center"><span>&#9668;</span> <span>1</span> <a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a>
            <a href="">6</a> <a href="">7</a> <a href="">8</a> <a href="">9</a> <a href="">10</a> <span class="nav_ext">...</span><a href="">&#9658;</a></div>


    <div>
            <input type="submit" value="New question" title="Create new question">
            <input type="submit" value="Save question" title="Save the question">
           <input type="submit" value="Delete question" title="Delete the question">
    </div>

    <tr>
        <td>
            <br>
            <input type="text" value="text of the test question" size="100">
            <br>
            <label>answer 1</label>
            <br>
            <input type="checkbox">
            <input type="text" value="text of the test answer" name="1">
            <input type="submit" value="-" title="Delete the answer">
            <br>
            <label>answer 2</label>
            <br>
           <div><input type="checkbox">
            <input type="text" value="text of the test answer" name="2">
            <input type="submit" value="-" title="Delete the answer">
           </div>
            <br>
           <div title="Add new answer"> <input type="submit" value="+"></div>
        </td>
    </tr>


</table>
</body>
</html>
