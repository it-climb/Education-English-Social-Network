<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
        label {width: 150px; display:inline-block;}
        input { display:inline-block; margin-right: 10px; }
        form {line-height: 160%; }
        .hide { display: none; }
        .error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
</head>
<body>

<div id="container">

    <form:form action="regSave" modelAttribute="user">
        <label for="emailInp">Email: </label>
        <form:input path="email" id="emailInp" />
        <form:errors path="email" cssClass="error" />
        <br/>

        <label for="passImp">Password: </label>
        <form:password path="password" id="passImp"/>
        <form:errors path="password" cssClass="error" />
        <br/>
        
        <label for="confPass">Confirm password:</label>
        <form:password path="confirmPassword" id="confPass"/>
        <form:errors path="confirmPassword" cssClass="error"/>
        <br/>
        <label for="firstNameInp">First Name:</label>
        <form:input path="firstName" id="firstNameInp"/>
        <form:errors path="firstName" cssClass="error"/>
        <br/>
        <label for="secondNameInp">Second Name:</label>
        <form:input path="secondName" id="secondNameInp"/>
        <form:errors path="secondName" cssClass="error"/>
        <br/>
        <label for="ageInp">Age:</label>
        <form:input path="age" id="ageInp"/>
        <form:errors path="age" cssClass="error"/>
        <br/>
        <input type="submit" value="OK" />
    </form:form>
</div>
</body>
</html>