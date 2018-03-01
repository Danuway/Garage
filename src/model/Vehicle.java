package model;

import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
import model.utility.EngineType;

public abstract class Vehicle {

	
	private String registrationNumber;
	private Color color;
	private int numberOfEngins;
	private EngineType enginType;
	private int cylinderVolume;
	private FuelType fuelType;
	private int length;
	
	
	
	public Vehicle(String registrationNumber, Color color, int numberOfEngins, EngineType enginType,
			int cylinderVolume, FuelType fuelType2, int length) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfEngins = numberOfEngins;
		this.enginType = enginType;
		this.cylinderVolume = cylinderVolume;
		this.fuelType = fuelType2;
		this.length = length;
	}
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public Color getColor() {
		return color;
	}

	public int getNumberOfEngins() {
		return numberOfEngins;
	}
	public EngineType getEnginType() {
		return enginType;
	}
	public int getCylinderVolume() {
		return cylinderVolume;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Vehicle with registrationNumber: " + registrationNumber 
				+ ", is of " + color + " color and have"
				+ numberOfEngins + " number of engins with engin type of " 
				+ enginType + " that have a cylinder volume of " + cylinderVolume
				+ ", the fuel type the engin takes is"
				+ fuelType + ", length=" + length + "]";
	}
	
	
}
