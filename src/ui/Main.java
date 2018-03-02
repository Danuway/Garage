package ui;

import controller.GarageHandler;
import model.Boat;
import model.Bus;
import model.Car;
import model.Garage;
import model.GarageIsFullException;
import model.Vehicle;
import model.utility.BoatType;
import model.utility.CarType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
public class Main {

	MainData data = new MainData(new Garage("myGarage", 100), new GarageHandler());
	

	
	public static void main(String[] args) {	
		//TODO: Populate garage from file and save content to garage.
		Garage myGarage = new Garage("myGarage", 100);
		GarageHandler myhandler = new GarageHandler();
		Vehicle newVehicle1 = new Car("0111111",Color.BLACK,4,4,EngineType.BOXER,CarType.SUV,2000,FuelType.BIO_DIESEL, 3);
		Vehicle newVehicle2 = new Bus("0147852", Color.BLUE, 1, EngineType.VEE, 3500, FuelType.GASOLINE, 15, 2, 10);
		Vehicle newVehicle3 = new Boat("25798825", Color.GREEN, 2, 1, EngineType.VR_AND_W, 4500, FuelType.PETROLEUM, 25, BoatType.BOWRIDER);
		
		try {
			myGarage.addVehicle(newVehicle1);
			myGarage.addVehicle(newVehicle2);
			myGarage.addVehicle(newVehicle3);
		} catch (GarageIsFullException e) {
			System.out.println("Error Adding vehicles...");
			e.printStackTrace();
		}
		while(true) {
			MainData.menuHandler(myGarage, myhandler);
			MainData.clearScreen();
		}
	}

}















