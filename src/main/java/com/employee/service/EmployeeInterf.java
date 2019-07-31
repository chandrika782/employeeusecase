package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.model.Employee;

public interface EmployeeInterf {
	
	public ResponseEntity<Employee> save(Employee employee);
	
	public ResponseEntity<List<Employee>> get();
	
	public ResponseEntity<Employee> getEmpId(int id);
	
	public ResponseEntity<String> update(Employee employee);
	
	public ResponseEntity<String> deleteEmpId(int id);

}
