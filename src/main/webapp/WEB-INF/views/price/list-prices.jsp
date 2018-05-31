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
<h2> Price </h2>
<form action="/price/list-prices/search" method = "get">
<select name="service">
  <option value="gaz">gaz</option>
  <option value="light">light</option>
  <option value="water">water</option>
  <option value="flat">flat</option>
</select> 
<input type="submit" value = "Search">

</form>
<c:forEach items = "${priceList}" var = "price">
${price.id } | ${price.createdAt } | ${price.price } | ${price.services.name} <br>
</c:forEach>
</body>
</html>
