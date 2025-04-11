package com.FirstProject.LeaveService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="leave_request")

public class Leave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long employeeid;
	private String fromDate;
	private String toDate;
	private String reason;
	private String status;
	
	public Long getId() {return id;}
	
	public Long getEmployeeid() {return employeeid;}
	public void setEmployeeid(Long employeeid) {this.employeeid = employeeid;}
	public String getFromDate() {return fromDate;}
	public void setFromDate(String fromDate) {this.fromDate = fromDate;}
	public String getToDate() {return toDate;}
	public void setToDate(String toDate) {this.toDate = toDate;}
	public String getReason() {return reason;}
	public void setReason(String reason) {this.reason = reason;}
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
}
