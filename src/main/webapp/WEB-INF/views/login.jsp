<%@ include file="/WEB-INF/taglib.jsp" %>

<h2>${ title }</h2>

<form:form action="/login" method="POST">
<div class="form-group">
	<label for="login">Login:</label> <input type="text"  class="form-control" name="login">
	 </div>
	 <div class="form-group">
	<label for="password">Password:</label> <input type="password"  class="form-control" name="password">
	 </div>
	
	<input type="submit" class="btn btn-success" value="Log In">
</form:form>