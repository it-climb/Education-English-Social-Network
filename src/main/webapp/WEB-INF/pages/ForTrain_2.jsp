
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Training with Bootstrap</title>

    <!-- Bootstrap -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/font-awesome.css" rel="stylesheet">
    <link href="resources/assets/css/my-css.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<%--Navigation menu bar--%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myMenu">
                <span class="sr-only">open nav</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="fortraining" class="navbar-brand">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myMenu">
            <ul class="nav navbar-nav" >
                <li><a href="#">menu 1</a> </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">menu 2<b class="caret"></b> </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">menu 2.1</a> </li>
                        <li><a href="#">menu 2.2</a> </li>
                        <li><a href="#">menu 2.3</a> </li>
                        <li class="divider"> </li>
                        <li><a href="#">menu 2.4</a> </li>
                    </ul>
                </li>
                <li><a href="#">menu 3</a> </li>
                <li><a href="#">menu 4</a> </li>
            </ul>
            <form action="" class="navbar-form navbar-right hidden-sm">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary form-control">
                    <i class="fa fa-sign-in">  Login</i>
                </button>
            </form>
        </div>
    </div>
</div><br><br><br>

<div class="container">
    <div class="row">
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#" class="btn btn-default">One <span class="badge">15</span></a> </li>
                <li><a href="#" >Two <span class="badge">65</span></a> </li>
                <li><a href="#" >Three <span class="badge">132</span></a> </li>
                <li><a href="#" >For <span class="badge">7</span></a> </li>
            </ul>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
            <div class="thumbnail">
                <img src="http://placehold.it/240x180">
                <div class="caption">
                    <a href="#"><h3>Our article</h3></a>
                    <p>This article about very important theme...  This article about very important theme...
                        This article about very important theme...  This article about very important theme...  </p>
                    <a href="#" class="btn btn-success">More <i class="fa fa-arrow-right"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/assets/js/bootstrap.js"></script>
</body>
</html>
