package com.spring.jpa.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jpa.Configuration.AppConfig;
import com.spring.jpa.model.Employee;
import com.spring.jpa.tx.employee.EmployeeManager;
import com.spring.jpa.tx.employee.impl.EmployeeManagerImpl;


public class Main {
	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee e=new Employee();
		e.setName("abc");
		e.setSalary("200");
		System.out.println("we got!!!!!!!");
		EmployeeManager empmanager=(EmployeeManager) appContext.getBean(EmployeeManager.class);
		//empmanager.insertEmp(e);
		//empmanager.deleteEmp(e);
		empmanager.updateEmp(e);
	}

}
