package com.FirstProject.LeaveService.service;

import java.util.List;

import com.FirstProject.LeaveService.model.Leave;

public interface LeaveService {
	List<Leave> getAllLeave();
	Leave getLeaveById(Long id);
	Leave applyLeave(Leave leave);
	Leave updateLeaveById(Long id, Leave newleave);
	void deleteLeaveByid(Long id);

}
