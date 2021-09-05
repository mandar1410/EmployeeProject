package com.technoelevate.employee.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.technoelevate.employee.Jdbc.EmployeeJdbc;
import com.technoelevate.employee.dto.EmployeeDTO;

@Controller
public class Empverfying  {
	@Autowired
	EmployeeJdbc emjdbc ;
	
	
	public boolean addData(EmployeeDTO emp) {
	
		return emjdbc.addEmp(emp);
	}
	
	public boolean deleteData(EmployeeDTO emp) {
		
		return emjdbc.deleteData(emp);
	}	
	
	public boolean updateData(EmployeeDTO emp) {
		
		return emjdbc.updateData(emp); 
	}
	
	public String displayData(EmployeeDTO emp) {
		
		return emjdbc.displayData(emp); 
	}
	
	public boolean autinticate (EmployeeDTO emp) {
		return emjdbc.authEmp(emp);
	}
}
