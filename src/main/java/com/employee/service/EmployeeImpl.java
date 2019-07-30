package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeImpl implements EmployeeInterf {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee save(Employee employee) {

		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> get() {
		return employeeRepo.findAll(); 
	}

	@Override 
	public String update(Employee employee) {
		if (!employeeRepo.findById(employee.getEmpId()).isPresent())
			throw new EmployeeException("employee not exist");

		employeeRepo.save(employee);
		return "updated successfully";
	}

	@Override
	public Employee getEmpId(int id) {

		return employeeRepo.findById(id).get();
	}

	@Override
	public String deleteEmpId(int id) {
		if (!employeeRepo.findById(id).isPresent())
			throw new EmployeeException("employee not exist");

		employeeRepo.deleteById(id);
		return "deleted successfully";
	}

} 
