<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/activity-style.css" rel="stylesheet">
    <script src="resources/assets/plugins/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="resources/assets/js/subjects.js"></script>
    <script type="text/javascript" src="resources/assets/js/test.js"></script>
    <meta charset="utf-8">
    <title>Add Read Activity</title>
</head>
<body onload="add_input();">
<form:form id="form" method="post" action="/addReadActivity" modelAttribute="raDto">
    <div class="container activity-border">

        <h3>Share your knowledge</h3>

            <%--FORMAT--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Format*</h4></div>
            <div class="col-md-10">
                <div class="format">
                    <div class="separate-line">
                        <%--<span id="3">111</span>--%>
                        <button id="1" type="button" class="btn btn-default" onclick="watchBtn()"> Watching </button>
                        <button id="2" type="button" class="btn btn-primary" onclick="readBtn()"> Reading </button>
                    <%--<button type="button" class="btn btn-default"> Typing </button>--%>
                    </div>
                    <div>
                        Text to read <br>
                        <input width="auto" type="text" class="form-control text-field" placeholder="Your text" id="textField"  name="text" value="${raDto.text}">
                    </div>
                </div>
            </div>
        </div>

            <%--TITLE--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Title*</h4></div>
            <div class="col-md-10">
                <input type="text" class="form-control" placeholder="Activity Title" id="nameField" name="name" value="${raDto.name}">
            </div>
        </div>

            <%--TARGET AGE--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Target Age*</h4></div>
            <div class="col-md-10">
                <div>
                    <button id="4" type="button" class="btn btn-primary" onclick="ageBtn(4)"> 6+ </button>
                    <button id="5" type="button" class="btn btn-default" onclick="ageBtn(5)"> 12+ </button>
                    <button id="6" type="button" class="btn btn-default" onclick="ageBtn(6)"> 16+ </button>
                    <button id="7" type="button" class="btn btn-default" onclick="ageBtn(7)"> 18+ </button>
                </div>
            </div>
        </div>
            <%--SUBJECTS--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Subjects*</h4></div>
            <div class="col-md-10">
                <div class="separate-line">
                    <div class="row">
                        <div id="inputs" class="col-md-7">
                        </div>
                        <div id="btns" class="col-md-5">
                        </div>
                    </div>
                    <a onclick="add_input()">Add one more subject</a>
                    <a onclick="del_input()">Delete last</a>
                </div>
            </div>
        </div>
            <%--BUTTON--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4></h4></div>
            <div class="col-md-10">
                <div>
                    <button type="submit" class="btn btn-primary btn-lg">Save</button>
                    <button type="reset" class="btn btn-default btn-lg">Cancel</button>
                    <%--<input type="hidden" id="10" name="listOfSubj">--%>
                    <%--<input type="hidden" id="listOfSubj" value="">List</input>--%>
                    <%--<button type="button" id="selector" value="click">Lisy</button>--%>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
