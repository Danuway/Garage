package model;

import model.utility.Color;
import model.utility.EngineType;

public class Bus extends Vehicle {

	private int noOfDeck;
	private int noOfWheels;
	
	public Bus(String registrationNumber, Color color, int numberOfEngins, EngineType enginType, int cylinderVolume,
			String fuelType, int length, int noOfDeck, int noOfWheels) {
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		this.noOfDeck = noOfDeck;
		this.noOfWheels = noOfWheels;
	}

	public int getNoOfDeck() {
		return noOfDeck;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}

	@Override
	public void parking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unParking() {
		// TODO Auto-generated method stub
		
	}
	

}
