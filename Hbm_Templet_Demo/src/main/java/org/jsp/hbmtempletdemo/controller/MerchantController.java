package org.jsp.hbmtempletdemo.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hbmtempletdemo.dao.MerchantDao;
import org.jsp.hbmtempletdemo.dto.Merchants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MerchantController {
	static Scanner s = new Scanner(System.in);
	private static MerchantDao mDao;

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("hbm-template.xml");
		mDao = context.getBean(MerchantDao.class);

	}

	public static void main(String[] args) {

		while (true) {
			displayMenu();
			switch (s.nextInt()) {
			case 1:
				saveMerchant();
				break;

			case 2:
				updateMerchant();
				break;

			case 3:
				findMerchantById();
				break;

			case 4:
				deleteMerchantById();
				break;

			case 5:
				findAll();
				break;

			default:
				System.out.println("invalid choice please enter again");
			}
		}
	}

	public static void displayMenu() {
		System.out.println("1. save merchants");
		System.out.println("2. update merchants");
		System.out.println("3. find merchants by id");
		System.out.println("4. delete merchants by id");
		System.out.println("5. find all merchants");
		System.out.println("enter your choice");
	}

	public static void saveMerchant() {
		Merchants m = new Merchants();
		System.out.println("name :");
		m.setName(s.next());
		System.out.println("phone :");
		m.setPhone(s.nextLong());
		System.out.println("gst :");
		m.setGst(s.nextDouble());
		System.out.println("email :");
		m.setEmail(s.next());
		System.out.println("password :");
		m.setPassword(s.next());

		m = mDao.savMerchants(m);
		System.out.println("merchant save successfully by id " + m.getId());
	}

	public static void updateMerchant() {
		System.out.println("enter id to update ");
		int id = s.nextInt();
		Merchants m = mDao.findById(id);
		if (m != null) {
			System.out.println("update name :");
			m.setName(s.next());
			System.out.println("update phone :");
			m.setPhone(s.nextLong());
			System.out.println("update gst :");
			m.setGst(s.nextDouble());
			System.out.println("update email :");
			m.setEmail(s.next());
			System.out.println("update password :");
			m.setPassword(s.next());

			m = mDao.updateMerchants(m);
		} else
			System.out.println("Merchant with ID " + id + " not found.");
	}

	public static void findMerchantById() {
		System.out.println("enter id to display your data ");
		int id = s.nextInt();
		Merchants m = mDao.findById(id);
		if (m != null) {
			System.out.println("name :" + m.getName());
			System.out.println("phone : " + m.getPhone());
			System.out.println("email : " + m.getEmail());
			System.out.println("gst : " + m.getEmail());
			System.out.println("-----------------------");
		} else
			System.out.println("you have entered invalid id " + id);
	}

	public static boolean deleteMerchantById() {
		System.out.println("enter your id to delete your details ");
		int id = s.nextInt();

		return mDao.deleteMerchants(id);
	}

	public static void findAll() {
		List<Merchants> m = mDao.findAll();
		if (m != null) {
			for (Merchants merchant : m) {
				System.out.println("Merchant ID: " + merchant.getId());
				System.out.println("Merchant Name: " + merchant.getName());
				System.out.println("phone : " + merchant.getPhone());
				System.out.println("email : " + merchant.getEmail());
				System.out.println("gst : " + merchant.getEmail());
				System.out.println("-----------------------");
			}
		}
	}

}
