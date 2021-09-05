package com.technoelevate.employee.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;

import com.technoelevate.employee.dto.EmployeeDTO;
@Controller
public class EmployeeJdbc {
	
	public boolean  addEmp(EmployeeDTO emp)  {
		boolean flag=false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/SpringMVC";
			String uname= "root";
			String pass= "root" ;
			String ps= "INSERT into employeedetails (EmpId,EmpName) Values(?,?)" ;
			Connection con = DriverManager.getConnection(dburl,uname,pass);
			PreparedStatement psc= con.prepareStatement(ps);
			psc.setString(1,emp.getEmpId() );
			psc.setString(2, emp.getEmpName());
			
			int m= psc.executeUpdate(); 
			if (m==1) {
				flag= true;	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
			
	}
	
	
	public boolean deleteData(EmployeeDTO emp)  {
		
		boolean flag= false;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl = "jdbc:mysql://localhost:3306/SpringMVC";
		String uname= "root";
		String pass= "root" ;
		String ps= "DELETE FROM  employeedetails where EmpName=?" ;
		Connection con = DriverManager.getConnection(dburl,uname,pass);
		PreparedStatement psc= con.prepareStatement(ps);

		psc.setString(1, emp.getEmpNameD());
		
		int m= psc.executeUpdate(); 
		if (m==1) {
			flag=true; 	
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return flag;
		
	}

	
	public boolean updateData(EmployeeDTO emp) {
		boolean flag= false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/SpringMVC";
			String uname= "root";
			String pass= "root" ;
			String ps= "UPDATE employeedetails SET EmpName=? where EmpName=?" ;
			Connection con = DriverManager.getConnection(dburl,uname,pass);
			PreparedStatement psc= con.prepareStatement(ps);

			psc.setString(1, emp.getEmPNameU());
			psc.setString(2, emp.getEmpName());
			
			int m= psc.executeUpdate(); 
			if (m==1) {
				flag=true; 	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
	
	public String displayData(EmployeeDTO emp) {
		String m;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/SpringMVC";
			String uname= "root";
			String pass= "root" ;
			String ps= "Select EmpName from employeedetails   where EmpId=? " ;
			Connection con = DriverManager.getConnection(dburl,uname,pass);
			PreparedStatement psc= con.prepareStatement(ps);

			psc.setString(1, emp.getEmpId());
		
			
			ResultSet rs= psc.executeQuery();
			rs.next();
			
			m = rs.getString(1);
					
			
			return m;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Wrong EmpId" ; 
	}
	
	
	public boolean authEmp(EmployeeDTO emp) {
		boolean flag= false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/SpringMVC";
			String uname= "root";
			String pass= "root" ;
			String ps= "Select EmpEmail,EmpPass from employeedetails where EmpEmail=? ";
			Connection con = DriverManager.getConnection(dburl,uname,pass);
			PreparedStatement psc= con.prepareStatement(ps);

			psc.setString(1, emp.getEmpEmail());
			
			
			ResultSet rs = psc.executeQuery() ;
			
			rs.next();
			if (rs.getString(1).equals(emp.getEmpEmail()) && rs.getString(2).equals(emp.getEmpPass()) ) {
				flag=true; 	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
	
}
