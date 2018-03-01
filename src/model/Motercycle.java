package model;

import model.utility.Color;
import model.utility.EngineType;

public class Motercycle extends Vehicle {

	private boolean hasSideCart;
	
	public Motercycle(String registrationNumber, Color color, int noOfWheels, int numberOfEngins, EngineType enginType,
			int cylinderVolume, String fuelType, int length,boolean hasSideCart) {
		super(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length);
		
		this.hasSideCart = hasSideCart;
	}

	@Override
	public void parking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unParking() {
		// TODO Auto-generated method stub
		
	}

	public boolean isHasSideCart() {
		return hasSideCart;
	}

	public void setHasSideCart(boolean hasSideCart) {
		this.hasSideCart = hasSideCart;
	}


}
