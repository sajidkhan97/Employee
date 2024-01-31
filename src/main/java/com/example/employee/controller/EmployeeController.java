package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.payload.EmployeeDto;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/saveEmployee/{department_id}")
	public String saveEmployee(@RequestBody EmployeeDto dto,@PathVariable long department_id) {
		empService.save(dto,department_id);
		return "Student saved Succesfully!!";
				
	}
	
	/*
	 * @GetMapping("/{id}") public Employee getEmployeeWithId(@PathVariable long id)
	 * { Employee employee=empService.getEmployeeId(id); return employee; }
	 * 
	 * @GetMapping("/allEmp") public List<Employee> getAllEmployee(){ List<Employee>
	 * employee =empService.getAllEmployees(); return employee;
	 * 
	 * }
	 * 
	 * @DeleteMapping("/{id}") public String deleteById(@PathVariable long id) {
	 * empService.deleteById(id); return "Employee Deleted Succesfully!!"; }
	 * 
	 * @PutMapping("/{id}") public Employee updateEmployee(@PathVariable long
	 * id, @RequestBody Employee update) {
	 * 
	 * Employee emp=empService.update(id,update); return emp;
	 * 
	 * 
	 * }
	 */
	
	@GetMapping("/{id}")
    public ResponseEntity<String> getDepartmentNameByEmployeeId(@PathVariable long id) {
        String departmentName = empService.getDepartmentNameByEmployeeId(id);
        return ResponseEntity.ok(departmentName);
    }
	
	@GetMapping("/counts")
	public Long count() {
		return empService.count();
		
	}
	

}

