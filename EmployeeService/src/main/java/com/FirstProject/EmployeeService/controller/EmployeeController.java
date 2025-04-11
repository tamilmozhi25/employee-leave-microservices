package com.FirstProject.EmployeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.EmployeeService.model.Employee;
import com.FirstProject.EmployeeService.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return employeeservice.getAllEmployee();
	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return employeeservice.getEmployeeById(id);
	}
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return employeeservice.addEmployee(emp);
	}
	@PutMapping("/{id}")
	public Employee updateEmployeeeByID(@PathVariable Long id,@RequestBody Employee newEmp)
	{
		return employeeservice.updateEmployeeById(id,newEmp);
	}
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Long id)
	{
		employeeservice.deleteEmployeeById(id);
	}

}
