package com.emrekaya.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emrekaya.model.employee;

@Configuration
public class AppConfig {
	@Bean
	public List<employee> employeeList(){
		List<employee> employeeList = new ArrayList<>();
		employeeList.add(new employee("1","emre","kaya"));
		employeeList.add(new employee("2","esra","kaya"));
		employeeList.add(new employee("3","cemal","kaya"));
		employeeList.add(new employee("4","öznur","kaya"));
		employeeList.add(new employee("5","halime","kaya"));
		
		return employeeList;

	}

}
