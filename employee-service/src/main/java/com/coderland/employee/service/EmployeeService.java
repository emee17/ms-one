package com.coderland.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderland.employee.model.Department;
import com.coderland.employee.model.Employee;
import com.coderland.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createDepartment(Employee emoployee) {
		return employeeRepository.save(emoployee);
	}

	public Optional<Employee> findById(Long id) {
		log.info("Inside Service findById");
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		optionalEmployee.ifPresent((employee) ->{
				Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/id/"+employee.getDepartmentId(), Department.class);
				log.info("department model {} ",department);
				employee.setDepartment(department);
			}
		);
		return optionalEmployee;
	}

	public List<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
