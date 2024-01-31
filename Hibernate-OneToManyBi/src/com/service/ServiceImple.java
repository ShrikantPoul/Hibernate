package com.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Student;
import com.entity.Teacher;
import com.util.HibernateUtil;

public class ServiceImple implements Service {
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void addTeacherWithMultipleStudents() {
		Session session = sf.openSession();
		Teacher teacher = new Teacher();
		System.out.println("Enter teacher name:");
		teacher.setTname(sc.next());

		System.out.println("How many students you want to add:");
		int n = sc.nextInt();

		List<Student> slist = new LinkedList<Student>();

		for (int i = 1; i <= n; i++) {
			Student student = new Student();
			System.out.println("Enter student name:");
			student.setSname(sc.next());

			slist.add(student);
			student.setTeacher(teacher);

		}
		teacher.setSlist(slist);
		session.save(teacher);
		session.beginTransaction().commit();
		System.out.println("Added!!!");

	}

	@Override
	public void addStudentWithTeacher() {

		Session session = sf.openSession();

		List<Student> slist = new LinkedList<Student>();
		Student s = new Student();
		System.out.println("Enter student name:");
		s.setSname(sc.next());
		slist.add(s);

		Teacher t = new Teacher();
		System.out.println("Enter teacher name:");
		t.setTname(sc.next());

		s.setTeacher(t);
		t.setSlist(slist);

		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Added!!!");

	}

	@Override
	public void getTeacherWithMultipleStudents() {

		Session session = sf.openSession();
		System.out.println("Enter tid:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		System.out.println(teacher);
		if (teacher != null) {
			System.out.println(teacher);
		} else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void getStudentWithTeacher() {

		Session session = sf.openSession();
		System.out.println("Enter student id:");
		Student student = session.get(Student.class, sc.nextInt());
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateTeacherUsingTid() {

		Session session = sf.openSession();
		System.out.println("Enter teacher id:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		if (teacher != null) {
			System.out.println("Enter teacher name:");
			teacher.setTname(sc.next());

			session.update(teacher);
			session.beginTransaction().commit();
			System.out.println("Teacher Updated!!!");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateStudentUsingTid() {

		Session session = sf.openSession();
		System.out.println("Enter tid:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		if (teacher != null) {
			List<Student> slist = teacher.getSlist();
			System.out.println("Enter Student id:");
			int sid = sc.nextInt();

			for (Student s : slist) {
				if (s.getSid() == sid) {
					System.out.println("Enter student name:");
					s.setSname(sc.next());
					session.update(s);
				}

			}
			session.beginTransaction().commit();
			System.out.println("Student updated!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateStudentUsingSid() {

		Session session = sf.openSession();
		System.out.println("Enter student id:");
		Student student = session.get(Student.class, sc.nextInt());
		if (student != null) {
			System.out.println("Enter student name:");
			student.setSname(sc.next());

			session.update(student);
			session.beginTransaction().commit();
			System.out.println("Student Details Updated!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateTeacherUsingSid() {

		Session session = sf.openSession();
		System.out.println("Enter student id:");
		Student student = session.get(Student.class, sc.nextInt());
		if (student != null) {
			Teacher teacher = student.getTeacher();
			System.out.println("Enter teacher name:");
			teacher.setTname(sc.next());

			session.update(teacher);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteTeacherWithAllStudent() {
		Session session = sf.openSession();
		System.out.println("Enter teacher id:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		if (teacher != null) {
			session.delete(teacher);
			session.beginTransaction().commit();
			System.out.println("Deleted!!!");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteAllStudentsOfParticularTeacher() {
		Session session = sf.openSession();
		System.out.println("Enter teacher id:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		if (teacher != null) {
			List<Student> slist = teacher.getSlist();
			teacher.setSlist(null);
			for (Student s : slist) {
				s.setTeacher(null);
				session.delete(s);
			}
			// session.delete(s);
			session.beginTransaction().commit();
			System.out.println("Deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteParticularStudentUsingTid() {
		Session session = sf.openSession();
		System.out.println("Enter teacher id:");
		Teacher teacher = session.get(Teacher.class, sc.nextInt());
		if (teacher != null) {
			List<Student> slist = teacher.getSlist();

			System.out.println("Enter Student id:");
			int sid = sc.nextInt();
			Student sd = null;
			for (Student s : slist) {
				if (s.getSid() == sid) {
					s.setTeacher(null);
					sd = s;
				}
			}
			slist.remove(sd);
			session.delete(sd);
			session.beginTransaction().commit();
			System.out.println("Deleted!!!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteTeacherUsingSid() {

		Session session = sf.openSession();
		System.out.println("Enter student id:");
		Student student = session.get(Student.class, sc.nextInt());
		if (student != null) {
			Teacher teacher = student.getTeacher();
			List<Student> slist = teacher.getSlist();
			for (Student s : slist) {
				s.setTeacher(null);
			}
			teacher.setSlist(null);
			session.delete(teacher);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id!!!");
		}

	}

}
