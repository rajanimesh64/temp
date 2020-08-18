
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table  border="1">
	<tr>
		<th>Part No</th>
		<th>Part Name</th>
		<th>Car Model</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
	<c:forEach items="${ listOfCarParts }" var="c">
		<tr>
			<td>${ c.partNo }</td>
			<td>${ c.name }</td>
			<td>${ c.carModel }</td>
			<td>${ c.price }</td>
			<td>${ c.quantity }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>