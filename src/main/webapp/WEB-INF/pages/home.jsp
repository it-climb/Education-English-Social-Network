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
  <%--<!--[if lt IE 9]>--%>
  <%--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
  <%--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>--%>
  <%--<![endif]-->--%>
</head>
<body>
<img src="resources/assets/img/1.jpg" style="position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; bottom: auto; right: auto;" class="vegas-background"><div style="margin: 0px; padding: 0px; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; background-image: url(&quot;resources/assets/plugins/vegas/overlays/02.png&quot;);" class="vegas-overlay"></div>
<div class="navbar navbar-inverse navbar-fixed-top scrollclass">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand"   href="/">EESN</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/"> <spring:message code="home.home"/> </a></li>
        <li><a href="/dep">DEPARTMENTS</a></li>
        <li><a href="/chat">CHAT</a></li>
        <li><a href="/points">POINTS</a></li>
        <li><a href="/translate">TRANSLATOR</a></li>
        <li><a href="/video">VIDEO</a></li>
        <li><a href="/subject">SUBJECTS</a></li>
        <li><a href="#contact">CONTACT</a></li>
        <li><a href="/activities">ACTIVITIES</a></li>
        <li><a href="#social-section">SOCIAL</a></li>
        <li><a href="/login">SIGN IN</a></li>
        <li><a href="/regSave">SIGN UP</a></li>
        <li><a href="/account">ACCOUNT</a></li>
      </ul>
    </div>
    <div>
      <span style="float: right">
        <a href="?lang=en">en</a>
        |
        <a href="?lang=ru">ru</a>
      </span>
    </div>
  </div>
</div>

<%--<!--HOME SECTION-->--%>
<div class="container" id="home">
  <div class="row text-center scrollclass">
    <div class="col-md-12">
      <span class="head-main">EDUCATION ENGLISH SOCIAL NETWORK </span>
      <h3 class="head-last">Bla bla bla bla</h3>
    </div>
  </div>
</div>
<%--<!--END HOME SECTION-->--%>

<%--<!--ABOUT SECTION-->--%>
<section class="for-full-back color-bg-one" id="about">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-8 col-md-offset-2 ">
        <h1>About Our Team</h1>
      </div>
      <div class="row text-center">
        <div class="col-md-8 col-md-offset-2 ">
          <h5>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.


          </h5>
        </div>
      </div>
    </div>
  </div>
</section>
<section class="for-full-back color-white" id="about-team">
  <div class="container">
    <div class="row text-center g-pad-bottom">
      <div class="col-md-8 col-md-offset-2 ">
        <h3>OUR TEAM MEMBERS</h3>
        <h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Curabitur nec nisl odio. Mauris vehicula at nunc id posuere.
        </h5>
      </div>

    </div>
    <div class="row text-center g-pad-bottom">

      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="alert alert-danger">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Praesent suscipit sem vel ipsum elementum venenatis.
        </div>
        <div class="team-member">
          <img src="resources/assets/img/team/1.png" class="img-circle" alt="">
          <h3><strong>ART DIRECTOR</strong></h3>
        </div>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="alert alert-success">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Praesent suscipit sem vel ipsum elementum venenatis.
        </div>
        <div class="team-member">
          <img src="resources/assets/img/team/2.png" class="img-circle" alt="">
          <h3><strong>WEB DESIGNER</strong></h3>
        </div>


      </div>
      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="alert alert-warning">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Praesent suscipit sem vel ipsum elementum venenatis.
        </div>
        <div class="team-member">
          <img src="resources/assets/img/team/4.png" class="img-circle" alt="">
          <h3><strong>SUPPORT MANAGER </strong></h3>
        </div>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="alert alert-info">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          Praesent suscipit sem vel ipsum elementum venenatis.
        </div>
        <div class="team-member">

          <img src="resources/assets/img/team/3.png" class="img-circle" alt="">
          <h3><strong>SUPPORT MANAGER </strong></h3>
        </div>
      </div>


    </div>


  </div>
</section>
<%--<!--END ABOUT SECTION-->--%>

<%--<!--CLIENT TESTIMONIALS SECTION-->--%>
<section id="clients-testimonial">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-12 ">
        <h1>Clients Testimonials</h1>
        <div id="carousel-example" class="carousel slide" data-ride="carousel">

          <ol class="carousel-indicators">
            <li data-target="#carousel-example" data-slide-to="0" class=""></li>
            <li class="" data-target="#carousel-example" data-slide-to="1"></li>
            <li class="" data-target="#carousel-example" data-slide-to="2"></li>
          </ol>

          <div class="carousel-inner">
            <div class="item active left">
              <div class="container center">
                <div class="col-md-6 col-md-offset-3 slide-custom">

                  <h4><i class="fa fa-quote-left"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit onec molestie non sem vel condimentum. <i class="fa fa-quote-right"></i></h4>
                  <div class="user-img pull-right">
                    <img src="resources/assets/img/user.gif" alt="" class="img-u image-responsive">
                  </div>
                  <h5 class="pull-right"><strong class="c-black">Lorem Dolor</strong></h5>
                </div>
              </div>
            </div>
            <div class="item next left">
              <div class="container center">
                <div class="col-md-6 col-md-offset-3 slide-custom">
                  <h4> <i class="fa fa-quote-left"></i> Aenean faucibus luctus enim. Duis quis sem risu suspend lacinia elementum nunc. <i class="fa fa-quote-right"></i></h4>
                  <div class="user-img pull-right">
                    <img src="resources/assets/img/user2.png" alt="" class="img-u image-responsive">
                  </div>
                  <h5 class="pull-right"><strong class="c-black">Faucibus luctus</strong></h5>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="container center">
                <div class="col-md-6 col-md-offset-3 slide-custom">
                  <h4><i class="fa fa-quote-left"></i>Sed ultricies, libero ut adipiscing fringilla, ante elit luctus lorem, a egestas dui metus a arcu condimentum. <i class="fa fa-quote-right"></i></h4>
                  <div class="user-img pull-right">
                    <img src="resources/assets/img/user.gif" alt="" class="img-u image-responsive">
                  </div>
                  <h5 class="pull-right"><strong class="c-black">Sed ultricies</strong></h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<%--<!--END CLIENT TESTIMONIALS SECTION-->--%>
<%--<!--PRICE SECTION-->--%>
<section class="for-full-back color-bg-one" id="pricing">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-8 col-md-offset-2 ">
        <h1>Pricing Options</h1>

      </div>
      <div class="row text-center">
        <div class="col-md-8 col-md-offset-2 ">
          <h5>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.

          </h5>
        </div>
      </div>
    </div>
  </div>
</section>
<section id="price-sec" class="for-full-back color-white">
  <div class="container">
    <div class="row text-center g-pad-bottom">


      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="panel-danger">
          <div class="panel-heading">
            <h4>MEDIUM PLAN</h4>
          </div>
          <div class="alert alert-danger">

            <ul class="plan">
              <li class="price"><strong>10</strong> <i class="fa fa-dollar"></i></li>
              <li><strong>52</strong> Emails</li>
              <li><strong>50 GB</strong> Space</li>
              <li><strong>Free</strong> Support</li>
            </ul>
            <a href="#" class="btn btn-danger ">BUY NOW</a>
          </div>

        </div>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="panel-warning">
          <div class="panel-heading">
            <h4>MEDIUM PLAN</h4>
          </div>
          <div class="alert alert-warning">

            <ul class="plan">
              <li class="price"><strong>25</strong> <i class="fa fa-dollar"></i></li>
              <li><strong>52</strong> Emails</li>
              <li><strong>50 GB</strong> Space</li>
              <li><strong>Free</strong> Support</li>
            </ul>
            <a href="#" class="btn btn-warning ">BUY NOW</a>
          </div>

        </div>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-6 ">
        <div class="panel-success">
          <div class="panel-heading">
            <h4>ECONOMY PLAN</h4>
          </div>
          <div class="alert alert-success">

            <ul class="plan">
              <li class="price"><strong>50</strong> <i class="fa fa-dollar"></i></li>
              <li><strong>52</strong> Emails</li>
              <li><strong>50 GB</strong> Space</li>
              <li><strong>Free</strong> Support</li>
            </ul>
            <a href="#" class="btn btn-success ">BUY NOW</a>
          </div>

        </div>
      </div>
      <div class="col-md-3 col-sm-3 col-xs-6">
        <div class="panel-info ">
          <div class="panel-heading">
            <h4>ADVANCE PLAN</h4>
          </div>
          <div class=" alert alert-info">

            <ul class="plan">
              <li class="price"><strong>125</strong> <i class="fa fa-dollar"></i></li>
              <li><strong>52</strong> Emails</li>
              <li><strong>50 GB</strong> Space</li>
              <li><strong>Free</strong> Support</li>
            </ul>
            <a href="#" class="btn btn-info ">BUY NOW</a>
          </div>

        </div>
      </div>


    </div>


  </div>
</section>
<%--<!-- END PRICE SECTION-->--%>


<%--<!--STATS SECTION-->--%>
<section>
  <div class="container">
    <div class="row ">
      <div class="col-md-3 ">
        <div class="stats-div">
          <h3>5000+ </h3>
          <h4>Projects</h4>
        </div>
      </div>


      <div class="col-md-3 ">
        <div class="stats-div">
          <h3>205+ </h3>
          <h4>Countries</h4>
        </div>

      </div>
      <div class="col-md-3 ">

        <div class="stats-div">
          <h3>1300+ </h3>
          <h4>Offices</h4>
        </div>
      </div>
      <div class="col-md-3 ">
        <div class="stats-div">
          <h3>2400+ </h3>
          <h4>Clients</h4>
        </div>
      </div>
    </div>
  </div>
</section>
<%--<!--END STATS SECTION-->--%>

<%--<!--CONTACT SECTION-->--%>
<section class="for-full-back color-bg-one" id="contact">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-8 col-md-offset-2 ">
        <h1>Contact</h1>
      </div>
      <div class="row text-center">
        <div class="col-md-8 col-md-offset-2 ">
          <h5>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.

          </h5>
        </div>
      </div>
    </div>
  </div>
</section>
<section class="for-full-back color-white text-center" id="contact-inner">
  <div class="container">

    <h1>GET IN TOUCH</h1>

    <form>
      <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <input class="form-control" required="required" placeholder="Name" type="text">
          </div>
        </div>
        <div class="col-md-12">
          <div class="form-group">
            <input class="form-control" required="required" placeholder="Email address" type="text">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 col-sm-12">
          <div class="form-group">
            <textarea name="message" id="message" required="required" class="form-control" style="min-height:200px;" placeholder="Message"></textarea>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Submit Request</button>
          </div>
        </div>
      </div>
    </form>
    <div id="add">
      <br>
      New Your City, USA
      <br>
      Call: + 123-00-89-00
      <br>
      E-mail: info@binarytheme.com
    </div>

  </div>
</section>

<%--<!--END CONTACT SECTION-->--%>
<%--<!--SOCIAL SECTION-->--%>
<section id="social-section">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-4 scl scl-dark-bk">
        <h4>FACEBOOK</h4>
        <p class="text-center"><a href="#"><i class="fa fa-facebook fa-5x"></i></a></p>
      </div>
      <div class="col-md-4 scl">
        <h4>TWITTER</h4>
        <p class="text-center"><a href="#"><i class="fa fa-twitter fa-5x"></i></a></p>
      </div>
      <div class="col-md-4 scl scl-dark-bk">
        <h4>GOOGLE +</h4>
        <p class="text-center"><a href="#"><i class="fa fa-google-plus fa-5x"></i></a></p>
      </div>
    </div>
  </div>
</section>

<%--<!--END SOCIAL SECTION-->--%>
<%--<!--FOOTER SECTION -->--%>

<div class="for-full-back" id="footer">
  2014 www.yourdomain.com | All Right Reserved | by: <a href="http://binarytheme.com" target="_blank" style="color:#fff">www.binarytheme.com</a>
</div>
<%--<!-- END FOOTER SECTION -->--%>

<%--&lt;%&ndash;<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->&ndash;%&gt;--%>
<%--<!-- CORE JQUERY  -->--%>
<%--<script src="resources/assets/plugins/jquery-1.10.2.js"></script>--%>
<%--<!-- BOOTSTRAP CORE SCRIPT   -->--%>
<%--<script src="resources/assets/plugins/bootstrap.js"></script>--%>
<%--<!-- VEGAS SLIDESHOW SCRIPTS -->--%>
<%--<script src="resources/assets/plugins/vegas/jquery.vegas.min.js"></script>--%>
<%--<!-- SCROLL SCRIPTS -->--%>
<%--<script src="resources/assets/plugins/jquery.easing.min.js"></script>--%>
<%--<!-- CUSTOM SCRIPTS -->--%>
<%--<script src="resources/assets/js/custom.js"></script>--%>
</body>

</html>
