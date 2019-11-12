<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<!-- Customer Form  -->
<div class="row">
	<div class="col-md-12 mt-5">
		<br>
		<h3>${action}</h3>
		
		<form:form id="customer_form" modelAttribute= "customerObj"  
		action="${pageContext.request.contextPath}/processCustomerForm" method="POST">
			<table>
				<tr>
					<td><form:label path="custcode" />Customer Code: </td>
					<td><form:input path="custcode" readonly="true" name="custcode" id="custcode" size="5" /> </td>
					<td><form:errors path="custcode" cssClass="error"/> </td>
				</tr>
				<tr>
					<td><form:label path="custname" />Customer Name: </td>
					<td><form:input path="custname" name="custname" id="custname" size="50"/> </td>
					<td><form:errors path="custname" cssClass="error"/> </td>
				</tr>
				<tr>
					<td><form:label path="contact" />Contact Name: </td>
					<td><form:input path="contact"  name="contact" id="contact" size="50"/> </td>
					<td><form:errors path="contact" cssClass="error"/> </td>
				</tr>
				<tr>
					<td><form:label path="email" />Contact Email: </td>
					<td><form:input path="email"  name="email" id="email" size="30"/> </td>
					<td><form:errors path="email" cssClass="error"/> </td>
				</tr>
				<tr>
					<td><form:label path="phone" />Contact Phone: </td>
					<td><form:input path="phone"  name="phone" id="phone" size="15"/> </td>
					<td><form:errors path="phone" cssClass="error"/> </td>
				</tr>
				<tr>
				
		
				
				</tr>
			</table>
			<input type ="submit" name="confirm" value="Save"/>
			<input type ="submit" name="cancel" value="Cancel"/>
		</form:form>
	</div>
</div>

<jsp:include page="footer.jsp"/>
