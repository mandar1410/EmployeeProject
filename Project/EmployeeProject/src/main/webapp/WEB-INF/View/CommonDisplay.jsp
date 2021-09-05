<%@page import="com.technoelevate.employee.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% String mmd = (String) request.getAttribute("msg");
	String dn = (String) request.getAttribute("display");
    EmployeeDTO en = (EmployeeDTO) request.getAttribute("empname");
    
	 
	
%>
<body>
<% 
	

	if(mmd=="Sucessfully Added"){
		out.println(mmd+" "+en.getEmpName());
	}else if(mmd=="Sucessfully Deleted"){
		out.println(mmd+" "+en.getEmpNameD());
	}else if(mmd=="Sucessfully Updated"){
		out.println(mmd+" "+en.getEmPNameU());
	}else {
		out.println(dn);
	}

 
%>
<br><br><br>
Go back to Main Menu :  <a href="./checkOp">Main</a>
</body>
</html>