<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Passing Test Activity</title>
</head>
<body>
<table >
    <div align="center">
        <b>Activity Show Page</b>
    </div>

   <div class="bot-navigation" align="center"><span>&#9668;</span> <span>1</span> <a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a>
            <a href="">6</a> <a href="">7</a> <a href="">8</a> <a href="">9</a> <a href="">10</a> <span class="nav_ext">...</span><a href="">&#9658;</a></div>


    <tr>
        <td>
         <form method="post" action="/newTestQ">
             <input type="submit" value="New question" title="Create new question">
         </form>
        </td>
        <td>
         <form method="post" action="/saveQ" name="save">
             <input type="submit" value="Save question" title="Save the question">
         </form>
        </td>
        <td>
           <input type="submit" value="Delete question" title="Delete the question">
        </td>
    </tr>

    <tr>

        <td>
            <form method="post" action="/saveQ" name="save">
            <br>
            <input type="text" placeholder="text of the test question" size="100" name="question" value="${passingTestData.question}">
            <br>
            <div class="multi-field-wrapper">
                <div class="multi-fields">
                    <div class="multi-field">
                        <br>
                        <input type="checkbox">
                        <input type="text" name="stuff[]" placeholder="new answer">
                        <button type="button" class="remove-field">Delete</button>
                        <br>
                    </div>
                </div>
                <br>
                <div> <button type="button" class="add-field">Add answer</button></div>
            </div>
            </form>
            </td>
    </tr>

        <script  src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
        <script type="text/javascript">
            $('.multi-field-wrapper').each(function() {
                var $wrapper = $('.multi-fields', this);
                $(".add-field", $(this)).click(function(e) {
                    $('.multi-field:first-child', $wrapper).clone(true).appendTo($wrapper).find('input').val('').focus();
                });
                $('.multi-field .remove-field', $wrapper).click(function() {
                    if ($('.multi-field', $wrapper).length > 1)
                        $(this).parent('.multi-field').remove();
                });
            });

        </script>
</table>
</body>
</html>

