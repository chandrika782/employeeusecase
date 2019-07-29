package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	

}
