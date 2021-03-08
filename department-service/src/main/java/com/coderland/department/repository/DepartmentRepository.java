package com.coderland.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderland.department.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	List<Department> findByDepartmentCode(String departmentCode);
	
	
}
