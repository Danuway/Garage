package model;

import model.utility.EngineType;

public class Boat extends Vehicle {


	private boolean isMotorBot; 
	
	public Boat(String registrationNumber, String color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length, boolean isMotorBot) {
		super(registrationNumber, color,  numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.isMotorBot = isMotorBot;
	}

	public boolean isMotorBot() {
		return isMotorBot;
	}


}
