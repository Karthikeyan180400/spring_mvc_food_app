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

	<h2>Update Menu</h2>

	<div class="container">
		<form:form action="updatemenu" modelAttribute="menu" method="post">
    Item Menu Id<form:input path="itemMenuId" value="${menu.getItemMenuId()}" readonly="true"/>
    Item Name<form:input path="name" value="${menu.getName()}" />
    Cost<form:input path="cost" value="${menu.getCost()}" />
    Type<form:input path="type" value="${menu.getType()}" />
    Offer<form:input path="offer" value="${menu.getOffer()}" />
    Description<form:input path="description" value="${menu.getDescription()}" />
		<form:button>Update</form:button>

		</form:form>

	</div>

</body>
</html>
