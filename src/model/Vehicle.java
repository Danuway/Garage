package model;

import model.utility.EngineType;
import model.utility.EngineType;

public abstract class Vehicle {

	
	private String registrationNumber;
	private String color;
	private int numberOfEngins;
	private EngineType enginType;
	private int cylinderVolume;
	private String fuelType;
	private int length;
	
	
	
	public Vehicle(String registrationNumber, String color, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfEngins = numberOfEngins;
		this.enginType = enginType;
		this.cylinderVolume = cylinderVolume;
		this.fuelType = fuelType;
		this.length = length;
	}
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getColor() {
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
	public String getFuelType() {
		return fuelType;
	}
	public int getLength() {
		return length;
	}
	
	public void parking() {
		System.out.println("Parking....");
	}
	
	public void unParking() {
		System.out.println("Unparking....");
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
