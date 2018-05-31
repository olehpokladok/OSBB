<%@ include file="/WEB-INF/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:choose>
	<c:when test="${ title == null }">
		<tiles:putAttribute name="title" value="App Title" />
	</c:when>
	
	<c:otherwise>
		<tiles:putAttribute name="title" value="${ title }"/>
	</c:otherwise>
</c:choose>

<title>
	<tiles:getAsString name="title"/>
</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<tiles:insertAttribute name="header" />
		<div class="container">
			
			<tiles:insertAttribute name="body" />		
		</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>