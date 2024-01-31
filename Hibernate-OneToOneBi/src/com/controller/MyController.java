package com.controller;

import java.util.Scanner;

import com.service.ServiceImple;
import com.service.Services;

public class MyController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Services s = new ServiceImple();
		boolean flag = true;

		while (flag) {
			System.out.println("---------------------------------");
			System.out.println("1. Add person with adhaar card");
			System.out.println("2. Add adhaar card with person");
			System.out.println("3. Get person with adhaar card");
			System.out.println("4. Get adhaar card with person");
			System.out.println("5. Update person using pid");
			System.out.println("6. Update adhaar card using aid");
			System.out.println("7. Update person using aid");
			System.out.println("8. Update adhaar card using pid");
			System.out.println("9. Delete person with adhaar card");
			System.out.println("10. Delete adhaar card with person");
			System.out.println("11. Delete person only");
			System.out.println("12. Delete adhaar card only");
			System.out.println("---------------------------------");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.addPersonWithAdhaarCard();
				break;

			case 2:
				s.addAdhaarCardWithPerson();
				break;

			case 3:
				s.getPersonWithAdhaarCard();
				break;

			case 4:
				s.getAdhaarCardWithPerson();
				break;

			case 5:
				s.updatePersonUsingPid();
				break;

			case 6:
				s.updateAdhaarCardUsingAid();
				break;

			case 7:
				s.updatePersonUsingAid();
				break;

			case 8:
				s.updateAdhaarCardUsingPid();
				break;

			case 9:
				s.deletePersonWithAdhaarCard();
				break;

			case 10:
				s.deleteAdhaarCardWithPerson();
				break;

			case 11:
				s.deletePersonOnly();
				break;

			case 12:
				s.deleteAdhaarCardOnly();
				break;

			case 13:
				flag = false;
				break;

			default:
				System.out.println("Wrong Choice!!!!");
				break;
			}
		}

	}

}
