<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<jsp:include page="header.jsp" />



<div class="row">
	<div class="col-md-12 mt-5">
		<br>
		<h3>My Cart (1 Item)</h3>
		
	
		<div class="row">
			<div class="col-md-8">
				
			
				<div class="row">
					<!-- list items in cart -->
					 
					 <c:forEach items="${myCartObj}" var="order">
				
					<div class="col-md-4">

						<img src="${pageContext.request.contextPath}\${order.photo}"
							class="card-img-top border border-primary" alt="...">
					</div>
					<div class="col-md-4">
						<p>${order.desc}
						<p>
						<p>Color : ${order.color}</p>
						<p>Size : ${order.size}</p>
						<p>SKU : ${order.sku}</p>

					</div>
					<div class="col-md-2">
						<label for="quantity">QUANTITY</label> <input type="text"
							id="quantity" size="4"> ${order.quantity}  <br>
						<br>

						<button type="button" class="btn btn-sm btn-primary">
							Remove</button>

					</div>
					<div class="col-md-2">

						<p>${order.quantity*order.unitprice*12}</p>
					</div>
					
					</c:forEach>
				
						
					
					
					
				</div>
				
				
			</div>
			
			
			
			<div class="col-md-3">

				<button type="button" class="btn btn-success btn-block" onclick="window.location.href = 'https://www.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-13T83266KC9472530';">
					CHECKOUT</button>
			
			
					<p>Sub-Total : $360.00</p>
					<p>Tax 	  : $31.90</p>
					<br>
					<h4>Total 	  : $391.95</h4>

				
				<div class="row">
					<div class="col-md-9"></div>
					<div class="col-md-3"></div>
				</div>
			</div>
		</div>
		
		
		
		
	</div>
</div>



<jsp:include page="footer.jsp" />