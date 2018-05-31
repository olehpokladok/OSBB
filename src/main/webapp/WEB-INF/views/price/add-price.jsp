<%@ include file="/WEB-INF/taglib.jsp" %>

<h2> Add price</h2>
<form:form action="/price/add-price" method="POST" modelAttribute="priceModel" >
	<form:select path="services" items="${servicesModel}" itemLabel="name" itemValue="id"/>
 	<div class="form-group">
		<label for="price">Price: </label> <form:input  class="form-control" path="price" /> 
	</div>
	<input type="submit" class="btn btn-success"  value="Add">
</form:form>