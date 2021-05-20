package com.mindtree.employee.model;

public class EmployeeResponse extends Response{
	
	private Employee employee;
	
	public EmployeeResponse() {

	}
	public EmployeeResponse(int status_code, String message,Employee employee) {
		super(status_code, message);
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}