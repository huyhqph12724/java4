<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<title>Add user</title>

<!-- Custom fonts for this template-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
rel="stylesheet" >

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0" style="margin:50px;">
				<!-- Nested Row within Card Body -->

				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-6">Add user</h1>
				</div>
				<form class="user"
					action="${pageContext.request.contextPath}/admin/user/add"
					method="POST">
					
						<div class="form-group mb-3">
							<input type="text" class="form-control form-control-user"
								name="username" placeholder="User Name" required>
						</div>
						<div class="form-group mb-3">
							<input type="text" class="form-control form-control-user"
								name="fullname" placeholder="Full Name" required>
						</div>
					
					<div class="form-group mb-3">
						<input type="text" class="form-control form-control-user"
							name="email" placeholder="Email Address" required>
					</div>
					<div class="form-group mb-3">	
							<input type="password" class="form-control form-control-user"
								name="password" placeholder="Password" required>		
					</div>
					<div class="form-group mb-3">	
							<input type="radio" name="role" value="1" >Admin
							<input type="radio" name="role" value="0" checked="checked">User	
					</div>
					<button class="btn btn-primary btn-user btn-block">Submit</button>
					<span>${mss}</span>
				</form>
			</div>

		</div>
	</div>
		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>
</body>

</html>