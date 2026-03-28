package com.shubham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shubham.entities.Employee;
import com.shubham.repositories.CompanyRepository;
import com.shubham.repositories.EmployeeRepository;
import com.shubham.repositories.ProjectRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public Employee addEmployee(Employee employee) {
		if (employee.getCompany() != null) {
			companyRepository.save(employee.getCompany());
		}

		if (employee.getProjects() != null && employee.getProjects().size() > 0) {
			projectRepository.saveAll(employee.getProjects());
		}
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(String id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employe not found"));
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		if (employee.getCompany() != null) {
			companyRepository.save(employee.getCompany());
		}

		if (employee.getProjects() != null && employee.getProjects().size() > 0) {
			projectRepository.saveAll(employee.getProjects());
		}
		return employeeRepository.save(employee);
	}

	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully !!";
	}

	public Employee getByName(String name) {
		return employeeRepository.findByName(name);
	}

	public Employee getByEmailAndName(String email, String name) {
		return employeeRepository.findByEmailAndName(email, name);
	}

	public Employee getByEmailOrName(String email, String name) {
		return employeeRepository.findByEmailOrName(email, name);
	}

	public List<Employee> getByEmail(String email) {
		return employeeRepository.findByEmailIsLike(email);
	}

	public List<Employee> getByNameLike(String name) {
		return employeeRepository.findByNameStartsWith(name);
	}

	public List<Employee> getByCompanyId(String companyId) {
		return employeeRepository.findByCompanyId(companyId);
	}
	
	public List<Employee> getAllWithPagination (int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return employeeRepository.findAll(pageable).getContent();
	}
	
	public List<Employee> allWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
		
		return employeeRepository.findAll(sort);		
	}

}
