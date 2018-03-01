package model;

import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;

public class Motercycle extends Vehicle {

	private boolean hasSideCart;
	
	public Motercycle(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, FuelType fuelType, int length,boolean hasSideCart) {
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.hasSideCart = hasSideCart;
	}



	public boolean isHasSideCart() {
		return hasSideCart;
	}

	public void setHasSideCart(boolean hasSideCart) {
		this.hasSideCart = hasSideCart;
	}


}
