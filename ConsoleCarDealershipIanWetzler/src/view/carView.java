package view;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.CarHelper;
import model.Car;

public class carView {

	public static void main(String[] args) {
	startUp();

	}
	public static void startUp() {
		boolean exit = false;
		while(exit == false) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsoleCarDealershipIanWetzler");
		EntityManager em = emf.createEntityManager();
		CarHelper help = new CarHelper(em);
		System.out.println("Welcome!");
		System.out.println("Select an item:");
		System.out.println("1- Add an item");
		System.out.println("2- Edit an item");
		System.out.println("3- Delete an item");
		System.out.println("4- View the list");
		System.out.println("5- exit");
		System.out.println("Your selection: ");
		Scanner in = new Scanner(System.in);
		int userSelection = in.nextInt();
		if(userSelection == 1) {
			System.out.println("Enter a Id: ");
			int id = in.nextInt();
			System.out.println("Enter a model: ");
			String model = in.next();
			System.out.println("Enter a year: ");
			int year = in.nextInt();
			System.out.println("Enter a make: ");
			String make = in.next();
			Car car = help.createCar(id,model, make, year);
			System.out.println("Persisted" + car);
			
			
		}
		else if(userSelection == 2) {
			System.out.println("Enter id of the car you would like to change: ");
			int id = in.nextInt();
			System.out.println("What coloumn would you like to change?: ");
			String entry = in.next();
			if(entry.equalsIgnoreCase("id") | entry.equalsIgnoreCase("year")) {
				System.out.println("Enter Edit: ");
				int change = in.nextInt();
				em.getTransaction().begin();
				help.editCarIdYear(id, entry, change);
				em.getTransaction().commit();
				System.out.println("Edited Car " + id);
			}
			else if(entry.equalsIgnoreCase("make") | entry.equalsIgnoreCase("model")) {
				System.out.println("Enter Edit: ");
				String change = in.next();
				em.getTransaction().begin();
				help.editCarMakeModel(id, entry, change);
				em.getTransaction().commit();
				System.out.println("Edited Car " + id);
			}
			else {
				System.out.println("Please Enter a valid Column");
				}
			}
		else if(userSelection == 3) {
			System.out.println("Please Enter id of item you wish to delete: ");
			int id = in.nextInt();
			em.getTransaction().begin();
			help.removeCar(id);
			em.getTransaction().commit();
			System.out.println("Removed Car" + id);
			
		}
		else if(userSelection ==4) {
			help.findAllCars();
			}
		else {
			System.out.println("Goodbye");
			exit = true;
			in.close();
			
			
		}
		}
	}
}
