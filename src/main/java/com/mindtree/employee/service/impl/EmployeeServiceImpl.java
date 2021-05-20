package com.mindtree.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mindtree.employee.dao.EmployeeDao;
import com.mindtree.employee.exception.EmployeeAlreadyExistsException;
import com.mindtree.employee.exception.EmployeeNotFoundException;
import com.mindtree.employee.model.Employee;
import com.mindtree.employee.model.EmployeeListResponse;
import com.mindtree.employee.model.EmployeeResponse;
import com.mindtree.employee.model.Response;
import com.mindtree.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Value("${success_code}")
	private int success_code;
	@Value("${created}")
	private int created;
	@Value("${no_content}")
	private int no_content;
	@Value("${bad_request}")
	private int bad_request;
	@Value("${not_found}")
	private int not_found;
	@Value("${internal_server_error}")
	private int internal_server_error;
	
	/*private final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class);*/
	
	@Override
	public EmployeeResponse saveEmployee(Employee employee) {
		EmployeeResponse empResponse=new EmployeeResponse();
		try
		{
		if (employeeDao.getEmployeeById(employee.getId()).isPresent()) {
			throw new EmployeeAlreadyExistsException("Employee already exists in the database"); 
		}
		else
		{		
			Employee emp=employeeDao.saveEmployee(employee);	
			empResponse.setEmployee(emp);
			empResponse.setStatus_code(created);
			empResponse.setMessage("Employee has been saved successfully");
		}
		}
		catch (EmployeeAlreadyExistsException e) {
			empResponse.setEmployee(null);
			empResponse.setStatus_code(not_found);
			empResponse.setMessage("Employee was not saved as it was alreday existing in the database");				
	    }
		catch (Exception e) {
			empResponse.setEmployee(null);
			empResponse.setStatus_code(internal_server_error);
			empResponse.setMessage("Something went wrong while saving the player..Please refer logs");				
	    }		
		return empResponse;
	}

	@Override
	public EmployeeResponse getEmployeeById(int id) {
		EmployeeResponse empResponse=new EmployeeResponse();
		try
		{
		Optional<Employee> emp=employeeDao.getEmployeeById(id);
		try {
			if(emp.isPresent())
			{
				empResponse.setEmployee(emp.get());
				empResponse.setStatus_code(success_code);
				empResponse.setMessage("Employee details");
			}
			else
			{
				throw new EmployeeNotFoundException("Employee with"+id+"was not present in database");
			}
		  }
		catch (EmployeeNotFoundException e) {
			empResponse.setEmployee(null);
			empResponse.setStatus_code(not_found);
			empResponse.setMessage("No Employees found for the given employeeId "+id);				
	    }
		}
		catch (Exception e) {
			empResponse.setEmployee(null);
			empResponse.setStatus_code(internal_server_error);
			empResponse.setMessage("Something went wrong while getting the Employee..Please refer logs");				
	    }	
		return empResponse;
		}
@Override
	public EmployeeListResponse getAllEmployees() {
		EmployeeListResponse empListResponse=new EmployeeListResponse();
		try
		{
		List<Employee> empList=employeeDao.getAllEmployees();
		try
		{
		if(!CollectionUtils.isEmpty(empList))
		{
			empListResponse.setEmployeeList(empList);
			empListResponse.setStatus_code(success_code);
			empListResponse.setMessage("List of Employees..");
		}
		else
		{
			throw new EmployeeNotFoundException("No Employee present in database");
		}
		}
		catch (Exception e) {
			empListResponse.setEmployeeList(null);
			empListResponse.setStatus_code(not_found);
			empListResponse.setMessage("No Employees found ");				
	    }	
		}
		catch (Exception e) {
			empListResponse.setEmployeeList(null);
			empListResponse.setStatus_code(internal_server_error);
			empListResponse.setMessage("Something went wrong while getting the employees..Please refer logs");				
	    }	
		return empListResponse;
		
	}

	@Override
	public Response deleteEmployeeById(int id) {
		Response response=new Response();
		try
		{
		if (!(employeeDao.getEmployeeById(id).isPresent())) {
			throw new EmployeeNotFoundException("Employee already exists in the database");
		}
		else
		{		
			boolean status=employeeDao.deleteEmployeeById(id);
			if(status)
			{
			response.setStatus_code(no_content);
			response.setMessage("Employee has been deleted successfully");
			}	
		}
		}
		catch (EmployeeNotFoundException e) {
			response.setStatus_code(not_found);
			response.setMessage("Employee with"+id+"was not present in database");
	    }
		catch (Exception e) {
			response.setStatus_code(internal_server_error);
			response.setMessage("Something went wrong while saving the player..Please refer logs");				
	    }	
		return response;
		
	}

}
