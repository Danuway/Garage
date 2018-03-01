package model;

import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
import model.utility.PlaneTypes;

public class Airplane extends Vehicle {

	private PlaneTypes planeType;
	public Airplane(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, FuelType fuelType, int length, PlaneTypes planeType) {
		super(registrationNumber, color,  numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.planeType = planeType;
	}
	public PlaneTypes getPlaneType() {
		return planeType;
	}



	
}
