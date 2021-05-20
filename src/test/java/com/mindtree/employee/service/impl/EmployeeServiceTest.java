/*package com.mindtree.employee.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.employee.dao.EmployeeDao;
import com.mindtree.employee.model.Employee;
import com.mindtree.employee.repository.EmployeeRepository;
import com.mindtree.employee.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Mock
	EmployeeRepository emplRep;
	
	@Mock
	EmployeeDao empDao;
	
	@InjectMocks
	@Spy
	EmployeeServiceImpl emplServImpl;
	
	List<Employee> list;
	Employee employee;
	
	@Before
	public void init()
	{
		list = new ArrayList<>();
		employee = new Employee();
		employee.setId(33527);
		employee.setName("Employee7");
		employee.setSalary(24000);
		employee.setDepartment("development");
		list.add(employee);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void saveEmployeeTest() {
		
		when(emplRep.save(Matchers.any(Employee.class))).thenReturn(employee);
		when(empDao.saveEmployee(Matchers.any(Employee.class))).thenReturn(employee);
		assertNotNull(emplServImpl.saveEmployee(employee));
		
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
		when(empDao.getEmployeeById(33257)).thenReturn(Optional.of(employee));
		assertNotNull(emplServImpl.getEmployeeById(33527));
	}
	
	@Test
	public void getAllEmployeesTest() {
		
		when(empDao.getAllEmployees()).thenReturn(list);
		assertEquals(list, emplServImpl.getAllEmployees());
	}
}
*/