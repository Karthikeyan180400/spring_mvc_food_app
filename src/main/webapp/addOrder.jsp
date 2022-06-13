<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 4px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: red;
	opacity: 0.8;
	color: white;
}
</style>
</head>
<body>
	<%@include file="userNaviBar.jsp"%>

	<h2>Menu</h2>

	<div class="container">
		<form:form action="createitem" modelAttribute="item">

	        Item Name<form:input path="name" value="${itemName}"
				readonly="true" />
            Quantity<form:input path="quantity" />
			<form:button>Add</form:button>

		</form:form>

	</div>
</body>
</html>


