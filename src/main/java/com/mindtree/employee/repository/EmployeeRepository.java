package com.mindtree.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}
