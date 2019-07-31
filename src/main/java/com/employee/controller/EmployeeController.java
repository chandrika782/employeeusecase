package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeInterf;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeInterf employeeInterf;

	@PostMapping("/employeeDetails")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return employeeInterf.save(employee);
	}

	@GetMapping("/getDetails")
	public ResponseEntity<List<Employee>> getEmployee() {
		return employeeInterf.get();
	}

	@GetMapping("/getDetailsById/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int empId) {
		return employeeInterf.getEmpId(empId);

	}

	@PutMapping("/updateEmpDetails")

	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		return employeeInterf.update(employee);
	}

	@DeleteMapping("/deleteDetailsById/{empId}")

	public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") int empId) {
		return employeeInterf.deleteEmpId(empId);
	}
}