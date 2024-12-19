package com.cdac.Service;

import java.util.List;

import com.cdac.dto.ApiResponse;
import com.cdac.pojos.Employee;

public interface EmployeeService {
	
	
	String addNewEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	ApiResponse deleteEmployee(Long employeeId);

	ApiResponse updateEmployee(Long employeeId, Employee employee);
}
