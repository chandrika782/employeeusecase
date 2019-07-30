package com.employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employee.controller.EmployeeController;
import com.employee.model.Employee;
import com.employee.service.EmployeeImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmployeeControllerTests {
	
	@Mock
	EmployeeImpl employeeImpl;
	
	@InjectMocks
	EmployeeController employeeController;
	
	private MockMvc mockMvc;
	
	Employee employee;
	
	@Before
	public void setup() {
		employee=new Employee();
		mockMvc=MockMvcBuilders.standaloneSetup(employeeController).build();
	
	}
	
	public static String asJsonString(final Object obj) {

 		try {

 			return new ObjectMapper().writeValueAsString(obj);

 		} catch (Exception e) {

 			throw new RuntimeException(e);

 		}}
	
	@Test
	public void createEmployee() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.post("/employee/employeeDetails").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
	
	}
	@Test
	public void getEmployee() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getDetails").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());

}
	
@Test
public void getEmployeeById() throws Exception {
	
	mockMvc.perform(MockMvcRequestBuilders.get("/employee/getDetailsById/2").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());

}

@Test
public void updateEmployee() throws Exception {
	
	mockMvc.perform(MockMvcRequestBuilders.put("/employee/updateEmpDetails").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
}

@Test
public void deleteEmployeeById() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteDetailsById/3").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());

}
}


