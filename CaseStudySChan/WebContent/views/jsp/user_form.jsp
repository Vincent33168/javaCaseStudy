<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<jsp:include page="header.jsp"/>

<!-- User Form  -->
<div class="row">
	<div class="col-md-12 mt-5">
		<br>
		<h3>${action_msg}</h3>
		
		<form:form id="user_form" modelAttribute= "userObj"  
		action="${pageContext.request.contextPath}/processUserForm" method="POST">
			<table>
				
				<tr>
					<td>Customer</td>
					<td>
						
						<select name="cust">
						<c:forEach items="${CUSTOMERLIST }" var="customer">
	           				<option value="${customer.custcode}"
	           				<c:if test="${customer.custcode eq selectedCustomer}">selected="selected"</c:if>
	           					>${customer.custname}	
						  		<%-- <option value="${customer.custcode}" >${customer.custname} --%>  
						 	</option>
						 </c:forEach>
						</select>
					
					</td>
				</tr>
				
				<tr>
					<td>Authorities / Roles</td>
					<td>
					  <input type="radio" name="user_role" value="ROLE_ADMIN" checked> Administrator<br>
					  <input type="radio" name="user_role" value="ROLE_CUSTOMER"> Customer User<br> 
					</td>
					
				</tr>	
				
				<tr>
					
					<td><form:label path="username" />User Name(Email):</td>
					<c:if test="${action == 'edit'}"> 
					<td><form:input path="username" readonly="true" name="username" id="username" size="50" placeholder="Email"/> </td>
					</c:if>
					<c:if test="${action != 'edit'}"> 
					<td><form:input path="username"  name="username" id="username" size="50" placeholder="Email"/> </td>
					</c:if>
					<td><form:errors path="username" cssClass="error"/> </td>
					
				</tr>
			
				<tr>
					<td><form:label path="fname" />First Name: </td>
					<td><form:input path="fname"  name="fname" id="fname" size="50" placeholder="First Name"/> </td>
					<td><form:errors path="fname" cssClass="error"/> </td>
				</tr>
				
				<tr>
					<td><form:label path="lname" />Last Name: </td>
					<td><form:input path="lname"  name="lname" id="lname" size="50" placeholder="Last Name"/> </td>
					<td><form:errors path="lname" cssClass="error"/> </td>
				</tr>
				
				
				<tr>
					<td><form:label path="password" />Password: </td>
					<td><form:input path="password" type="password" name="password" id="password" size="18" placeholder="Password"/> </td>
					<td><form:errors path="password" cssClass="error"/> </td>
				</tr>
				<tr>
		            <td><label>Confirm Password:</label></td>
		            <td><input type="password" name="confirmPassword" id="confirmPassword" size="18" placeholder="Confirm password"/></td>
	        		<td><span class="error">${message}</span></td>
	        	</tr>
			
			</table>
			<input type ="submit" name="confirm" value="Save"/>
			<input type ="submit" name="cancel" value="Cancel"/>
		</form:form>
	</div>
</div>

<jsp:include page="footer.jsp"/>
