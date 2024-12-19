package com.cdac.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity//mandatory cls level annoatation
@Table(name="employees")
//to customize table name

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class Employee extends BaseEntity {

	
	@Column(length=20, name="firstname" )
	private String firstName;
	
	
	@Column(length=20, name="lastname" )
	private String lastName;
	
	@Column(length=25, name="Email" ,unique = true )
	private  String Email;
	
	@Column(length=25,name="Location")
	private String location;
	
	@Column(length=25,name="Department")
	private String department;
	private LocalDate JoinDate ;
	@Column(name = "salary")
	private  double salary;
	public Employee(String firstName, String lastName, String email, String location, String department,
			LocalDate joinDate, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.location = location;
		this.department = department;
		JoinDate = joinDate;
		this.salary = salary;
	}
	
	
	
	
	
	
	
}
