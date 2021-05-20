package com.mindtree.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employee.model.Employee;
import com.mindtree.employee.model.EmployeeListResponse;
import com.mindtree.employee.model.EmployeeResponse;
import com.mindtree.employee.model.Response;
import com.mindtree.employee.service.EmployeeService;

@RestController
@RequestMapping("employees/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(value = "save/employee", method = RequestMethod.POST)
	public EmployeeResponse saveEmployee(@RequestBody Employee employee) {
		/*if (employeeService.getEmployeeById(employee.getId()).isPresent()) {
			throw new EmployeeAlreadyExistsException(employee.getId());
		}*/
		EmployeeResponse employeeResponse=employeeService.saveEmployee(employee);
		/*Response response = new Response();
		response.setMessage("Employee has been saved successfully");*/
		/*return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.CREATED);*/
		return employeeResponse;
	}

	@RequestMapping(value = "get/employee/{id}", method = RequestMethod.GET)
	public EmployeeResponse getEmployeeById(@PathVariable int id) {
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		/*if (!employee.isPresent()) {
			throw new EmployeeNotFoundException(id);
		}*/
		/*return new ResponseEntity<>(employeeResponse, HttpStatus.OK);*/
		return employeeResponse;
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public EmployeeListResponse getAllEmployees() {
		EmployeeListResponse empListResponse=employeeService.getAllEmployees();
		/*return new ResponseEntity<>(empListResponse, HttpStatus.OK);*/
		return empListResponse;
	}

	@RequestMapping(value = "delete/employee/{id}", method = RequestMethod.DELETE)
	public Response deleteEmployee(@PathVariable int id) {
		Response response=employeeService.deleteEmployeeById(id);
		return response;
	}
}
