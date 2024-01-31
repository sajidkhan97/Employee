package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Department;
import com.example.employee.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService deptService;
	
	
	@PostMapping("/saveDept")
	public String saveDepartment(@RequestBody Department dept) {
		deptService.saveDept(dept);
		return "Department saved!!";
		
		
	}

}
