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
<h2> Pay for flat </h2>
<form:form action="/payment/flat-count" method="POST" modelAttribute="paymentModel" >
<h2>Price for 1m2</h2>
<b>${maxPrice}</b><br>
<h2>M2 in your flat</h2>
<b>${currentUser}</b><br>
<h2>Amount</h2>
<b>${maxPrice * currentUser} hrv</b><br>

		<input type="hidden" name="service" value="${4}" ><br>
		<input type="hidden" name="created_at" value="${data}"><br>  
		<input type="hidden" name="cost" value="${currentUser *  maxPrice}"><br>  
		<input type="submit" class="btn btn-success"  value="Pay">
</form:form>
</body>
</html>