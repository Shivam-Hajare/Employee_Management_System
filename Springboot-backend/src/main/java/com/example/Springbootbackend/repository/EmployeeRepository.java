package com.example.Springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springbootbackend.model.Employee;

//No need to add @Respository as it is inbuild in JPARepository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
