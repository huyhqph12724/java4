<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
<link href="/user/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="user/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Send Email</h1>
							</div>
							<form class="user"
								action="${pageContext.request.contextPath}/sendmail"
								method="POST">
								
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="title" placeholder="Tiêu đề" required>
								</div>
								<div class="form-group">
									<textarea name="text" class="form-control form-control-user" cols="" rows= "" 
									placeholder="Nội dung" required ></textarea>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										name="email" placeholder="Địa chỉ email" required>
								</div>
								<button class="btn btn-primary btn-user btn-block">
									Send</button>
								<span>${mss}</span>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="/user/vendor/jquery/jquery.min.js"></script>
	<script src="/user/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/user/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/user/js/sb-admin-2.min.js"></script>
</body>
</html>