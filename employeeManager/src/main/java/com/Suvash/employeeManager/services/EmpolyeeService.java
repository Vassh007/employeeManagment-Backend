package com.Suvash.employeeManager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Suvash.employeeManager.exception.UserNotFoundException;
import com.Suvash.employeeManager.model.Employee;
import com.Suvash.employeeManager.repository.EmployeeRepo;

@Service
public class EmpolyeeService {
	private final EmployeeRepo emRepo;

	@Autowired
	public EmpolyeeService(EmployeeRepo emRepo) {
		super();
		this.emRepo = emRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeNumber(UUID.randomUUID().toString());
		return emRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return emRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return emRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return emRepo.findEmployeeById(id).
					orElseThrow(() -> new UserNotFoundException("User by id, " + id + " was not found!"));
	}

	public void  deleteEmployee(Long id) {
		emRepo.deleteEmployeeById(id);
	}
}
