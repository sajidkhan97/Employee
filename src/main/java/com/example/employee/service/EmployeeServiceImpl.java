package com.example.employee.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.exceptions.CustomException;
import com.example.employee.payload.EmployeeDto;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;

	

	@Override
	public Employee getEmployeeId(long id) {
		Optional<Employee> findById = empRepo.findById(id);
		Employee employee = findById.get();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAll = empRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee update(long id, Employee update) {
		Optional<Employee> findById = empRepo.findById(id);
		Employee employee = findById.get();
		if( employee != null) {
			employee.setName(update.getName());
			employee.setCity(update.getCity());
			employee.setMobile(update.getMobile());
			empRepo.save(employee);
			
			
		}
		else {
			System.out.println("NO employee found with that id ");
		}
		return employee;
	}

	@Override
	public void save(EmployeeDto dto, long department_id) {
		
		Employee emp = new Employee();
		emp.setName(dto.getName());
		emp.setCity(dto.getCity());
		emp.setMobile(dto.getMobile());
		Department dept = deptRepo.findById(department_id).orElseThrow(() -> new CustomException("department does not exists with id "+dto.getDepartment_id()));
		emp.setDepartment(dept);
		empRepo.save(emp);
		
		
	}

	@Override
	public String getDepartmentNameByEmployeeId(long id) {
		Employee employee = empRepo.findById(id)
                .orElseThrow(() -> new CustomException("Employee not found with ID: " + id));
		Department department = employee.getDepartment();
		return (department != null) ? department.getDeptName() : null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return empRepo.count();
	}


	

}
