<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <%--<!--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>-->--%>
  <%--<!--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>-->--%>
  <![endif]-->
</head>
<body>
<div>
  <nav class="navbar navbar-default home-head">
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

        <c:if test="${email != null}">
      <div class="col-md-1"></div>
      <div class="col-md-3" >
          <a role="button" type="button" class="btn btn-primary btn-lg reg">Share knowledge</a>
        <%--</div>--%>
      <%--<div class="col-md-1">--%>
          <img src="resources/assets/img/user2.png" class="img-thumbnail user-foto" >
      </div>
    </div>

        </c:if>

        <c:if test="${email == null}">
    <div class="col-md-2"></div>
    <div class="col-md-2" >
          <a role="button" type="button" class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-1">Log In</a>
          <a role="button" type="button" class="btn btn-primary btn-lg reg" data-toggle="modal" data-target="#modal-2">Sign Up</a>
      </div>
        </c:if>


  </nav>
</div>


<div class="modal" id="modal-1">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <div class="modal-body">

        <div class="btn-group btn-group-justified" role="group" aria-label="...">

          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active">Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-2" data-dismiss="modal">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns">Log In with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div>
        <form:form method="post" action="/userLog">
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>

        <input type="text" class="form-control"  placeholder="Email" name="email" value="${user.email}">
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>

        <input type="text" class="form-control" placeholder="Password" name="password" value="${user.password}">
        </div>
          <input role="button" type="submit" class="btn btn-primary  btn-block" value="Sign In"/>

        </form:form>

        <div class="checkbox">
          <input type="checkbox">
          <div class="rm">Remember me</div>
        </div>
        <div class="fmp">
          <p><strong>Forgot my password</strong></p>
        </div>


      </div>
    </div>
  </div>
</div>

<div class="modal" id="modal-1-error">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <div class="modal-body">

        <div class="btn-group btn-group-justified" role="group" aria-label="...">

          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active">Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-2" data-dismiss="modal">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns">Log In with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div>
        <div class="warning">
          <p class="bg-danger">Incorrect <strong>Email</strong> or <strong>Password</strong></p>
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
          <input type="text" class="form-control" placeholder="Email">
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
          <input type="text" class="form-control"  placeholder="Password">
        </div>
        <button type="button" class="btn btn-primary  btn-block btns">Sign In</button>

        <div class="checkbox">
          <input type="checkbox">
          <div class="rm">Remember me</div>
        </div>
        <div class="fmp">
          <p><strong>Forgot my password</strong></p>
        </div>


      </div>
    </div>
  </div>
</div>


<div class="modal" id="modal-2">

  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <div class="modal-body">

        <div class="btn-group btn-group-justified" role="group" aria-label="...">

          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-1" data-dismiss="modal">Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns">Sign Up with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div>
        <form:form action="saveUser" modelAttribute="dto">
          <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
            <form:input path="fullName" type="text" class="form-control"  placeholder="Full Name"  value="${dto.fullName}"/>
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
          <form:input path="email" type="text" class="form-control"  placeholder="Email"  value="${dto.email}"/>
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
          <form:input path="password" type="text" class="form-control"  placeholder="Password" value="${dto.password}"/>
        </div>
        <div>
        <input role="button" type="submit" class="btn btn-primary  btn-block" value="Sign Up"/>
        </div>
        </form:form>
        <div class="checkbox">
          <input type="checkbox">
          <div class="rm">Remember me</div>
        </div>
        <div class="policy">
          <p><strong>By signing up to create an account I accept EESN's Terms of Use and Privacy Policy</strong></p>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="modal-2-error">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <div class="modal-body">

        <div class="btn-group btn-group-justified" role="group" aria-label="...">

          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-1" data-dismiss="modal">Log In</button>
          </div>
          <div class="btn-group" role="group">
            <button type="button" class="btn btn-default active">Sing Up</button>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary  btn-block btns">Sign Up with Facebook</button>
        <div class="or">
          <p><strong>or</strong></p>
        </div>
        <div>
          <p class="bg-danger warning2">Incorrect <strong>Full Name</strong> format, <strong>Email</strong> or <strong>Password</strong></p>
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
          <input type="text" class="form-control"  placeholder="Full Name">
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
          <input type="text" class="form-control"  placeholder="Email">
        </div>
        <div class="input-group email-password">
          <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
          <input type="text" class="form-control"  placeholder="Password">
        </div>
        <button type="button" class="btn btn-primary  btn-block btns">Sign Up</button>
        <div class="checkbox">
          <input type="checkbox">
          <div class="rm">Remember me</div>
        </div>

        <div class="policy">
          <p><strong>By signing up to create an account I accept EESN's Terms of Use and Privacy Policy</strong></p>
        </div>
      </div>
    </div>
  </div>
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
<%--<script src="resources/assets/plugins/vegas/jquery.vegas.min.js"></script>--%>
<!-- SCROLL SCRIPTS -->
<%--<script src="resources/assets/plugins/jquery.easing.min.js"></script>--%>
<!-- CUSTOM SCRIPTS -->
<%--<script src="resources/assets/js/custom.js"></script>--%>
</body>

</html>
