<%@page import="com.technoelevate.employee.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%     EmployeeDTO en = (EmployeeDTO) request.getAttribute("empname"); 
      String mmd = (String) request.getAttribute("msg") ;
%>
<body>
  <%
  if(mmd=="Sucessfully Added"){
		out.println(mmd+" "+en.getEmpName());
  }else {
	  out.println(mmd);
  }
  %>

 
 <br>
 Go back to Login Page<br>
 <a href="index.jsp">Login</a>
</body>
</html>