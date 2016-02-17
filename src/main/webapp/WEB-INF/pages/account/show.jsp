<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<jsp:include page="../layout/classic.jsp"/>

<ul id="myTabs" class="nav nav-tabs" role="tablist">
  <li role="presentation" class="active">
    <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a>
  </li>
  <li role="presentation" class="">
    <a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">Profile</a>
  </li>
</ul>
<div id="myTabContent" class="tab-content">

  <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
    <table class="table">
      <tr>
        <td>First Name:</td>
        <td>${account.firstName}</td>
      </tr>
      <tr>
        <td>Second Name:</td>
        <td>${account.secondName}</td>
      </tr>
      <tr>
        <td>Age:</td>
        <td>${account.age}</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>${account.user.email}</td>
      </tr>
    </table>
  </div>

  <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
    <form:form method="post" action="/accountUpdate" >

      <input type="hidden" name="accountId" value="${account.id}">
      <input type="hidden" name="userId" value="${account.user.id}">
      <table class="table">
        <tr>
          <td>First Name:</td>
          <td><input type="text" name="firstName" value="${account.firstName}"/></td>
        </tr>
        <tr>
          <td>Second Name:</td>
          <td><input type="text" name="secondName" value="${account.secondName}"/></td>
        </tr>
        <tr>
          <td>Age:</td>
          <td><input type="text" name="age" value="${account.age}"/></td>
        </tr>
        <tr>
          <td>Email:</td>
          <td><input type="text" name="email" value="${account.user.email}"/></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" class="btn btn-success" value="Save">
          </td>
        </tr>
      </table>
    </form:form>
  </div>
</div>


</body>
</html>