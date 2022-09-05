package com.example.Springbootbackend.controller;

import java.util.List;

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

import com.example.Springbootbackend.model.Employee;
import com.example.Springbootbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
 
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//Build create employee REST API
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		//return new ResponseEntity<Employee>(null, null)
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	//Build get all employees REST API
	
	@GetMapping()
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//Build Get emp by iD
	
	//http://localhost:8080:api/employee/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeID(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeByID(id), HttpStatus.OK);
	}
	
	//Bulid update emp rest api
	
	//http://localhost:8080:api/employee/1
	@PutMapping("{id}")
	public ResponseEntity<Employee>updatEmployee(@PathVariable("id")long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
		
	}
	
	//BUILD DELETE REST API
	
	//http://localhost:8080:api/employee/1
	@DeleteMapping("{id}")
	public ResponseEntity<String>deletEmployee(@PathVariable("id") long id) {
		
		employeeService.deletEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfuly!.", HttpStatus.OK);
	}
	
}
