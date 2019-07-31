package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.Exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeImpl implements EmployeeInterf {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public ResponseEntity<Employee> save(Employee employee) {
		Employee em = employeeRepo.save(employee);

		return new ResponseEntity<>(em,HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<List<Employee>> get() {
		
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(),HttpStatus.OK); 
	}

	@Override 
	public ResponseEntity<String> update(Employee employee) {
		if (!employeeRepo.findById(employee.getEmpId()).isPresent())
			throw new EmployeeException("employee not exist");

		employeeRepo.save(employee);
		return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		//return  ResponseEntity.status(HttpStatus.OK).body("updated successfully");
	}

	@Override
	public ResponseEntity<Employee> getEmpId(int id) {

		return new ResponseEntity<>(employeeRepo.findById(id).get(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteEmpId(int id) {
		if (!employeeRepo.findById(id).isPresent())
			throw new EmployeeException("employee not exist");

		employeeRepo.deleteById(id);
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	}

} 
