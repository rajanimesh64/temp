<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addCarPart.req" method="POST">
Part No: <input type="text" name="partNo" /> <br />
Part Name :<input type="text"  name="name" /> <br />
Car Model :<input type="text"  name="carModel" /> <br/>
Price :<input type="text"  name="price" /> <br/>
Quantity :<input type="text"  name="quantity" /> <br/>
<button type="submit"> Add</button>
</form>

</body>
</html>