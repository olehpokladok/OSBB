<%@ include file="/WEB-INF/taglib.jsp" %>

<h2> Add indicator</h2>
<form:form action="/indicator/add-indicator" method="POST" modelAttribute="indicatorModel" >
	<div class="form-group">
		<label for="services_name">Check service: </label>
		<form:select path="services" items="${servicesModel}" itemLabel="name" itemValue="id"/>
	</div>
	<div class="form-group">
		<label for="counter">Counter indicator: </label> <form:input  class="form-control" path="counter" /> 
	</div>
	<input type="submit" class="btn btn-success"  value="Add">
<b>${maxCounter}</b>
</form:form>
