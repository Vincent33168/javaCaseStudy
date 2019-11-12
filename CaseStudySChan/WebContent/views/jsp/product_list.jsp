<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>   
<%@page import="com.footwear.model.Item" %>
<%@page import="java.util.*"%> 

<jsp:include page="header.jsp"/>


			
	<!-- pagination -->
	<div class="row">

		<div class="col-md-12 mt-5">
		<br/>
		
		<p>Search by Category</p>
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
	</div>

	<!-- <pagination end -->
				

	<!-- product list -->
	<div class="row">

		<div class="col-md-12">

			${message} <br>
			
			<div class="row">
			 <c:forEach items="${ITEMLIST}" var="item">
			
					<div class="col-md-3">
						<div class="card">
							<a href="${pageContext.request.contextPath}/buyitem/${item.id}">
							
							<img src="${pageContext.request.contextPath}/resources/${item.photo}" class="card-img-top" alt="...">
							<div class="card-body">
								<p class="card-text">
									${item.name}
									
								</p>
							</div>
							<div class="card-footer">
								${item.desc}
								${item.currency}
								${item.unitprice}
								
							</div>
						</div>
					</div>
				
					 </c:forEach>
				
			
			
			
			</div>
			
		</div>
	</div>


	<!-- <product list end -->


<jsp:include page="footer.jsp"/>