<%--
  Created by IntelliJ IDEA.
  User: God
  Date: 1/16/2018
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Hello World - Personal</title>
</head>
<body>
Hello World of Spring!

<br><br>

Student name: ${param.studentName}

<br><br>

The message: ${message}

<hr>

<img src="${pageContext.request.contextPath}/resources/img/deity.jpg" alt="Death Deity"/>
</body>
</html>
