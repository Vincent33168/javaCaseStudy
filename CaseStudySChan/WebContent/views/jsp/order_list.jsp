<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"/>

<!--customer order list  -->
    
<div class="row">
	<div class="col-md-12 mt-5" >
	<br>
	
		<h3>Your Orders</h3> 
		
	
		<table class="table table-bordered table-sm table-hover"  >
			<thead class="table-info">
				<tr>
					<th>Customer</th>
					<th>Order #</th>
					<th>Order Date</th>
					<th>Total</th>
					<th>View Detail</th>
					
				</tr>
			</thead>
			
		
			<tbody>
			
			<c:forEach items="${myOrdersObj}" var="order">
				<tr>
					<td>${order.customer.custname }</td>
					<td>${order.id }</td>
					<td>${order.odate }</td>
						<td>$<fmt:formatNumber type = "number"
						 	maxFractionDigits="2" value = "${order.orderTotal }"/></td>
					
					<td>
						<a href="${pageContext.request.contextPath}/viewOrderDetail/${order.id}"><input type="button" value="View Detail"></a>
					</td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
</div>
</div>
	<div class="row">
		 <hr>
		<div class="col-md-12" >
			<c:if test="${!empty selectedOrderObj}">
   			 <h6>Order Details - (Order #${selectedOrderId})</h6>	
   			 		<table class="table table-bordered table-sm table-hover">
   			 			<thead class="table-secondary">
							<tr>
							<th>Product Name</th>
							<th>Description</th>
							<th>Color</th>
							<th>Size</th>
							<th>SKU</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Sub-Total</th>
							<th>Tax</th>
							<th>Total</th>
							
							</tr>
						</thead>
				 <c:forEach items="${selectedOrderObj.odetail}" var="orderDetail">
					<tr>
						<td>${orderDetail.name}</td>
						<td>${orderDetail.desc}</td>
						<td>${orderDetail.color}</td>
						<td>${orderDetail.size}</td>
						<td>${orderDetail.sku}</td>
						<td>${orderDetail.quantity}</td>
						<td>${orderDetail.unitprice*12}</td>
						<td>${orderDetail.quantity*orderDetail.unitprice*12}</td>
						
						<td>$<fmt:formatNumber type = "number"
					 	maxFractionDigits="2" value = "${orderDetail.quantity*orderDetail.unitprice*12*8.875/100}"/></td>
					 	
						<td>$<fmt:formatNumber type = "number"
					 	maxFractionDigits="2" value = "${orderDetail.quantity*orderDetail.unitprice*12*1.0875}"/> </td>
					</tr>
				  
				 
				 </c:forEach>
				 </table>
			</c:if>
		</div>	
		 
	</div>

	

<jsp:include page="footer.jsp"/>