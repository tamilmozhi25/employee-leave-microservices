package com.FirstProject.LeaveService.controller;

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

import com.FirstProject.LeaveService.feign.EmployeeClient;
import com.FirstProject.LeaveService.model.Employee;
import com.FirstProject.LeaveService.model.Leave;
import com.FirstProject.LeaveService.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
	@Autowired
	private LeaveService leaveservice;
	
	@Autowired
	private EmployeeClient employeeclient;
	
	@GetMapping("/employeeinfo/{id}")
	public Employee getEmployeeInfo(@PathVariable Long id)
	{
		return employeeclient.getEmployeeById(id);
	}
	
	@GetMapping
	public List<Leave> getAllLeave()
	{
		return leaveservice.getAllLeave();
	}
	@GetMapping("/{id}")
	public Leave getLeaveById(@PathVariable Long id)
	{
		return leaveservice.getLeaveById(id);
	}
	@PostMapping
	public Leave applyLeave(@RequestBody Leave leave)
	{
		return leaveservice.applyLeave(leave);
	}
	@PutMapping("/{id}")
	public Leave updateLeaveById(@PathVariable Long id, @RequestBody Leave Newleave)
	{
		return leaveservice.updateLeaveById(id,Newleave);
	}
	@DeleteMapping("/{id}")
	public void deleteLeaveById(@PathVariable Long id)
	{
		leaveservice.deleteLeaveByid(id);
	}
}
