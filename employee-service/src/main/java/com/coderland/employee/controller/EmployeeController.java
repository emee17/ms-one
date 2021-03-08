package com.coderland.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderland.employee.model.Employee;
import com.coderland.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {


	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/greetings")
	public String greetings() {
		log.info("Inside greetings");
		return "Alhamdulillah Its working";
	}
	
	@PostMapping("/create")
	public Employee createDepartment(@RequestBody Employee emoployee)
	{
		log.info("Inside create");
		return employeeService.createDepartment(emoployee);
	}
	@GetMapping("/id/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		log.info("Inside findById");
		return employeeService.findById(id).isPresent() ? employeeService.findById(id).get() : null;
	}
	@GetMapping("/email/{email}")
	public List<Employee> findByEmail(@PathVariable("email") String email) {
		log.info("Inside findByCode");
		return employeeService.findByEmail(email);
	}
	@GetMapping("/")
	public List<Employee> findAll() {
		log.info("Inside findAll");
		return employeeService.findAll();
	}

}
