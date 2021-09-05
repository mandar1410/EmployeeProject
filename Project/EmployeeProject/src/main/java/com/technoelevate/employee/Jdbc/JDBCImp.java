package com.technoelevate.employee.Jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technoelevate.employee.dto.EmployeeDTO;

public class JDBCImp {
		
	 private JdbcTemplate temp;



	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	 
	
	public  List<EmployeeDTO> getAllEmp(){
		RowMapper<EmployeeDTO> rowMapper = new EmpRowMapper();
		String q= "Select * from employeedetails" ;
		List<EmployeeDTO> empD = temp.query(q, rowMapper);
		return empD; 
	}
	
	
	public int  registerUser(EmployeeDTO emp) {
		String m= "Insert into employeedetails Values(?,?,?,?)";
		int b = temp.update(m,emp.getEmpId(),emp.getEmpName(),emp.getEmpEmail(),emp.getEmpPass());
		return b;
	}
	 
}
