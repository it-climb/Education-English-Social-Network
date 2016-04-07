<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

</head>
<body class="no-js">

<div class="container">

   </div>
<nav class="navbar navbar-default">
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
                        <input form="searchForm" type="text" class="form-control" placeholder="Search for knowledge...">
                        <span class="input-group-btn"><button form="searchForm" class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button></span>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-2" >
                <a role="button" type="button" class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-1">Log In</a>
                <%--<a href="/login" role="button" type="button" class="btn btn-link btn-lg reg" data-toggle="modal" data-target="#modal-1">Log In</a>--%>
                <a role="button" type="button" class="btn btn-primary btn-lg reg" data-toggle="modal" data-target="#modal-2">Sign Up</a>
                <%--<a href="/regSave" role="button" type="button" class="btn btn-primary btn-lg reg" data-toggle="modal" data-target="#modal-2">Sign Up</a>--%>
            </div>
        </div>
    </nav>

<div class="well">
    <div class="col-md-3">

    </div>
    <div class="col-md-3">
        Type:
        <div class="btn-group">
            <button type="button" class="btn btn-primary">Watching</button>
            <button type="button" class="btn btn-primary">Reading</button>
            <button type="button" class="btn btn-primary">Typing</button>
        </div>
    </div>
    <div class="col-md-3">
        Target age:
        <div class="btn-group">
            <button type="button" class="btn btn-primary">6+</button>
            <button type="button" class="btn btn-primary">12+</button>
            <button type="button" class="btn btn-primary">16+</button>
            <button type="button" class="btn btn-primary">18+</button>
        </div>
    </div>
    <div class="col-md-3">
        Sorting:
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
                <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">most rated first</a></li>
                <li><a href="#">CSS</a></li>
                <li><a href="#">JavaScript</a></li>
            </ul>
        </div>
    </div>
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
                <div class="input-group email-password">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></div>
                    <input type="text" class="form-control"  placeholder="Email">
                </div>
                <div class="input-group email-password">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                    <input type="text" class="form-control" placeholder="Password">
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

    <aside class="col-xs-3">
    <h4>Overlapping Subjects</h4>

    <form id="searchForm" role="form" method="post" action="/createActivities">

        <div class="checkbox">
            <label><input type="checkbox" name="checkOverSub" value="comp">Computer Science</label><br>
            <label><input type="checkbox" name="checkOverSub" value="phys">Physical Science</label><br>
            <label><input type="checkbox" name="checkOverSub" value="rus">Russian Language</label><br>
            <label><input type="checkbox" name="checkOverSub" value="eng">English Language</label>
        </div>

        <h4>Target Age</h4>

        <div class="checkbox">
            <label><input type="checkbox" name="checkOverSub" value="six">6+</label><br>
            <label><input type="checkbox" name="checkOverSub" value="twelve">12+</label><br>
            <label><input type="checkbox" name="checkOverSub" value="sixteen">16+</label><br>
            <label><input type="checkbox" name="checkOverSub" value="eighteen">18+</label>
        </div>

        <h4>Difficulty Level</h4>

        <div class="checkbox">
            <label><input type="checkbox" name="checkOverSub" value="easy">Easy</label><br>
            <label><input type="checkbox" name="checkOverSub" value="normal">Normal</label><br>
            <label><input type="checkbox" name="checkOverSub" value="hard">Hard</label>
        </div>

        <h4>Sort By</h4>
        <div class="radio">
            <label><input type="radio" name="optionsRadios" value="rating">Rating</label><br>
            <label><input type="radio" name="optionsRadios" value="createDate">Create Date</label>
        </div>

        <h4>Type</h4>
        <div class="checkbox">
            <label><input type="checkbox" name="num" value="watch">Watching</label><br>
            <label><input type="checkbox" name="num" value="read">Reading</label><br>
            <label><input type="checkbox" name="num" value="test">Typing</label>
        </div>

        <input class="btn btn-default" type="submit" value="Create activities">
    </form>
    </aside>

    <div class="col-xs-9">
        <div class="jumbotron">

            <div id="clear">
                <div class="row">


                    <c:forEach var="activity" items="${activities}">

                        <div id="activity" class="row">

                            <div class="col-lg-3">
                                <div class="thumbnail">
                                    <img src="pic_mountain.jpg" alt="Mountain View">
                                </div>
                            </div>


                            <div class="col-lg-5">
                                <p class="lead">${activity.name}</p>

                                <c:if test="${activity.type.ordinal()==1}">

                                    <div class="btn-group">
                                        <form role="form" method="post" action="/watchActivity">
                                            <input type="hidden" name="id" value="${activity.id}">
                                            <input class="btn btn-success btn-sm" type="submit" value="Watch">
                                        </form>
                                    </div>

                                    <c:if test="${activity.author.user.email == email}">

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/updateWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Edit">
                                            </form>
                                        </div>

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/deleteWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Delete">
                                            </form>
                                        </div>

                                    </c:if>
                                </c:if>

                                <c:if test="${activity.type.ordinal()==2}">

                                    <div class="btn-group">
                                        <form role="form" method="post" action="/watchActivity">
                                            <input type="hidden" name="id" value="${activity.id}">
                                            <input class="btn btn-success btn-sm" type="submit" value="Watch">
                                        </form>
                                    </div>

                                    <c:if test="${activity.author.user.email == email}">

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/updateWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Edit">
                                            </form>
                                        </div>

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/deleteWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Delete">
                                            </form>
                                        </div>

                                    </c:if>
                                </c:if>

                                <c:if test="${activity.type.ordinal()==0}">

                                    <div class="btn-group">
                                        <form role="form" method="post" action="/watchActivity">
                                            <input type="hidden" name="id" value="${activity.id}">
                                            <input class="btn btn-success btn-sm" type="submit" value="Watch">
                                        </form>
                                    </div>

                                    <c:if test="${activity.author.user.email == email}">

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/updateWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Edit">
                                            </form>
                                        </div>

                                        <div class="btn-group">
                                            <form role="form" method="post" action="/deleteWatchActivity">
                                                <input type="hidden" name="id" value="${activity.id}">
                                                <input class="btn btn-default btn-sm" type="submit" value="Delete">
                                            </form>
                                        </div>

                                    </c:if>
                                </c:if>

                                <c:forEach var="subject" items="${sub}">
                                    <c:if test="${activity.id == subject.activity.id}">
                                        ${subject.name}<br>
                                    </c:if>
                                </c:forEach>
                            </div>


                            <div class="col-lg-4">

                                <div id="rait" align="right" weight=33%>
                                    <strong>Raiting</strong><br>
                                    <small>passed 14.305 times</small>
                                </div>

                                <div id="age" align="right" weight=33%>
                                    <p>+12</p>
                                </div>

                                <div id="author" align="right" weight=33%>
                                    <strong>create data</strong><br>
                                    <strong>by author</strong>
                                </div>

                            </div>

                        </div>

                    </c:forEach>



                </div>
            </div>
        </div>


    </div>
</div>
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

</div>





</body>
