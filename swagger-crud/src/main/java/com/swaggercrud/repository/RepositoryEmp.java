package com.swaggercrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaggercrud.dto.Employee;

public interface RepositoryEmp extends JpaRepository<Employee, Integer> {

	public Employee findByEmailIgnoreCase(String email); 
	
	public List<Employee> findByDepartmentIgnoreCase(String department);
	
	public List<Employee> findByAgeAndDepartmentIgnoreCase(int age,String department);
	
	public List<Employee> findByNameContaining(String name);
	
	public Employee findByNameStartingWith(String name);
	
	public List<Employee> findByNameEndingWith(String name);
	
	public List<Employee> findByOrderByAgeAsc();
}
