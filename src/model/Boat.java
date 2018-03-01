package model;

import model.utility.BoatType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;

public class Boat extends Vehicle {


	private BoatType boatType; 
	
	public Boat(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, FuelType fuelType, int length, BoatType boatType) {
		super(registrationNumber, color,  numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.boatType = boatType;
	}

	
	public BoatType getBoatType() {
		return boatType;
	}



}
