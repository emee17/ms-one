package com.coderland.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee", uniqueConstraints={
        @UniqueConstraint( name = "employee_unique",  columnNames ={"email"})
     })
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", initialValue = 1, allocationSize = 10)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(name="email", nullable = false, unique = true)
	private String email;
	private Long departmentId;
	@Transient
	private Department department;
	
}
