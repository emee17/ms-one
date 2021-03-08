package com.coderland.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderland.department.model.Department;
import com.coderland.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/department")
@Slf4j
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/greetings")
	public String greetings() {
		log.info("Inside greetings");
		return "Alhamdulillah Its working";
	}
	
	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department department) {
		log.info("Inside create");
		return departmentService.createDepartment(department);
	}
	@GetMapping("/id/{id}")
	public Department findById(@PathVariable("id") Long id) {
		log.info("Inside findById");
		return departmentService.findById(id).isPresent() ? departmentService.findById(id).get() : null;
	}
	@GetMapping("/code/{code}")
	public List<Department> findByCode(@PathVariable("code") String code) {
		log.info("Inside findByCode");
		return departmentService.findByCode(code);
	}
	@GetMapping("/")
	public List<Department> findAll() {
		log.info("Inside findAll");
		return departmentService.findAll();
	}
}
