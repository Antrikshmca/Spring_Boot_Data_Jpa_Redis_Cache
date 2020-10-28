package com.antriksh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antriksh.model.Employee;
import com.antriksh.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public Employee saveEmployee(
			@RequestBody Employee employee )
	{
		return service.saveEmployee(employee);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return  ResponseEntity.ok(service.getAllEmployee());
	}
	
	@GetMapping("/one/{empId}")
	public Employee getOneEmployee( @PathVariable Integer empId) {
		return service.getOneemployee(empId);
	}
	@GetMapping("/modify/{empId}")
	public Employee updateemEmployee( @PathVariable Integer empId,
			@RequestBody Employee employee)
	
	{
		Employee emp = service.updateEmployee(empId, employee);
		return emp;
	}
	@GetMapping("/remove/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		service.deleteEmployee(empId);
		return "employee deleted "+empId;
	}
}
