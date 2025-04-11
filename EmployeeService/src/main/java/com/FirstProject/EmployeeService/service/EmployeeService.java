package com.FirstProject.EmployeeService.service;

import java.util.List;

import com.FirstProject.EmployeeService.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
	Employee addEmployee(Employee emp);
	Employee updateEmployeeById(Long id, Employee newEmp);
	void deleteEmployeeById(Long id);
	

}
