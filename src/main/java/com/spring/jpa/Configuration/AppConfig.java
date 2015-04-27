package com.spring.jpa.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.jpa.model.Employee;
import com.spring.jpa.tx.employee.DAO.impl.EmployeeDAOimpl;
import com.spring.jpa.tx.employee.impl.EmployeeManagerImpl;

@ComponentScan(basePackages = "com.spring.jpa")
@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		//this can even be done in persistence.xml
		//emfb.setPersistenceUnitName("employeePersistenceUnit");
		emfb.setDataSource(dataSource());
		emfb.setJpaVendorAdapter(jpaVendorAdapter());
		emfb.setPackagesToScan("com.spring.jpa.model");
		//JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		//emfb.setJpaVendorAdapter(vendorAdapter);
		//emfb.setJpaDialect(jpaDialect());
		return emfb;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/testHibernate");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}

	@Bean
	public HibernateJpaDialect jpaDialect() {
		HibernateJpaDialect dialect = new HibernateJpaDialect();
		return dialect;
	}
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().nativeEntityManagerFactory);
		transactionManager.setDataSource(dataSource());
		transactionManager.setJpaDialect(jpaDialect());
		return transactionManager;
		
	}
	

	/*@Bean
	public EmployeeManagerImpl employeeManagerImpl(){
		EmployeeManagerImpl emp= new EmployeeManagerImpl();
		System.out.println("inside employeemanager");
		return new EmployeeManagerImpl();
	}
	@Bean
	public EmployeeDAOimpl employeeDAOimpl(){
		System.out.println("emp DAO");
		return new EmployeeDAOimpl();
	}
	@Bean
	public Employee employee(){
		return new Employee();
	}*/

}