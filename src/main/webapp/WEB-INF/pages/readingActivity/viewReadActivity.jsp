<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/activity-style.css" rel="stylesheet">
    <script src="resources/assets/plugins/bootstrap.js" type="text/javascript"></script>
    <script src="resources/assets/plugins/jquery.easing.min.js" type="text/javascript"></script>
    <meta charset="utf-8">
    <title>View</title>
</head>
<body>
<div class="container activity-border">

    <%--VIEW HEAD--%>
    <div class="row block-interval">
        <div class="col-md-11">
            <h3 class="activity-padding">${nameActivity}<span class="label label-info">read</span><span class="label label-success">test</span></h3>
        </div>
        <div class="col-md-1">
            <h3>12+</h3>
        </div>
    </div>
        </br>

    <%--BODY--%>
    <div class="row block-interval">
        <div class="col-md-12">
            <div class="embed-responsive embed-responsive-16by9 activity-padding">
                <p>${text}</p>
                <hr class="separate-line block-interval-line">
            </div>
        </div>
    </div>

    <%--FOOTER--%>
    <div class="row block-interval activity-padding">
        <div class="col-md-8">
            Physical Science(easy)<br>
            Math(hard)<br>
            Something(normal)<br>
        </div>
        <div class="col-md-4" align="right">
            <tr>Date of create by <a>${nameAuthor}</a></tr>
            <tr>
                <span class="glyphicon glyphicon-star yellow" aria-hidden="true"></span>
                <span class="glyphicon glyphicon-star yellow" aria-hidden="true"></span>
                <span class="glyphicon glyphicon-star yellow" aria-hidden="true"></span>
                <span class="glyphicon glyphicon-star yellow" aria-hidden="true"></span>
                <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            </tr>
        </div>
    </div>

</div>
</body>
</html>
