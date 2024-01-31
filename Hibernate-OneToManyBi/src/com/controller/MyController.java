package com.controller;

import java.util.Scanner;

import com.service.Service;
import com.service.ServiceImple;

public class MyController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service s = new ServiceImple();
		boolean flag = true;

		while (flag) {
			System.out.println("------------------------------");
			System.out.println("1. Add teacher with multiple students.");
			System.out.println("2. Add student with teacher.");
			System.out.println("3. Get teacher with multiple students.");
			System.out.println("4. Get student with teacher.");
			System.out.println("5. Update teacher using tid.");
			System.out.println("6. Update student using tid.");
			System.out.println("7. Update student using sid.");
			System.out.println("8. Update teacher using sid.");
			System.out.println("9. Delete teacher with all student.");
			System.out.println("10. Delete all students of particular teacher.");
			System.out.println("11. Delete particular student using tid.");
			System.out.println("12. Delete teacher using sid.");
			System.out.println("------------------------------");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				s.addTeacherWithMultipleStudents();
				break;
			case 2:
				s.addStudentWithTeacher();
				break;
			case 3:
				s.getTeacherWithMultipleStudents();
				break;
			case 4:
				s.getStudentWithTeacher();
				break;
			case 5:
				s.updateTeacherUsingTid();
				break;
			case 6:
				s.updateStudentUsingTid();
				break;
			case 7:
				s.updateStudentUsingSid();
				break;
			case 8:
				s.updateTeacherUsingSid();
				break;
			case 9:
				s.deleteTeacherWithAllStudent();
				break;
			case 10:
				s.deleteAllStudentsOfParticularTeacher();
				break;
			case 11:
				s.deleteParticularStudentUsingTid();
				break;
			case 12:
				s.deleteTeacherUsingSid();
				break;
			case 13:
				flag = false;
				break;
			default:
				System.out.println("Wrong Choice!!!");
				break;
			}
		}

	}

}
