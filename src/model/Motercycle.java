package model;

import model.utility.EngineType;

public class Motercycle extends Vehicle {

	private boolean hasSideCart;
	
	public Motercycle(String registrationNumber, String color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length,boolean hasSideCart) {
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.hasSideCart = hasSideCart;
	}


}
