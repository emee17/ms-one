package com.coderland.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderland.department.model.Department;
import com.coderland.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository  departmentRepository;

	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Optional<Department> findById(Long id) {
		return departmentRepository.findById(id);
	}

	public List<Department> findByCode(String code) {
		return departmentRepository.findByDepartmentCode(code);
	}
}
