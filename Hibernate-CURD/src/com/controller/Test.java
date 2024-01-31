package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.College;
import com.model.Student;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student student = new Student(7, "Shrikant");

		College college = new College();
		college.setCid(4);
		college.setCname("PCCOE");

		int sid = (int) session.save(student);
		int cid = (int) session.save(college);
		session.beginTransaction().commit();

		System.out.println("Student id:" + sid + "\n College id:" + cid);

	}

}
