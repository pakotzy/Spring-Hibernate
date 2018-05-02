<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: God
  Date: 5/1/2018
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Register New User</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
	           modelAttribute="user"
	           class="form-horizontal">
		<!-- Check for registration error -->
		<c:if test="${registrationError != null}">
			<div class="alert alert-danger col-xs-offset-1 col-xs-10">
					${registrationError}
			</div>
		</c:if>
		…
		<!-- User name -->
		<form:input path="userName" placeholder="username" class="form-control" />
		<!-- Password -->
		<form:password path="password" placeholder="password" class="form-control" />
		<button type="submit" class="btn btn-primary">Register</button>
	</form:form>
</body>
</html>
