package org.jsp.hbmtempletdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("hbm-template.xml");
		System.out.println(context.getBean("hibernateTemplate"));
	}

}
