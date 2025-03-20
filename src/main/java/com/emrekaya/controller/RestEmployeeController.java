package com.emrekaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrekaya.model.employee;
import com.emrekaya.model.updateEmployeeRequest;
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
	
	@PostMapping(path="/save-employee")
	public employee savEmployee(@RequestBody employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}
	
	@DeleteMapping(path="/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable(name = "id")String id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping(path = "/update-employee/{id}")
	public employee updateEmployee(@PathVariable(name="id")String id,@RequestBody updateEmployeeRequest request) {
		return employeeService.updateEmployee(id, request);
	}
	
	
}
