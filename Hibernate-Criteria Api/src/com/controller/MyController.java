package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Employee;
import com.util.HibernateUtil;

public class MyController {

	public static void addEmployee(SessionFactory sf) {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("How many employees you want to add:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Employee employee = new Employee();
			System.out.println("Enter ename:");
			employee.setEname(sc.next());
			System.out.println("Enter eaddress:");
			employee.setEaddress(sc.next());
			session.save(employee);
		}
		session.beginTransaction().commit();
		System.out.println("Added!!!");

	}

	public static void getAllEmployee(SessionFactory sf) {
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);

		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> elist = query.getResultList();
		System.out.println(elist);

	}

	public static void getEmployeeUsingId(SessionFactory sf) {
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.multiselect(root.get("ename"),root.get("eaddress")).where(builder.equal(root.get("eid"), 2));

		Query<Object[]> query = session.createQuery(criteriaQuery);
		Object[] ename = query.getSingleResult();
		System.out.println(Arrays.toString(ename));

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		// addEmployee(sf);
		// getAllEmployee(sf);
		getEmployeeUsingId(sf);
	}

}
