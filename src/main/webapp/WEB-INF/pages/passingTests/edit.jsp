<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Passing Test Activity</title>
</head>
<body>
<table>
    <%--<div align="center">--%>
        <%--<b>Activity Show Page</b>--%>
    <%--</div>--%>

   <%--<div class="bot-navigation" align="center"><span>&#9668;</span> <span>1</span> <a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a>--%>
            <%--<a href="">6</a> <a href="">7</a> <a href="">8</a> <a href="">9</a> <a href="">10</a> <span class="nav_ext">...</span><a href="">&#9658;</a></div>--%>


    <%--<div>--%>
            <%--<input type="submit" value="New question" title="Create new question">--%>
            <%--<input type="submit" value="Save question" title="Save the question">--%>
           <%--<input type="submit" value="Delete question" title="Delete the question">--%>
    <%--</div>--%>

    <%--<tr>--%>
        <%--<td>--%>
            <%--<br>--%>
            <%--<input type="text" placeholder="text of the test question" size="100">--%>
            <%--<br>--%>
            <%--&lt;%&ndash;<label>answer 1</label>&ndash;%&gt;--%>
            <%--<br>--%>
            <%--<input type="checkbox">--%>
            <%--<input type="text" placeholder="text of the test answer" name="1">--%>
            <%--<input type="submit" value="-" title="Delete the answer">--%>
            <%--<br>--%>
            <%--&lt;%&ndash;<label>answer 2</label>&ndash;%&gt;--%>
            <%--<br>--%>
           <%--<div><input type="checkbox">--%>
            <%--<input type="text" placeholder="text of the test answer" name="2">--%>
            <%--<input type="submit" value="-" title="Delete the answer">--%>
           <%--</div>--%>
            <%--<br>--%>
           <%--<div title="Add new answer"> <input type="submit" value="+"></div>--%>
        <%--</td>--%>
    <%--</tr>--%>

    <form name="links" method="post"><>
        <table id="tbl">
            <tr>
                <td><input type="text" name="name" width="60"></td>
                <td><input type="text" name="URL" width="60"></td>
                <td><input type="text" name="category" width="30"></td>
                <td><input type="button" onclick="add_new_row();" value="+"> </td>
            </tr>
        </table>
        <td><input type="submit"></td>
        <td><input type="reset"></td>
    </form>

    <SCRIPT  language = 'JavaScript'>
        var numb;
        numb = 1; // переменная для формирования идентификатора элемента
        function add_new_row() {
            var currrow;
            currow = document.all.tbl.rows.length; // вычислить количество строк в таблице
            numb++;
            document.all.tbl.insertRow(currow); // добавляем строку в таблицу
            document.all.tbl.rows[currow].insertCell(0); // добавляем ячейки
            document.all.tbl.rows[currow].insertCell(1);
            document.all.tbl.rows[currow].insertCell(2);
            document.all.tbl.rows[currow].insertCell(2);
            // вставляем в форму поля
            document.all.tbl.rows[currow].cells[0].innerHTML =
                    '<input type=\"text\" name=\"name_'+ numb +'\">';
            document.all.tbl.rows[currow].cells[1].innerHTML =
                    '<input type=\"text\" name=\"url_'+ numb+'\">';
            document.all.tbl.rows[currow].cells[2].innerHTML =
                    '<input type=\"text\" name=\"category_'+ numb+'\">';
            // кнопка для вызова функции для добавления следующей строки
            document.all.tbl.rows[currow].cells[3].innerHTML =
                    '<input type=button name=\"btnNext\" value=\"+\" onClick=\"add_new_row()\">';
        }
    </SCRIPT>


</table>
</body>
</html>
