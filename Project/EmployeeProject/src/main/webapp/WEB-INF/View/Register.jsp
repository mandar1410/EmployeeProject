<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./reg" method="post">
   Id:	 <input type="text" name="EmpId" required="required"><br><br>
   Name: <input type="text" name="EmpName" required="required"><br><br>
   Email: <input type="text" name="EmpEmail" required="required"><br><br>
   Pass: <input type="text" name="EmpPass" required="required"><br><br>
   <input type="submit" value="Register">
	</form>
</body>
</html>