package com.example.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.entity.Employee;
import com.example.mongo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	public List<Employee> getemployeeList() {
		return empRepo.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
		// TODO Auto-generated method stub
		
	}

	public Optional<Employee> findEmployee(int id) {
		return empRepo.findById(id);
		
	}

}
