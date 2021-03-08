package com.coderland.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

	@GetMapping("/employeeservicefallback")
	public String employeeServiceFllbackMethod() {
		return "employee service is taking longer than expected please try again later";
	}
	
	@GetMapping("/departmenteservicefallback")
	public String departmentServiceFllbackMethod() {
		return "department service is taking longer than expected please try again later";
	}
}
