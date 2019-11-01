<jsp:include page="header.jsp"/>

	<!--carpisel start -->
	<div class="row">
		<div class="col-md-12">
			<div class="carousel slide" id="carousel-516849">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-516849" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-516849">
					</li>
					<li data-slide-to="2" data-target="#carousel-516849">
					</li>
				</ol>
				<div class="carousel-inner" >
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carousel Bootstrap First" src="${pageContext.request.contextPath}/resources/photo/pexels-photo-631988.jpeg">
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/photo/pexels-photo-1122605.jpeg">
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="${pageContext.request.contextPath}/resources/photo/pexels-photo-247321.jpeg">
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-516849" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-516849" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
	<!-- carousel end-->

	<!--best selling items -->
	<br/>
	<div class="row">
		<div class="col-md-12">
			 <!--<p class="badge badge-default"> -->
			 <h2>BEST SELLING ITEMS THIS WEEK</h2>
			 <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.<p>


		</div>
	</div>


	<!--best seller section start from here-->
	<div class="row">

		<div class="col-md-4 d-none" id="1">
			<div class="card" >
				 
				  <img src="${pageContext.request.contextPath}/resources/photo/ANCHOR02.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				  	 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="card-link">$00.00</a>
				    
				  </div>
			</div>
		</div>

		<div class="col-md-4" id="2">
			<div class="card" >
				  <img src="${pageContext.request.contextPath}/resources/photo/ANCHOR02.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				  	 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="card-link">$00.00</a>
				   
				  </div>
			</div>
		</div>


		<div class="col-md-4">
			<div class="card" >
				  <img src="${pageContext.request.contextPath}/resources/photo/BLACKSTONE01.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				  	 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="card-link">$00.00</a>
				    
				  </div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card" >
				  <img src="${pageContext.request.contextPath}/resources/photo/ATLANTIC.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				  	 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="#" class="card-link">$00.00</a>
				    
				  </div>
			</div>
		</div>

	</div>
	<!--best seller end-->

	<!--pagination start from here-->

	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<nav>
				<ul class="pagination">
					<li class="page-item">
						<a class="page-link" href="#">Previous</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">1</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">2</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">3</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">4</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">5</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="#">Next</a>
					</li>

				</ul>
				

			</nav>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<!--pagination end-->



<jsp:include page="footer.jsp"/>