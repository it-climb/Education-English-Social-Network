<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/activity-style.css" rel="stylesheet">
    <script src="resources/assets/plugins/bootstrap.js" type="text/javascript"></script>
    <script src="resources/assets/plugins/jquery.easing.min.js" type="text/javascript"></script>
    <meta charset="utf-8">
    <title>Add Watch Activity</title>
</head>
<body>
<form:form method="post" action="/addWatchActivity" modelAttribute="waDto">
    <div class="container activity-border">

        <h3>Share your knowledge</h3>

        <%--FORMAT--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Format*</h4></div>
            <div class="col-md-10">
                <div class="format">
                    <div class="separate-line">
                    <button href="/addWatchActivity" type="button" class="btn btn-primary"> Watching </button>
                    <button href="/addReadActivity" type="button" class="btn btn-default"> Reading </button>
                    <%--<button type="button" class="btn btn-default"> Typing </button>--%>
                    </div>
                    <div>
                        Link to video <br>
                        <input type="text" class="form-control" placeholder="Http://"  name="url" value="${waDto.url}">
                    </div>
                </div>
            </div>
        </div>

        <%--TITLE--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Title*</h4></div>
            <div class="col-md-10">
                <input type="text" class="form-control" placeholder="Activity Title" name="name" value="${waDto.name}">
            </div>
        </div>

        <%--TARGET AGE--%>
        <div class="row block-interval">
            <div class="col-md-2"><h4>Target Age*</h4></div>
            <div class="col-md-10">
                <div>
                    <button type="button" class="btn btn-primary"> 6+ </button>
                    <button type="button" class="btn btn-default"> 12+ </button>
                    <button type="button" class="btn btn-default"> 16+ </button>
                    <button type="button" class="btn btn-default"> 18+ </button>
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
</form:form>
</body>
</html>
