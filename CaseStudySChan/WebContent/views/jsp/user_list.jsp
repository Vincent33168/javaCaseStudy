<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<jsp:include page="header.jsp"/>

<!-- show user list by customer  -->

<div class="row">
	<div class="col-md-12 mt-5">
		<br>
		<form action="adduser" method="get">
		<h3>User Maintenance</h3> 
		<input type="submit" value="Create New User"/>
		</form>
		${message}
	
		<!-- get user list from DB  -->
		<table class="table  table-bordered table-sm table-hover">
			<thead class="table-info">
				<tr>
					<th>#</th>
					<th>Customer Name</th>
					<th>User Name (Email)</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Authority</th>
					<th>Enabled</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${USERLIST}" var="user">
				<tr>
					<td>${user.customer.custcode}</td>
					<td>${user.customer.custname}</td>
					<td>${user.username}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td> <c:forEach items="${user.authorities}" var="authority">  
						${authority.authority}
					</c:forEach>
					</td>
					<td>${user.enabled}</td>
					<td>
						<a href="${pageContext.request.contextPath}/edituser/${user.username}/"><input type="button" value="EDIT"></a>
						<a href="${pageContext.request.contextPath}/deleteuser/${user.username}/"><input type="button" value="DELETE"></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

	
<!-- end of user list -->	

<jsp:include page="footer.jsp"/>