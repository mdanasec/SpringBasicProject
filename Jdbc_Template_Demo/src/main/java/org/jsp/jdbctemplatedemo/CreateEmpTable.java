package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateEmpTable {
	public static void main(String[] args) {

		String qry = "create table employee "
				+ "(id int not null, name varchar(45) not null, desg varchar(45) not null, salary varchar(45) not null)";

		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		template.execute(qry);
		System.out.println("employee table is created");
	}
}
