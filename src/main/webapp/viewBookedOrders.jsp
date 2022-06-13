<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	background-color: navy;
	color: white;
}
</style>
</head>
<body>
	<%@include file="userNaviBar.jsp"%>
	<h2>Order Details</h2>

	<form:form action="saveitem">
		<table id="customers">
			<tr>
				<th>Order Id</th>
				<th>Total Cost</th>
				<th>Ordered Items</th>
				<th>Cancel Order</th>

			</tr>
			<c:forEach var="foodorder" items="${foodorders}">
				<tr>
					<td>${foodorder.getId()}</td>
					<td>${foodorder.getTotal()}</td>
					<td><a href="viewitems?id=${foodorder.getId()}">View Items</a></td>
					<td><a href="cancelorder?id=${foodorder.getId()}">Cancel Order</a></td>

				</tr>
			</c:forEach>

		</table>
	</form:form>
</body>
</html>


