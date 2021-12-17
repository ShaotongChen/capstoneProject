<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-ccenter mb-3">New Student Page</h1>
<form action="NewStudent" method="POST">
<div class="form-group">
<label for="name">Student Name</label>
<input type="text" class="form-control" id="name" name="studentName" placeholder="Enter Student Name">
</div>
<div class="form-group">
<label for="gender">Student Gender</label>
<input type="radio" id="gender" name="gender" value="Male"> 
<input type="radio" id="gender" name="gender" value="FeMale"> 
</div>
<div class="ccontainer text-center"> 
<a herf="Student" class="btn btn-outline-success">Back</a>
<button type="submit" class="btn btn-primary" >Add</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>