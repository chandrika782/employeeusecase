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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.Exception.EmployeeException;
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

		employee = new Employee(); 

		employee.setEmpId(1);
		employee.setEmpName("chandu");
		employee.setGender("female");
		employee.setPhoneno(99009);
		employee.setAddress("kadapa");
	}

	@Test

	public void save() {

		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		ResponseEntity<Employee> Actualvalue = employeeImpl.save(employee);
		Assert.assertEquals(employee, Actualvalue.getBody());

	}

	@Test
	public void get() {

		List<Employee> l = new ArrayList<>();
		l.add(employee);
		Mockito.when(employeeRepo.findAll()).thenReturn(l);
		ResponseEntity<List<Employee>> Actualvalue = employeeImpl.get();
		Assert.assertEquals(l, Actualvalue.getBody());
	}

	@Test

	public void update() {

		Mockito.when(employeeRepo.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		ResponseEntity<String> Actualvalue = employeeImpl.update(employee);
		Assert.assertEquals(Actualvalue.getBody(), "updated successfully");

	}

	@Test(expected = EmployeeException.class)
	public void updateNegative() {

		Mockito.when(employeeRepo.findById(2)).thenReturn(Optional.of(employee));
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		ResponseEntity<String> Actualvalue = employeeImpl.update(employee);
//		Assert.assertEquals(Actualvalue, "updated successfully");

	}

	@Test

	public void getEmpId() {

		Mockito.when(employeeRepo.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		ResponseEntity<Employee> Actualvalue = employeeImpl.getEmpId(employee.getEmpId());
		Assert.assertEquals(Actualvalue.getBody(), employee);

	}

	@Test
	public void deleteEmpId() {

		Mockito.when(employeeRepo.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		// Mockito.when(employeeRepo.deleteById(employee.getEmpId()));
		ResponseEntity<String> Actualvalue = employeeImpl.deleteEmpId(employee.getEmpId());
		Assert.assertEquals(Actualvalue.getBody(), "deleted successfully");
	}

	@Test(expected = EmployeeException.class)
	public void deleteNegative() {
		Mockito.when(employeeRepo.findById(2)).thenReturn(Optional.of(employee));
		// Mockito.when(employeeRepo.deleteById(employee.getEmpId()));
		ResponseEntity<String> Actualvalue = employeeImpl.deleteEmpId(employee.getEmpId());
//			Assert.assertEquals(Actualvalue, "deleted successfully");

	}

}
