package com.example.Springbootbackend.service;

import java.util.List;

import com.example.Springbootbackend.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeByID(long id);
	Employee updateEmployee(Employee employee, long id);
	void deletEmployee(long id);
}
