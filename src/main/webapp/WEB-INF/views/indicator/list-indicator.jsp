<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<h2> List indicator </h2>
<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Date</th>
			<th>Service name</th>
			<th>Counter</th>
			<th>Number flat</th>
		</tr>
		
		<c:forEach items="${indicatorList}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.createdAt}</td>
				<td>${i.services.name}</td>
				<td>${i.counter}</td>
				<td>${i.user_id.flat}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>