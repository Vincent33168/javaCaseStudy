<jsp:include page="header.jsp"/>

<!-- Contact Us -->

    <div class="container-fluid">+
	<div class="row">
		<div class="col-md-12 mt-5">
			<div>
				<h3 class="display-4">
					Contact Us
				</h3>
				<h6  class="display-5">
					<div>
						<p>
							<span>For An Immediate response on any <strong>urgent</strong> issue please e-mail<br><strong><a href="mailto:contact@jfootwear.com"></a><span>sales@jfootwear.com</span></strong></span>
						</p>
						<p>
							<span>Tel: 123-456-7890<br>Fax: 123-300-400</span><br>
						</p>
						<p>
							<span><strong>Office Hours:</strong></span><br><span>Monday - Friday: 9am-6pm est<br>Saturday and Sunday: Closed</span>
						</p>
						
					</div>
				</h6>
			</div>
			<form role="form" action="${pageContext.request.contextPath}/processContactUsForm" method="POST">
			
			<div class="row">
              <div class="col-md-4 mb-3">
                <label for="name">Your Name</label>
                <input type="text" class="form-control" id="name" placeholder="Name" value="" required>
              </div>
              
              <div class="col-md-4 mb-3">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" placeholder="Email" value="" required>
              </div>
               <div class="col-md-4 mb-3">
               </div>
            </div>
				
			 Message
			<div class="row">
			
				 <div class="col-md-8">
				<label for="message">
						
					</label>
					
					<textarea class="form-control" rows="3" cols="100 required">
					
					</textarea>
				 </div>
			  <div class="col-md-8 mb-2">
               </div>
				
		
			</div>
			

				<button type="submit" class="btn btn-primary mb-4">
					Submit
				</button>
				<br><br><br>
			</form>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"/>
