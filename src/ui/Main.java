package ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.GarageHandler;
import model.Boat;
import model.Bus;
import model.Car;
import model.Garage;
import model.GarageIsFullException;
import model.NoVehicleFoundException;
import model.Vehicle;
import model.utility.BoatType;
import model.utility.CarType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
public class Main {

	static Scanner cin = new Scanner(System.in);
	static int choice;

	public static void displayMenu() {
		System.out.println("Welcome to our garage!");
		System.out.println("======================");
		System.out.println();
		System.out.println("Please select from the menu below");
		System.out.println(  "1) List all parked vehicles.\n" 
				+ "2) List all vehicle types currently parked in the garage.\n" 
				+ "3) Park and unpark specific vehicles from the garage.\n"
				+ "4) Set the maximum capacity of the garage.\n"
				+ "5) Find a parcked vehicle.\n"
				+ "6) Create a garage.\n"
				+ "7) Seve garage and all its vehicles to a file.\n"
				+ "8) Exit the program.");
	}
	public static int consoleInput() {

		try {
			return cin.nextInt();
		} catch (Exception e) {
			System.out.println("Try a valid menue");
		}
		return 0;
	}

	public static void menuHandler(Garage garage, GarageHandler myhandler) {
		int choice;
		displayMenu();
		choice = consoleInput();
		switch (choice) {
		case 1:
			for(Vehicle vehicle : garage.getVehicles())
				System.out.println(vehicle.toString());
			break;
			
		case 2:
			for(Vehicle vehicle : garage.getVehicles())
				System.out.println(vehicle.toString());
				//System.out.println(vehicle.getType); TODO: getVehicleType
			break;
			
		case 3:			
			try {
				garage.addVehicle(discribeVehicle());
			} catch (GarageIsFullException e) {
				e.printStackTrace();
			}
			break;
			
		case 4:
			System.out.println("Enter the prefered capacity: ");
			int capacity = consoleInput();
			garage.setMaxCapacity(capacity);
			System.out.println("Maximum Capacity is set to " + capacity);
			break;
			
		case 5:
			System.out.println("Enter the registration number: ");
			Scanner sc = new Scanner(System.in);
			String regnr = sc.nextLine();
			sc.close();
			try {
				System.out.println(myhandler.getVehicleFromRegNr(regnr).toString()); // TODO: HANDLE THE RETURNED VEHICLE IN A USER FRIENDLY MANNER
			} catch (NoVehicleFoundException e) {
				System.out.println("Wrong registration number..."
						+ "The vehicle could not be found.");
			}
			break;
			
		case 6:
			System.out.println("Please enter the capaciaty: ");
			int cap = consoleInput();
			System.out.println("The name of the garage: ");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine();
			sc1.close();
			myhandler.createGarage(cap, name);
			System.out.println("Garage with name " + name + "and "
					+ "capacity " + cap + "is created");
			break;
		case 7:
			FileWriter writer;
			try {
				writer = new FileWriter("GarageOutput.txt");
			
			for(Vehicle myVehicle: myhandler.getParkedVehicles()){
				
				writer.write(myVehicle.toString());
			}
			writer.close();
			} catch (IOException e) {
				System.out.println("Something went wrong ...");
				System.err.println(e);
				;
			}
			break;
		default:
			System.out.println("Are you shure you want to leave? ");
			System.out.println("1) yes \n"
								+ "2) no");
			choice = consoleInput();
			if (choice == 1) {
				System.exit(0);
			}
			break;
		}

	}
	private static Garage selectGarage() {
		int counter = 0;
		GarageHandler newHandler = new GarageHandler();
		ArrayList<Garage> garages = newHandler.getGarages();
		System.out.println("Select a garage from the list: ");
		for(Garage g : garages)
			System.out.println(++counter + ")" + g.getName());
		counter = consoleInput();
		--counter;		
		return garages.get(counter);
	}
	private static Vehicle discribeVehicle() {
		
		System.out.println("Enter Registration Number:");
		String registrationNumber = cin.nextLine();
		System.out.println("Select the color of the car: ");
		Color color = selectColor();
		System.out.println("Enter the number of engin: ");
		int numberOfEngins = consoleInput();
		EngineType enginType = selectEngin();
		int cylinderVolume = selectCilndeVolume();
		FuelType fuelType2 = selectFuleType();
		int length = inputLength();
		
		//Vehicle newVehicle = new V
		//return newVehicle;
		return null;
	}
	private static int inputLength() {
		System.out.println("Please enter the length of the vehicle: ");
		return consoleInput();
	}
	private static FuelType selectFuleType() {
		FuelType fuelType = FuelType.PETROLEUM; // Default value.
		System.out.println("1) " + FuelType.BIO_DIESEL);
		System.out.println("2) " + FuelType.DIESEL);
		System.out.println("3) " + FuelType.ETHANOL);
		System.out.println("4) " + FuelType.GAS);
		System.out.println("5) " + FuelType.GASOLINE);
		System.out.println("6) " + FuelType.PETROLEUM);
		int choice = consoleInput();
		switch (choice) {
		case 1:
			fuelType = FuelType.BIO_DIESEL;
			break;
		case 2:
			fuelType = FuelType.DIESEL;
			break;
		case 3:
			fuelType = FuelType.ETHANOL;
			break;
		case 4:
			fuelType = FuelType.GAS;
			break;
		case 5:
			fuelType = FuelType.GASOLINE;
			break;
		case 6:
			fuelType = FuelType.PETROLEUM;
			break;
		}
		return fuelType;
	}
	private static int selectCilndeVolume() {
		System.out.println("What is the cilender volume :");
		return consoleInput();
	}
	private static EngineType selectEngin() {
		EngineType newEnginType = EngineType.BOXER; //Default EngineType.
		System.out.println("1) " + EngineType.BOXER);
		System.out.println("2) " + EngineType.EIGHT_CYLINDER);
		System.out.println("3) " + EngineType.FOUR_CYLINDER);
		System.out.println("4) " + EngineType.INLINE);
		System.out.println("5) " + EngineType.SINGLE);
		System.out.println("6) " + EngineType.SIX_CYLINDER);
		System.out.println("7) " + EngineType.STRAIGHT);
		System.out.println("8) " + EngineType.THREE_CYLINDER);
		System.out.println("9) " + EngineType.TWO_CYLINDER);
		System.out.println("10) " + EngineType.V_TWIN);
		System.out.println("11) " + EngineType.VEE);
		System.out.println("12) " + EngineType.VR_AND_W);
		
		int choice = consoleInput();
		switch (choice) {
		case 1:
			newEnginType = EngineType.BOXER;
			break;
		case 2:
			newEnginType = EngineType.EIGHT_CYLINDER;
			break;
		case 3:
			newEnginType = EngineType.FOUR_CYLINDER;
			break;
		case 4:
			newEnginType = EngineType.INLINE;
			break;
		case 5:
			newEnginType = EngineType.SINGLE;
			break;
		case 6:
			newEnginType = EngineType.SIX_CYLINDER;
			break;
		case 7:
			newEnginType = EngineType.STRAIGHT;
			break;
		case 8:
			newEnginType = EngineType.THREE_CYLINDER;
			break;
		case 9:
			newEnginType = EngineType.TWO_CYLINDER;
			break;
		case 10:
			newEnginType = EngineType.V_TWIN;
			break;
		case 11:
			newEnginType = EngineType.VEE;
			break;
		case 12:
			newEnginType = EngineType.VR_AND_W;
			break;
		}
		return newEnginType;
	}
	private static Color selectColor() {
		Color newColor = Color.BLACK; //Default color
		System.out.println("1) " + Color.BLACK);
		System.out.println("2) " + Color.BLUE);
		System.out.println("3) " + Color.BROWN);
		System.out.println("4) " + Color.GREEN);
		System.out.println("5) " + Color.GREY);
		System.out.println("6) " + Color.RED);
		System.out.println("7) " + Color.SILVER);
		System.out.println("8) " + Color.WHITE);
		int choice = consoleInput();
		switch (choice) {
		case 1:
			newColor = Color.BLACK;
			break;
		case 2:
			newColor = Color.BLUE;
			break;
		case 3:
			newColor = Color.BROWN;
			break;
		case 4:
			newColor = Color.GREEN;
			break;
		case 5:
			newColor = Color.GREY;
			break;
		case 6:
			newColor = Color.RED;
			break;
		case 7:
			newColor = Color.SILVER;
			break;
		case 8:
			newColor = Color.WHITE;
			break;
		}
		return newColor;
	}
	private static void displayVehiclesInASpecificGarage(ArrayList<Garage> garages) {
		int counter = 1;
		for (Garage garage : garages) {	
			System.out.println("List of Garages : ");
			System.out.println(counter + ")" + garage.getName() + "\n");	
			++counter;
		}
		System.out.print("Select a garage: ");

		choice = consoleInput();
		for (Vehicle vehicle : garages.get(choice).getVehicles()) {
			System.out.println(vehicle.toString());
		}
	}
	
	
	
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
		menuHandler(myGarage, myhandler);
		}
	}

}















