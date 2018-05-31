<%@ include file="/WEB-INF/taglib.jsp" %>

<h2> Add service</h2>
<form:form action="/services/add-service" method="POST" modelAttribute="servicesModel">
 	<div class="form-group">
		<label for="name">Service: </label> <form:input  class="form-control" path="name" /> 
	</div>
	<input type="submit" class="btn btn-success"  value="Add">
</form:form>