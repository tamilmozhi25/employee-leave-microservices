package com.FirstProject.LeaveService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FirstProject.LeaveService.model.Employee;

@FeignClient(name = "EmployeeService",url="http://localhost:8082")
public interface EmployeeClient {
	
	@GetMapping("/api/employee/{id}")
	Employee getEmployeeById(@PathVariable Long id);

}
