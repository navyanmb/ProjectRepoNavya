package com.mindtree.employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.employee.model.Employee;

@Service
public interface EmployeeDao {

	public Employee saveEmployee(Employee employee);
	
	public Optional<Employee> getEmployeeById(int id);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployeeById(int id);
}
