package com.example.Springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Springbootbackend.exception.ResourceNotFoundException;
import com.example.Springbootbackend.model.Employee;
import com.example.Springbootbackend.repository.EmployeeRepository;
import com.example.Springbootbackend.service.EmployeeService;

import net.bytebuddy.asm.Advice.Return;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	} 

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByID(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent())
//		{ 
//			return employee.get();
//			
//		}
//		else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		//lamda exp
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check id is present or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing emp to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deletEmployee(long id) {
		// TODO Auto-generated method stub
		//check the emp is available or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));

		employeeRepository.deleteById(id);
	}
	

}
