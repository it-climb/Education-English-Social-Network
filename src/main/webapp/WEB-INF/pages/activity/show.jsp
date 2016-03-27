<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>
<head>
    <title>All</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link href="resources/assets/css/style2.css" rel="stylesheet">


</head>
<body class="no-js">

<div id="container">
    <div id="header">

        <form role="form" class="form-inline" method="get" action="/activities">
            <input class="form-control" placeholder="Enter email" type="text" name="author">
            <input type="hidden" name="number" value="${paginator.pageSize}">
            <input class="btn btn-default" type="submit" value="Search for author">
        </form>

        <form role="form" class="form-inline" method="get" action="/activities">
            <input class="form-control" placeholder="Enter  Subject" type="text" name="subject">
            <input type="hidden" name="number" value="${paginator.pageSize}">
            <input class="btn btn-default" type="submit" value="Search for subject">
        </form>

    </div>

    <div id="navigation">
        <p class="text-center">You serched for <b>Martial Arts.</b> 5 matches</p>
    </div>

    <div id="menu">

        <div class="row">
            <div class="col-lg-2">
            </div>
            <div class="col-lg-10">
                <h4>Overlapping Subjects</h4>

                <form role="form" method="post" action="/createActivities">

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
            </div>
        </div>
    </div>

    <div id="content">
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

    <div id="paginator">
        <div class="row">
            <div class="col-lg-12">



            </div>

            <div align="center">
                <form role="form" class="form-inline" method="get" action="/activities">
                    Show on page by number
                    <div class="form-group">
                        <input class="form-control" placeholder="Введите email" type="text" name="number" value="${paginator.pageSize}">
                    </div>
                    <c:if test="${author != null}"><input type="hidden" name="author" value="${author}"></c:if>
                    <input class="btn btn-default" type="submit" value="Number of activities">
                </form>
            </div>

            <div id="pages" align="center">
                <c:if test="${author == null}">
                    <c:if test="${paginator.hasPrevious()}">
                        <a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}">previous</a>  |
                    </c:if>
                    current: ${paginator.getPageNumber()+1}  |
                    <a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}">next</a>  |
                </c:if>


            </div>

            <div id="email" align="right"><strong>${email}</strong></div>
        </div>
    </div>
</div>

<div id="footer">



</div>
</div>

</body>
