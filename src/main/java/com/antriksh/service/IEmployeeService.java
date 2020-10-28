package com.antriksh.service;

import java.util.List;

import com.antriksh.model.Employee;

public interface IEmployeeService {
	
	public Employee saveEmployee(Employee e);
	public Employee updateEmployee(Integer empId ,Employee e);
	public void deleteEmployee(Integer empId);
	
	public Employee getOneemployee(Integer empId);
	public List<Employee> getAllEmployee();

}
