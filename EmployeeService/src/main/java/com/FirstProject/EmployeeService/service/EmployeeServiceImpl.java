package com.FirstProject.EmployeeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FirstProject.EmployeeService.model.Employee;
import com.FirstProject.EmployeeService.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeerepository;
	@Override
	public List<Employee> getAllEmployee() {
		
		return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeerepository.findById(id).orElse(null);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return employeerepository.save(emp);
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee newEmp) {
		
		Employee oldemployee = getEmployeeById(id);
		if(oldemployee!=null)
		{
			oldemployee.setName(newEmp.getName());
			oldemployee.setDepartment(newEmp.getDepartment());
			oldemployee.setEmail(newEmp.getEmail());
			return employeerepository.save(oldemployee);
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		
		employeerepository.deleteById(id);
	}
	
	

}
