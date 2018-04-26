<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Pakotzy Company Home Page</title>
</head>
<body>
	<h2>Pakotzy Company - Home Page</h2>
	<hr>

	Welcom to the Pakotzy Company - Home Page

	<hr>

	User: <security:authentication property="principal.username"/>,
	Role(s): <security:authentication property="principal.authorities"/>

	<hr>

	<security:authorize access="hasRole('G')">
		<a href="${pageContext.request.contextPath}/boss">Boss Page!</a>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>
