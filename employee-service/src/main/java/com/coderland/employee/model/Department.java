package com.coderland.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

	private Long id;
	private String departmentName;
	private String address;
	private String departmentCode;
	
}
