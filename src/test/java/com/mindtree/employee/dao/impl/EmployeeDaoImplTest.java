/*package com.mindtree.employee.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.employee.dao.impl.EmployeeDaoImpl;
import com.mindtree.employee.model.Employee;
import com.mindtree.employee.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoImplTest {

	@Mock
	EmployeeRepository emplRep;
	
	@InjectMocks
	@Spy
	EmployeeDaoImpl emplDaoImpl;
	
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
	
	@Test
	public void saveEmployeeTest() {
		
		when(emplRep.save(Matchers.any(Employee.class))).thenReturn(employee);
		Employee empl = emplDaoImpl.saveEmployee(employee);
		assertNotNull(empl);
	}
	
	@Test
	public void getEmployeeByIdTest() {
				
		when(emplRep.findById(33527)).thenReturn(Optional.of(employee));
		assertNotNull(emplDaoImpl.getEmployeeById(33527));
	}
	
	@Test
	public void getAllEmployeesTest() {
		
		when(emplRep.findAll()).thenReturn(list);
		assertEquals(list, emplDaoImpl.getAllEmployees());
	}
	
}
*/