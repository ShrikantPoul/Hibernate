package com.controller;

import java.util.Scanner;

import com.service.Services;
import com.service.ServicesImple;

public class MyController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Services s = new ServicesImple();
		boolean flag = true;

		while (flag) {
			System.out.println("------------------------------------------");
			System.out.println("1. Add car with engine.");
			System.out.println("2. Get car with engine.");
			System.out.println("3. Update car with engine.");
			System.out.println("4. Update car only");
			System.out.println("5. Delete car with engine");
			System.out.println("6. Delete car only");
			System.out.println("7. Delete engine only");
			System.out.println("8. add existing engine to existing car");
			System.out.println("------------------------------------------");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.addCarWithEngine();
				break;
			case 2:
				s.getCarWithEngine();
				break;
			case 3:
				s.updateCarWithEngine();
				break;
			case 4:
				s.updateCarOnly();
				break;
			case 5:
				s.deleteCarWithEngine();
				break;
			case 6:
				s.deleteCarOnly();
				break;
			case 7:
				s.deleteEngineOnly();
				break;
			case 8:
				s.addExistingEngineToExistingCar();
				break;
			case 9:

				flag = false;
				break;
			default:
				System.out.println("Wrong choice!!!!!!");
				break;

			}

		}

		// s.addCarWithEngine();

		// s.getCarWithEngine();

		// s.updateCarWithEngine();

		// s.updateCarOnly();

		// s.deleteCarWithEngine();

		// s.deleteCarOnly();

		// s.deleteEngineOnly();

		// s.addExistingEngineToExistingCar();
	}

}
