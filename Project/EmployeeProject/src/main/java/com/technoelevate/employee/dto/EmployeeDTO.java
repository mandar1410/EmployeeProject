package com.technoelevate.employee.dto;

import java.io.Serializable;




public class EmployeeDTO implements Serializable{
	
	private String EmpId;
	private String EmpName;
	private String EmPNameU;
	private String EmpNameD;
	private String EmpEmail;
	private String EmpPass;
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmPNameU() {
		return EmPNameU;
	}
	public void setEmPNameU(String emPNameU) {
		EmPNameU = emPNameU;
	}
	public String getEmpNameD() {
		return EmpNameD;
	}
	public void setEmpNameD(String empNameD) {
		EmpNameD = empNameD;
	}
	
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getEmpPass() {
		return EmpPass;
	}
	public void setEmpPass(String empPass) {
		EmpPass = empPass;
	}
	@Override
	public String toString() {
		return  EmpId+" "+EmpName;
	}
	
	
	
	
	
	
	
}
