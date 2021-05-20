package com.mindtree.employee.service;

import org.springframework.stereotype.Service;

import com.mindtree.employee.model.Employee;
import com.mindtree.employee.model.EmployeeListResponse;
import com.mindtree.employee.model.EmployeeResponse;
import com.mindtree.employee.model.Response;

@Service
public interface EmployeeService {

	public EmployeeResponse saveEmployee(Employee employee);

	public EmployeeResponse getEmployeeById(int id);

	public EmployeeListResponse getAllEmployees();

	public Response deleteEmployeeById(int id);

}
