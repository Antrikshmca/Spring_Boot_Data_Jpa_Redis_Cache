package com.antriksh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.antriksh.ResourceNotFoundException;
import com.antriksh.model.Employee;
import com.antriksh.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	@CachePut(value = "employees",key="#empId")
	public Employee updateEmployee(Integer empId, Employee e) {
		Employee emp=repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Emolyee Not Exit"));
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		return repo.save(emp);
	}

	@Override
	@CacheEvict(value = "employees",allEntries = true)
	public void deleteEmployee(Integer empId) {
		Employee emp=repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Emolyee Not Exit"));
		 repo.delete(emp);
	}

	@Override
	@Cacheable(value = "employees",key="#empId")
	public Employee getOneemployee(Integer empId) {
		Employee emp=repo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Emolyee Not Exit"));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}
