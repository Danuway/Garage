package model;

import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;

public class Bus extends Vehicle {

	private int noOfDeck;
	private int noOfWheels;
	
	public Bus(String registrationNumber, Color color, int numberOfEngins, EngineType enginType, int cylinderVolume,
			FuelType fuelType, int length, int noOfDeck, int noOfWheels) {
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



}
