package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.AdhaarCard;
import com.model.Person;
import com.util.HibernateUtil;

public class ServiceImple implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addPersonWithAdhaarCard() {
		Session session = sf.openSession();
		Person person = new Person();
		System.out.println("Enter pname:");
		person.setPname(sc.next());

		AdhaarCard adhaarCard = new AdhaarCard();
		System.out.println("Enter aname:");
		adhaarCard.setAname(sc.next());

		person.setAdhaarCard(adhaarCard);
		adhaarCard.setPerson(person);

		session.save(person);

		session.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void addAdhaarCardWithPerson() {
		Session session = sf.openSession();

		AdhaarCard adhaarCard = new AdhaarCard();
		System.out.println("Enter aname:");
		adhaarCard.setAname(sc.next());

		Person person = new Person();
		System.out.println("Enter pname:");
		person.setPname(sc.next());

		adhaarCard.setPerson(person);
		person.setAdhaarCard(adhaarCard);

		session.save(adhaarCard);

		session.beginTransaction().commit();
		System.out.println("Success");

	}

	@Override
	public void getPersonWithAdhaarCard() {
		Session session = sf.openSession();
		System.out.println("Enter person id:");
		Person person = session.get(Person.class, sc.nextInt());
		if (person != null) {
			System.out.println(person);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id!!!!!!");
		}

	}

	@Override
	public void getAdhaarCardWithPerson() {

		Session session = sf.openSession();
		System.out.println("Enter adhaar id:");
		AdhaarCard adhaarCard = session.get(AdhaarCard.class, sc.nextInt());
		if (adhaarCard != null) {
			System.out.println(adhaarCard);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id!!!!!!!");
		}

	}

	@Override
	public void updatePersonUsingPid() {
		Session session = sf.openSession();
		System.out.println("Enter person id you want to update:");
		Person person = session.get(Person.class, sc.nextInt());
		if (person != null) {
			System.out.println("Enter pname:");
			person.setPname(sc.next());

			session.update(person);
			session.beginTransaction().commit();
			System.out.println("Person updated!!!!!");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateAdhaarCardUsingAid() {
		Session session = sf.openSession();
		System.out.println("Enter adhaar id you want to update:");
		AdhaarCard adhaarCard = session.get(AdhaarCard.class, sc.nextInt());

		if (adhaarCard != null) {
			System.out.println("Enter aname:");
			adhaarCard.setAname(sc.next());

			session.update(adhaarCard);
			session.beginTransaction().commit();
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updatePersonUsingAid() {
		Session session = sf.openSession();
		System.out.println("Enter Adhaar id:");
		AdhaarCard adhaarCard = session.get(AdhaarCard.class, sc.nextInt());
		if (adhaarCard != null) {
			Person person = adhaarCard.getPerson();
			System.out.println("Enter pname:");
			person.setPname(sc.next());

			session.update(adhaarCard);
			session.beginTransaction().commit();
			System.out.println("Updated!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateAdhaarCardUsingPid() {
		Session session = sf.openSession();
		System.out.println("Enter person id:");
		Person person = session.get(Person.class, sc.nextInt());
		if (person != null) {
			AdhaarCard adhaarCard = person.getAdhaarCard();
			System.out.println("Enter aname:");
			adhaarCard.setAname(sc.next());

			session.update(person);
			session.beginTransaction().commit();
			System.out.println("Updated!!!");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deletePersonWithAdhaarCard() {
		Session session = sf.openSession();
		System.out.println("Enter person id:");
		Person person = session.get(Person.class, sc.nextInt());

		if (person != null) {
			session.delete(person);
			session.beginTransaction().commit();
			System.out.println("Person details deleted!!!");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteAdhaarCardWithPerson() {

		Session session = sf.openSession();
		System.out.println("Enter Adhaar id:");
		AdhaarCard adhaarCard = session.get(AdhaarCard.class, sc.nextInt());
		if (adhaarCard != null) {
			session.delete(adhaarCard);
			session.beginTransaction().commit();
			System.out.println("AdhaarCard details deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deletePersonOnly() {
		Session session = sf.openSession();
		System.out.println("Enter person id:");
		Person person = session.get(Person.class, sc.nextInt());
		if (person != null) {
			person.getAdhaarCard().setPerson(null);
			person.setAdhaarCard(null);
			session.update(person);
			session.delete(person);
			session.beginTransaction().commit();
			System.out.println("Person deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteAdhaarCardOnly() {
		Session session = sf.openSession();
		System.out.println("Enter adhaar id:");
		AdhaarCard adhaarCard = session.get(AdhaarCard.class, sc.nextInt());
		if (adhaarCard != null) {
			Person person = adhaarCard.getPerson();
			person.setAdhaarCard(null);
			adhaarCard.setPerson(null);
			session.update(adhaarCard);
			session.delete(adhaarCard);
			session.beginTransaction().commit();
			System.out.println("Adhaar card deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

}
