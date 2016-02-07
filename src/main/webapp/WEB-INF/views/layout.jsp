<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<!--[if IE]>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<![endif]-->
	<!--REQUIRED STYLE SHEETS-->
	<!-- BOOTSTRAP CORE STYLE CSS -->
	<link href="resources/assets/css/bootstrap.css" rel="stylesheet">
	<!-- FONTAWESOME STYLE CSS -->
	<link href="resources/assets/css/font-awesome.min.css" rel="stylesheet">
	<!-- VEGAS STYLE CSS -->
	<link href="resources/assets/scripts/vegas/jquery.vegas.min.css" rel="stylesheet">
	<!-- CUSTOM STYLE CSS -->
	<link href="resources/assets/css/stylep.css" rel="stylesheet">
	<%--<link href="resources/assets/css/style.css" rel="stylesheet">--%>
	<!-- GOOGLE FONT -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
			<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>

<div id="header">
	<tiles:insertAttribute name="header" />
</div>

<div id="telo">
	<tiles:insertAttribute name="body" />
</div>

<div class="for-full-back" id="footer">
	<tiles:insertAttribute name="footer" />
</div>

</body>
</html>