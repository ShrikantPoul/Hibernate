package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		Student student = new Student();
		student.setSid(11);
		student.setSname("Shrikant");

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Success");
	}

}
