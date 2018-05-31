<%@ include file="/WEB-INF/taglib.jsp" %>
<style>
.error{
color:red;
}
</style>

<h2> Register page </h2>
<form:form action="/register" method="POST" modelAttribute="userModel">

 	<div class="form-group">
		<label for="login">Login: </label><form:errors path="login" cssClass = "error"/> <form:input  class="form-control" path="login" /> 
	</div>
	<div class="form-group">
		<label for="email">Email address: </label><form:errors path="email" cssClass = "error"/> <form:input  class="form-control" path="email" /> 
	</div>
	<div class="form-group">
		<label for="email">Password: </label> <form:password  class="form-control" path="password"/> 
	</div>
	
	<div class="form-group">
		<label for="flat">Flat: </label><form:errors path="flat" cssClass = "error"/> <form:input  class="form-control" path="flat" /> 
	</div>
	<div class="form-group">
		<label for="area">Area: </label><form:errors path="area" cssClass = "error"/> <form:input  class="form-control" path="area" /> 
	</div>
	
	
	<input type="submit" class="btn btn-success"  value="Register">

</form:form>