package com.FirstProject.LeaveService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FirstProject.LeaveService.feign.EmployeeClient;
import com.FirstProject.LeaveService.model.Employee;
import com.FirstProject.LeaveService.model.Leave;
import com.FirstProject.LeaveService.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private EmployeeClient employeeclient;
	
	@Autowired
	private LeaveRepository leaverepository;

	@Override
	public List<Leave> getAllLeave() {
		return leaverepository.findAll();
	}

	@Override
	public Leave getLeaveById(Long id) {
		return leaverepository.findById(id).orElse(null);
	}

	@Override
	public Leave applyLeave(Leave leave) {
		//return leaverepository.save(leave);
		try
		{
			Employee employee = employeeclient.getEmployeeById(leave.getEmployeeid());
			if(employee!=null)
			{
				leave.setStatus("PENDING");
				return leaverepository.save(leave);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Employee Not Found! cannot apply leave");
		}
		return null;
	}

	@Override
	public Leave updateLeaveById(Long id, Leave newleave) {
		Leave oldleave=getLeaveById(id);
		if(oldleave!=null)
		{
			oldleave.setEmployeeid(newleave.getEmployeeid());
			oldleave.setFromDate(newleave.getFromDate());
			oldleave.setToDate(newleave.getToDate());
			oldleave.setReason(newleave.getReason());
			oldleave.setStatus(newleave.getStatus());
			return leaverepository.save(oldleave);
		}
		return null;
	}

	@Override
	public void deleteLeaveByid(Long id) {
		leaverepository.deleteById(id);
	}
	
	

}
