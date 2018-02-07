<%--
  Created by IntelliJ IDEA.
  User: God
  Date: 1/17/2018
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Student - Login</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">

	First name: <form:input path="firstName" />

	<br><br>

	Last name: <form:input path="lastName" />

	<br><br>

	Country:
	<form:select path="country" items="${countries}" />

	<br><br>
	
	Favorite language:
	<form:radiobuttons path="favoriteLanguage" items="${languages}"/>

	<br><br>

	Operating system:
	<form:checkboxes path="operatingSystems" items="${systems}" />

	<br><br>

	<input type="submit" value="Submit" />

</form:form>
</body>
</html>
