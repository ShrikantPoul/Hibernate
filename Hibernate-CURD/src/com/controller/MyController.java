package com.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtil;

public class MyController {

	public static void getStudent(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Student id:");
		int id = sc.nextInt();

		// Student s = session.get(Student.class, id);
		// System.out.println(s);

		Student s = session.load(Student.class, id);
		System.out.println(s.getSid());
		System.out.println(s.getSname());
	}

	public static void addStudent(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

//		Student s = new Student();
		System.out.println("Enter Student Id:");
//		s.setSid(sc.nextInt());
		System.out.println("Enter Student Name:");
//		s.setSname(sc.next());

//		int i = (int) session.save(s);
//		System.out.println(i);
//      session.persist(s);
		session.beginTransaction().commit();
		System.out.println("Success");

	}

	public static void updateStudent(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

//		System.out.println("Enter Student Id:");
//		int id = sc.nextInt();
//		Student student = session.get(Student.class, id);
//
//		 if (student != null) {

//		Student student = new Student();
//		student.setSid(10);
//
		System.out.println("Enter Student Name:");
//		student.setSname(sc.next());
//
//			session.update(student);
//		session.saveOrUpdate(student);
//			// session.save(student);
		session.beginTransaction().commit();
//			System.out.println("Student Details Updated!!!!!!!");
//
//		} else {
//			System.out.println("Invalid Id!!!!!");
//		}

	}

	public static void deleteStudent(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter student id you want to delete : ");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);
		if (student != null) {

			session.delete(student);
			// session.save(student);
			session.beginTransaction().commit();
			System.out.println("Student details deleted!!!!!");

		} else {
			System.out.println("Invalid ID!!!!!");
		}

	}

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// addStudent(sf);
		// getStudent(sf);

		// updateStudent(sf);
		// deleteStudent(sf);

		Session session = sf.openSession();
		Session session1 = sf.openSession();
		Session session3 = sf.getCurrentSession();
		Session session4 = sf.getCurrentSession();

		System.out.println(session.hashCode());
		System.out.println(session1.hashCode());
		System.out.println(session3.hashCode());
		System.out.println(session4.hashCode());

	}

}
