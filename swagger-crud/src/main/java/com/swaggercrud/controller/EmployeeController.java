package com.swaggercrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swaggercrud.dto.Employee;
import com.swaggercrud.repository.RepositoryEmp;
import com.swaggercrud.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RepositoryEmp repo;
	
	@PostMapping("/employee")
	public String saveById(@RequestBody Employee employee) {
		employeeService.saveEmployeeById(employee);
		return "Data Saved";
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> findById(@PathVariable int id) {
		return employeeService.findById(id);	
	}
	
	@DeleteMapping("/emoloyee/{id}")
	public String deleteById(@PathVariable int id) {
		employeeService.deleteById(id);
		return "Employee Deleted";
	}
	
	@PostMapping("/employees")
	public String saveAll(@RequestBody List<Employee> emp) {
		employeeService.saveAll(emp);
		return "Multiple employees saved";
	}
	
	@DeleteMapping("/employee")
	public String deleteAll() {
		employeeService.deleteAll();
		return "All employees deleted";
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateById(@PathVariable int id,@RequestBody Employee employee) {
		return employeeService.updateById(id, employee);
	}
	
	@GetMapping("/employee")
	public Employee getEmployeeByEmail(@RequestParam String email) {
		return repo.findByEmailIgnoreCase(email);
	}
	
	@GetMapping("/emp")
	public List<Employee> getByDepartment(@RequestParam String department) {
		return repo.findByDepartmentIgnoreCase(department);
	}
	
	@GetMapping("/emps/{age}")
	public List<Employee> getByAgeAndDepartment(@PathVariable int age,@RequestParam String department) {
		return repo.findByAgeAndDepartmentIgnoreCase(age, department);
	}
	
	@GetMapping("/e")
	public List<Employee> getByNameContaining(@RequestParam String name){
		return repo.findByNameContaining(name);
	}
	
	@GetMapping("employ")
	public Employee getNameStartingWith(@RequestParam String name) {
		return repo.findByNameStartingWith(name); 
	}
	
	@GetMapping("employe")
	public List<Employee> getNameEndingWith(@RequestParam String name){
		return repo.findByNameEndingWith(name);
	}
	
	@GetMapping("em")
	public List<Employee> getOrderByage(){
		return repo.findByOrderByAgeAsc();
	}
}
