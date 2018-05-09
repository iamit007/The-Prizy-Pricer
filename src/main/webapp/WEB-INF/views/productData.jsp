<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Data Page</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">

<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/SearchPageParam.js"></script></head>
<body>
	<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO PRODUCT DATA PAGE</h2>
			</div>

			<div class="card-body">
			
			<form:form action="all" method="get" modelAttribute="products">
				<div class="form-group">
				
				<label class="control-labe">Enter Product Notes</label>
				<form:input path="prodNotes" cssClass="form-control col-sm-4" />
						
				<label for="prodDesc" class="control-label col-sm-2">Product Description</label>
				<form:textarea path="prodDesc" cssClass="form-control col-sm-4" />
				<input type="submit" value="Search"/>
				</div>
				
				
			</form:form>
			<hr/>
			
			
			
			<hr/>
				<table class="table table-hover">
					<tr class="thead-dark">
						<th>PROD ID</th>
						<th>STORE</th>
						<th>BARCODE URL</th>
						<th>PRICE</th>
						<th colspan="2">OPERATION</th>
					</tr>
					
					<c:forEach items="${page.getContent()}" var="products">
						<tr>
							<td><c:out value="${products.prodId}" /></td>
							<td><c:out value="${products.storeName}" /></td>
							<td><c:out value="${products.barCodeUrl}" /></td>
							<td><c:out value="${products.prodPrice}" /></td>
							<td><a href="delete?prodId=${products.prodId}"
								class="btn btn-danger">DELETE</a></td>
							<td><a href="details?prodId=${products.prodId}" class="btn btn-info">DETAILS</a></td>

						</tr>
					</c:forEach>
					
				</table>

			</div>
			<!-- CARD BODY END -->

			<div class="card-footer text-white">
				<!-- for(int i=0;i<=n-1;i++)-->

				<ul class="pagination">

					<c:if test="${!page.isFirst()}">
						<li class="page-item">
						<a class="page-link" href="#" onclick="setParam('page',0)">First</a></li>
					</c:if>

					<c:if test="${page.hasNext()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()+1})">Next</a></li>
					</c:if>

					<c:if test="${!empty page.getContent()}">
					<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
						<c:choose>
							<c:when test="${page.getNumber() eq i}">
								 <li class="page-item active"><a class="page-link" href="#">${i+1}</a></li>
							</c:when>
							<c:otherwise>
							<li class="page-item"><a class="page-link" href="#" onclick="setParam('page',${i})">${i+1}</a></li>
							
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</c:if>

					<c:if test="${page.hasPrevious()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()-1})">Previous</a></li>
					</c:if>



					<c:if test="${!page.isLast()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getTotalPages()-1})">Last</a></li>
					</c:if>


				</ul>
			</div>

		</div>
		<!-- CARD END -->

	</div>
	<!-- Container End -->
</body>
</html>



