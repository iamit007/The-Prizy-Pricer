<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Price and Data Entry Page</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">

<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script>


</head>
<body>
	<div class="container">
		<div class="card">

			<div class="card-header bg-primary text-white">
				<h2>Welcome to Product Entry PAGE</h2>
			</div>

			<div class="card-body">

				<form:form action="show" method="post" modelAttribute="products">

					<div class="form-group">
						<label for="storeName" class="control-label col-sm-4">Store
							Name</label>
						<form:select path="storeName" cssClass="form-control col-sm-4">
							<form:option value="">--select--</form:option>
							<form:options items="${storeNames}" />
						</form:select>

						<form:errors path="storeName" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="prodNotes" class="control-label col-sm-4">Product
							Notes</label>
						<form:textarea path="prodNotes" cssClass="form-control col-sm-4" />
						<form:errors path="prodNotes" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="prodDesc" class="control-label col-sm-4">Product
							Desc</label>
						<form:textarea path="prodDesc" cssClass="form-control col-sm-4" />
						<form:errors path="prodDesc" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="barCodeUrl" class="control-label col-sm-4">BarCode
							URL</label>
						<form:textarea path="barCodeUrl" cssClass="form-control col-sm-4" />
					</div>

					<div class="form-group">
						<label for="prodPrice" class="control-label col-sm-4">Product
							Price</label>
						<form:textarea path="prodPrice" cssClass="form-control col-sm-4" />
						<form:errors path="prodPrice" cssClass="text-danger" />
					</div>

					<input type="submit" value="Enter Data"
						class="btn btn-success" />

				</form:form>
			</div>
			<!-- CARD BODY END -->

			<c:if test="${null != message}">
				<div class="card-footer bg-success text-white">
					<b> ${message} </b>
				</div>
				<!-- CARD FOOTER END -->
			</c:if>
		</div>
		<!-- CARD END -->
	</div>
	<!-- Container END -->
</body>
</html>


