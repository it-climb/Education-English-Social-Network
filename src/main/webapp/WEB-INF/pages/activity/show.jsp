<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/classic.jsp"/>

<Html>
<head>
    <title>Activity</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!--<link href="css/style.css" rel="stylesheet">-->

</head>
<body class="no-js">
<div class="container">
    <div class="row">
        <div class="col-lg-4">

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

            <table class="table">

                <form method="get" action="/activities">
                    <input class="btn btn-default "type="submit" value="Show All">
                </form>

                <form method="get" action="/activities">
                    <input type="hidden" name="onlyMy" value="true">
                    <input class="btn btn-default" type="submit" value="Show yours">
                </form>

            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3">
            <h4><b>All activities</b></h4> <c:if test="${author != null}"> for <h4> <b> ${author}</b></h4></c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <table class="table table-striper table-bordered">

                <tr>
                    <th>Author of activity</th>
                    <th>Author first name</th>
                    <th>Author second name</th>
                    <th>Author age</th>
                    <th>Activity name</th>
                    <th>Activity target age</th>
                    <th>Activity type</th>
                    <th>Subject</th>
                </tr>

                <c:forEach var="activity" items="${activities}">
                <tr>

                    <td>${activity.author.user.email}</td>
                    <td>${activity.author.firstName}</td>
                    <td>${activity.author.secondName}</td>
                    <td>${activity.author.age}</td>
                    <td>${activity.name}</td>

                    <td>${activity.targetAge}</td>
                    <td>${activity.type}</td>
                    <td>
                        <c:forEach var="subject" items="${sub}">
                            <c:if test="${activity.id == subject.activity.id}">
                                ${subject.name},
                            </c:if>
                        </c:forEach>
                    </td>
                    <c:if test="${activity.type.ordinal()==1}">
                        <td>
                            <a href="/watchActivity?id=${activity.id}">View</a>

                            <c:if test="${activity.author.user.email == email}">|
                                <a href="/updateWatchActivity?id=${activity.id}">Edit</a> |
                                <a href="/deleteWatchActivity?id=${activity.id}">Delete</a>
                            </c:if>
                        </td>
                    </c:if>

                    <c:if test="${activity.type.ordinal()==2}">
                        <td><a href="/readActivity?id=${activity.id}">View</a>
                            <c:if test="${activity.author.user.email == email}">|

                                <a href="/updateReadActivity?id=${activity.id}">Edit</a> |
                                <a href="/deleteReadActivity?id=${activity.id}">Delete</a>
                            </c:if></td>
                    </c:if>
                    <c:if test="${activity.type.ordinal()==0}">
                        <c:if test="${activity.author.user.email == email}">
                            <td><a href="/passingTestActivity?id=${activity.id}">View</a> |
                                <a href="/editPassingTestActivity?id=${activity.id}">Edit</a> |
                                <a href="/deletePassingActivity?id=${activity.id}">Delete</a></td>
                        </c:if>
                    </c:if>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </div>

    <table class="table">
        <tr>
            <td>
                <c:if test="${author == null}">
                    <c:if test="${paginator.hasPrevious()}">
                        <a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}">previous</a>  |
                    </c:if>

                    current: ${paginator.getPageNumber()+1}  |

                    <a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}">next</a>  |
                </c:if>

                <!-- <c:if test="${author != null}">
            	<c:if test="${paginator.hasPrevious()}">
                	<a href="/activities?page=${paginator.getPageNumber()-1}&number=${paginator.pageSize}&author=${author}">previous</a>  |
            	</c:if>

        	current: ${paginator.getPageNumber()+1}  |
        	<a href="/activities?page=${paginator.getPageNumber()+1}&number=${paginator.pageSize}&author=${author}">next</a>  |
      	</c:if> -->
            </td>
        </tr>


        <tr>
            <td>
                <form role="form" method="post" action="/createActivities">

                    <div class="radio">
                        <label>
                            <input type="radio" name="num" value="watch">Watching Activity
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="num" value="read">Reading Activity
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="num" value="test">Test Activity
                        </label>
                    </div>

                    <input class="btn btn-default" type="submit" value="Create activities">

                </form>
            </td>
            <td>

                <form role="form" class="form-inline" method="get" action="/activities">
                    Show on page by number
                    <div class="form-group">
                        <input class="form-control" placeholder="Введите email" type="text" name="number" value="${paginator.pageSize}">
                    </div>

                    <c:if test="${author != null}"><input type="hidden" name="author" value="${author}"></c:if>
                    <input class="btn btn-default" type="submit" value="Number of activities">
                </form>
            </td>
        </tr>
    </table>
    <div align="right"><strong>${email}</strong></div>
</div>
</body>
</html>
