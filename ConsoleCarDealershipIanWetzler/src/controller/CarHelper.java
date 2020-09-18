package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

public class CarHelper {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsoleCarDealershipIanWetzler");
	EntityManager em = emf.createEntityManager();
	
	public CarHelper(EntityManager em) {
		this.em = em;
	}
	public Car createCar(int id,String make, String model, int year) {
		EntityManager em = emf.createEntityManager();
		Car car = new Car(id, make,model,year);
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		em.persist(car);
		em.close();
		return car;
	}
	public void removeCar(int id) {
		Car car = findCar(id);
		if(car != null) {
			em.remove(car);
			}
		}
	public void editCarIdYear(int id, String entry, int change) {
		Car car = findCar(id);
		if(car != null) {
			if(entry.equalsIgnoreCase("id")) {
				car.setId(change);
				em.persist(car);
			}
			else if(entry.equalsIgnoreCase("Year")) {
				car.setYear(change);
				em.persist(car);
			}
		
	}
	
		
	}
	public void editCarMakeModel(int id, String entry, String change) {
		Car car = findCar(id);
		if(car != null) {
			if(entry.equalsIgnoreCase("make")) {
				car.setMake(change);
				em.persist(car);
			}
			else if(entry.equalsIgnoreCase("model")) {
				car.setModel(change);
				em.persist(car);
			}
		
		}
	}
	public Car findCar(int id) {
		return em.find(Car.class, id);
	}
	public void findAllCars() {
		
		int i = 1;
		while(em.find(Car.class, i) != null) {
			em.getTransaction().begin();
			Car car = em.find(Car.class, i);
			System.out.println("ID: " + car.getId());
			System.out.println("Make: " + car.getMake());
			System.out.println("Model: " + car.getModel());
			System.out.println("Year: " + car.getYear());
			i++;
			
		}
		em.close();
	}
		
		
}


