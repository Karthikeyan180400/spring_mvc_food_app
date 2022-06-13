<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="userNaviBar.jsp" %>
	<h2>Bill</h2>
	
	
	<table>
	    <tr>
	      <td>Name: ${foodorder.getUser().getName()}</td>
	    </tr>
	    <tr>
	      <td>Phone Number: ${foodorder.getUser().getPhone()} </td>
	    </tr>
	    <tr>
	      <th>Item Name</th>
	      <th>Quantity</th>
	      <th>Cost</th>
	      <th>Offer</th>
	    </tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.getName()}</td>
				<td>${item.getQuantity()}</td>
				<td>${item.getCost()}</td>
				<td>${item.getMenu().getOffer()}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>CGST</td>
			<td></td>
			<td>+12 %</td>
		</tr>
		<tr>
			<td>SGST</td>
			<td></td>
			<td>+8 %</td>
		</tr>

		<tr>
			<td></td>
			<td><b>Total Cost</b></td>
			<td>${foodorder.getTotal()}</td>
		</tr>

	</table>

</body>
</html>