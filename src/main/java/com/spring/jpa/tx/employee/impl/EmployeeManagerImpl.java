package com.spring.jpa.tx.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.model.Employee;
import com.spring.jpa.tx.employee.EmployeeManager;
import com.spring.jpa.tx.employee.DAO.EmployeeDAO;
import com.spring.jpa.tx.employee.DAO.impl.EmployeeDAOimpl;

@Service("EmployeeManagerImpl")
public class EmployeeManagerImpl implements EmployeeManager {
	
	@Autowired EmployeeDAO employee;
	
	public EmployeeManagerImpl(){
		System.out.println("inside constructor");
	}
	
	@Transactional
	public void insertEmp(Employee emp) {
		employee.insertEmp(emp);
		
	}

	@Transactional
	public void deleteEmp(Employee emp) {
		employee.deleteEmp(emp);
		
	}

	@Transactional
	public void updateEmp(Employee emp) {
		employee.updateEmp(emp);
		
	}

	@Override
	public List<Employee> findAllEmp() {
		return employee.findAllEmps();
	}

	

}
