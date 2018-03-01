package model;

import model.utility.CarType;
import model.utility.EngineType;

public class Car extends Vehicle {

	private CarType carType;
	private int noOfWheels;
	
	public Car(String registrationNumber, String color, int noOfWheels, int numberOfEngins, EngineType enginType,
			CarType carType, int cylinderVolume, String fuelType, int length) {
		
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		this.carType = carType;
		this.noOfWheels = noOfWheels;
	}

	public CarType getCarType() {
		return carType;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}


	
	
}
