package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.req.EmployeeReq;
import com.employee.management.service.EmployeeService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
 
	@Autowired
	public EmployeeService service;
	
	@PostMapping
	private ResponseEntity<Employee>create(@RequestBody EmployeeReq req){
		Employee response=service.createEmployee(req);
		return new ResponseEntity<Employee>(response,HttpStatus.CREATED);
		
	}
	@GetMapping("/getAll")
	private ResponseEntity<List<Employee>> getAll(){
		List <Employee> response=service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") Long id){
		Employee response=service.getEmployeeById(id);
		return new ResponseEntity<Employee>(response,HttpStatus.OK);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id , @RequestBody EmployeeReq req){
		Employee response=service.updateEmployee(id,req);
		
		
		return new ResponseEntity<Employee>(response,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
	    service.deleteEmployee(id);
	    return ResponseEntity.noContent().build();
	}
}
