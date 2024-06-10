<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Random r = new Random();
		int num = r.nextInt(5);
		out.println("Division :: 60 / " + num + " = " + (60/num));
	%>
</body>
</html>