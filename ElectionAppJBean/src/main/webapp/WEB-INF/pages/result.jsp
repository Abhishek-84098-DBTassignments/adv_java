<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	
	<jsp:useBean id="res" class="com.sunbeam.beans.CandidateListBean"/>
	${res.fetchCandidates()}
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Actions</th>
			</tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="c" items="${res.candidateList}">
	    		<tr>
	    			<td>${c.id }</td>
	    			<td>${c.name }</td>
	    			<td>${c.party }</td>
	    			<td>${c.votes }</td>
	    			<td>
	    				<a href="ctl?page=editcand&id=${c.id}">
	    					<img alt="Edit" src="images/edit.png" width="20" height="20"/>
	    				</a>
	    				<a href="ctl?page=delcand&id=${c.id}">
	    					<img alt="delete" src="images/delete.png" width="20" height="20"/>
	    				</a>
	    			</td>
	    		</tr>>
	    	</c:forEach>
	    </tbody>
	</table>
	<br/><br/><br/>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>