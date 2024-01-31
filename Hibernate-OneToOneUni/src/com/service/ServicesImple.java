package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Car;
import com.entity.Engine;
import com.util.HibernateUtil;

public class ServicesImple implements Services {

	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addCarWithEngine() {
		Session session = sf.openSession();
		Car car = new Car();
		System.out.println("Enter Car Name : ");
		car.setCname(sc.next());

		Engine engine = new Engine();
		System.out.println("Enter Engine Name : ");
		engine.setEname(sc.next());

		car.setEngine(engine);

		session.save(car);
		session.beginTransaction().commit();
		System.out.println("Cars and engine added successfully!!!");

	}

	@Override
	public void getCarWithEngine() {
		Session session = sf.openSession();
		System.out.println("Enter car id:");
		Car c = session.get(Car.class, sc.nextInt());
		System.out.println(c);
		session.beginTransaction().commit();

	}

	@Override
	public void updateCarWithEngine() {

		Session session = sf.openSession();
		System.out.println("Enter id:");
		Car c = session.get(Car.class, sc.nextInt());
		System.out.println(c);

		if (c != null) {

			System.out.println("Enter Car Name:");
			c.setCname(sc.next());

			Engine engine = c.getEngine();
			System.out.println("Enter engine name:");
			engine.setEname(sc.next());

			session.update(c);
			session.beginTransaction().commit();
			System.out.println("Car and engine details updated successfully!");

		} else {
			System.out.println("Invalid id!!!!!!!!!");
		}

	}

	@Override
	public void updateCarOnly() {
		Session session = sf.openSession();

		System.out.println("Enter car id:");
		Car c = session.get(Car.class, sc.nextInt());
		System.out.println(c);

		if (c != null) {
			System.out.println("Enter car name:");
			c.setCname(sc.next());

			session.update(c);
			session.beginTransaction().commit();
			System.out.println("Car updated Successfully");

		} else {
			System.out.println("Invalid id:");
		}

	}

	@Override
	public void deleteCarWithEngine() {
		Session session = sf.openSession();
		System.out.println("Enter Car id:");
		Car car = session.get(Car.class, sc.nextInt());

		if (car != null) {
			session.delete(car);
			session.beginTransaction().commit();
			System.out.println("car details deleted successfully!!!!!!");
		} else {
			System.out.println("Invalid id!!!!!");
		}

	}

	@Override
	public void deleteCarOnly() {
		Session session = sf.openSession();
		System.out.println("Enter car id:");
		Car car = session.get(Car.class, sc.nextInt());
		System.out.println(car);

		if (car != null) {
			car.setEngine(null);
			session.update(car);
			session.delete(car);
			session.beginTransaction().commit();
			System.out.println("car details deleted successfully");

		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteEngineOnly() {
		Session session = sf.openSession();
		System.out.println("Enter car id:");
		Car car = session.get(Car.class, sc.nextInt());

		if (car != null) {
			Engine engine = car.getEngine();
			car.setEngine(null);
			session.update(car);
			session.delete(engine);
			session.beginTransaction().commit();
			System.out.println("Engine deleted successfully");
		}

	}

	@Override
	public void addExistingEngineToExistingCar() {
		Session session = sf.openSession();

		System.out.println("Enter car id:");
		Car car = session.get(Car.class, sc.nextInt());

		System.out.println("Enter engine id:");
		Engine engine = session.get(Engine.class, sc.nextInt());

		if (car != null && engine != null) {

			car.setEngine(engine);
			session.update(car);
			session.beginTransaction().commit();
			System.out.println("Success");

		} else {
			System.out.println("Invalid Id");
		}

	}

}
