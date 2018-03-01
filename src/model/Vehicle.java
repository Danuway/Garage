package model;

import model.utility.EngineType;
import model.utility.EngineType;

public abstract class Vehicle {
/**
 *
+ parking(void): void
+ unParking(void): void
+toString(void):void



 */
	
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
	
	
}
