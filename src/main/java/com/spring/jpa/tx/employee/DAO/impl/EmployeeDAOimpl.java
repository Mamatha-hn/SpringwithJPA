package com.spring.jpa.tx.employee.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.model.Employee;
import com.spring.jpa.tx.employee.DAO.EmployeeDAO;


@Repository
public class EmployeeDAOimpl implements EmployeeDAO{
	public static final String SELECT_QUERY = "select p from Employee p";
	public EmployeeDAOimpl(){
		System.out.println("inside emp dao impl const");
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertEmp(Employee emp) {
		entityManager.persist(emp);
		
	}

	@Transactional
	public void deleteEmp(Employee emp) {
		System.out.println("execute query");
		Query query = entityManager.createQuery("DELETE FROM Employee e where e.name =:empname");
		System.out.println("execute query 2");
		query.setParameter("empname", emp.getName());
		
		int delete = query.executeUpdate();
		
		entityManager.flush();
		
		
		
	}

	@Transactional
	public void updateEmp(Employee emp) {
		String UPDATE_QUERY = "UPDATE Employee e SET e.salary= :Usalary where e.name= :Ename";
		
		Query query = entityManager.createQuery(UPDATE_QUERY);
		query.setParameter("Usalary", emp.getSalary());
		query.setParameter("Ename", emp.getName());
		
		System.out.println("Query is " +UPDATE_QUERY);
		
		query.executeUpdate();
		entityManager.flush();
		
	}

	@Transactional
	public List<Employee> findAllEmps() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Employee> emp = (List<Employee>) query.getResultList();
		return emp;
	}


}
