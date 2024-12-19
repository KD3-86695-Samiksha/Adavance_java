package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Service.EmployeeService;
import com.cdac.dto.ApiResponse;
import com.cdac.pojos.Employee;

@RestController
	@RequestMapping("/employees")
	@CrossOrigin(origins = "http://localhost:3000")
	
	public class EmployeeController {
		
		@Autowired
		private EmployeeService employeeservice;
		
		
		public EmployeeController() {
			System.out.println("in ctor"+getClass());
			}
		

		/*
		 * URL - http://host:port/employees Method - GET payload - none ! resp - JSON
		 * representation of List<Employee> Desc - get all employee
		 */
		@GetMapping("/")
		public ResponseEntity<?> getEmployee() {
			System.out.println("get all");
			List<Employee> emp= employeeservice.getAllEmployee();
		if (emp.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			return ResponseEntity.ok(emp);
		}
		

		/*
		 * URL - http://host:port/employees Method - POST payload - JSON representation
		 * of category -> Java - @RequestBody resp - String Desc - add new employees
		 */
		@PostMapping
		
		public ResponseEntity<?> addNewEmployee(@RequestBody Employee  employee){
			System.out.println("in add employee"+employee);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(employeeservice.addNewEmployee(employee));
		}
		
		
		/*
		 * URL -  http://host:port/employees?empId=....
		 * Method -  DELETE
		 * payload -  request param
		 * resp success - DTO
		* resp error - DTO
		 * Desc - Hard delete employees details
	 */
		
		@DeleteMapping
		public ResponseEntity<?> deleteCategoryDetails(@RequestParam() Long employeeId)
		{
			System.out.println("in delete "+employeeId);
			try {
				//invoke service layer method
				return ResponseEntity.ok(
				employeeservice.deleteEmployee(employeeId));
			} catch (RuntimeException e) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponse(e.getMessage()));
			}
		}
			
			

			/*
			 * URL - http://host:port/employees/{employeesId} Method - PUT payload - updated
			 * category contents resp - success - api resp dto resp - error -api resp dto
			 * Desc - Update employees details
			 */
			
			@PutMapping("/{employeesId}")
			public ResponseEntity<?> updateemployeesDetails(@PathVariable Long employeeId, @RequestBody Employee employee) {
				System.out.println("in update Employee " + employeeId + " " + employee);

				// invoke service layer method
				//TO DO - change Sts code - in case of error !!!
				return ResponseEntity.ok(
						employeeservice.updateEmployee(employeeId, employee));

			}
		
	

		
		
		
}
