package com.shubham.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entities.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Employee findByName(String name);
	
	Employee findByEmailAndName(String email, String name);
	
	Employee findByEmailOrName(String email, String name);
	
	List<Employee> findByEmailIsLike(String email);

	List<Employee> findByNameStartsWith(String name);

	List<Employee> findByCompanyId(String companyId);
}
