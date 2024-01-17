package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Student student = new Student();
		student.setSid(11);
		student.setSname("Shrikant");

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Success");

	}

}
