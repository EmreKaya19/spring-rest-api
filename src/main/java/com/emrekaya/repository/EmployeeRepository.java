package com.emrekaya.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emrekaya.model.employee;

@Repository
public class EmployeeRepository {
	@Autowired
	private List<employee> employeeList;
	
public List<employee>getAEmployeeList(){

	return employeeList;
}
 
public employee getEmployeebyİD(String id) {
	employee Findemployee=null;
	
	for (employee employee1 : employeeList) {
		if (id.equals(employee1.getId())) {
			Findemployee=employee1;
			break;
		}
		
	}
	
	return Findemployee;
}

public List<employee> getEmployeeWithParams(String firstName , String lastName){
	List<employee> getEmployeeWithParams = new ArrayList<>();	
	if (firstName==null && lastName==null) {
		return employeeList;
		
	}
	
	for (employee employee : employeeList) {
		if (firstName!=null && lastName!=null) {
			if (employee.getFirstName().equalsIgnoreCase(firstName)&& employee.getLastName().equalsIgnoreCase(lastName)) {
				getEmployeeWithParams.add(employee);
			}
			
		}
		if (firstName!=null && lastName==null) {
			if (employee.getFirstName().equalsIgnoreCase(firstName)) {
				getEmployeeWithParams.add(employee);
			}
			
		}
		if (firstName==null && lastName!=null) {
			if (employee.getLastName().equalsIgnoreCase(lastName)) {
				getEmployeeWithParams.add(employee);
			}
			
		}
	}
	return getEmployeeWithParams;
}



}
