package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "Car")
public class Car {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "model")
	private String model;
	@Column(name = "year")
	private int year;
	@Column(name = "make")
	private String make;
	
public Car() {
	
	
	}
public Car(int id,String make,String model, int year) {
	this.setId(id);
	this.setModel(model);
	this.setYear(year);
	this.setMake(make);
	}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public int getId() {
		return id;
	}
public void setId(int id) {
		this.id = id;
}
}
