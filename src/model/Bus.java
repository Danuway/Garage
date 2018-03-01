package model;

import model.utility.CarType;
import model.utility.EngineType;

public class Bus extends Vehicle {

	public Bus(String registrationNumber, String color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length) {
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		// TODO Auto-generated constructor stub
	}

	private int noOfDeck;
	private int noOfWheels;
	
}
