package com.swaggercrud.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaggercrud.dto.Employee;
import com.swaggercrud.repository.RepositoryEmp;
import com.swaggercrud.service.EmployeeService;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	RepositoryEmp empRepo;
	
	@Override
	public void saveEmployeeById(Employee employee) {
		empRepo.save(employee);
			
	}

	@Override
	public Optional<Employee> findById(int id) {
		return empRepo.findById(id);
		
	}

	@Override
	public void deleteById(int id) {
		Employee e1=empRepo.findById(id).get();
		if(e1!=null)
		{
			empRepo.deleteById(id);
		}	
	}

	@Override
	public void saveAll(List<Employee> emp) {
		empRepo.saveAll(emp);
		
	}

	@Override
	public void deleteAll() {
		empRepo.deleteAll();
	}

	@Override
	public Employee updateById(int id, Employee employee) {
		Employee existEmployee=empRepo.findById(id).get();
		existEmployee.setName(employee.getName());
		existEmployee.setEmail(employee.getEmail());
		existEmployee.setAge(employee.getAge());
		existEmployee.setDepartment(employee.getDepartment());
		existEmployee.setLocation(employee.getLocation());
		empRepo.save(existEmployee);
		return existEmployee;
	}
}
