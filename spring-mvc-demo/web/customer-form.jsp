<%--
  Created by IntelliJ IDEA.
  User: God
  Date: 1/19/2018
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Customer - Login</title>

	<style>
		.error{ color: red }
	</style>
</head>
<body>
	<i>Fields marked with Asterisk (*) are required!</i>

	<br><br>

	<form:form modelAttribute="customer" action="processForm">
		First Name: <form:input path="firstName"/>

		<br><br>

		Last Name*: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error" />

		<br><br>

		Free passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error" />

		<br><br>

		Postal code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error" />

		<br><br>

		Course code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error" />

		<br><br>

		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>
