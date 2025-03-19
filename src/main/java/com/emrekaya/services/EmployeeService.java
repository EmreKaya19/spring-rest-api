package com.emrekaya.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrekaya.model.employee;
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
}
