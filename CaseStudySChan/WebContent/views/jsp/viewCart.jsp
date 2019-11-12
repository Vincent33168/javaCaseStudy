<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" />

<div class="row">
	<div class="col-md-12 mt-5 mb-5 ">
	<br>
		<h3>Your Cart</h3>
		<h6>${message}</h6>
		<!--********************************************* -->	
		<!-- Show ITEMS IN CART  					Start -->
		<!--********************************************* -->
	
		
		<div class="row">
							
			<c:forEach items="${myCartObj}" var="cart">	 
			<div class="col-md-8">
		
				<div class="row">
					<c:forEach items="${cart.odetail}" var="orderDetail">  
					<!-- list items in cart -->
				
				
					<div class="col-md-4">
						<img src="${pageContext.request.contextPath}/resources/${orderDetail.photo}"
							class="card-img-top border border-primary" alt="...">
					</div>
					
					<div class="col-md-4">
						<p>${orderDetail.desc}</p>
						<p></p>
						<p>Color :  ${orderDetail.color} </p>
						<p>Size :  ${orderDetail.size} </p>
						<p>SKU :  ${orderDetail.sku} </p>
						<p>Unit Price :$  ${orderDetail.unitprice} &nbsp $(${orderDetail.unitprice*12})/Case </p>

					</div>
					
					
					<div class="col-md-2">
					
					
						<label for="quantity">QUANTITY</label> 
						<form id="viewMyCart" action="${pageContext.request.contextPath}/updateCart/${cart.id}/${orderDetail.id}"  method="POST">
						<input type="number" id="quantity" name="quantity" size="4" min="0" max="1000" value= "${orderDetail.quantity}" /> <br>
						<br>



						 <button type="submit" name = "update" id="update" class="btn btn-sm btn-primary">
							Update</button>  
						</form>	
						
					<%-- 	 <a href="${pageContext.request.contextPath}/updateCart/${orderDetail.id}/"><input type="button" 
						class="btn btn-sm btn-primary" value="Update"></a>	  --%>
					</div>
			
					
					<div class="col-md-2">
						<h5>$<fmt:formatNumber type = "number" 
   									maxFractionDigits = "2" value = "${orderDetail.quantity*orderDetail.unitprice*12}"/></h5>
						
						
						
					</div>
				 </c:forEach>  
				</div>
					
			</div>
			
		
			<!--********************************************* -->	
			<!-- Order Total  							Start -->
			<!--********************************************* -->
			<div class="col-md-4">
			<a href="${pageContext.request.contextPath}/confirmOrder/${cart.id}"><input type="button" class="btn btn-success btn-block" value="CHECKOUT"> </a>
			
			<!-- 	<button type="button" class="btn btn-success btn-block" onclick="window.location.href = 'https://www.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-13T83266KC9472530';">
					CHECKOUT</button> -->
			
					<p>Sub-Total :$ <fmt:formatNumber type = "number" 
    											  maxFractionDigits = "2" value = "${cart.amount}" /> </p>
					
					<p>Tax :$  <fmt:formatNumber type = "number" 
    											  maxFractionDigits = "2" value = "${cart.tax}" /> </p>
					
					<br>
					<h4>Total :$ <fmt:formatNumber type = "number" 
    											  maxFractionDigits = "2" value = "${cart.orderTotal}" /> </h4>
	
			</div>
			<!--******************************************** -->
			<!-- Order Total 							End  -->
			<!--******************************************** -->
			
		
		</c:forEach>		
		</div>
		
			
	</div>
		
	<br><br>
	
</div>


<jsp:include page="footer.jsp" />
