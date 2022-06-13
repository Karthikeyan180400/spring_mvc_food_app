<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=email], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=number], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: navy;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #111;
}

button {
	background-color: Red;
	opacity: 0.8;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: #111;
}

div.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>
<%@include file="adminNaviBar.jsp" %>

	<h2>Your Profile</h2>

	<div class="container">
		<form:form action="updateadmin" modelAttribute="admin" method="post">
		
   <a href="editadmin?id=${admin.getId()}">Update</a>
   <a href="deleteadmin?id=${admin.getId()}">Delete</a><br><br>
   
    Id<form:input path="id" value="${admin.getId()}" readonly="true"/>
    Name<form:input path="name" value="${admin.getName()}" readonly="true" />
    Email<form:input path="email" value="${admin.getEmail()}"  readonly="true"/>
    Phone<form:input path="phone" value="${admin.getPhone()}"  readonly="true"/>
    Password<form:input path="password" value="${admin.getPassword()}" readonly="true" />
    Role<form:input path="role" value="${admin.getRole()}" readonly="true" />
    
   
		</form:form>

	</div>

</body>
</html>
