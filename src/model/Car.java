package model;

import model.utility.CarType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;

public class Car extends Vehicle {

	private CarType carType;
	private int noOfWheels;
	
	public Car(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			CarType carType, int cylinderVolume, FuelType fuelType, int length) {
		
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
