package model;

import java.util.ArrayList;

public class Garage {
	private int maxCapacity;
	private int noOfVehicles;
	private String name;
	private ArrayList<Vehicle> vehicles;
	
	/**
	 * @param name Name of the garage
	 * @param capacity sets the max capacity
	 */
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
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	
	/**	
	 * Adds an vehicle to the garage if the garage is not full
	 * @param newVehicle 
	 * @throws GarageIsFullException
	 */
	public void addVehicle(Vehicle newVehicle) throws GarageIsFullException {
		if(noOfVehicles == maxCapacity) {
			throw new GarageIsFullException();
		}
		vehicles.add(newVehicle);
		noOfVehicles = vehicles.size();
	}
	
	/**
	 * Removes the vehicle from the garage
	 * @param vehicle
	 */
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
		noOfVehicles = vehicles.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(getClass() == obj.getClass()) {
			Garage testObj = (Garage)obj;
			if(name.equals(testObj.getName())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
