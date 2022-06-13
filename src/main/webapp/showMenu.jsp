<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	opacity:0.8;
	color: white;
}
</style>
</head>
<body>
<%@include file="adminNaviBar.jsp" %>

	<h2>Menu</h2>

	<table id="customers">
		<tr>

			<th>Item Menu ID</th>
			<th>Item Name</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Offer</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
			

		</tr>
		<c:forEach var="menu" items="${menus}">
		<tr>
			<td>${menu.getItemMenuId()}</td>
			<td>${menu.getName()}</td>
			<td>${menu.getType()}</td>
			<td>${menu.getCost()}</td>
			<td>${menu.getOffer()}</td>
			<td>${menu.getDescription()}</td>

			<td><a href="editmenu?id=${menu.getItemMenuId()}">Edit</a></td>
			<td><a href="deletemenu?id=${menu.getItemMenuId()}">Delete</a></td>
       </tr>
       </c:forEach>
	</table>

</body>
</html>


