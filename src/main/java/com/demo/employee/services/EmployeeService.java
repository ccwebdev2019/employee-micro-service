package com.demo.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.models.Employee;
import com.demo.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> findEmployeeWithId(Long id) {
		Optional<Employee> foundEmployee = employeeRepository.findById(id);
		return foundEmployee;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public String addEmployee(Employee employee) {
		Employee saved = employeeRepository.save(employee);
		String savedEmployee = "employee name " + saved.getName() + " saved";
		return savedEmployee;
	}
	
	public Employee updateEmployee(Employee employee, Long id) {
		employee.setId(id);
		Employee employeeUpdated = employeeRepository.save(employee);
		return employeeUpdated;
	}

}
