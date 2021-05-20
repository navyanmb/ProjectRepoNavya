package com.mindtree.employee.exception;

@SuppressWarnings("serial")
public class EmployeeAlreadyExistsException extends Exception{
	
	public EmployeeAlreadyExistsException(String msg) {
		super(msg);
	}

}
