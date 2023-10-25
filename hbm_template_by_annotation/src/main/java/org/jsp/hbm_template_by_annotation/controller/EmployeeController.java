package org.jsp.hbm_template_by_annotation.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hbm_template_by_annotation.EmployeConfig;
import org.jsp.hbm_template_by_annotation.dao.EmployeeDao;
import org.jsp.hbm_template_by_annotation.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {

	static Scanner s = new Scanner(System.in);
	static EmployeeDao eDao;
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeConfig.class);
		eDao = context.getBean(EmployeeDao.class);
	}

	public static void main(String[] args) {

		while (true) {
			displayMenu();
			switch (s.nextInt()) {
			case 1:
				saveEmps();
				break;

			case 2:
				updateEmps();
				break;
				
			case 3:
				findEmpsById();
				break;
				
			case 4:
				deleteEmpsById();
				break;
			case 5:
				findAllEmps();
				break;

			default:
				break;
			}
		}

	}

	public static void displayMenu() {
		System.out.println("1. save Employee");
		System.out.println("2. update Employee ");
		System.out.println("3. find Employee  by id");
		System.out.println("4. delete Employee  by id");
		System.out.println("5. find all Employee ");
		System.out.println("enter your choice");
	}

	public static void saveEmps() {
		Employee e = new Employee();
		System.out.println("name :");
		e.seteName(s.next());
		System.out.println("phone :");
		e.setPhone(s.nextLong());
		System.out.println("email :");
		e.setEmail(s.next());
		System.out.println("Desiganation :");
		e.setDesignation(s.next());
		System.out.println("salary :");
		e.setSalary(s.nextDouble());
		System.out.println("password :");
		e.setPasswornd(s.next());

		e = eDao.saveEmps(e);
	}

	public static void updateEmps() {
		System.out.println("enter id to update employee ");
		int id = s.nextInt();

		Employee e = eDao.findEmpsById(id);
		if (e != null) {
			System.out.println("name :");
			e.seteName(s.next());
			System.out.println("phone :");
			e.setPhone(s.nextLong());
			System.out.println("email :");
			e.setEmail(s.next());
			System.out.println("Desiganation :");
			e.setDesignation(s.next());
			System.out.println("salary :");
			e.setSalary(s.nextDouble());
			System.out.println("password :");
			e.setPasswornd(s.next());

			e = eDao.saveEmps(e);
		} else
			System.err.println("invalid id !!");
	}

	public static void findEmpsById() {
		System.out.println("enter id to update employee ");
		int id = s.nextInt();

		Employee e = eDao.findEmpsById(id);
		if (e != null) {
			System.out.println("name :" + e.geteName());
			System.out.println("name :" + e.getPhone());
			System.out.println("name :" + e.getEmail());
			System.out.println("name :" + e.getDesignation());
			System.out.println("name :" + e.getSalary());
		} else
			System.err.println("invalid id !!");
	}

	public static boolean deleteEmpsById() {
		System.out.println("enter id to update employee ");
		int id = s.nextInt();
		return eDao.deleteById(id);
	}

	public static void findAllEmps() {
		List<Employee> e = eDao.findAllEmps();
		for (Employee emps : e) {
			System.out.println("Employee Name: " + emps.geteName());
			System.out.println("name :" + emps.getPhone());
			System.out.println("name :" + emps.getEmail());
			System.out.println("name :" + emps.getDesignation());
			System.out.println("name :" + emps.getSalary());
		}
	}

}
