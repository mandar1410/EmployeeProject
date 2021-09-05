package com.technoelevate.employee.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.technoelevate.employee.dto.EmployeeDTO;

public class EmpRowMapper implements RowMapper<EmployeeDTO> {
	
	
	@Override
	public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	EmployeeDTO empdto = new EmployeeDTO();	
	empdto.setEmpId(rs.getString(1));
	empdto.setEmpName(rs.getString(2));
		
	return empdto;
	}

}
  