<%@ include file="/WEB-INF/taglib.jsp" %>
<div class="my-header">
 <div class="logo">
                <h2>Home Page</h2>
  </div>
</div>
    <nav>
        <ul>
 <li class="active"><a class="first_nav" href="/">Home</a></li>
 
 
<sec:authorize access="!isAuthenticated()">
	<li><a href="/login">Go to Login</a> </li>
	<li><a href="/register">Go to Register</a></li>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	
	<sec:authorize access="hasRole('ADMIN')">
	<!-- <li><a href="/services/add-service">Add-service</a>  </li>  -->
 	<li><a href="/price/add-price">Add-price</a></li> 
	<li><a href="/price/list-prices">List-price</a></li>
	<li><a href="/payment/list-payments">All-payments</a></li>
	<li><a href="/indicator/list-indicator">All list-indicator</a></li>
	</sec:authorize>
	
	
<li>
<sec:authorize access="isAuthenticated()">
	<li><a href="/price/list-user-prices">List-price</a></li>
	<li><a href="/payment/flat-count">Pay for flat</a></li>
	<li><a href="/payment/list-payment-user">Payments</a></li>
	<li><a href="/indicator/add-indicator">Add-indicator</a></li>
	<li><a href="/indicator/list-indicator-user">List-indicator</a></li>


<form:form action="/logout" method="POST">
		<input type="submit" class=" btn btn-danger my-log-out" value="Log Out"> 
	</form:form>
	</sec:authorize>
</li>	
	
	
</sec:authorize>
</ul>

</nav>