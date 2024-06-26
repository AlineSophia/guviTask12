package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
