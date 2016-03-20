<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/activity-style.css" rel="stylesheet">
    <script src="resources/assets/plugins/bootstrap.js" type="text/javascript"></script>
    <%--<script src="resources/assets/plugins/jquery.easing.min.js" type="text/javascript"></script>--%>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <meta charset="utf-8">
    <title>Add Watch Activity</title>
</head>
<body>
<form:form name="addActivity" method="post" action="/addReadActivity" modelAttribute="raDto">
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
                        <input width="auto" type="text" class="form-control text-field" placeholder="Your text"  name="text" value="${raDto.text}">
                    </div>
                </div>
            </div>
        </div>

            <%--TITLE--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Title*</h4></div>
            <div class="col-md-10">
                <input type="text" class="form-control" placeholder="Activity Title" name="name" value="${raDto.name}">
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
                        <div class="col-md-7">
                            <input type="text" class="form-control" placeholder="Subject Title">
                        </div>
                        <div class="col-md-5">
                            <button type="button" class="btn btn-primary"> Easy </button>
                            <button type="button" class="btn btn-default"> Normal </button>
                            <button type="button" class="btn btn-default"> Hard </button> <br>
                        </div>
                    </div>
                    <a>Add one more subject</a>
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
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function ageBtn(id){
            if (id == 4){document.getElementById('4').classList.remove("btn-default").remove("btn-primary").add("btn-primary");}else{document.getElementById('4').classList.remove("btn-default").add("btn-default")}
            if (id == 5){document.getElementById('5').classList.remove("btn-default").remove("btn-primary").add("btn-primary");}else{document.getElementById('5').classList.remove("btn-default").add("btn-default")}
            if (id == 6){document.getElementById('6').classList.remove("btn-default").remove("btn-primary").add("btn-primary");}else{document.getElementById('6').classList.remove("btn-default").add("btn-default")}
            if (id == 7){document.getElementById('7').classList.remove("btn-default").remove("btn-primary").add("btn-primary");}else{document.getElementById('7').classList.remove("btn-default").add("btn-default")}
        }
        function readBtn() {
            document.getElementById('1').classList.remove("btn-primary");
//            document.getElementById('1').classList.remove("btn-default");
            document.getElementById('1').classList.add("btn-default");
            document.getElementById('2').classList.remove("btn-default");
//            document.getElementById('2').classList.remove("btn-primary");
            document.getElementById('2').classList.add("btn-primary");
        }
        function watchBtn() {
            document.getElementById('1').classList.remove("btn-default");
            document.getElementById('1').classList.remove("btn-primary");
            document.getElementById('1').classList.add("btn-primary");
            document.getElementById('2').classList.remove("btn-primary");
//            document.getElementById('2').classList.remove("btn-default");
            document.getElementById('2').classList.add("btn-default");
        }
    </script>
</form:form>
</body>
</html>
