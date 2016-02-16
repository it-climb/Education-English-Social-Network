
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="ui.bootstrap.demo">
<head>
    <title></title>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.1.2.js"></script>


    <script src="resources/assets/js/example.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div ng-controller="RatingDemoCtrl">
    <uib-rating ng-model="rate" max="max" readonly="isReadonly" on-hover="hoveringOver(value)"
                on-leave="overStar = null" titles="['one','two','three']"
                aria-labelledby="default-rating"></uib-rating>
                 <span class="label"
                       ng-class="{'label-warning': percent<30, 'label-info': percent>=30 && percent<70, 'label-success': percent>=70}"
                       ng-show="overStar && !isReadonly">{{percent}}%</span>
    <form id="aaa" name="aaa" action="/depSaveStars" method="post">
        <input type="hidden" name="rate" ng-value="rate"/>

        <input type="hidden" name="id" value="">
        <input type="submit" value="Export">/>
    </form>

</div>
</body>
</html>
