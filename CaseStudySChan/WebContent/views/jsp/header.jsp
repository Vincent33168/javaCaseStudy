<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib  prefix="sec" uri="http://www.springframework.org/security/tags"  %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>J&F Footwear Inc.</title>  

    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" >
    
    <script src="https://use.fontawesome.com/3f1380c70e.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  </head>

  <body>
  	
  
  	
  	
  	
  	<!-- shopping cart		 -->
  	
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
		<div class="col-md-12 ">
				<div class="row mr-1">
				
					<!-- 1st item -->
					<div class="col-md-4">

						<img src="${pageContext.request.contextPath}/resources/photo/ANCHOR02.jpg"
							class="card-img-top border border-primary" alt="...">
					</div>
					<div class="col-md-6">
						<dl class="_w">
						  <dd>Pure High-Top WC WNT</dd>
						  <dd>Color : Black/Olive</dd>
						  <dd>Size : A</dd>
						  <dd>Quantity : 3<span> <button type="button" class="btn btn-sm btn-primary">Remove</button> </span></dd> 
						
						</dl>
											

					</div>
					<div class="col-md-2">
						<dl class="_w">
						<dt>US$180.00</dt>
						</dl>
					</div>
					
					<!-- 2nd item -->
						
					<div class="col-md-4">

						<img src="${pageContext.request.contextPath}/resources/photo/ANCHOR02.jpg"
							class="card-img-top border border-primary" alt="...">
					</div>
					<div class="col-md-6">
						<dl class="_w">
						  <dd>Pure High-Top WC WNT</dd>
						  <dd>Color : Black/Olive</dd>
						  <dd>Size : A</dd>
						 <dd>Quantity : 3<span> <button type="button" class="btn btn-sm btn-primary">Remove</button> </span></dd>
						</dl>
						  					

					</div>
					<div class="col-md-2">
						<dl class="_w">
						<dt>US$180.00</dt>
						</dl>
					</div>
					
					
					
					
				</div>
		</div>
		
	</div>
	
	
	
	<!-- shopping cart Total line -->
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-8">
					
					<dl>
					<dt class="float-right">Total: US$360.00 (2 ITEMS)</dt>
					</dl>
				</div>
			</div>
			<br>
			<!-- view cart and checkout button  -->
			<div class="row mb-3">
				
				<div class="col-md-5">
					 
					<button type="button" onclick="window.location.href = 'viewCart';" class="btn btn-block btn-sm btn-outline-info">
						VIEW CART
					</button>
				</div>
				<div class="col-md-7">
					 
					<button type="button" class="btn btn-success btn-sm btn-block" onclick="window.location.href = 'https://www.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-13T83266KC9472530';">
						PROCEED TO CHECKOUT
					</button>
				</div>
			</div>
		</div>
	</div>
	
	</div>
</div>
	
	
	
	
	
	<!-- end shopping cart -->
	
    <div class="container-fluid">
			
				

	<!--navbar start-->

	<div class="row">
		<div class="col-md-12">
				
				
			<!-- NAVBAR  -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>

				<!-- Home button -->
				</button> <a class="navbar-brand" href="${pageContext.request.contextPath}/home"><i class="fa fa-home"  style="font-size:25px;">${cartItem }</i>J&F Footwear </a>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">

						<!-- For Men Category Drop-down Selection  -->
						<li class="nav-item dropdown active ">
							 <a class="nav-link dropdown-toggle" href="MEN" id="navbarDropdownMenuLink" data-toggle="dropdown">Men<span class="sr-only">(current)</span></a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=MEN&subcat=CASUAL">Casual Shoes</a> 
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=MEN&subcat=DRESS">Dress Shoes</a> 
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=MEN&subcat=BOOTS">Boots</a>
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=MEN&subcat=SANDALS">Sandals</a>
								  <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=MEN&subcat=SLIPPERS">Slippers</a>
								
							</div>
						</li>

						<!-- For Women Category Drop-down Selection  -->
						<li class="nav-item dropdown active">
							 <a class="nav-link dropdown-toggle" href="WOMEN" id="navbarDropdownMenuLink" data-toggle="dropdown">Women</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=WOMEN&subcat=CASUAL">Casual Shoes</a> 
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=WOMEN&subcat=DRESS">Dress Shoes</a> 
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=WOMEN&subcat=BOOT">Boots</a>
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=WOMEN&subcat=SANDALS">Sandals</a>
								  <a class="dropdown-item" href="${pageContext.request.contextPath}/product?cat=WOMEN&subcat=SLIPPERS">Slippers</a>
								
							</div>
						</li>

						
						<!-- Contact us botton -->
						<li class="nav-item">
							 <a class="nav-link active" href="${pageContext.request.contextPath}/contactUs">Contact Us</a>
						</li>

						<!-- About us botton -->
						<li class="nav-item">
							 <a class="nav-link active" href="${pageContext.request.contextPath}/aboutUs">About Us</a>
						</li>

						<!-- Admin functions  -->
							<sec:authorize access="hasRole('ADMIN')">
					  			
							<li class="nav-item dropdown active">
								<a class="nav-link dropdown-toggle" href="admin" id="navbarDropdownMenuLink" data-toggle="dropdown">Admin</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/customer">Customer Maintenance</a> 
								  <a class="dropdown-item" href="${pageContext.request.contextPath}/users">User Maintenance</a> 
								 <a class="dropdown-item" href="${pageContext.request.contextPath}/inventory">Update Inventory</a> 
								</div>
							</li>
								
						  	</sec:authorize>
										
					</ul>

				

					<ul class="nav ml-md-auto">
					
						<c:if test="${pageContext.request.userPrincipal.name!=null}"> 
						
						<!-- View My Order  -->
						<li class="nav-item ">
							 <a class="nav-link" href="${pageContext.request.contextPath}/orderHistory">Orders</a>
						</li>
						
						<!-- Shopping Cart button -->
						<!-- 	<li class="nav-item cartbutton" id="cart-btn"> -->
						<li class="nav-item cartbutton">
							 <a class="nav-link" href="${pageContext.request.contextPath}/cartlist">Cart<i class="fa fa-shopping-cart" style="font-size:25px;"></i> 
						
							  <span class="sr-only"></span><span class="badge badge-primary badge-pill"></span></a> 
							
						</li>
						
						</c:if>

						<!-- Logout button -->
						<c:if test="${pageContext.request.userPrincipal.name!=null}">  
						<li class="nav-item ">
							 <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout </a>
						</li>
						</c:if>
						 
						<!-- Login button -->
						<c:if test="${pageContext.request.userPrincipal.name==null}">  
						<li class="nav-item ">
							 <a class="nav-link" href="${pageContext.request.contextPath}/login">Login </a>
						</li>
						</c:if>
						

					</ul>
				</div>
			</nav>
	
		</div>
	</div>			
	<!--navbar end-->

