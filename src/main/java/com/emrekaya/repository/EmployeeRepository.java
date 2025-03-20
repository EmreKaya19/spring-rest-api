package com.emrekaya.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emrekaya.model.employee;
import com.emrekaya.model.updateEmployeeRequest;

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


public employee saveEmployee(employee newEmployee) {
	employeeList.add(newEmployee);
	return newEmployee;
}



public boolean deleteEmployee(String id) {
	employee deleteEmployee=null;
	
	for (employee employee : employeeList) {
		if (id.equals(employee.getId())) {
			deleteEmployee=employee;
		}
		
	}
	if (deleteEmployee==null) {
		return false;
	}
	employeeList.remove(deleteEmployee);
	return true;
}

private employee findEmployeebyid(String id) {
	employee findEmploye =null;
	for (employee employee : employeeList) {
		if (employee.getId().equals(id)) {
			findEmploye =employee;
			break;
		}
		
	}
	return findEmploye;
	
}
public employee updateEmployee(String id , updateEmployeeRequest request) {
	employee findEmployee= findEmployeebyid(id);
	if (findEmployee!=null) {
		deleteEmployee(id);
		employee updatedEmployee=new employee();
		updatedEmployee.setId(id);
		updatedEmployee.setFirstName(request.getFirstName());
		updatedEmployee.setLastName(request.getLastName());
		
		employeeList.add(updatedEmployee);
		return updatedEmployee;
	}
	return null;
	
}












}
