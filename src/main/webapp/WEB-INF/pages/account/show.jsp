<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<jsp:include page="../layout/classic.jsp"/>

<ul id="myTabs" class="nav nav-tabs" role="tablist">
  <li role="presentation" class="active">
    <a href="#homes" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a>
  </li>
  <li role="presentation" class="">
    <a href="#profile" id="profile-tab" role="tab" data-toggle="tab" aria-controls="profile" aria-expanded="true">Profile</a>
  </li>
  <li role="presentation" class="">
    <a href="#points" id="points-tab" role="tab" data-toggle="tab" aria-controls="points" aria-expanded="true">Points</a>
  </li>

</ul>
<div id="myTabContent" class="tab-content">

  <div role="tabpanel" class="tab-pane active in" id="homes" aria-labelledby="home-tab">
    <table class="table">
      <tr>
        <td>First Name:</td>
        <td>${userData.firstName}</td>
      </tr>
      <tr>
        <td>Second Name:</td>
        <td>${userData.secondName}</td>
      </tr>
      <tr>
        <td>Gender:</td>
        <td>${userData.gender}</td>
      </tr>
      <tr>
        <td>Age:</td>
        <td>${userData.age}</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>${email}</td>
      </tr>
    </table>
  </div>

  <div role="tabpanel" class="tab-pane" id="profile" aria-labelledby="profile-tab">
    <form:form method="post" action="/accountUpdate" >

      <table class="table">
        <tr>
          <td>First Name:</td>
          <td><input type="text" name="firstName" value="${userData.firstName}"/></td>
        </tr>
        <tr>
          <td>Second Name:</td>
          <td><input type="text" name="secondName" value="${userData.secondName}"/></td>
        </tr>
        <tr>
          <td>Gender:</td>
          <td>
            <select name="gender" size="1">
            <option value="unknown">Unknown</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>Age:</td>
          <td><input type="text" name="age" value="${userData.age}"/></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" class="btn btn-success" value="Save">
          </td>
        </tr>
      </table>
    </form:form>
  </div>

  <div role="tabpanel" class="tab-pane" id="points" aria-labelledby="points-tab">
    <table class="table">
      <tr>
        <p>AuthorshipPoints : ${authorshipPoints.authorshipPoints}</p>
      </tr>
      <c:forEach var="knowledgePoints" items="${knowledgeLevelPoints}">
        <tr>
          <td>${knowledgePoints.subject} : ${knowledgePoints.knowledgeLevelPoints}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>