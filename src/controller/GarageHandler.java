package controller;

import java.util.ArrayList;
import java.util.HashSet;

import model.Garage;
import model.GarageIsFullException;
import model.Vehicle;

public class GarageHandler {
	private ArrayList<Garage> garages;
	
	public GarageHandler() {
		garages = new ArrayList<Garage>();
	}
	
	public ArrayList<Vehicle> getParkedVehicles(){
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		for(Garage garage : garages) {
			for(Vehicle vehicle: garage.getVehicles()) {
				vehicles.add(vehicle);
			}
		}
		return vehicles;
	}
	
	public HashSet<String> getVehicleTypes(Garage garage){
		HashSet<String> set = new HashSet<String>();
		
		for(Vehicle vehicle : garage.getVehicles()) {
			set.add(vehicle.toString());
		}
		
		return set;
	}
	
	/**
	 * Adds the vehicle to the garage
	 * @param garage
	 * @param vehicle
	 * @return Number of vehicles added to the garage
	 * @throws GarageIsFullException
	 */
	public int park(Garage garage, Vehicle vehicle) throws GarageIsFullException {
		int ret = 0;
		for(Garage garageItem : garages) {
			if(garageItem.equals(garage)) {
				garage.addVehicle(vehicle);
				ret = 1;
			}
		}
		return ret;
	}
	
	public void unpark(Garage garage, Vehicle vehicle) {
		for(Garage garageItem : garages) {
			if(garageItem.equals(garage)) {
				garage.removeVehicle(vehicle);
			}
		}
	}
	
	/**
	 * Creates a new garage 
	 * @param capacity
	 * @param name
	 */
	public void createGarage(int capacity, String name) {
		Garage garage = new Garage(name,capacity);
		garages.add(garage);
	}
}
