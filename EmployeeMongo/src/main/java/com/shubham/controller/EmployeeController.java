package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entities.Employee;
import com.shubham.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("/getByName/{name}")
	public Employee getByName(@PathVariable String name) {
		return employeeService.getByName(name);
	}

	@GetMapping("/getByEmailAndName")
	public Employee getByEmailAndName(@RequestParam String email, @RequestParam String name) {
		return employeeService.getByEmailAndName(email, name);
	}
	
	@GetMapping("/getByEmailOrName")
	public Employee getByEmailOrName(@RequestParam String email, @RequestParam String name) {
		return employeeService.getByEmailOrName(email, name);
	}
	
	@GetMapping("/getByEmail")
	public List<Employee> getByEmail(@RequestParam String email) {
		return employeeService.getByEmail(email);
	}
	
	@GetMapping("/getByNameLike")
	public List<Employee> getByNameLike(@RequestParam String name) {
		return employeeService.getByNameLike(name);
	}
	
	@GetMapping("/getByCompanyId")
	public List<Employee> getByCompanyId(@RequestParam String companyId) {
		return employeeService.getByCompanyId(companyId);
	}
	
	@GetMapping("/getListOfPage")
	public List<Employee> getByPage(@RequestParam int pageNo, @RequestParam int pageSize){
		return employeeService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/getListBySort")
	public List<Employee> getBySort(){
		return employeeService.allWithSorting();
	}
	
}
