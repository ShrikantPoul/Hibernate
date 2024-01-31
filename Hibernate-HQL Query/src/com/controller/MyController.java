package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Student;
import com.util.HibernateUtil;

public class MyController {

	public static void getAllStudent(SessionFactory sf) {
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);

		for (Student s : slist) {
			System.out.println(s);
		}
	}

	public static void getStudentMarksUsingName(SessionFactory sf) {
		Session session = sf.openSession();
		Query<Double> query = session.createQuery("Select smarks from Student where sname=:stu");
		query.setParameter("stu", "Shree");
		Double d = query.getSingleResult();
		System.out.println(d);

	}

	public static void getSnameAndSmarks(SessionFactory sf) {
		Session session = sf.openSession();
		Query<Object[]> query = session.createQuery("Select sname,smarks from Student where smarks > 50.00");
		List<Object[]> olist = query.getResultList();
		for (Object[] objArr : olist) {
			System.out.println(Arrays.toString(objArr));
		}
	}

	public static void getSnameAndSmarksUsingLike(SessionFactory sf) {
		Session session = sf.openSession();
		Query<Object[]> query = session.createQuery("Select sname,smarks from Student where sname like 'A%'");
		List<Object[]> list = query.getResultList();
		for(Object[] objArr:list) {
			System.out.println(Arrays.toString(objArr));
		}

	}

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Scanner sc = new Scanner(System.in);

//		Session session = sf.openSession();
//
//		Student student = new Student(1, "Shree", 80.7);
//		Student student1 = new Student(2, "Tanmay", 74.80);
//		Student student2 = new Student(3, "Rohan", 35.67);
//		Student student3 = new Student(4, "Yash", 67.80);
//		Student student4 = new Student(5, "Akshay", 75.79);
//		Student student5 = new Student(6, "Avi", 95.80);
//
//		session.save(student);
//		session.save(student1);
//		session.save(student2);
//		session.save(student3);
//		session.save(student4);
//		session.save(student5);
//
//		session.beginTransaction().commit();
//		System.out.println("Student details inserted!!!");

		// getAllStudent(sf);
		// getStudentMarksUsingName(sf);
		//getSnameAndSmarks(sf);
		getSnameAndSmarksUsingLike(sf);
	}
}
