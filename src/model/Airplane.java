package model;

import model.utility.Color;
import model.utility.EngineType;
import model.utility.PlaneTypes;

public class Airplane extends Vehicle {

	private PlaneTypes planeType;
	public Airplane(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length, PlaneTypes planeType) {
		super(registrationNumber, color,  numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.planeType = planeType;
	}
	public PlaneTypes getPlaneType() {
		return planeType;
	}
	@Override
	public void parking() {
		System.out.println("Parking the plane " + getPlaneType());
	}
	@Override
	public void unParking() {
		System.out.println("Unparking the plane " + getPlaneType());
	}

	
}
