package com.technoelevate.employee.mycontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.technoelevate.employee.dto.EmployeeDTO;
import com.technoelevate.employee.service.Empverfying;
import com.technoelevate.employee.service.ServiceJDBC;


@Controller
public class EmployeeController {
	
	@Autowired
	Empverfying service ;
	@Autowired
	ServiceJDBC check;
	
	@GetMapping("/register")
	public String register() {
		return "Register" ;
	}
	
	@GetMapping("/add")
	public String addEmpData() {
		return "Add";
	}
	
	@GetMapping("/delete")
	public String getDeleteData() {
		return "Delete" ;
	}
	
	@GetMapping("/update")
	public String getUpdatedData() {
		return "Update" ;
	}
	
	@GetMapping("/display")
	public String getEmpData() {
		return "Display";
	}
	
	@GetMapping("/checkOp")
	public String logoutCheck() {
		return "Operation";
	}
	
	
	
	@GetMapping("/logout")
    public String logOut(EmployeeDTO emp, ModelMap map, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "Lout";
	}
	
	@PostMapping("/addEmp")
	public String presentData(EmployeeDTO emp, ModelMap map, HttpServletRequest request) {
		HttpSession s = request.getSession(false) ;
		if(s != null) {
			
			boolean md = service.addData(emp);
			if(md) {
				map.addAttribute("empname",emp);
				map.addAttribute("msg","Sucessfully Added");	
			}else {
				map.addAttribute("msg","Error 404");
			}
			
			return "CommonDisplay" ;
		}else {
			map.addAttribute("msg","Invalid Session");
			return "CommonDisplay";
		}
		
		
	}
	
	@PostMapping("/reg")	
	 public String registerNew(EmployeeDTO emp ,ModelMap map ) {
		 
		  int k = check.registerUser(emp);
		  if(k==1) {
				map.addAttribute("empname",emp);
				map.addAttribute("msg","Sucessfully Added");	
			}else {
				map.addAttribute("msg","Error 404");
			}
		 return "Regi" ;
	 }
	@PostMapping("/deletedata")
	public String deleteData(EmployeeDTO emp, ModelMap map ) {
		
		boolean md = service.deleteData(emp);
		if(md) {
			map.addAttribute("empname",emp);
			map.addAttribute("msg","Sucessfully Deleted");	
		}else {
			map.addAttribute("msg","Wrong Name Entered");
		}
		return "CommonDisplay" ;
	}
	
	@PostMapping("/updateData")
	public String updateData(EmployeeDTO emp,  ModelMap map) {
		boolean md= service.updateData (emp);
		if(md) {
			map.addAttribute("empname",emp);
			map.addAttribute("msg","Sucessfully Updated");	
		}else {
			map.addAttribute("msg","Wrong Name Entered");
		}
		return "CommonDisplay" ;
	}
	
	@PostMapping("/displayData")
	public String displayData (ModelMap map, EmployeeDTO emp) {
	    String md= service.displayData (emp);
		 if(md!=null) {
			map.addAttribute("display",md);
			
		}else {
			map.addAttribute("msg","Wrong Name Entered");
		}
		return "CommonDisplay";
	}
	
	@GetMapping("/displayAll")
	public String getMapping (ModelMap map, EmployeeDTO emp) {
	List<EmployeeDTO> empList=	check.getAllData();
	 if(empList!=null) {
		 map.addAttribute("mapDis", empList);
			
		}else {
			map.addAttribute("msg","Opps Something Went Wrong");
		}
	
	return "ListDisplay" ;
	}
	
	@PostMapping("/auth")
	public String autinticate(EmployeeDTO emp,ModelMap map, HttpServletRequest request) {
		boolean md=service.autinticate(emp);
		if(md) {
			HttpSession mySession = request.getSession();
			
			return "Operation";	
		}else {
			map.addAttribute("msg","Invalid Credientials");
		}
		return "Error";
	}
}
