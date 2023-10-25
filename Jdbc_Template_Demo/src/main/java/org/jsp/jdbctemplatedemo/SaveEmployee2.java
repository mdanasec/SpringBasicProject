package org.jsp.jdbctemplatedemo;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveEmployee2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the employee id , name, desg, salary to save");

		int id = s.nextInt();
		String name = s.next();
		String desg = s.next();
		double salary = s.nextDouble();

		String qry = "insert into employee values(?,?,?,?)";
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		int r = template.update(qry, id, name, desg, salary);
		System.out.println(r + " rows inseted ");

	}
}
