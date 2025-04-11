package com.FirstProject.LeaveService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.LeaveService.model.Leave;
@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

}
