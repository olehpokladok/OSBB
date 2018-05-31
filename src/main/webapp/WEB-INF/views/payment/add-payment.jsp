<%@ include file="/WEB-INF/taglib.jsp" %>

<h2> Pay ${currentService} </h2>
<h2>New counter</h2>
<b>${newCounter } </b>
<h2>Before counter</h2>
<b>${allIndicator} </b>
<h2>Price</h2>
<b>${maxPrice} </b>
<h2>Amount</h2>
<b>${(newCounter - allIndicator)*  maxPrice} hrv</b>
<form:form action="/payment/add-payment" method="POST" modelAttribute="paymentModel" >
		<input type="hidden" name="service" value="${serviceId}"><br>
		<input type="hidden" name="created_at" value="${data}"><br>  
		<input type="hidden" name="cost" value="${(newCounter - allIndicator)*  maxPrice}"><br>  
		<input type="submit" class="btn btn-success"  value="Pay">
</form:form>
