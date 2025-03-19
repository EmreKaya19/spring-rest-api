package com.emrekaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrekaya.model.employee;
import com.emrekaya.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
 @GetMapping(path="/list")
	public List<employee>getAllEmployeeList(){
	return	employeeService.getAllEmployeeList();
		
	
	}
	@GetMapping(path="/list/{id}")
	public employee getEmployeebyİD(@PathVariable(name = "id",required = true)String id) {
		return employeeService.getEmployeebyİD(id);
		
	}
	
	@GetMapping(path ="/with-params")
	public List<employee> getEmployeeWithParams(@RequestParam(name ="firstName",required = false) String firstName, @RequestParam (name ="lastName",required = false) String lastName){
		
		return employeeService.gEmployeeWithParams(firstName, lastName);
	}
}
