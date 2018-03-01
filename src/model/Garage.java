package model;

import java.util.ArrayList;

public class Garage {
	private int maxCapacity;
	private int noOfVehicles;
	private String name;
	private ArrayList<Vehicle> vehicles;
	
	public Garage(String name, int capacity) {
		this.name = name;
		maxCapacity = capacity;
		noOfVehicles = 0;
		vehicles = new ArrayList<Vehicle>();
	}
	
	public void setMaxCapacity(int capacity) {
		maxCapacity = capacity;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int getNoOfVehicles() {
		return noOfVehicles;
	}
	
	public String getName() {
		return name;
	}
	
	public void addVehicle(Vehicle newVehicle) throws GarageIsFullException {
		if(noOfVehicles == maxCapacity) {
			throw new GarageIsFullException();
		}
		vehicles.add(newVehicle);
		noOfVehicles++;
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
		noOfVehicles = vehicles.size();
	}
}
