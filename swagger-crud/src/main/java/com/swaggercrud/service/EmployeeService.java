package com.swaggercrud.service;


import java.util.List;
import java.util.Optional;

import com.swaggercrud.dto.Employee;


public interface EmployeeService {

	public void saveEmployeeById(Employee emp);
	
	public Optional<Employee> findById(int id);
	
	public void deleteById(int id);
	
	public void saveAll(List<Employee> emp);
	
	public void deleteAll(); 
	 
	public Employee updateById(int id , Employee employee);
}
