<jsp:include page="header.jsp" />
  
  
  <div id="cartbox" class="row">
	<div class="col-md-12">
  
    <!-- cart header -->
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				My Cart
			</h3>
		</div>
	</div>
	
	<!-- cart items list -->
	<div class="row">
		<div class="col-md-12">
		<!-- 1st item -->
				<div class="row">
					<div class="col-md-4">

						<img src="photo\ANCHOR02.jpg"
							class="card-img-top border border-primary" alt="...">
					</div>
					<div class="col-md-4">
						<p>Pure High-Top WC WNT
						<p>
						<p>Color : Black/Olive</p>
						<p>Size : A</p>
						<p>SKU : 1001</p>

					</div>
					<div class="col-md-2">
						<label for="quantity">QUANTITY</label> <input type="text"
							id="quantity" size="4"> <br>
						<br>

						<button type="button" class="btn btn-sm btn-primary">
							Remove</button>

					</div>
					<div class="col-md-2">

						<p>US$180.00</p>
					</div>
					
					<!-- 2nd item -->
						
					<div class="col-md-4">

						<img src="photo\ANCHOR02.jpg"
							class="card-img-top border border-primary" alt="...">
					</div>
					<div class="col-md-4">
						<p>Pure High-Top WC WNT</p>
						<p>Color : Black/Olive</p>
						<p>Size : A</p>
						<p>SKU : 1002</p>

					</div>
					<div class="col-md-2">
						<label for="quantity">QUANTITY</label> <input type="text"
							id="quantity" size="4"> <br>
						<br>

						<button type="button" class="btn btn-sm btn-primary">
							Remove</button>

					</div>
					<div class="col-md-2">
						
						<p>US$180.00</p>
					</div>
				</div>
		</div>
		
	</div>
	
	
	
	<!-- Total line -->
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-8">
				</div>
				<div class="col-md-4">
					<h3>
						Total: US$360.00 (2 ITEMS)
					</h3>
				</div>
			</div>
			
			<!-- view cart and checkout button  -->
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					 
					<button type="button" onclick="window.location.href = 'viewCart.jsp';" class="btn btn-block btn-outline-info">
						VIEW CART
					</button>
				</div>
				<div class="col-md-4">
					 
					<button type="button" class="btn btn-success btn-block">
						PROCEED TO CHECKOUT
					</button>
				</div>
			</div>
		</div>
	</div>
	
	</div>
</div>
	

<jsp:include page="footer.jsp" />