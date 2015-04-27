package com.spring.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	public Employee(){
		System.out.println("inside emp constru");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="SALARY", nullable = false)
	private String salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
	

}
