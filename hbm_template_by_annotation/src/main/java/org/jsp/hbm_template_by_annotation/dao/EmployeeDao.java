package org.jsp.hbm_template_by_annotation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.hbm_template_by_annotation.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	public EntityManager manager;
	
	public Employee saveEmps(Employee emps) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(emps);
		transaction.begin();
		transaction.commit();
		return emps;	
	}
	
	public Employee updateEmps(Employee emps) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(emps);
		transaction.commit();
		transaction.begin();
		return emps;	
	}
	
	public Employee findEmpsById(int id) {
		return manager.find(Employee.class, id);	
	}
	
	public boolean deleteById(int id) {
		Employee e = findEmpsById(id);
		if(e!=null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(e);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;	
	}
	
	public List <Employee> findAllEmps() {
		
	       EntityTransaction transaction = manager.getTransaction();

	        String jpql = "SELECT e FROM Employee e";
	        Query query = manager.createQuery(jpql);

	        List<Employee> employees = query.getResultList();

	        transaction.begin();
	        transaction.commit();

	        return employees;
		
	}
	
}
