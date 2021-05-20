package com.mindtree.employee.model;

import java.util.List;

public class EmployeeListResponse extends Response{
	
	private List<Employee> employeeList;
	
	public EmployeeListResponse() {
	}
	
	public EmployeeListResponse(int status_code, String message, List<Employee> employeeList) {
		super(status_code, message);
		this.employeeList = employeeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
    
}
