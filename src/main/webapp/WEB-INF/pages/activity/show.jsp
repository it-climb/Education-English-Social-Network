<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>All</title>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link href="resources/assets/css/style.css" rel="stylesheet">
    <style>

        /*html {*/
            /*height: 100%;*/
            /*width: 100%;*/
        /*}*/

        #sort {
            margin: 8px 0px 0px 0px;
        }

        .content{
            height: 75%;
            width: 100%;
        }

        #subject {
            height: 80px;
        }

        #activity {
            margin: 10px;
            height: 150px;
            background: #FFFAFA;
            border: 2px solid #000000;
        }

        #imgAct {
            margin: 5%;
        }

        #text {
            text-align: right;
        }

        .rating {
            unicode-bidi: bidi-override;
            direction: rtl;
            font-size: 10pt;
        }
        .rating > span {
            display: inline-block;
            position: relative;
            width: 1.1em;
        }
        .rating > span:hover:before,
        .rating > span:hover ~ span:before {
            content: "\2605";
            position: absolute;
        }

        #activities {
            width: 100%;
            height: 90%;
        }

        /*html {*/
            /*position: relative;*/
            /*min-height: 100%;*/
        /*}*/

        /*body {*/
            /*!* Margin bottom by footer height *!*/
            /*margin-bottom: 80px;*/
        /*}*/
        /*.footer {*/
            /*position: relative;*/
            /*bottom: 0;*/
            /*width: 1138px;*/
            /*!* Set the fixed height of the footer here *!*/
            /*height: 80px;*/

        /*}*/
        /*#foot {*/
            /*height: 80px;*/
            /*width: 1168px;*/
            /*background: #FFFAFA;*/
            /*border: 2px solid #000000;*/
        /*}*/

        #pagin {
            align: right-side;
        }

        #rait {
            margin-right: 10px;
        }

        .container{
            height: 100%;
            border: 2px solid #000000;
        }

    </style>
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
            </c:if>

            <c:if test="${email == null}">
            <div class="col-md-2"></div>
            <div class="col-md-2" >
                <a role="button" type="button" class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-1">Log In</a>
                <a role="button" type="button" class="btn btn-primary btn-lg reg" data-toggle="modal" data-target="#modal-2">Sign Up</a>
            </div>
            </c:if>
        </div>
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
    <div class="heading">
        <div class="row">
            <div class="col-md-2">
            </div>


            <div id="type" class="col-md-3">
                Type:

                <div class="btn-group">
                    <button type="button" class="btn btn-primary btn-sm">Watching</button>
                    <button type="button" class="btn btn-primary btn-sm">Reading</button>
                    <button type="button" class="btn btn-primary btn-sm">Typing</button>
                </div>

            </div>
            <div id="age" class="col-md-4">
                <div class="col-md-4">
                    <p id="sort" class="text-right">Target age:</p>
                </div>
                <div class="col-md-8">
                    <div class="col-sm-12">
                        <div class="btn-group">
                            <button type="button" class="btn btn-primary btn-sm">6+</button>
                            <button type="button" class="btn btn-primary btn-sm">12+</button>
                            <button type="button" class="btn btn-primary btn-sm">16+</button>
                            <button type="button" class="btn btn-primary btn-sm">18+</button>
                        </div>
                    </div>
                </div>
            </div>

            <div id="sorting" class="col-md-3">
                <div class="col-md-4">
                    <p id="sort" class="text-right">Sorting:</p>
                </div>
                <div class="col-md-8">
                    <div class="dropdown">
                        <button class="btn btn-primary btn-sm dropdown-toggle" type="button" data-toggle="dropdown">most rated first
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="#">most rated first</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="clear: both "></div>
    <div class="content" >
        <div class="row">
            <div class="col-md-3">
                <div id="leftside">
                    <h4> Overlapping Subjects </h4>

                    <c:forEach var="subject" items="${sub}">
                    <div id="subject">
                        <div>
                            <div class="checkbox">
                                <label><input type="checkbox" name="num" value="watch">${subject.name}</label><br>
                            </div>
                            <div class="col-sm-2">
                            </div>
                            <div class="col-sm-10">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary btn-sm">Easy</button>
                                    <button type="button" class="btn btn-primary btn-sm">Normal</button>
                                    <button type="button" class="btn btn-primary btn-sm">Hard</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>>
                </div>

            </div>

            <div class="col-md-9">
                <div id="activities">
                    <c:forEach var="activity" items="${activities}">
                    <div id="activity">
                        <div class="row">
                            <div class="col-lg-3">

                                <div id="imgAct" class="thumbnail">
                                    <img src="pic_mountain.jpg" alt="Mountain View">
                                </div>
                            </div>
                            <div class="col-md-5">
                                <h4><a href="Activity.html">${activity.name}</a></h4>
                                <button type="button" class="btn btn-danger btn-sm">watching</button>
                                <button type="button" class="btn btn-success btn-sm">test</button><br>

                                <c:forEach var="subject" items="${sub}">
                                    <c:if test="${activity.id == subject.activity.id}">
                                        ${subject.name}<br>
                                    </c:if>
                                </c:forEach>

                            </div>


                            <div id="text" class="col-md-4">
                                <div id="rait">
                                    <div class="rating">
                                        <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
                                    </div>
                                    <sub>passed 14,305 times</sub><br>
                                    <br>
                                    <b>${activity.targetAge}</b><br>
                                    <br>
                                    <b>20 sep 2009</b><br>
                                    <b><a href="Autor.html">by ${activity.author.fullName}</a></b>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>>
                </div>
            </div>

    <div class="row">
        <div class="col-md-8">
        </div>
        <div class="col-md-4">
            <ul id="pagin" class = "pagination">
                <li><a href = "#">&laquo;</a></li>
                <li class="active"><a href = "#">1</a></li>
                <li><a href = "#">2</a></li>
                <li><a href = "#">3</a></li>
                <li><a href = "#">4</a></li>
                <li><a href = "#">5</a></li>
                <li><a href = "#">&raquo;</a></li>
            </ul>
        </div>
    </div>
        </div>
    </div>
</div>>
            <div style="clear: both "></div>

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

</body>
</html>