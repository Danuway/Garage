package model;

import model.utility.BoatType;
import model.utility.Color;
import model.utility.EngineType;

public class Boat extends Vehicle {


	private BoatType boatType; 
	
	public Boat(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length, BoatType boatType) {
		super(registrationNumber, color,  numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.boatType = boatType;
	}

	
	public BoatType getBoatType() {
		return boatType;
	}


	@Override
	public void parking() {
		System.out.println("Parking the boat");
	}

	@Override
	public void unParking() {
		
	}


}
