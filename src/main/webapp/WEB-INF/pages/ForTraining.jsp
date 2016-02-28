<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Training with Bootstrap</title>

    <!-- Bootstrap -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet">
    <link href="resources/assets/css/font-awesome.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myMenu">
                <span class="sr-only">open nav</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Logo</a>
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

        </div>
    </div>
</div>

<div class="carousel slide" id="carousel">
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel" data-slide-to="0"></li>
        <li data-target="#carousel" data-slide-to="1"></li>
        <li data-target="#carousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="resources/assets/img/b.jpg" alt="">
            <div class="carousel-caption">
                <h3>First slide</h3>
                <p>Describe of first slide</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/assets/img/s.jpg" alt="">
            <div class="carousel-caption">
                <h3>First slide</h3>
                <p>Describe of first slide</p>
            </div>
        </div>
        <div class="item">
            <img src="resources/assets/img/h.jpg" alt="">
            <div class="carousel-caption">
                <h3>First slide</h3>
                <p>Describe of first slide</p>
            </div>
        </div>
    </div>

<%--toggles arrow--%>
    <a href="#carousel" class="left carousel-control" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a href="#carousel" class="right carousel-control" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>


<div class="container" >
    <div class="row">
        <h1>My super site!!</h1>
        <p><i class="glyphicon glyphicon-bell"></i> </p>
        <p><i class="fa fa-euro fa-spin"></i> </p>
    </div>
</div>

<div class="container" >
    <a href="#" class="btn btn-default">Button 1</a>
    <a href="#" class="btn btn-danger">Button 2</a>
    <a href="#" class="btn btn-success">Button 3</a>
    <a href="#" class="btn btn-warning">Button 4</a>
    <a href="#" class="btn btn-info btn-lg">Button 5</a>
</div>


<div class="container" >
    <div class="row">
        <div class="btn-group">
            <a href="#" class="btn btn-default"><i class="fa fa-play"></i> </a>
            <a href="#" class="btn btn-danger"><i class="fa fa-birthday-cake" ></i></a>
            <a href="#" class="btn btn-success"><i class="fa fa-microphone" ></i></a>
            <a href="#" class="btn btn-warning"><i class="fa fa-question" ></i></a>
            <a href="#" class="btn btn-info"><i class="fa fa-map-o" ></i></a>
        </div>
        <br>
        <div class="btn-group btn-group-justified btn-lg">
            <a href="#" class="btn btn-default"><i class="fa fa-play"></i> </a>
            <a href="#" class="btn btn-danger"><i class="fa fa-birthday-cake" ></i></a>
            <a href="#" class="btn btn-success"><i class="fa fa-microphone" ></i></a>
            <a href="#" class="btn btn-warning"><i class="fa fa-question" ></i></a>
            <a href="#" class="btn btn-info"><i class="fa fa-map-o" ></i></a>
        </div>
        <br>
        <div class="btn-group btn-group-vertical btn-sm">
            <a href="#" class="btn btn-default"><i class="fa fa-play"></i> </a>
            <a href="#" class="btn btn-danger"><i class="fa fa-birthday-cake" ></i></a>
            <a href="#" class="btn btn-success"><i class="fa fa-microphone" ></i></a>
            <a href="#" class="btn btn-warning"><i class="fa fa-question" ></i></a>
            <a href="#" class="btn btn-info"><i class="fa fa-map-o" ></i></a>
        </div>
    </div>
</div><br><br>

<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div class="btn-group">
                <button class="btn dropdown-toggle" data-toggle="dropdown">
                    Menu dropdown <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                </ul>

            </div>
            <div class="btn-group dropup">
                <button class="btn dropdown-toggle" data-toggle="dropdown">
                    Menu dropdown <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                </ul>
            </div>
            <div class="btn-group">
                <button class="btn btn-success">
                    Menu dropdown
                </button>
                <button class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                    <li><a href="#">Menu</a> </li>
                </ul>
            </div>
        </div>
    </div>
</div><br><br>


<%--Tabs--%>
<div class="container">
    <div class="row">
        <div class="tabs">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Inset 1</a> </li>
                <li><a href="#tab2" data-toggle="tab">Inset 2</a> </li>
                <li><a href="#tab3" data-toggle="tab">Inset 3</a> </li>
            </ul>
            <div class="tab-content " >
                <div class="tab-pane in fade active" id="tab1">
                    <p>Some text in here 1</p>
                </div>
                <div class="tab-pane fade" id="tab2">
                    <p>Some text in here 22</p>
                </div>
                <div class="tab-pane fade" id="tab3">
                    <p>Some text in here 333</p>
                </div>
            </div>
        </div>
    </div>
</div><br><br>


<%--Spoiler--%>
<div class="container">
    <a href="#spoiler1" data-toggle="collapse" class="btn btn-success">Open spoiler 1</a>
    <div class="collapse" id="spoiler1">
        <div class="well" >
            <p>Text in the spoiler 1</p>
        </div>
    </div>
</div><br><br>


<%--Carousel--%>
<div class="container">
    <div class="col-md-6">
        <div class="panel-group" id="myAccordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a href="#collapse1" data-toggle="collapse" class="">Panel number 1</a>
                    </h4>
                </div>
                <div class="panel-collapse collapse" id="collapse1">
                    <div class="panel-body">
                        <p>My content in panel number 1</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-6">

    </div>
</div>



<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-md-offset-0 hidden-sm visible-xs visible-lg">
            <div class="row">
                <div class="col-md-4 col-md-offset-0"><h1>Hello My World !!!</h1></div>
                <div class="col-md-3 col-md-offset-2"><h1>Hello My World !!!</h1></div>
                <div class="col-md-2"><h1>Hello My World !!!</h1></div>
            </div>

        </div>
        <div class="col-md-3 col-md-offset-1"><h1>Hello My World !!!</h1></div>
        <div class="col-md-2"><h1>Hello My World !!!</h1></div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/assets/js/bootstrap.js"></script>
</body>
</html>