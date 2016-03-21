<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <!--[if IE]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <![endif]-->
  <title> Education English Social Network </title>
  <!--REQUIRED STYLE SHEETS-->
  <!-- BOOTSTRAP CORE STYLE CSS -->
  <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
  <!-- FONTAWESOME STYLE CSS -->
  <link href="resources/assets/css/font-awesome.min.css" rel="stylesheet">
  <!-- VEGAS STYLE CSS -->
  <link href="resources/assets/scripts/vegas/jquery.vegas.min.css" rel="stylesheet">
  <!-- CUSTOM STYLE CSS -->
  <link href="resources/assets/css/style.css" rel="stylesheet">
  <!-- GOOGLE FONT -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="row">
      <div class="col-md-1">

        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">
              <img alt="Brand" src="resources/assets/img/logo.png" class="img-circle">

            </a>
          </div>
        </div>
      </div>
      <div class="col-md-1">
               <span class="brand">
                  <p class="navbar-text"><strong>EESN</strong></p>

               </span>
      </div>
      <div class="col-md-2"></div>
      <div class="col-md-4">

        <div class="header-search">
          <div class="input-group input-group-lg">
            <span class="input-group-addon">Catalog</span>
            <input type="text" class="form-control" placeholder="Search for knowledge...">
            <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button></span>
          </div>
        </div>
      </div>
      <div class="col-md-2"></div>
      <div class="col-md-2" >
          <a href="/login" role="button" type="button" class="btn btn-link btn-lg reg">Log In</a>
          <a href="/regSave" role="button" type="button" class="btn btn-primary btn-lg reg">Sign Up</a>
      </div>
    </div>
  </nav>
</div>




<div class="content">
  <div class="jumbotron" >
    <div class="row">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
        <div class="one">
          <div class="input-group input-group-lg" >

            <input type="text" class="form-control" placeholder="Search for knowledge...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="title-content">
    Most Popular Courses
  </div>
  <div class="row">
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>How to Climb in Java World</h4></a>
              by Ievgen Grabets
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>How to Get Fat in 3 Month</h4></a>
              by Pavel Brilliant
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>How to Skive Standup Calls</h4></a>
              by Danil Lapirow
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>The Youngest Hero</h4></a>
              by Alex Kobets
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
  </div>
  <div class="title-content">
    Last Added Courses
  </div>
  <div class="row">
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>From Poland to Java</h4></a>
              by Ruslan Skira
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>Code Like a Superman</h4></a>
              by Valerii Kukharchuk
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>Support is Above Everything</h4></a>
              by Sergei Bragin
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
    <div class="col-sm-6 col-md-3">
      <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="thumbnail">
            <img src="resources/assets/img/logo.png" class="img-rounded">
            <div class="caption">
              <a><h4>Batman Engineering Tricks</h4></a>
              by Alex Kachura
            </div>
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
  </div>
</div>
<div class="bottom">
  <div class="row">
    <div class="col-md-5">
      <p class="copy">&copy; 2016 EESN. All rights reserved</p>
    </div>
    <div class="col-md-5"></div>
    <div class="col-md-2">
      <button type="button" class="btn btn-link btn-lg reg">Team</button>
      <button type="button" class="btn btn-link btn-lg reg">Contacts</button>
    </div>
  </div>
</div>

<%--<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->--%>
<!-- CORE JQUERY  -->
<script src="resources/assets/plugins/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP CORE SCRIPT   -->
<script src="resources/assets/plugins/bootstrap.js"></script>
<!-- VEGAS SLIDESHOW SCRIPTS -->
<script src="resources/assets/plugins/vegas/jquery.vegas.min.js"></script>
<!-- SCROLL SCRIPTS -->
<script src="resources/assets/plugins/jquery.easing.min.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="resources/assets/js/custom.js"></script>
</body>

</html>
