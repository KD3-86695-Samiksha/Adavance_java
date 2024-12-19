package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
