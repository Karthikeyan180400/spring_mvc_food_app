<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body{
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
	background-color: navy;
	color: white;
}
</style>
</head>
<body>
<%@include file="userNaviBar.jsp" %>
	<h2>Order Item Details</h2>

<form:form action="setitem" modelAttribute="item">
	<table id="customers">
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Cost</th>

		</tr>
		<c:forEach var="item" items="${items}">
		<tr>
			<td>${item.getName()}</td>
			<td>${item.getQuantity()}</td>
			<td>${item.getCost()}</td>
		
		</tr>	
		</c:forEach>
		
	</table>
	<a href="setitem">Make A Order</a>
</form:form>
</body>
</html>


