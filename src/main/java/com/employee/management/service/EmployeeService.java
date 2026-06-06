package com.employee.management.service;

import java.util.List;

import com.employee.management.entity.Employee;
import com.employee.management.req.EmployeeReq;


public interface EmployeeService {

	Employee createEmployee(EmployeeReq req);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, EmployeeReq req);

	void deleteEmployee(Long id);

}
