package com.cdac.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.EmployeeDao;
import com.cdac.dto.ApiResponse;
import com.cdac.pojos.Employee;




@Service 
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   
	
	
	@Autowired
	
	private EmployeeDao empDao;
	@Override
	public String addNewEmployee(Employee employee) {
		Employee persistentemp = empDao.save(employee);
		return "Added new employee with ID="+persistentemp.getClass();
	}
	@Override
	public List<Employee> getAllEmployee() {
		
		return empDao.findAll();
	}
	@Override
	public ApiResponse deleteEmployee(Long employeeId) {
		if(empDao.existsById(employeeId)) {
			empDao.deleteById(employeeId);
		return new ApiResponse("Deleted Category Details");
	}
	throw new ResourceNotFoundException("Invalid Category ID !!!!!!!!");

	}
	@Override
	public ApiResponse updateEmployee(Long employeeId, Employee employee) {
		if(empDao.existsById(employeeId));
		//employee id valid
	//	empDao.setId(id);
		empDao.save(employee);// detached --> persistent
		return new ApiResponse("Invalid employee ID !!!!");
	}// DML - update
		
	
	

}
