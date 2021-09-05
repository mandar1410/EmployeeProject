package com.technoelevate.employee.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import com.technoelevate.employee.jdbc.JDBCImp;
import com.technoelevate.employee.dto.EmployeeDTO;

@Component
public class ServiceJDBC {
	ApplicationContext con = new ClassPathXmlApplicationContext("com/technoelevate/employee/service/Config.xml"); 
	JDBCImp imp = con.getBean("daoOperationimpl",JDBCImp.class);
	
	public List<EmployeeDTO> getAllData() {
		return imp.getAllEmp();
	}
	
	public int registerUser(EmployeeDTO emp) {
		return imp.registerUser(emp);
	}
}
