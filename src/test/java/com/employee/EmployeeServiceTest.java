package com.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	@Mock
	EmployeeRepo employeeRepo;
	
	
	@InjectMocks
	EmployeeImpl employeeImpl;
	
	
	Employee employee;
	

	@Before
	public void init() {
		
		Employee emp=new Employee();
		
		emp.setEmpId(1);
		emp.setEmpName("chandu");
		emp.setGender("female");
		emp.setPhoneno(99009);
		emp.setAddress("kadapa");
	}
	
	@Test
	
	public void save() {
		
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		Employee Actualvalue = employeeImpl.save(employee);
		Assert.assertEquals(employee, Actualvalue);
		
	}
	
	
	@Test
	
	public void get() {
		
		List<Employee> l=new ArrayList<Employee>();
		l.add(employee);
		Mockito.when(employeeRepo.findAll()).thenReturn(l);
		List<Employee> Actualvalue=employeeImpl.get();
		Assert.assertEquals(l, Actualvalue);
	}

	
	
	@Test
	
	public void update() {
		
		
		Mockito.when(employeeRepo.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		String Actualvalue=employeeImpl.update(employee);
		Assert.assertEquals(Actualvalue, "updated successfully");
		
	}
	
	@Test
	
	public void getEmpId() {
	}
	s
	@Test
	public void deleteEmpId() {
	}
	}
	


