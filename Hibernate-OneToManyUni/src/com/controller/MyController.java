package com.controller;

import java.util.Scanner;

import com.services.Service;
import com.services.ServiceImple;

public class MyController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Service s = new ServiceImple();
		boolean flag = true;

		while (flag) {
			System.out.println("-------------------------------------");
			System.out.println("1. Add company with many employees.");
			System.out.println("2. Get company with many employees.");
			System.out.println("3. Update company using cid.");
			System.out.println("4. Update employee using cid.");
			System.out.println("5. Delete company with employees.");
			System.out.println("6. Delete employees only.");
			System.out.println("7. Delete particular employee.");
			System.out.println("8. Delete company only.");
			System.out.println("-------------------------------------");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			System.out.println("-------------------------------------");

			switch (ch) {
			case 1:
				s.addCompanyWithManyEmployees();
				break;
			case 2:
				s.getCompanyWithManyEmployees();
				break;
			case 3:
				s.updateCompanyUsingCid();
				break;
			case 4:
				s.updateEmployeeUsingCid();
				break;
			case 5:
				s.deleteCompanyWithEmployees();
				break;
			case 6:
				s.deleteEmployeesOnly();
				break;
			case 7:
				s.deleteParticularEmployee();
				break;
			case 8:
				s.deleteCompanyOnly();
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Wrong choice!!!");
			}

		}
	}

}
