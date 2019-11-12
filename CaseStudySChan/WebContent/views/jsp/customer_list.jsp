<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<jsp:include page="header.jsp"/>

<!--customer list  -->
    
<div class="row">
	<div class="col-md-12 mt-5">
	<br>
	<form action="addcustomer" method="get">
		<h3>Customer Maintenance</h3> 
		<input type="submit" value="Add New Customer"/>
	</form>
		${message}
		<table class="table table-bordered table-sm table-hover">
			<thead class="table-info">
				<tr>
					<th>#</th>
					<th>Customer Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${CUSTOMERLIST}" var="customer">
				<tr>
					<td>${customer.custcode}</td>
					<td>${customer.custname}</td>
					<td>${customer.contact}</td>
					<td>${customer.email}</td>
					<td>${customer.phone}</td>
					<td>
						<a href="${pageContext.request.contextPath}/editcustomer/${customer.custcode}/"><input type="button" value="EDIT"></a>
						<a href="${pageContext.request.contextPath}/deletecustomer/${customer.custcode}/"><input type="button" value="DELETE"></a>
					</td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
	</div>
</div>
	

<jsp:include page="footer.jsp"/>