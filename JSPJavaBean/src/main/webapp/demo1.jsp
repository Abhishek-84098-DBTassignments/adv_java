<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP 1</title>
</head>
<body>
	<h1>JSP SYNTAX</h1>
		<%! 
			int count = 0;
			
			public void jspInit(){
				System.out.println("Demo1 init() called!");
			}
			public void jspDestroy(){
				System.out.println("Demo1 destroy() called!");
			}
		%>
		<br/><br/>
		<%
			Date now = new Date();
			out.println("Server time :: "+now);
		%>
		<br/><br/>
		<% 
			if(count%2 == 0)
				out.println("Even count :: "+count);
			else
				out.println("odd count :: "+count);
		%>
		
		
		<% count++; %>
</body>
</html>