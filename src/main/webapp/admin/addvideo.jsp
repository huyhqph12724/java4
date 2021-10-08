<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add video</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	
	<form class="container" style="margin:50px;" action="${pageContext.request.contextPath}/admin/video/add" method="POST">
	<div class="text-left">
		<h1 class="h3 text-gray-900 mb-6">Add Video</h1>
	</div>
		<div class="mb-2">
			<label for="exampleInputEmail1" class="form-label">Video ID
				</label> <input type="text" class="form-control"
				 name="videoId" required="required">
		</div>
		<div class="mb-2">
			<label for="exampleInputPassword1" class="form-label">Title</label>
			<input type="text" class="form-control"
				name="title" required="required">
		</div>
		<div class="mb-2">
			<label for="exampleInputPassword1" class="form-label">Description</label>
			<textarea rows="" cols="" class="form-control" name="description"></textarea>
		</div>
		<div class="mb-2">
			<label for="exampleInputPassword1" class="form-label">Views</label>
			<input type="number" class="form-control"
				value="0" readonly="readonly">
		</div>
		<div class="form-group mb-2">	
			<input type="radio" name="active" value="1" checked="checked">Active
			<input type="radio" name="active" value="0" >In active
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>