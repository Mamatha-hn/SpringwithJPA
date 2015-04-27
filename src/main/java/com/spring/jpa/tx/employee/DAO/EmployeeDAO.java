package com.spring.jpa.tx.employee.DAO;


import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.jpa.model.Employee;

@Service
public interface EmployeeDAO {

	void insertEmp(Employee emp);
	void deleteEmp(Employee emp);
	void updateEmp(Employee emp);

	List<Employee> findAllEmps();
}