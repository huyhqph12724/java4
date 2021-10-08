<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">


<title>Update Video</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
rel="stylesheet" >

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0" style="margin:50px;">
				<!-- Nested Row within Card Body -->

				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-6">Update video</h1>
				</div>
				<form class="user"
					action="${pageContext.request.contextPath}/admin/video/update"
					method="POST">

						<div class="form-group mb-3">
							<span class="text-primary h5">ID video</span>
							<input type="text" class="form-control form-control-user"
								name="videoId" placeholder="VideoId" value="${video.videoId}" readonly>
						</div>
						<div class="form-group mb-3">
							<span class="text-primary h5">Title</span>
							<input type="text" class="form-control form-control-user"
								name="title" placeholder="Title" value="${video.title}" required>
						</div>
				
					<div class="form-group mb-3">
						<span class="text-primary h5">Description</span>
						<input type="text" class="form-control form-control-user"
							name="description" placeholder="Description" value="${video.description}" required>
					</div>
					<div class="form-group mb-3">	
							<input type="radio" name="active" value="1" ${video.active? 'checked':'' } />Active
							<input type="radio" name="active" value="0" ${video.active? '':'checked'} />Inactive	
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