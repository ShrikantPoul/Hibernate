package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.Student;
import com.util.HibernateUtil;

public class MyController {

	public static void addStudent(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		System.out.println("How many students you want to add:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Student student = new Student();
			System.out.println("Enter student name:");
			student.setSname(sc.next());
			System.out.println("Enter student address:");
			student.setSaddress(sc.next());
			session.save(student);
			session.beginTransaction().commit();
			System.out.println("Added");
		}

	}

	public static void getAllStudent(SessionFactory sf) {
		Session session = sf.openSession();
		Query<Object[]> query = session.createNamedQuery("getAllStudent");
		query.setParameter("name", "Shree");
		List<Object[]> obj = query.getResultList();
		for (Object[] objArr : obj) {
			System.out.println(Arrays.toString(objArr));
		}

	}

	public static void getStudentUsingId(SessionFactory sf) {
		Session session = sf.openSession();
		Query<String> query= session.createNamedQuery("getStudentUsingIdSQLQuery");
		query.setParameter("id", 5);
		String s=query.getSingleResult();
		System.out.println(s);

	}

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// addStudent(sf);
		//getAllStudent(sf);
		getStudentUsingId(sf);

	}

}
