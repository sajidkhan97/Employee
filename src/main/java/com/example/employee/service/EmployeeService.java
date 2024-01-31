package com.example.employee.service;

import java.util.List;

import com.example.employee.entity.Employee;
import com.example.employee.payload.EmployeeDto;

public interface EmployeeService {

	

	Employee getEmployeeId(long id);

	List<Employee> getAllEmployees();

	void deleteById(long id);

	Employee update(long id, Employee update);

	void save(EmployeeDto dto, long department_id);

	String getDepartmentNameByEmployeeId(long id);

	Long count();

	

	

}
