package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void saveDept(Department dept) {
		deptRepo.save(dept);
		
	}

}
