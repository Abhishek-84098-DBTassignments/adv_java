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
	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty property="id" name="vb" param="candidate"/>
	<jsp:setProperty property="userId" name="vb" value="${lb.user.id }"/>
	Hello,${lb.user.firstName}${lb.user.firstName}<hr/>
	${vb.getStatusVote()}
	<c:choose>
		<c:when test="${vb.voteStatus == 1 }"><
			${vb.vote()}
			<c:choose>
				<c:when test="${vb.getCnt() != 0}">
					<h3>Vote register successfully!!!</h3>
					${vb.setStatusUser()}
					<a href="index.jsp">Logout</a>
				</c:when>
				<c:otherwise>
					<h3>Vote failed!!!</h3>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h2>Vote registered already.Get Lost!!!</h2>
			<a href="index.jsp">Logout</a>
		</c:otherwise>
	</c:choose>
</body>
</html>