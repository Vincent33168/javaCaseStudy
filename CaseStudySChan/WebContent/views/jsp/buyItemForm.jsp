<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.footwear.model.Item"%>
<%@page import="java.util.*"%>

<jsp:include page="header.jsp" />


<div class="row">
	<div class="col-md-12  mt-5">
		<br/>
		<div class="row">
			<div class="col-md-7">
				<h4 class="text-center">${SELECTEDITEM.desc}</h4>
				<div class="card bg-default">
					<h5 class="card-header">${SELECTEDITEM.name}</h5>
					
					<img src="${pageContext.request.contextPath}/resources/${SELECTEDITEM.photo}" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text"></p>
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
			<div class="col-md-5  mt-5">
			
				
				<h5>${SELECTEDITEM.currency}${SELECTEDITEM.unitprice} <span> 
				(${SELECTEDITEM.currency}${SELECTEDITEM.unitprice*12} Per Case)</span></h5><br/>
				
				<form:form id="buyItemForm"  name ="buyItemForm" modelAttribute="CartObj" 
				action="${pageContext.request.contextPath}/addToCart/${SELECTEDITEM.id}"  method="POST">
					<div class="form-group">
						<label for="color"> COLOR </label> 
						<select   id="color" name="color">
						<c:forEach items="${SELECTEDITEM.itemdetail}" var = "colors">
							<option value="${colors.color}">${colors.color}</option>
						</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label for="size"> SIZE </label> 
							<select  id="size" name="size">
						<c:forEach items="${SELECTEDITEM.itemdetail}" var = "sizes">
							<option value="${sizes.size}">${sizes.size}</option>
						</c:forEach>
						</select>

					</div>
					
					<div class="form-group">
						<label for="quantity">QUANTITY</label>
   						 <input  type="number"  id="quantity" name="quantity" size="4" min="1" max="1000"/>
   						 
   						 <p class="error">${message}</p> 
   						 
  					</div>

					<button type="submit"   class="btn btn-primary">ADD TO CART
					</button>
				</form:form>
				<br/>
				<br/>
				<H6>SIZE CHART</H6>
				<table class="table table-sm">
					<thead class="thead-light">
						<tr>
							<th scope="col">SIZE</th>
							<th scope="col">6.5</th>
							<th scope="col">7.0</th>
							<th scope="col">7.5</th>
							<th scope="col">8.0</th>
							<th scope="col">8.5</th>
							<th scope="col">9.0</th>
							<th scope="col">9.5</th>
							<th scope="col">10</th>
							<th scope="col">10.5</th>
							<th scope="col">11.0</th>
							<th scope="col">11.5</th>
							<th scope="col">12.0</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">A</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
						<tr>
							<th scope="row">B</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col">1</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">1</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
						<tr>
							<th scope="row">C</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col">1</th>
							<th scope="col">1</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">2</th>
							<th scope="col">1</th>
							<th scope="col">1</th>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp" />