package com.FirstProject.EmployeeService.model;


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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name ="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String department;
	private String email;
	
	public Long getId(){return id;}
	
	public String getName(){return name;}
	public void setName(String name){this.name=name;}
	
	public String getDepartment(){return department;}
	public void setDepartment(String department){this.department=department;}
	
	public String getEmail(){return email;}
	public void setEmail(String email){this.email=email;}

}
