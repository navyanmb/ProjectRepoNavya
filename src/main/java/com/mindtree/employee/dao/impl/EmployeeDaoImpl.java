package com.mindtree.employee.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.employee.dao.EmployeeDao;
import com.mindtree.employee.model.Employee;
import com.mindtree.employee.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return empRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		boolean status=false;
		empRepository.deleteById(id);
		status=true;
		return status;
	}
}
