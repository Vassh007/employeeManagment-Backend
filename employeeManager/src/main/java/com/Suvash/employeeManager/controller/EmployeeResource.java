package com.Suvash.employeeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Suvash.employeeManager.model.Employee;
import com.Suvash.employeeManager.services.EmpolyeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private final EmpolyeeService emServices;

	@Autowired
	public EmployeeResource(EmpolyeeService emServices) {
		super();
		this.emServices = emServices;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = emServices.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee em = emServices.findEmployeeById(id);
		return new ResponseEntity<>(em, HttpStatus.OK);
	}
	
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = emServices.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = emServices.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        emServices.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
