package com.controller;

import java.util.Scanner;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.College;
import com.model.Student;
import com.util.HibernateUtil;

public class MyController {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Student s = new Student();
		s.setSid(1);
		s.setSname("Shrikant");
		
		College college=new College();
		college.setCid(1);
		college.setCname("PCCOE");

		Session session = sf.openSession();
		session.save(s);
		session.beginTransaction().commit();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		int i = sc.nextInt();

		Student s1 = session.get(Student.class, i);
		System.out.println(s1);

		// session.clear();
		session.evict(s1);

		Student s2 = session.get(Student.class, i);
		System.out.println(s2);

		Cache cache = sf.getCache();
		cache.evictAll();

		Session session1 = sf.openSession();
		Student s3 = session1.get(Student.class, i);
		System.out.println(s3);
		
		College college1=session1.get(College.class, i);
		System.out.println(college);

	}

}
