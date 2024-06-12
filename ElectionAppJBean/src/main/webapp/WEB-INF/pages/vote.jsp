<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
	<h2>${initParam.appTitle }</h2>
	Hello, ${lb.user.firstName }${lb.user.lastName }<hr/>
	<c:choose>
		<c:when test="${lb.user.status == 0 }">
			<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
			<jsp:setProperty  name="vb" property="userId" value="${lb.user.id}"/>
			<jsp:setProperty  name="vb" property="candId" param="candidate"/>
			${vb.vote}
			<c:redirect url="ctl?page=logout"/>
		</c:when>
		<c:otherwise>
			Vote registered already!!! Get Lost!!!
		</c:otherwise>
	</c:choose>
	<a href="ctl?page=index">Logout</a>
</body>
</html>