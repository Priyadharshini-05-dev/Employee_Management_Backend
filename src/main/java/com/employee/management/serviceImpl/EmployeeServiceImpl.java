package com.employee.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.req.EmployeeReq;
import com.employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(EmployeeReq req) {

        Employee employee = new Employee();

        employee.setName(req.getName());
        employee.setPhone(req.getPhone());
        employee.setEmail(req.getEmail());
        employee.setAddress(req.getAddress());
        employee.setDepartment(req.getDepartment());
        employee.setDesignation(req.getDesignation());
        employee.setSalary(req.getSalary());
        employee.setJoiningDate(req.getJoiningDate());

        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

	@Override
	public Employee getEmployeeById(Long id) {
		
		return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found !"));
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeReq req) {
		Employee employee=repository.findById(id).orElseThrow(()->new RuntimeException("Employee not Found!"));
		
		 employee.setName(req.getName());
	        employee.setPhone(req.getPhone());
	        employee.setEmail(req.getEmail());
	        employee.setAddress(req.getAddress());
	        employee.setDepartment(req.getDepartment());
	        employee.setDesignation(req.getDesignation());
	        employee.setSalary(req.getSalary());
	        employee.setJoiningDate(req.getJoiningDate());
		return repository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee=repository.findById(id).orElseThrow(()->new RuntimeException("Employee not Found!"));
		repository.delete(employee);
		
	}


	
}