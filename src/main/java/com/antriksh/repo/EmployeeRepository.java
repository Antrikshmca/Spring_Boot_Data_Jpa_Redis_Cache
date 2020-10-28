package com.antriksh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antriksh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
