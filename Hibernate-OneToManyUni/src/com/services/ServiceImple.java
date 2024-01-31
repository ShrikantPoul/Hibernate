package com.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Company;
import com.entity.Employee;
import com.util.HibernateUtil;

public class ServiceImple implements Service {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addCompanyWithManyEmployees() {
		Session session = sf.openSession();
		Company company = new Company();
		System.out.println("Enter company name:");
		company.setCname(sc.next());

		List<Employee> elist = new LinkedList<Employee>();
		System.out.println("How many employees you want to add:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Employee employee = new Employee();
			System.out.println("Enter ename:");
			employee.setEname(sc.next());
			elist.add(employee);

		}
		company.setElist(elist);
		session.save(company);
		session.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void getCompanyWithManyEmployees() {
		Session session = sf.openSession();
		System.out.println("Enter company id:");
		Company company = session.get(Company.class, sc.nextInt());
		System.out.println(company);
		// session.beginTransaction().commit();

	}

	@Override
	public void updateCompanyUsingCid() {
		Session session = sf.openSession();
		System.out.println("Enter Company id:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {
			System.out.println("Enter company name:");
			company.setCname(sc.next());
			session.update(company);
			session.beginTransaction().commit();
			System.out.println("Updated!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateEmployeeUsingCid() {
		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {
			List<Employee> elist = company.getElist();

			for (Employee e : elist) {
				System.out.println(e);
			}
			System.out.println("Enter eid:");
			Employee employee = session.get(Employee.class, sc.nextInt());
			System.out.println(employee);
			if (employee != null) {
				System.out.println("Enter ename:");
				employee.setEname(sc.next());

				session.update(company);
				session.beginTransaction().commit();
				System.out.println("Employee details updated!!!!");

			} else {
				System.out.println("Invalid id!!");
			}

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteCompanyWithEmployees() {

		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {
			session.delete(company);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteEmployeesOnly() {

		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {
			List<Employee> elist = company.getElist();
			company.setElist(null);
			for (Employee e : elist) {
				session.delete(e);
			}

			session.beginTransaction().commit();
			System.out.println("Employees deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteParticularEmployee() {
		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {

			System.out.println("Enter eid:");
			int eid = sc.nextInt();

			List<Employee> elist = company.getElist();
			Employee emp = null;
			for (Employee e : elist) {
				if (e.getEid() == eid) {
					emp = e;
				}

			}
			if (emp != null) {
				elist.remove(emp);
				session.delete(emp);
				session.beginTransaction().commit();
			}

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteCompanyOnly() {
		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company company = session.get(Company.class, sc.nextInt());
		if (company != null) {
			company.setElist(null);
			session.delete(company);
			session.beginTransaction().commit();
			System.out.println("Deleted!!!");
		} else {
			System.out.println("Invalid id!!");
		}

	}

}
