<%--
  Created by IntelliJ IDEA.
  User: God
  Date: 1/17/2018
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Student - Confirmation</title>
</head>
<body>
	Confirmed as: ${student.firstName} ${student.lastName}

	<br><br>

	Country: <img src="${pageContext.request.contextPath}/resources/img/${student.country}.png"
	              alt="User flag" height="42" width="42"/>

	<br><br>

	Favorite language: ${student.favoriteLanguage}

	<br><br>

	Operating systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>...</li>
		</c:forEach>
	</ul>
</body>
</html>
