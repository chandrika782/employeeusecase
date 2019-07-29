package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeInterf {
	
	public Employee save(Employee employee);
	
	public List<Employee> get();
	
	public Employee getEmpId(int id);
	
	public String update(Employee employee);
	
	public String deleteEmpId(int id);

}
