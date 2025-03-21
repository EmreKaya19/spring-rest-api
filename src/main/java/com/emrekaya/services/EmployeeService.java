package com.emrekaya.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrekaya.model.employee;
import com.emrekaya.model.updateEmployeeRequest;
import com.emrekaya.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
public List<employee> getAllEmployeeList(){
return	employeeRepository.getAEmployeeList();
	 
}

public employee getEmployeebyİD(String id) {
	return employeeRepository.getEmployeebyİD(id);
}

public List<employee> gEmployeeWithParams(String firstName , String lastName){
	return employeeRepository.getEmployeeWithParams(firstName, lastName);
}


public employee saveEmployee (employee newEmployee) {
	return employeeRepository.saveEmployee(newEmployee);
}

public boolean deleteEmployee(String id) {
	return employeeRepository.deleteEmployee(id);
}

public employee updateEmployee(String id , updateEmployeeRequest request) {
	return employeeRepository.updateEmployee(id, request);
}

}
