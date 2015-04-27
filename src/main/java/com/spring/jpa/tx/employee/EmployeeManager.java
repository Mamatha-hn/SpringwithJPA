package com.spring.jpa.tx.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.jpa.model.Employee;

@Service
public interface EmployeeManager {

	void insertEmp(Employee emp);
	void deleteEmp(Employee emp);
	void updateEmp(Employee emp);
	List<Employee> findAllEmp();
}